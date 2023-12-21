package bo.edu.uto.dtic.certificadonotas.controllers.reportes;

import org.springframework.stereotype.Component;

@Component
public class auxiliar {
    public String unidad(int n){
        switch (n){
            case 1: return "UNO";
            case 2: return "DOS";
            case 3: return "TRES";
            case 4: return "CUATRO";
            case 5: return "CINCO";
            case 6: return "SEIS";
            case 7: return "SIETE";
            case 8: return "OCHO";
            case 9: return "NUEVE";
            default: return "";
        }
    }
    public String valor(int d,int u){
        String res;
        switch(d){
            case 0: return unidad(u);
            case 1: {
                switch(u){
                    case 0: res= "DIEZ";break;
                    case 1: res= "ONCE";break;
                    case 2: res= "DOCE";break;
                    case 3: res= "TRECE";break;
                    case 4: res= "CATORCE";break;
                    case 5: res= "QUINCE";break;
                    default: res= "DIECI"+unidad(u);break;
                }
            }break;
            case 2: res="VEINTE"+( u==0? "":unidad(u)); break;
            case 3:{
                res= "TREINTA"+( u==0? "":" Y "+unidad(u));
            }break;
            case 4: res= "CUARENTA"+( u==0? "":" Y "+unidad(u)); break;
            case 5: res= "CINCUENTA"+( u==0? "":" Y "+unidad(u)); break;
            case 6: res= "SESENTA"+( u==0? "":" Y "+unidad(u)); break;
            case 7: res= "SETENTA"+( u==0? "":" Y "+unidad(u)); break;
            case 8: res= "OCHENTA"+( u==0? "":" Y "+unidad(u)); break;
            case 9: res= "NOVENTA"+( u==0? "":" Y "+unidad(u)); break;
            default: res= "CIEN";
        }
        return res;
    }

    public String literal(int n){
        String res="";
        
        res=n!=0?valor((n/10),(n%10)): "CERO";
        return res;
    }
    public String mes(String cad){
        Integer x=Integer.parseInt(cad);
        switch(x){
            case 1:  return "Enero                                       ";
            case 2:  return "Febrero                                   ";
            case 3:  return "Marzo                                      ";
            case 4:  return "Abril                                         ";
            case 5:  return "Mayo                                        ";
            case 6:  return "Junio                                         ";
            case 7:  return "Julio                                          ";
            case 8:  return "Agosto                                      ";
            case 9:  return "Septiembre                             ";
            case 10: return "Octubre                                    ";
            case 11: return "Noviembre                               ";
            case 12: return "Diciembre                                 ";
            default: return "";
        }
    }
    public String formatoFecha(String f){
        String res="";
        res= f.substring(6, 8)+"            "+mes(f.substring(4, 6))+f.substring(2, 4);
        return res;
    }
}
