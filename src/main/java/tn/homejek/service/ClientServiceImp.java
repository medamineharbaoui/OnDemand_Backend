package tn.homejek.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.homejek.model.Client;
import tn.homejek.repository.ClientRepository;

import java.util.List;

@Service
public class ClientServiceImp implements ClientService {

    @Autowired
    ClientRepository clientRepository;

    @Override
    public Client addClient(Client client) {
        return clientRepository.save(client);
    }

    @Override
    public Client updateClient(Client client) {
        return clientRepository.save(client);
    }

    @Override
    public void banClient(Long clientId) {
//        Client client = clientRepository.findById(clientId).get();
//        client.setStatus(ValidationStatus.BANNED);
//        clientRepository.save(client);
    }

    @Override
    public void deleteClient(Long clientId) {
//        Client client = clientRepository.findById(clientId).get();
//        client.setStatus(ValidationStatus.DELETED);
//        clientRepository.save(client);
    }

    @Override
    public Client getClient(Long clientId) {
        return clientRepository.findById(clientId).get();
    }

    @Override
    public List<Client> getAllClients() {
        return clientRepository.findAll();
    }
}
