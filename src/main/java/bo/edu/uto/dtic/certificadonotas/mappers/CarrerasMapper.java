package bo.edu.uto.dtic.certificadonotas.mappers;

import java.util.List;
import bo.edu.uto.dtic.certificadonotas.models.Carrera;

public interface CarrerasMapper {
    public List<Carrera> filterCarreraByFacultad(String id_facultad);
    public List<Carrera> filterCarreraByGestion(Integer id_carrera);
}
