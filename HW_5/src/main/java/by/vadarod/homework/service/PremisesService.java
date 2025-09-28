package by.vadarod.homework.service;

import by.vadarod.homework.entity.Premises;
import by.vadarod.homework.repository.PremisesRepository;

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


}
