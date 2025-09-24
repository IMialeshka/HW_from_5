package by.vadarod.homework;


import by.vadarod.homework.entity.Client;
import by.vadarod.homework.entity.Status;
import by.vadarod.homework.service.ClientService;

import java.util.Date;
import java.util.List;


public class App 
{
    public static void main( String[] args )
    {
        Client client1 = new Client();
        client1.setAge(18);
        client1.setName("Ivan");
        client1.setSurname("Ivanov");
        client1.setAmount(125.12);
        client1.setPhone("+37544123455");
        client1.setLastVisitDate(new Date());
        client1.setStatus(Status.ACTIVE);
        ClientService.addClientService(client1);

        Client client2 = new Client();
        client2.setAge(28);
        client2.setName("Petr");
        client2.setSurname("Ivanov");
        client2.setAmount(1200.12);
        client2.setPhone("+37544125555");
        client2.setLastVisitDate(new Date());
        client2.setStatus(Status.PREMIUM);
        ClientService.addClientService(client2);

        Client client3 = new Client();
        client3.setAge(43);
        client3.setName("Petr");
        client3.setSurname("Petrov");
        client3.setAmount(10000.15);
        client3.setPhone("+375446666655");
        client3.setLastVisitDate(new Date());
        client3.setStatus(Status.PREMIUM);
        ClientService.addClientService(client3);

        Client client4 = new Client();
        client4.setAge(65);
        client4.setName("Irina");
        client4.setSurname("Smirnova");
        client4.setAmount(100.15);
        client4.setPhone("+3754466888855");
        client4.setLastVisitDate(new Date());
        client4.setStatus(Status.BLOCKED);
        ClientService.addClientService(client4);

        Client client5 = new Client();
        client5.setAge(72);
        client5.setName("Igor");
        client5.setSurname("Smirnova");
        client5.setAmount(120.15);
        client5.setPhone("+3754411118855");
        client5.setLastVisitDate(new Date());
        client5.setStatus(Status.BLOCKED);
        ClientService.addClientService(client5);

        List<Client> clients = ClientService.getAllClientsService();

        for (Client client : clients) {
            System.out.println(client.getName() +"  "+ client.getSurname() + " " + client.getStatus());
        }

        System.out.println("============================================================================");
        ClientService.dellClientService(1);

        List<Client> clientsAfterDell = ClientService.getAllClientsService();

        for (Client client : clientsAfterDell) {
            System.out.println(client.getName() +"  "+ client.getSurname() + " " + client.getStatus());
        }

        System.out.println("============================================================================");

        ClientService.changeStatusService(2, Status.BLOCKED);

        List<Client> clientsAfterChange = ClientService.getAllClientsService();

        for (Client client : clientsAfterChange) {
            System.out.println(client.getName() +"  "+ client.getSurname() + " " + client.getStatus());
        }

    }
}
