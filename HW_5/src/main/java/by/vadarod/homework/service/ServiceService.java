package by.vadarod.homework.service;

import by.vadarod.homework.config.HibernateConnection;
import by.vadarod.homework.entity.Service;
import by.vadarod.homework.repository.ServiceRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;

public class ServiceService {
    private ServiceRepository serviceRepository = new ServiceRepository();

    public void addService(Service service)
    {
        serviceRepository.addService(service);
    }


    public Service findMinPriceService() {
        return serviceRepository.findMinPriceService();
    }

    public void checkCacheService(long id) {
        serviceRepository.checkCache(id);
    }

    public void checkCache2Level(long id) {
        serviceRepository.checkCache2Level(id);
    }
}
