package repositories;

import models.User;
import models.WineBottle;

import org.springframework.data.neo4j.repository.GraphRepository;

public interface WineBottleRepository extends GraphRepository<WineBottle> {

}