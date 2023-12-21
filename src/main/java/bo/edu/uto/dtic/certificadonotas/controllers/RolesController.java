package bo.edu.uto.dtic.certificadonotas.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


import bo.edu.uto.dtic.certificadonotas.mappers.RolesMapper;
import bo.edu.uto.dtic.certificadonotas.models.Rol;


@RestController
@CrossOrigin(origins = "*", methods= {RequestMethod.POST,RequestMethod.GET})
public class RolesController {

	@Autowired
	private RolesMapper rolesMapper;

	@GetMapping("/roles")
	public ResponseEntity<?> getById(Integer id_usuario) {
		Map<String, Object> respuesta = new HashMap<String, Object>();
		HttpStatus estado = HttpStatus.OK;
		List<Rol> resultado = null;
		respuesta.put("usuario", id_usuario);
		try {
			resultado = rolesMapper.getById(id_usuario);
			respuesta.put("resultado", resultado);
		} catch (Exception e) {
			respuesta.put("mensaje", "Error al realizar la consulta.");
			respuesta.put("debug", e.toString());
			estado = HttpStatus.INTERNAL_SERVER_ERROR;
		}
		return new ResponseEntity<Object>(respuesta, estado);
	}
        
	@GetMapping("/getRolById")
	public ResponseEntity<?> getRolById(Integer id_usuario,Integer id_rol) {
		Map<String, Object> respuesta = new HashMap<String, Object>();
		HttpStatus estado = HttpStatus.OK;
		Rol resultado = null;
		respuesta.put("usuario", id_usuario);
		System.out.println(id_usuario);
		System.out.println(id_rol);
		try {
			resultado = rolesMapper.getRolById(id_usuario,id_rol);
			respuesta.put("resultado", resultado);
		} catch (Exception e) {
			respuesta.put("mensaje", "Error al realizar la consulta.");
			respuesta.put("debug", e.toString());
			estado = HttpStatus.INTERNAL_SERVER_ERROR;
		}
		return new ResponseEntity<Object>(respuesta, estado);
	}

}
