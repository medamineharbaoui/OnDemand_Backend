package tn.homejek.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.homejek.model.Client;
import tn.homejek.service.ClientService;

import java.util.List;

@RestController
@RequestMapping("/rest/api/client")
public class ClientController {

    @Autowired
    ClientService clientService;

    @GetMapping("/getAll")
    public ResponseEntity<List<Client>> getAll (){
        return ResponseEntity.ok(clientService.getAllClients());
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Client> getOneById (@PathVariable Long id){
        return ResponseEntity.ok(clientService.getClient(id));
    }

    @PostMapping("/ban")
    public ResponseEntity<Void> ban (@RequestParam Long id){
        clientService.banClient(id);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/delete")
    public ResponseEntity<Void> delete (@RequestParam Long id){
        clientService.deleteClient(id);
        return ResponseEntity.ok().build();
    }
}
