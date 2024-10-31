package tn.homejek.service;

import tn.homejek.model.Service_;

import java.util.List;

public interface ServiceService {

    Service_ addService(Service_ service);

    Service_ updateService(Service_ service);

    void deleteService(Long serviceId);

    Service_ getService(Long serviceId);

    List<Service_> getAllServices();

    List<Service_> getServicesByCategory(Long catId);

}
