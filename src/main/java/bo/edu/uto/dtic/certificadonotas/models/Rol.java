package bo.edu.uto.dtic.certificadonotas.models;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(Include.NON_NULL)
public class Rol {
	private Integer id_rol;
	private Boolean id_estado;
	private String rol;
	private String descripcion;
	private Integer id_sistema;
	
	private Integer id_usuario;
	private String recordatorio;
}
