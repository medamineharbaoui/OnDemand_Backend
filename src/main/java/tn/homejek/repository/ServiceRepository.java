package tn.homejek.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.homejek.model.Service_;

@Repository
public interface ServiceRepository extends JpaRepository<Service_, Long> {

}
