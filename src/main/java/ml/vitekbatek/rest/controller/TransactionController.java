package ml.vitekbatek.rest.controller;

import ml.vitekbatek.rest.model.Transaction;
import ml.vitekbatek.rest.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TransactionController {
    private final TransactionService transactionService;

    @Autowired
    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @PostMapping(value = "/services")
    public ResponseEntity<?> create(@RequestBody Transaction transaction) {
        transactionService.create(transaction);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping(value = "/services")
    public ResponseEntity<List<Transaction>> read() {
        final List<Transaction> clients = transactionService.readAll();
        return clients != null &&  !clients.isEmpty()
                ? new ResponseEntity<>(clients, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping(value = "/services/{id}")
    public ResponseEntity<Transaction> read(@PathVariable(name = "id") int id) {
        final Transaction client = transactionService.readOne(id);
        return client != null
                ? new ResponseEntity<>(client, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping(value = "/services/{id}")
    public ResponseEntity<?> delete(@PathVariable(name = "id") int id) {
        final boolean deleted = transactionService.delete(id);
        return deleted
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }
}
