package tn.homejek.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.homejek.model.ServiceProvider;
import tn.homejek.model.ValidationStatus;
import tn.homejek.repository.ServiceProviderRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ServiceProviderServiceImp implements ServiceProviderService {

    @Autowired
    ServiceProviderRepository serviceProviderRepository;

    @Override
    public ServiceProvider addServiceProvider(ServiceProvider serviceProvider) {
        serviceProvider.setStatus(ValidationStatus.NOT_VALID);
        return serviceProviderRepository.save(serviceProvider);
    }

    @Override
    public ServiceProvider updateServiceProvider(ServiceProvider serviceProvider) {
        return serviceProviderRepository.save(serviceProvider);
    }

    @Override
    public void banServiceProvider(Long serviceProviderId) {
        ServiceProvider serviceProvider = serviceProviderRepository.findById(serviceProviderId).get();
        serviceProvider.setStatus(ValidationStatus.BANNED);
        serviceProviderRepository.save(serviceProvider);
    }

    @Override
    public void deleteServiceProvider(Long serviceProviderId) {
        ServiceProvider serviceProvider = serviceProviderRepository.findById(serviceProviderId).get();
        serviceProvider.setStatus(ValidationStatus.DELETED);
        serviceProviderRepository.save(serviceProvider);
    }

    @Override
    public void acceptServiceProvider(Long serviceProviderId) {
        ServiceProvider serviceProvider = serviceProviderRepository.findById(serviceProviderId).get();
        serviceProvider.setStatus(ValidationStatus.VALID);
        serviceProviderRepository.save(serviceProvider);
    }

    @Override
    public ServiceProvider getServiceProvider(Long serviceProviderId) {
        return serviceProviderRepository.findById(serviceProviderId).get();
    }

    @Override
    public List<ServiceProvider> getPendingServiceProviders() {
        return serviceProviderRepository
                .findAll()
                .stream()
                .filter(elt -> elt.getStatus() == ValidationStatus.NOT_VALID)
                .collect(Collectors.toList());

    }

    @Override
    public List<ServiceProvider> getAllServiceProviders() {
        return serviceProviderRepository.findAll().stream().filter(elt -> elt.getStatus() == ValidationStatus.VALID).collect(Collectors.toList());
    }
}
