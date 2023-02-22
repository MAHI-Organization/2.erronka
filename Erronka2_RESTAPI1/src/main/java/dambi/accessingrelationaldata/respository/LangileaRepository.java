package dambi.accessingrelationaldata.respository;

import org.springframework.data.repository.CrudRepository;

import dambi.accessingrelationaldata.model.Langilea;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

public interface LangileaRepository extends CrudRepository<Langilea, String> {

}
