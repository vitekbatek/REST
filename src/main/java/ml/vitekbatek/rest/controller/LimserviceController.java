package ml.vitekbatek.rest.controller;

import ml.vitekbatek.rest.model.Limservice;
import ml.vitekbatek.rest.service.LimserviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class LimserviceController {

    private final LimserviceService limserviceService;

    @Autowired
    public LimserviceController(LimserviceService limserviceService) {
        this.limserviceService = limserviceService;
    }

    @PostMapping(value = "/limservices")
    public ResponseEntity<?> create(@RequestBody Limservice limservice) {
        limserviceService.create(limservice);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping(value = "/limservices")
    public ResponseEntity<List<Limservice>> read() {
        final List<Limservice> clients = limserviceService.readAll();
        return clients != null &&  !clients.isEmpty()
                ? new ResponseEntity<>(clients, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping(value = "/limservices/{id}")
    public ResponseEntity<Limservice> read(@PathVariable(name = "id") int id) {
        final Limservice client = limserviceService.readOne(id);
        return client != null
                ? new ResponseEntity<>(client, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping(value = "/limservices/{id}")
    public ResponseEntity<?> delete(@PathVariable(name = "id") int id) {
        final boolean deleted = limserviceService.delete(id);
        return deleted
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }
}

