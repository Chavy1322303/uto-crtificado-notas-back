package bo.edu.uto.dtic.certificadonotas.models;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Registro {
    private String _gestion;
	private Integer id_gestion;
	private String nombre;
	private String programa;	
	private String sigla;
	private Integer id_estudiante;
    private List<Nota> notas;

	public List<Integer> gestiones;
	public String id_facultad;

}
