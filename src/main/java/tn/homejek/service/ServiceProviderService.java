package tn.homejek.service;

import tn.homejek.model.ServiceProvider;

import java.util.List;

public interface ServiceProviderService {

    ServiceProvider addServiceProvider(ServiceProvider serviceProvider);

    ServiceProvider updateServiceProvider(ServiceProvider serviceProvider);

    void banServiceProvider(Long serviceProviderId);

    void deleteServiceProvider(Long serviceProviderId);

    void acceptServiceProvider(Long serviceProviderId);

    ServiceProvider getServiceProvider(Long serviceProviderId);

    List<ServiceProvider> getAllServiceProviders();

    List<ServiceProvider> getPendingServiceProviders();

}
