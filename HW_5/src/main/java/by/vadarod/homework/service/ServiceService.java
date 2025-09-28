package by.vadarod.homework.service;

import by.vadarod.homework.entity.Service;
import by.vadarod.homework.repository.ServiceRepository;

public class ServiceService {
    private ServiceRepository serviceRepository = new ServiceRepository();

    public void addService(Service service)
    {
        serviceRepository.addService(service);
    }
}
