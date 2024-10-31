package tn.homejek.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.homejek.model.Admin;

@Repository
public interface AdminRepository extends JpaRepository<Admin, Long> {

}
