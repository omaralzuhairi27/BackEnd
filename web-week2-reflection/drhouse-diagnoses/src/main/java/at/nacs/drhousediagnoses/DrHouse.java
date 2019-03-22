package at.nacs.drhousediagnoses;

import at.nacs.drhousediagnoses.domian.Patient;

public class DrHouse {

    public void diagnosis(Patient patient) {
        patient.setDiagnosis("");
        if (patient.getDiagnosis().equals("")) {
            return;
        }
    }

}