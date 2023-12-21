package bo.edu.uto.dtic.certificadonotas.controllers.reportes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.ArrayList;
import java.util.Calendar;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;

import bo.edu.uto.dtic.certificadonotas.models.Nota;
import bo.edu.uto.dtic.certificadonotas.models.Registro;

@Component
public class CertificadoPDF {
    @Autowired
    private auxiliar aux;
    
    private Logger logger = LoggerFactory.getLogger(CertificadoPDF.class);
    public ByteArrayInputStream certificado(List<Registro> datos) throws IOException{
        Document document = new Document();
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        
        try {
            //BaseFont cc = BaseFont.createFont("../../resources",BaseFont.WINANSI, BaseFont.EMBEDDED);  
            BaseFont cambria = BaseFont.createFont("src/main/resources/pdf/cambria.ttf",BaseFont.WINANSI, BaseFont.EMBEDDED);
            BaseFont aria = BaseFont.createFont("src/main/resources/pdf/timesbd.ttf", BaseFont.WINANSI, BaseFont.EMBEDDED);

            com.itextpdf.text.Font fTituloB = new com.itextpdf.text.Font(aria, 9, Font.NORMAL, BaseColor.BLACK);
            com.itextpdf.text.Font fTexto = new com.itextpdf.text.Font(cambria, 12, Font.NORMAL, BaseColor.BLACK);
            com.itextpdf.text.Font fContenido = new com.itextpdf.text.Font(cambria, 10, Font.NORMAL, BaseColor.BLACK);

            DateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
            String FechaActual = dateFormat.format(Calendar.getInstance().getTime());

            FechaActual = aux.formatoFecha(FechaActual);

            PdfWriter writer = PdfWriter.getInstance(document,out);
            Paragraph par = null;
            PdfPCell celda = null;
            PdfPTable tDatos = null;

            document.setPageSize(PageSize.LETTER);
            document.setMargins(60, 57, 113, 57);
            document.open();

            for(int i=0;i<datos.size();i++){
                if(i!=0)
                    document.newPage();
                document.add(Chunk.NEWLINE);
                document.add(Chunk.NEWLINE);
                par=new Paragraph(datos.get(i).getNombre(),fTexto );
                par.setIndentationLeft(115);
                par.setSpacingAfter(9f);
                document.add(par);  

                par = new Paragraph(datos.get(i).getPrograma(),fTexto );
                par.setIndentationLeft(65);
                par.setSpacingAfter(9f);
                document.add(par);

                par = new Paragraph(datos.get(i).get_gestion(),fTexto );
                par.setIndentationLeft(112);
                par.setSpacingAfter(22f);
                document.add(par);

                tDatos = new PdfPTable(5);
                tDatos.setWidths(new int[] { 7 , 24 , 6 , 5 , 19 });
                tDatos.setWidthPercentage(100f);
                

                celda = new PdfPCell();
                par = new Paragraph("  ",fTituloB);
                par.setAlignment(Element.ALIGN_CENTER);
                celda.addElement(par);
                celda.setColspan(5);    
                celda.setFixedHeight(55);
                celda.setBorder(0);
                tDatos.addCell(celda);
            

                List<Nota> nota=new ArrayList<Nota>();
                nota=datos.get(i).getNotas();
                String cad="";
                Integer n;
                for(int j=0;j<nota.size();j++){
                    celda = new PdfPCell();
                    cad=nota.get(j).getSigla()==null?"NULL":nota.get(j).getSigla();
                    par = new Paragraph(cad,fContenido);
                    celda.addElement(par);
                    celda.setBorder(0);
                    tDatos.addCell(celda);
                    
                    celda = new PdfPCell();
                    cad=nota.get(j).getMateria()==null?"NULL":nota.get(j).getMateria();
                    par = new Paragraph(cad,fContenido);
                    celda.addElement(par);
                    celda.setBorder(0);
                    tDatos.addCell(celda);
                    
                    celda = new PdfPCell();
                    cad=nota.get(j).getHrs_totales()==null?"NULL":(nota.get(j).getHrs_totales()).toString();
                    par = new Paragraph(cad,fContenido);
                    par.setIndentationLeft(10);
                    celda.addElement(par);
                    celda.setBorder(0);
                    tDatos.addCell(celda);
                    
                    celda = new PdfPCell();
                    cad=nota.get(j).getNf()==null?"NULL":(nota.get(j).getNf()).toString();
                    par = new Paragraph(cad,fContenido);
                    celda.addElement(par);
                    celda.setBorder(0);
                    tDatos.addCell(celda);
                    
                    celda = new PdfPCell();
                    n=nota.get(j).getNf()>nota.get(j).getNota()?nota.get(j).getNf():nota.get(j).getNota();
                    par = new Paragraph(aux.literal(n),fContenido );
                    celda.addElement(par);
                    celda.setBorder(0);
                    tDatos.addCell(celda);                    
                }
                document.add(tDatos);
    
                PdfContentByte cb = writer.getDirectContentUnder();
                cb.saveState();
                cb.beginText();
                cb.moveText(222, 130);
                cb.setFontAndSize(cambria, 12);
                cb.showText(FechaActual);
                cb.endText();
                cb.restoreState();
            }                       
            document.close();
        } catch (DocumentException e) {
            logger.error(e.toString());
        }
        return new ByteArrayInputStream(out.toByteArray()); 
    }
}
