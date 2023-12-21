package bo.edu.uto.dtic.certificadonotas.models;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Nota {
	private String sigla;
	private String materia;
	private Integer nf;
	private Integer nota;
	private Integer hrs_totales;
}
