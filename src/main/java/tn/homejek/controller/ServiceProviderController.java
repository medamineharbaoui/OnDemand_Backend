package tn.homejek.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.homejek.model.ServiceProvider;
import tn.homejek.service.ServiceProviderService;

import java.util.List;

@RestController
@RequestMapping("/rest/api/serviceProvider")
public class ServiceProviderController {

    @Autowired
    ServiceProviderService serviceProviderService;

    @GetMapping("/getPending")
    public ResponseEntity<List<ServiceProvider>> getPending (){
        return ResponseEntity.ok(serviceProviderService.getPendingServiceProviders());
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<ServiceProvider>> getAll (){
        return ResponseEntity.ok(serviceProviderService.getAllServiceProviders());
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<ServiceProvider> getOneById (@PathVariable Long id){
        return ResponseEntity.ok(serviceProviderService.getServiceProvider(id));
    }

    @PostMapping("/accept")
    public ResponseEntity<Void> accept (@RequestParam Long id){
        serviceProviderService.acceptServiceProvider(id);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/ban")
    public ResponseEntity<Void> ban (@RequestParam Long id){
        serviceProviderService.banServiceProvider(id);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/delete")
    public ResponseEntity<Void> delete (@RequestParam Long id){
        serviceProviderService.deleteServiceProvider(id);
        return ResponseEntity.ok().build();
    }
}
