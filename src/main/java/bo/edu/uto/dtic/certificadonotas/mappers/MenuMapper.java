package bo.edu.uto.dtic.certificadonotas.mappers;

import java.util.List;

import bo.edu.uto.dtic.certificadonotas.models.Enlaces;


public interface MenuMapper {
    public List<Enlaces> getById(Integer id_rol);
}
