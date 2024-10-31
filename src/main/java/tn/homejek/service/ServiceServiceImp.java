package tn.homejek.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.homejek.model.Service_;
import tn.homejek.model.ValidationStatus;
import tn.homejek.repository.ServiceRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ServiceServiceImp implements ServiceService {

    @Autowired
    ServiceRepository serviceRepository;

    @Autowired
    ServiceProviderService serviceProviderService;
    @Override
    public Service_ addService(Service_ service) {
        return serviceRepository.save(service);
    }

    @Override
    public Service_ updateService(Service_ service) {
        return serviceRepository.save(service);
    }

    @Override
    public void deleteService(Long serviceId) {
        Service_ service = serviceRepository.findById(serviceId).get();
        service.setStatus(ValidationStatus.DELETED);
        serviceRepository.save(service);
    }

    @Override
    public Service_ getService(Long serviceId) {
        return serviceRepository.findById(serviceId).get();
    }

    @Override
    public List<Service_> getAllServices() {
        return serviceRepository.findAll().stream()
                .filter(elt -> elt.getStatus() == ValidationStatus.VALID)
                .collect(Collectors.toList());
    }

    @Override
    public List<Service_> getServicesByCategory(Long catId) {
        return serviceRepository
                .findAll()
                .stream()
                .filter(elt -> elt.getCategory().getId() == catId)
                .collect(Collectors.toList());
    }
}
