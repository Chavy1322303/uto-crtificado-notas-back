package bo.edu.uto.dtic.certificadonotas.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import bo.edu.uto.dtic.certificadonotas.mappers.MenuMapper;
import bo.edu.uto.dtic.certificadonotas.models.Enlaces;

@RestController
@CrossOrigin(origins = "*", methods= {RequestMethod.POST,RequestMethod.GET})
public class MenuController {

    @Autowired
    private MenuMapper menuMapper;

    @GetMapping("/menu")
    public ResponseEntity<?> menus(Integer id_rol) {
        Map<String, Object> respuesta = new HashMap<String, Object>();
        HttpStatus estado = HttpStatus.OK;
        List<Enlaces> enlaces = null;
        respuesta.put("dato",id_rol);
        try {
            enlaces = menuMapper.getById(id_rol);
            respuesta.put("resultado", enlaces);
        } catch (Exception e) {
            respuesta.put("mensaje", "Error al realizar la consulta.");
            respuesta.put("debug", e.toString());
            estado = HttpStatus.INTERNAL_SERVER_ERROR;
        }
        return new ResponseEntity<Object>(respuesta, estado);
    }

}
