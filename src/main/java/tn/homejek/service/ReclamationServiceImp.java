package tn.homejek.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.homejek.model.Reclamation;
import tn.homejek.model.ReclamationStatus;
import tn.homejek.repository.AdminRepository;
import tn.homejek.repository.ReclamationRepository;

@Service
public class ReclamationServiceImp implements ReclamationService{

    @Autowired
    ReclamationRepository reclamationRepository;

    @Autowired
    AdminRepository adminRepository;

    @Override
    public Reclamation addReclamation(Reclamation reclamation) {
        return reclamationRepository.save(reclamation);
    }

    @Override
    public Reclamation updateReclamation(Reclamation reclamation) {
        return reclamationRepository.save(reclamation);
    }

    @Override
    public void updateReclamationStatus(Long reclamationId, ReclamationStatus reclamationStatus) {
        Reclamation reclamation = reclamationRepository.findById(reclamationId).get();
        reclamation.setStatus(reclamationStatus);
        reclamationRepository.save(reclamation);
    }

    @Override
    public void updateReclamationAssignee(Long reclamationId, Long adminId) {
        Reclamation reclamation = reclamationRepository.findById(reclamationId).get();
        reclamation.setAssignee(adminRepository.findById(adminId).get());
        reclamationRepository.save(reclamation);
    }
}
