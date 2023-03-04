package be.thomasmore.travelwebapp.repositories;

import be.thomasmore.travelwebapp.model.Client;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.data.repository.CrudRepository;

public interface ClientRepository extends CrudRepository<Client,Integer> {

}
