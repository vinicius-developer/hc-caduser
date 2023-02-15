package com.healthcare.cadusers.entities;

import jakarta.persistence.*;

@Entity(name = "clinics_speciality_relationship")
public class ClinicSpeciality {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idclinic_speciality;
    @ManyToOne
    @JoinColumn(name = "idclinic", referencedColumnName = "idclinic")
    private Clinic clinic;
    @ManyToOne
    @JoinColumn(name = "idspeciality", referencedColumnName = "idspeciality")
    private MedicineSpeciality medicineSpeciality;

    public ClinicSpeciality() {
    }

    public ClinicSpeciality(Integer idclinic_speciality, Clinic clinic, MedicineSpeciality medicineSpeciality) {
        this.idclinic_speciality = idclinic_speciality;
        this.clinic = clinic;
        this.medicineSpeciality = medicineSpeciality;
    }

    public Integer getIdclinic_speciality() {
        return idclinic_speciality;
    }

    public void setIdclinic_speciality(Integer idclinic_speciality) {
        this.idclinic_speciality = idclinic_speciality;
    }

    public Clinic getClinic() {
        return clinic;
    }

    public void setClinic(Clinic clinic) {
        this.clinic = clinic;
    }

    public MedicineSpeciality getMedicineSpeciality() {
        return medicineSpeciality;
    }

    public void setMedicineSpeciality(MedicineSpeciality medicineSpeciality) {
        this.medicineSpeciality = medicineSpeciality;
    }
}
