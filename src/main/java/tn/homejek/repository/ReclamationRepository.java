package tn.homejek.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.homejek.model.Reclamation;

@Repository
public interface ReclamationRepository extends JpaRepository<Reclamation, Long> {

}
