package bo.edu.uto.dtic.certificadonotas.mappers;

import java.util.List;

import bo.edu.uto.dtic.certificadonotas.models.Rol;

public interface RolesMapper {
	public List<Rol> getAll(Integer id_usuario);
	public List<Rol> getById(Integer id_usuario);
	public Rol getRolById(Integer id_usuario,Integer id_rol);
}
