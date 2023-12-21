package bo.edu.uto.dtic.certificadonotas.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Carrera {
    private String id_facultad;
	private String facultad;
	private String abrev;
	private Integer id_carrera;
	private String carrera;
	private Integer id_gestion;
	private String _gestion;
}
