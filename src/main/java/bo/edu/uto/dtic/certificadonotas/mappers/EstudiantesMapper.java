package bo.edu.uto.dtic.certificadonotas.mappers;

import java.util.List;
import bo.edu.uto.dtic.certificadonotas.models.Estudiante;

public interface EstudiantesMapper {
    public List<Estudiante> FilterByName(String cad);
    public List<Estudiante> FilterByFacultad(String cad,String id_facultad);
    public List<Estudiante> FilterByEstudiante(Integer id_estudiante);
    public List<Estudiante> FilterByGestion(Integer id_estudiante);
    public List<Estudiante> FilterByCarrera(Integer id_carrera, Integer id_gestion);
}
