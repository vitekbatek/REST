package ml.vitekbatek.rest.repository;

import ml.vitekbatek.rest.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Integer>  {
}
