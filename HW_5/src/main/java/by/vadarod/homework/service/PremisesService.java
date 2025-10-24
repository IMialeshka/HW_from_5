package by.vadarod.homework.service;

import by.vadarod.homework.entity.Premises;
import by.vadarod.homework.entity.PremisesMore;
import by.vadarod.homework.repository.PremisesRepository;

import java.util.List;
import java.util.Map;

public class PremisesService {
    private PremisesRepository premisesRepository = new PremisesRepository();

    public void addPremisesService(Premises premises)
    {
        premisesRepository.addPremises(premises);
    }

    public Premises copyPremisesService(long id, short idPremises) {
       return premisesRepository.copyPremises(id, idPremises);
    }

    public Premises uppPricePremisesService(long id, double price) {
        return premisesRepository.uppPricePremises(id, price);
    }

    public List<PremisesMore> getAllPremisesMoreService() {
        return premisesRepository.getAllPremisesMore();
    }

    public void dellPremisesService(Premises premises)
    {
        premisesRepository.dellPremises(premises);
    }

    public Map<String, Double> findCostForClientService() {
        PremisesRepository premisesRepository = new PremisesRepository();
        return premisesRepository.findCostForClient();

    }

    public Short findTotalCountVisitorsService() {
        return premisesRepository.findTotalCountVisitors();
    }



    public List<Premises> findPremisesByAgeService(int yare) {
        return premisesRepository.findPremisesByAge(yare);
    }

}
