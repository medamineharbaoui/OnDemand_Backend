package tn.homejek.service;

import tn.homejek.model.Reclamation;
import tn.homejek.model.ReclamationStatus;

public interface ReclamationService {

    Reclamation addReclamation(Reclamation reclamation);

    Reclamation updateReclamation(Reclamation reclamation);

    void updateReclamationStatus(Long reclamationId,ReclamationStatus reclamationStatus);

    void updateReclamationAssignee(Long reclamationId,Long adminId);

}
