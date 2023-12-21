package bo.edu.uto.dtic.certificadonotas.mappers;

import java.util.List;

import bo.edu.uto.dtic.certificadonotas.models.Bitacora;

public interface BitacoraMapper {
    public List<Bitacora>  bitacoraByUsuario(Integer id_usuario);

    public int insert (Bitacora dato);
}
