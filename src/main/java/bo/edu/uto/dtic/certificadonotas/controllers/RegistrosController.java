package bo.edu.uto.dtic.certificadonotas.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import bo.edu.uto.dtic.certificadonotas.mappers.EstudiantesMapper;
import bo.edu.uto.dtic.certificadonotas.mappers.RegistrosMapper;
import bo.edu.uto.dtic.certificadonotas.models.Estudiante;
import bo.edu.uto.dtic.certificadonotas.models.Facultad;
import bo.edu.uto.dtic.certificadonotas.models.Registro;

@RestController
@CrossOrigin(origins = "*" , methods = {RequestMethod.POST,RequestMethod.GET})
public class RegistrosController {
    @Autowired
    private RegistrosMapper registrosMapper;

    @Autowired
    private EstudiantesMapper estudiantesMapper;

    @GetMapping("/estudianteById")
    public ResponseEntity<?> estudianteByGestion(@RequestBody Registro r) {
        
        Map<String, Object> respuesta = new HashMap<String, Object>();
        HttpStatus estado = HttpStatus.OK;
        Registro registro = null;
        respuesta.put("dato", r.getId_estudiante());
        try {
            registro = registrosMapper.getByIdEstudianteAndIdGestion(r);
            respuesta.put("resultado", registro);
        } catch (Exception e) {
            respuesta.put("mensaje", "Error al realizar la consulta.");
            respuesta.put("debug", e.toString());
            estado = HttpStatus.INTERNAL_SERVER_ERROR;
        }
        return new ResponseEntity<Object>(respuesta, estado);
    }

    @GetMapping("/estudianteByGestion")
    public ResponseEntity<?> estudianteMoreGestion(@RequestBody Registro r) {
        Map<String, Object> respuesta = new HashMap<String, Object>();
        HttpStatus estado = HttpStatus.OK;
        Registro registro = null;
        List<Registro> registros = new ArrayList<Registro>();
        respuesta.put("dato", r.getId_estudiante());
        try {
            List<Integer> l=r.getGestiones();
            for(int i=0;i<l.size();i++){
                r.setId_gestion(l.get(i));
                registro = registrosMapper.getByIdEstudianteAndIdGestion(r);
                registros.add(registro);
            }
            respuesta.put("resultado", registros);
        } catch (Exception e) {
            respuesta.put("mensaje", "Error al realizar la consulta.");
            respuesta.put("debug", e.toString());
            estado = HttpStatus.INTERNAL_SERVER_ERROR;
        }
        return new ResponseEntity<Object>(respuesta, estado);
    }

    @GetMapping("/registroNotasByIdCarreraAndIdGestion")
    public ResponseEntity<?> notasByIdCarreraAndIdGestion(@RequestBody Facultad t){
        Map<String, Object> respuesta = new HashMap<String , Object>();
        HttpStatus estado = HttpStatus.OK;

        respuesta.put("dato","Estudiantes por carrera y gestion");
        try {
            respuesta.put("resultado", registrosMapper.notasByIdFacultadAndIdGestion(t));
        } catch (Exception e) {
            respuesta.put("mensaje", "Error al realizar la consulta.");
            respuesta.put("debug", e.toString());
            estado = HttpStatus.INTERNAL_SERVER_ERROR;
        }
        return new ResponseEntity<Object>(respuesta, estado);
    }

    public List<Registro> impresion(Registro r) {
        Registro registro = null;
        List<Registro> registros = new ArrayList<Registro>();
        List<Integer> l=new ArrayList<Integer>();
        l= r.getGestiones();
        
        for(int i=0;i<l.size();i++){
            r.setId_gestion(l.get(i));
            registro = registrosMapper.getByIdEstudianteAndIdGestion(r);
            registros.add(registro);
        }
        return registros;
    }
}