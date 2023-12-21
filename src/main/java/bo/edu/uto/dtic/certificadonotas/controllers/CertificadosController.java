package bo.edu.uto.dtic.certificadonotas.controllers;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
 
import bo.edu.uto.dtic.certificadonotas.controllers.reportes.CertificadoPDF;
import bo.edu.uto.dtic.certificadonotas.mappers.RegistrosMapper;
import bo.edu.uto.dtic.certificadonotas.models.Facultad;
import bo.edu.uto.dtic.certificadonotas.models.Registro;

import org.springframework.http.MediaType;

import org.springframework.http.HttpHeaders;

@RestController
@CrossOrigin(origins = "*",methods = {RequestMethod.GET,RequestMethod.POST})
@RequestMapping("/certificado")
public class CertificadosController {
    @Autowired
    private RegistrosController registrosController;
    @Autowired
    private CertificadoPDF certificadoPDF;

    @PostMapping(value = "/universitario",produces=MediaType.APPLICATION_PDF_VALUE)
    public ResponseEntity<InputStreamResource> universitario(Integer id_estudiante,String cadena)throws IOException{
        List<Integer> l=convertir(cadena);

        Registro r=new Registro();
        r.setGestiones(l);
        r.setId_estudiante(id_estudiante);
        List<Registro> datos=new ArrayList<Registro>();
        datos = registrosController.impresion(r);
        ByteArrayInputStream res = certificadoPDF.certificado(datos);
        
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Disposition","inline; attachment; filename=Certificado_de_notas.pdf;");
        return ResponseEntity.ok().headers(headers).contentType(MediaType.APPLICATION_PDF).body(new InputStreamResource(res));
    }

    @Autowired
    private RegistrosMapper registrosMapper;
    @PostMapping(value = "/facultad",produces=MediaType.APPLICATION_PDF_VALUE)
    public ResponseEntity<InputStreamResource> facultad(String id_facultad,Integer id_gestion)throws IOException{
        
        Facultad est=new Facultad();
        est.setId_facultad(id_facultad);
        est.setId_gestion(id_gestion);
        List<Registro> datos=new ArrayList<Registro>();
        datos = registrosMapper.notasByIdFacultadAndIdGestion(est);
        ByteArrayInputStream res = certificadoPDF.certificado(datos);
        
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Disposition","inline; attachment; filename=Certificado_de_notas.pdf;");
        return ResponseEntity.ok().headers(headers).contentType(MediaType.APPLICATION_PDF).body(new InputStreamResource(res));
    
    }

    @PostMapping(value = "/carrera",produces=MediaType.APPLICATION_PDF_VALUE)
    public ResponseEntity<InputStreamResource> carrera(Integer id_carrera,Integer id_gestion)throws IOException{
        
        Facultad est=new Facultad();
        est.setId_carrera(id_carrera);
        est.setId_gestion(id_gestion);
        List<Registro> datos=new ArrayList<Registro>();
        datos = registrosMapper.notasByIdCarreraAndIdGestion(est);
        System.out.println(est);
        ByteArrayInputStream res = certificadoPDF.certificado(datos);
        
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Disposition","inline; attachment; filename=Certificado_de_notas.pdf;");
        return ResponseEntity.ok().headers(headers).contentType(MediaType.APPLICATION_PDF).body(new InputStreamResource(res));
    
    }

    public List<Integer> convertir(String cad){
        List<Integer> l=new ArrayList<Integer>();
        int i,n,p;
        i=0;n=cad.length();p=0;
        while(i<n){
            if(cad.charAt(i)=='_'){
                l.add(Integer.parseInt(cad.substring(p, i)));
                p=i+1;
            }
            i++;    
        }
        return l;
    }
}
