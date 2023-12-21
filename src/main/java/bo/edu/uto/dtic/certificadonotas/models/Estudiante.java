package bo.edu.uto.dtic.certificadonotas.models;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Estudiante {
    private Integer id_estudiante;
    private Integer id_gestion;
    private String abrev;
    private String programa;
    private String nombre; 
    private String _gestion; 

    private Integer id_carrera;
}
