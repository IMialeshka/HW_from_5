package by.vadarod.homework;


import by.vadarod.homework.entity.*;
import by.vadarod.homework.service.ClientService;
import by.vadarod.homework.service.EmployeeService;
import by.vadarod.homework.service.PremisesService;
import by.vadarod.homework.service.ServiceService;

import java.util.Date;
import java.util.List;


public class App 
{
    public static void main( String[] args )
    {
       /* Client client1 = new Client();
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
        premises3.setMaxPeople((short) 10);
        premises3.setStatus(PremisesStatus.REPAIR);
        premises3.setPrice(135.56);
        premisesService.addPremisesService(premises3);

        Premises premises4 = new Premises();
        premises4.setName("Yoga room");
        premises4.setIdNumber((short) 4);
        premises4.setMaxPeople((short) 12);
        premises4.setStatus(PremisesStatus.ACTIVE);
        premises4.setPrice(156.56);
        premisesService.addPremisesService(premises4);

        System.out.println("================================ 5 ==========================================");
        Premises premisesCopy = premisesService.copyPremisesService(1L, (short) 12);
        System.out.println(premisesCopy.getId() + " " + premisesCopy.getName() + " " + premisesCopy.getIdNumber());

        System.out.println("================================ 6 ==========================================");
        Premises premisesUpp = premisesService.uppPricePremisesService(5L, 1111.12);
        System.out.println(premisesUpp.getId() + " " + premisesUpp.getName() + " " + premisesUpp.getIdNumber() + " " + premisesUpp.getPrice());

        System.out.println("================================HW 7==========================================");
        System.out.println("================================ 1 ==========================================");

        Client client6 = new Client();
        client6.setAge(72);
        client6.setName("Igor");
        client6.setSurname("Pupkin");
        client6.setAmount(125.15);
        client6.setPhone("+37544111156675");
        client6.setLastVisitDate(new Date());
        client6.setStatus(Status.PREMIUM);
        client6.setAddress(new Address("Minsk", "Nezavisimosti", 1, "123456"));
        ClientService.addClientService(client6);

        List<Client> clientsAddress = ClientService.getAllClientsService();

        for (Client clientAddress : clientsAddress) {
            if (clientAddress.getAddress() != null) {
                System.out.println(clientAddress.getName() + "  " + clientAddress.getSurname() + " " + clientAddress.getAddress());
            }
        }
        System.out.println("================================ 2 ==========================================");
        List<PremisesMore> premisesMoreList = premisesService.getAllPremisesMoreService();

        for (PremisesMore premises : premisesMoreList) {
                System.out.println(premises.getPrice());
        }
        System.out.println("================================ 3 ==========================================");
        List<ClientPremium> clientPremiumList = clientService.getAllClientPremiumService();

        for (ClientPremium clientPremium : clientPremiumList) {
            System.out.println(clientPremium);
        }*/


        System.out.println("================================ HW 8 ==========================================");
        System.out.println("================================ 1, 2 ==========================================");
        ClientService clientService = new ClientService();
        Client client1 = new Client();
        client1.setYearOfBirth(1985);
        client1.setName("Igor");
        client1.setSurname("Pupkin");
        client1.setAmount(125.15);
        client1.setPhone("+37544111156675");
        client1.setLastVisitDate(new Date());
        client1.setStatus(Status.PREMIUM);
        client1.setAddress(new Address("Minsk", "Nezavisimosti", 1, "123456"));
        clientService.addClientUserService(client1);

        Client client2 = new Client();
        client2.setYearOfBirth(1985);
        client2.setName("Ivan");
        client2.setSurname("Ivanov");
        client2.setAmount(111.15);
        client2.setPhone("+37544144456675");
        client2.setLastVisitDate(new Date());
        client2.setStatus(Status.PREMIUM);
        client2.setAddress(new Address("Minsk", "Nezavisimosti", 4, "123456"));
        clientService.addClientUserService(client2);

        Client client3 = new Client();
        client3.setYearOfBirth(1985);
        client3.setName("Ivan");
        client3.setSurname("Smirnov");
        client3.setAmount(111.15);
        client3.setPhone("+37544666456675");
        client3.setLastVisitDate(new Date());
        client3.setStatus(Status.PREMIUM);
        client3.setAddress(new Address("Vitebsk", "Nezavisimosti", 4, "123456"));
        clientService.addClientUserService(client3);

        Client client4 = new Client();
        client4.setYearOfBirth(1985);
        client4.setName("Elena");
        client4.setSurname("Smirnova");
        client4.setAmount(111.45);
        client4.setPhone("+37116675");
        client4.setLastVisitDate(new Date());
        client4.setStatus(Status.PREMIUM);
        client4.setAddress(new Address("Vitebsk", "Nezavisimosti", 4, "123456"));
        clientService.addClientUserService(client4);

        System.out.println("================================ 3 ==========================================");
        EmployeeService employeeService = new EmployeeService();
        Employee employee1 = new Employee();
        employee1.setYearOfBirth(1985);
        employee1.setName("Ina");
        employee1.setSurname("Smirnova");
        employee1.setPosition("Trener");
        employee1.setSalary(1000.12);
        employee1.setHiringDate(new Date());
        employee1.setTerminationDate(new Date());
        employee1.setAddress(new Address("Vitebsk", "Nezavisimosti", 4, "123456"));
        employeeService.addEmployeeService(employee1);

        Employee employee2 = new Employee();
        employee2.setYearOfBirth(1996);
        employee2.setName("Ina");
        employee2.setSurname("Ltaria");
        employee2.setPosition("Manager");
        employee2.setSalary(1200);
        employee2.setHiringDate(new Date());
        employee2.setTerminationDate(new Date());
        employee2.setAddress(new Address("Minsk", "Nezavisimosti", 12, "123456"));
        employeeService.addEmployeeService(employee2);

        Employee employee3 = new Employee();
        employee3.setYearOfBirth(1987);
        employee3.setName("Igor");
        employee3.setSurname("Ltaria");
        employee3.setPosition("Trener");
        employee3.setSalary(1500);
        employee3.setHiringDate(new Date());
        employee3.setTerminationDate(new Date());
        employee3.setAddress(new Address("Minsk", "Pobedi", 12, "123456"));
        employeeService.addEmployeeService(employee3);

        Employee employee4 = new Employee();
        employee4.setYearOfBirth(1991);
        employee4.setName("Ivan");
        employee4.setSurname("Ivanov");
        employee4.setPosition("Director");
        employee4.setSalary(3560);
        employee4.setHiringDate(new Date());
        employee4.setTerminationDate(new Date());
        employee4.setAddress(new Address("Minsk", "Masherova", 12, "123456"));
        employeeService.addEmployeeService(employee4);


    }
}
