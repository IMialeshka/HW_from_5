package by.vadarod.homework.service;

import by.vadarod.homework.entity.Client;
import by.vadarod.homework.entity.ClientPremium;
import by.vadarod.homework.entity.Status;
import by.vadarod.homework.repository.ClientRepository;

import java.util.List;

public class ClientService {
    public static List<Client> getAllClientsService()
    {
        return ClientRepository.getAllClients();
    }

    public static void addClientService(Client client)
    {
        ClientRepository.addClient(client);
    }

    public static void dellClientService(long id)
    {
        ClientRepository.dellClient(id);
    }

    public static void changeStatusService(long id, Status newStatus)
    {
        ClientRepository.changeStatus(id, newStatus);
    }

    public Client getIdClientService(long id)
    {
        ClientRepository clientRepository = new ClientRepository();
        return clientRepository.getIdClient(id);
    }

    public List<ClientPremium>  getAllClientPremiumService()
    {
        ClientRepository clientRepository = new ClientRepository();
        return clientRepository.getAllClientPremium();
    }
    public void addClientUserService(Client client)
    {
        ClientRepository clientRepository = new ClientRepository();
        clientRepository.addClientUser(client);
    }
    public List<Client> findClientByNameService(String name)
    {
        ClientRepository clientRepository = new ClientRepository();
        return clientRepository.findClientByName(name);
    }

}
