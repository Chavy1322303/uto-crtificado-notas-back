package bo.edu.uto.dtic.certificadonotas.controllers;

import java.util.HashMap;
import java.util.Map;

import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import bo.edu.uto.dtic.certificadonotas.mappers.FacultadesMapper;
import bo.edu.uto.dtic.certificadonotas.mappers.UsuarioMapper;
import bo.edu.uto.dtic.certificadonotas.models.Facultad;
import bo.edu.uto.dtic.certificadonotas.models.Usuario;

@RestController
@CrossOrigin(origins = "*", methods= {RequestMethod.POST,RequestMethod.GET})
public class UsuarioController {
    @Autowired
    private UsuarioMapper usuarioMapper;
    @Autowired
    private FacultadesMapper facultadesMapper;

    @GetMapping("/perfil")
    public ResponseEntity<?> DetallePerfil(Integer id_usuario) {
        Map<String, Object> respuesta = new HashMap<String, Object>();
        HttpStatus estado = HttpStatus.OK;
        Usuario user = null;

        respuesta.put("perfil", id_usuario);
        try {
            user = usuarioMapper.getById(id_usuario);
            respuesta.put("resultado", user);
        } catch (Exception e) {
            respuesta.put("mensaje", "Error al realizar la consulta.");
            respuesta.put("debug", e.toString());
            estado = HttpStatus.INTERNAL_SERVER_ERROR;
        }
        return new ResponseEntity<Object>(respuesta, estado);
    }

    @GetMapping("/permisoUsuario")
    public ResponseEntity<?> permiso(Integer id_usuario) {
        Map<String, Object> respuesta = new HashMap<String, Object>();
        HttpStatus estado = HttpStatus.OK;
        Facultad user = null;
        respuesta.put("perfil", 0);
        try {
            user=facultadesMapper.permisoUsuario(id_usuario);
            respuesta.put("resultado", user);
        } catch (Exception e) {
            respuesta.put("mensaje", "Error al realizar la consulta.");
            respuesta.put("debug", e.toString());
            estado = HttpStatus.INTERNAL_SERVER_ERROR;
        }
        return new ResponseEntity<Object>(respuesta, estado);
    }

    public String clave(String cad){
        String res="";
        for(int i=0;i<cad.length();i++){
            res=res+cad.charAt(i)+'.';
        }
        return res;
    }

}
