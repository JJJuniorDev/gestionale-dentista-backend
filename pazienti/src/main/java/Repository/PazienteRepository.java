package Repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import Model.Paziente;

public interface PazienteRepository extends MongoRepository<Paziente, String>{
	List<Paziente> findByDentistaId(String dentistaId);
}
