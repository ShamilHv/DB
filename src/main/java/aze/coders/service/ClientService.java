package aze.coders.service;

import aze.coders.entity.Client;

import java.util.List;

public interface ClientService {
    Client getClientById(int id);
    List<Client> getAllClients();
    void addClient(Client client);
    void deleteClient(int id);
    void updateClientName(int id, String newName);

}
