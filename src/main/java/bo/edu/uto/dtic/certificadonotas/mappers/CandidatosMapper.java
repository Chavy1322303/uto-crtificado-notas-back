package bo.edu.uto.dtic.certificadonotas.mappers;

import java.util.List;
import org.springframework.stereotype.Repository;

import bo.edu.uto.dtic.certificadonotas.models.Candidatos_ext;


@Repository
public interface CandidatosMapper {

	public List<Candidatos_ext> getAll(Candidatos_ext dato);

	public Candidatos_ext getById(Integer id);

	public int insert(Candidatos_ext dato);

	public int update(Candidatos_ext dato);

	public int delete(Candidatos_ext dato);
}
