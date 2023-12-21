package bo.edu.uto.dtic.certificadonotas.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import bo.edu.uto.dtic.certificadonotas.mappers.CarrerasMapper;
import bo.edu.uto.dtic.certificadonotas.mappers.EstudiantesMapper;
import bo.edu.uto.dtic.certificadonotas.mappers.FacultadesMapper;
import bo.edu.uto.dtic.certificadonotas.models.Carrera;
import bo.edu.uto.dtic.certificadonotas.models.Estudiante;
import bo.edu.uto.dtic.certificadonotas.models.Facultad;
import bo.edu.uto.dtic.certificadonotas.models.Registro;

@RestController
@CrossOrigin(origins = "*" , methods = {RequestMethod.POST , RequestMethod.GET})

public class FiltrosController {
    
    @Autowired
    private EstudiantesMapper estudiantesMapper;
    @Autowired
    private FacultadesMapper facultadesMapper;
    @Autowired
    private CarrerasMapper carrerasMapper;

    @PostMapping("/filtrarByNombre")
    public ResponseEntity<?> filtrarByNombre(@RequestBody Registro r){
        Map<String , Object> respuesta = new HashMap <String, Object>();
        HttpStatus estado = HttpStatus.OK;
        String cad=cadenaBusc(r.getNombre());

        try {
            List<Estudiante> estudiantes = estudiantesMapper.FilterByName(cad);
            respuesta.put("resultado",estudiantes);
        } catch (Exception e) {
            respuesta.put("mensaje" , "Error al realizar consulta");
            respuesta.put("debug" , e.toString());
            estado = HttpStatus.INTERNAL_SERVER_ERROR;
        }
        return new ResponseEntity<Object>(respuesta, estado);
    }

    @PostMapping("/filtrarByNombreFacultad")
    public ResponseEntity<?> filtrarByNombreFacultad(@RequestBody Registro r){
        Map<String , Object> respuesta = new HashMap <String, Object>();
        HttpStatus estado = HttpStatus.OK;
        String cad=cadenaBusc(r.getNombre());

        try {
            List<Estudiante> estudiantes = estudiantesMapper.FilterByFacultad(cad,r.getId_facultad());
            respuesta.put("resultado",estudiantes);
        } catch (Exception e) {
            respuesta.put("mensaje" , "Error al realizar consulta");
            respuesta.put("debug" , e.toString());
            estado = HttpStatus.INTERNAL_SERVER_ERROR;
        }
        return new ResponseEntity<Object>(respuesta, estado);
    }

    @GetMapping("/filtrarFacultad")
    public ResponseEntity<?> filtrarFacultad(){
        Map<String , Object> respuesta = new HashMap <String, Object>();
            HttpStatus estado = HttpStatus.OK;
        try {
            List<Facultad> facultades = facultadesMapper.filtrarFacultad();
            respuesta.put("resultado",facultades);
        } catch (Exception e) {
            respuesta.put("mensaje", "Error al realizar consulta");
            respuesta.put("debug", e.toString());
            estado = HttpStatus.INTERNAL_SERVER_ERROR;
        }
        return new ResponseEntity<Object>(respuesta, estado);
    }

    @GetMapping("/filtrarFacultadById")
    public ResponseEntity<?> filtrarFacultadById(String id_facultad){
        Map<String , Object> respuesta = new HashMap <String, Object>();
        HttpStatus estado = HttpStatus.OK;
        try {
            List<Facultad> facultades = facultadesMapper.filtrarByFacultad(id_facultad);
            respuesta.put("resultado",facultades);
        } catch (Exception e) {
            respuesta.put("mensaje", "Error al realizar consulta");
            respuesta.put("debug", e.toString());
            estado = HttpStatus.INTERNAL_SERVER_ERROR;
        }
        return new ResponseEntity<Object>(respuesta, estado);
    }

    @GetMapping("/filtrarByEstudiante")
    public ResponseEntity<?> filtrarByEstudiante(Integer idEstudiante){
        Map<String , Object> respuesta = new HashMap <String, Object>();
        HttpStatus estado = HttpStatus.OK;

        try {
            List<Estudiante> estudiantes = estudiantesMapper.FilterByEstudiante(idEstudiante);
            respuesta.put("resultado",estudiantes);
        } catch (Exception e) {
            respuesta.put("mensaje" , "Error al realizar consulta");
            respuesta.put("debug" , e.toString());
            estado = HttpStatus.INTERNAL_SERVER_ERROR;
        }
        return new ResponseEntity<Object>(respuesta, estado);
    }


    @GetMapping("/filterCarreraByFacultad")
    public ResponseEntity<?> filterCarreraByFacultad(String id_facultad){
        Map<String , Object> respuesta = new HashMap <String, Object>();
        HttpStatus estado = HttpStatus.OK;
        try {
            List<Carrera> carreras = carrerasMapper.filterCarreraByFacultad(id_facultad);
            
            respuesta.put("resultado",carreras);
        } catch (Exception e) {
            respuesta.put("mensaje", "Error al realizar consulta");
            respuesta.put("debug", e.toString());
            estado = HttpStatus.INTERNAL_SERVER_ERROR;
        }
        return new ResponseEntity<Object>(respuesta, estado);
    }
    @GetMapping("/filterCarreraByGestion")
    public ResponseEntity<?> filterCarreraByGestion(Integer id_carrera){
        Map<String , Object> respuesta = new HashMap <String, Object>();
        HttpStatus estado = HttpStatus.OK;
        try {
            List<Carrera> carreras = carrerasMapper.filterCarreraByGestion(id_carrera);
            
            respuesta.put("resultado",carreras);
        } catch (Exception e) {
            respuesta.put("mensaje", "Error al realizar consulta");
            respuesta.put("debug", e.toString());
            estado = HttpStatus.INTERNAL_SERVER_ERROR;
        }
        return new ResponseEntity<Object>(respuesta, estado);
    }

    public String cadenaBusc(String cad){
        String res="";
        res= cad.replaceAll("\\s+","%");
        return "%"+res+"%";
    }
}