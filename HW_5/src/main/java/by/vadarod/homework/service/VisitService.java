package by.vadarod.homework.service;

import by.vadarod.homework.entity.Visit;
import by.vadarod.homework.repository.VisitRepository;

public class VisitService {
    private VisitRepository visitRepository = new VisitRepository();

    public void addVisit(Visit visit)
    {
        visitRepository.addVisit(visit);
    }
}
