package ml.vitekbatek.rest.repository;

import ml.vitekbatek.rest.model.Client;
import ml.vitekbatek.rest.model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepository extends JpaRepository<Transaction, Integer> {
}
