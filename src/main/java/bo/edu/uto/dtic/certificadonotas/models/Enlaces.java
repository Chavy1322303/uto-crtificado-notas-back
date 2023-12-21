package bo.edu.uto.dtic.certificadonotas.models;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Enlaces {
	private Integer id_enlace;
	private Integer id_enlace_padre;
	private Boolean id_estado;
	private Integer orden;
	private Integer nivel;
	private String enlace;
	private String ruta;
	private String posicion;
	private List<Enlaces> enlaces;

	private Integer id_rol;
}
