package bo.edu.uto.dtic.certificadonotas.mappers;

import java.util.List;

import bo.edu.uto.dtic.certificadonotas.models.Facultad;

public interface FacultadesMapper {
    public List<Facultad> filtrarFacultad();
    public List<Facultad> filtrarByFacultad(String id_facultad);
    public Facultad permisoUsuario(Integer id_usuario);
}
