package bo.edu.uto.dtic.certificadonotas.mappers;

import java.util.List;

import bo.edu.uto.dtic.certificadonotas.models.Facultad;
import bo.edu.uto.dtic.certificadonotas.models.Registro;

public interface RegistrosMapper {
    public Registro getByIdEstudianteAndIdGestion (Registro r);
    public List<Registro> notasByIdFacultadAndIdGestion(Facultad t);
    public List<Registro> notasByIdCarreraAndIdGestion(Facultad t);
}
