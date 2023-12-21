package bo.edu.uto.dtic.certificadonotas.models;

import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(Include.NON_NULL)
public class Bitacora {
    private Integer id_bitacora;
	private Integer id_usuario;
	private Integer id_rol;
	private Date fecha;
	private String descripcion;
	private String nom_documento;
	private String tipo;
	private Integer id_gestion;
	private Integer id_estudiante;
	private String id_facultad;
	private Integer id_carrera;
	private Boolean id_estado;
}
