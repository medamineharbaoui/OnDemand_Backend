package tn.homejek.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import tn.homejek.model.Client;
import tn.homejek.model.ServiceProvider;
import tn.homejek.model.User;
import tn.homejek.service.ClientService;
import tn.homejek.service.ServiceProviderService;
import tn.homejek.service.UserService;

@RestController
@RequestMapping("/rest/api/user")
public class UserController {

    @Autowired
    UserService userService;

    @Autowired
    ServiceProviderService serviceProviderService;

    @Autowired
    ClientService clientService;

    @PostMapping("/registerServiceProvider")
    public ResponseEntity<User> registerServiceProvider(@RequestBody ServiceProvider sp){
        try {
            sp = serviceProviderService.addServiceProvider(sp);
            return ResponseEntity.ok(sp);
        }catch (Exception ex){
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, ex.getMessage());
        }
    }

    @PostMapping("/registerClient")
    public ResponseEntity<User> registerClient(@RequestBody Client client){
        try {
            client = clientService.addClient(client);
            return ResponseEntity.ok(client);
        }catch (Exception ex){
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, ex.getMessage());
        }
    }
}
