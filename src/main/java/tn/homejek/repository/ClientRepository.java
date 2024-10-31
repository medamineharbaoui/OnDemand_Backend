package tn.homejek.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.homejek.model.Client;

public interface ClientRepository extends JpaRepository<Client, Long> {

}
