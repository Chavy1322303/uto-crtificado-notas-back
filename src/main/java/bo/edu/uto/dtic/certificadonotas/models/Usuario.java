package bo.edu.uto.dtic.certificadonotas.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class Usuario {
	private String  nombres;
	private String  paterno;
	private String  materno;
	private String  rol;
	private String  apodo;
    private Integer id_usuario;
	private String recordatorio;
}
