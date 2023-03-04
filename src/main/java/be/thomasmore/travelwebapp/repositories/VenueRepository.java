package be.thomasmore.travelwebapp.repositories;

import be.thomasmore.travelwebapp.model.Venue;
import org.springframework.data.repository.CrudRepository;

public interface VenueRepository extends CrudRepository<Venue,Integer> {
}
