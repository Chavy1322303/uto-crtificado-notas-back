package bo.edu.uto.dtic.certificadonotas.models;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Facultad {
    private String id_facultad;
	private Integer  id_gestion;
	private String  _gestion; 
	private String facultad;
	private String abrev;	
	
	private Integer id_carrera;	
}
