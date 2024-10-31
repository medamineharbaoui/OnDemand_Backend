package tn.homejek.service;

import tn.homejek.model.Client;

import java.util.List;

public interface ClientService {

    Client addClient(Client client);

    Client updateClient(Client client);

    void banClient(Long clientId);

    void deleteClient(Long clientId);

    Client getClient(Long clientId);

    List<Client> getAllClients();
}
