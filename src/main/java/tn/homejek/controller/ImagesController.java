package tn.homejek.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;
import tn.homejek.model.Client;
import tn.homejek.model.ServiceProvider;
import tn.homejek.model.Service_;
import tn.homejek.service.AttachmentService;
import tn.homejek.service.ClientService;
import tn.homejek.service.ServiceProviderService;
import tn.homejek.service.ServiceService;

@RestController
@RequestMapping("/rest/api/images")
public class ImagesController {

    @Autowired
    AttachmentService attachmentService;

    @Autowired
    ClientService clientService;

    @Autowired
    ServiceProviderService serviceProviderService;

    @Autowired
    ServiceService serviceService;

    @PostMapping("/addClientPersonalImage/{id}")
    public ResponseEntity addClientPersonalImage(@RequestParam("file") MultipartFile file, @PathVariable Long id) {
        try {
            Client client = clientService.getClient(id);
            if (client != null){
                String path = attachmentService.uploadImage(file);
                if (path != null){
                    client.setPersonal_image(path);
                    clientService.updateClient(client);
                    return ResponseEntity.ok().build();
                }else{
                    throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "an error occurred when trying to save the file");
                }
            } else{
                throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "No client found with the given id");
            }
        } catch (Exception ex) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, ex.getMessage());
        }
    }

    @PostMapping("/addSpPersonalImage/{id}")
    public ResponseEntity addSpPersonalImage(@RequestParam("file") MultipartFile file, @PathVariable Long id) {
        try {
            ServiceProvider sp = serviceProviderService.getServiceProvider(id);
            if (sp != null){
                String path = attachmentService.uploadImage(file);
                if (path != null){
                    sp.setPersonal_image(path);
                    serviceProviderService.updateServiceProvider(sp);
                    return ResponseEntity.ok().build();
                }else{
                    throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "an error occurred when trying to save the file");
                }
            } else{
                throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "No service provider found with the given id");
            }
        } catch (Exception ex) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, ex.getMessage());
        }
    }

    @PostMapping("/addSpCinRectoImage/{id}")
    public ResponseEntity addCinRectoImage(@RequestParam("file") MultipartFile file, @PathVariable Long id) {
        try {
            ServiceProvider sp = serviceProviderService.getServiceProvider(id);
            if (sp != null){
                String path = attachmentService.uploadImage(file);
                if (path != null){
                    sp.setCin_recto_image(path);
                    serviceProviderService.updateServiceProvider(sp);
                    return ResponseEntity.ok().build();
                }else{
                    throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "an error occurred when trying to save the file");
                }
            } else{
                throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "No service provider found with the given id");
            }
        } catch (Exception ex) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, ex.getMessage());
        }
    }

    @PostMapping("/addSpCinVersoImage/{id}")
    public ResponseEntity addCinVersoImage(@RequestParam("file") MultipartFile file, @PathVariable Long id) {
        try {
            ServiceProvider sp = serviceProviderService.getServiceProvider(id);
            if (sp != null){
                String path = attachmentService.uploadImage(file);
                if (path != null){
                    sp.setCin_recto_image(path);
                    serviceProviderService.updateServiceProvider(sp);
                    return ResponseEntity.ok().build();
                }else{
                    throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "an error occurred when trying to save the file");
                }
            } else{
                throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "No service provider found with the given id");
            }
        } catch (Exception ex) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, ex.getMessage());
        }
    }

    @PostMapping("/addServiceImage/{id}")
    public ResponseEntity addServiceImage(@RequestParam("file") MultipartFile file, @PathVariable Long id) {
        try {
            Service_ service = serviceService.getService(id);
            if (service != null){
                String path = attachmentService.uploadImage(file);
                if (path != null){
                    service.getImagesUrl().add(path);
                    serviceService.updateService(service);
                    return ResponseEntity.ok().build();
                }else{
                    throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "an error occurred when trying to save the file");
                }
            } else{
                throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "No service found with the given id");
            }
        } catch (Exception ex) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, ex.getMessage());
        }
    }
}
