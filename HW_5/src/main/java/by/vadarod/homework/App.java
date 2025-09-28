package by.vadarod.homework;


import by.vadarod.homework.entity.*;
import by.vadarod.homework.service.ClientService;
import by.vadarod.homework.service.PremisesService;
import by.vadarod.homework.service.ServiceService;

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

        System.out.println("================================HW 6==========================================");
        System.out.println("================================1, 2==========================================");
        ClientService clientService = new ClientService();
        Client client = clientService.getIdClientService(3);
        System.out.println(client.getName() +"  "+ client.getSurname() + " " + client.getStatus());

        System.out.println("================================ 3 ==========================================");
        ServiceService serviceService = new ServiceService();
        Service service1 = new Service();
        service1.setName("Tennis");
        service1.setPrice(123.12);
        serviceService.addService(service1);

        Service service2 = new Service();
        service2.setName("Swimming");
        service2.setPrice(145.12);
        serviceService.addService(service2);

        Service service3 = new Service();
        service3.setName("Football");
        service3.setPrice(145.33);
        serviceService.addService(service3);

        Service service4 = new Service();
        service4.setName("Basketball");
        service4.setPrice(233.46);
        serviceService.addService(service4);

        System.out.println("================================ 4 ==========================================");
        PremisesService premisesService = new PremisesService();
        Premises premises1 = new Premises();
        premises1.setName("Gym");
        premises1.setIdNumber((short) 1);
        premises1.setMaxPeople((short) 25);
        premises1.setStatus(PremisesStatus.ACTIVE);
        premises1.setPrice(135.56);
        premisesService.addPremisesService(premises1);

        Premises premises2 = new Premises();
        premises2.setName("Gym");
        premises2.setIdNumber((short) 2);
        premises2.setMaxPeople((short) 29);
        premises2.setStatus(PremisesStatus.REPAIR);
        premises2.setPrice(135.56);
        premisesService.addPremisesService(premises2);

        Premises premises3 = new Premises();
        premises3.setName("Aerobics room");
        premises3.setIdNumber((short) 3);
        premises3.setMaxPeople((short) 30);
        premises3.setStatus(PremisesStatus.REPAIR);
        premises3.setPrice(135.56);
        premisesService.addPremisesService(premises3);

        Premises premises4 = new Premises();
        premises4.setName("Yoga room");
        premises4.setIdNumber((short) 4);
        premises4.setMaxPeople((short) 32);
        premises4.setStatus(PremisesStatus.ACTIVE);
        premises4.setPrice(156.56);
        premisesService.addPremisesService(premises4);

        System.out.println("================================ 5 ==========================================");
        Premises premisesCopy = premisesService.copyPremisesService(1L, (short) 12);
        System.out.println(premisesCopy.getId() + " " + premisesCopy.getName() + " " + premisesCopy.getIdNumber());

        System.out.println("================================ 6 ==========================================");
        Premises premisesUpp = premisesService.uppPricePremisesService(5L, 1111.12);
        System.out.println(premisesUpp.getId() + " " + premisesUpp.getName() + " " + premisesUpp.getIdNumber() + " " + premisesUpp.getPrice());


    }
}
