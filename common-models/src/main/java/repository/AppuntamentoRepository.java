package repository;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import model.Appuntamento;

public interface AppuntamentoRepository extends MongoRepository<Appuntamento, ObjectId>{

}
