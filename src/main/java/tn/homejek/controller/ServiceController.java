package tn.homejek.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import tn.homejek.model.Service_;
import tn.homejek.service.ServiceService;

import java.util.List;

@RestController
@RequestMapping("/rest/api/service")
public class ServiceController {

    @Autowired
    ServiceService serviceService;

    @PostMapping("/add")
    public ResponseEntity<Service_> addService(@RequestBody Service_ service){
        try {
            service = serviceService.addService(service);
            return ResponseEntity.ok(service);
        }catch (Exception ex){
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, ex.getMessage());
        }
    }

    @GetMapping("/getByCategory")
    public ResponseEntity<List<Service_>> getBySp(Long catId){
        return ResponseEntity.ok(serviceService.getServicesByCategory(catId));
    }
}
