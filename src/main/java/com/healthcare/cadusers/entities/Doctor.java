package com.healthcare.cadusers.entities;

import jakarta.persistence.*;

@Entity(name = "clinic_doctors")
public class Doctor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer iddoctor;
    @Column(length = 100)
    private String name;
    @Column(length = 50)
    private String license_registration;
    @Column(columnDefinition = "CHAR default 'T'", length = 1, nullable = false)
    private String status;
    @Column(columnDefinition="TIMESTAMP default CURRENT_TIMESTAMP", name = "insert_timestamp")
    private String insertTimestamp;

    @ManyToOne
    @JoinColumn(name = "idclinic", referencedColumnName = "idclinic")
    private Clinic clinic;
    @ManyToOne
    @JoinColumn(name = "idspeciality", referencedColumnName = "idspeciality")
    private MedicineSpeciality medicineSpeciality;

    public Doctor() {
    }

    public Doctor(String name, String license_registration, String status, Clinic clinic, MedicineSpeciality medicineSpeciality) {
        this.name = name;
        this.license_registration = license_registration;
        this.status = status;
        this.clinic = clinic;
        this.medicineSpeciality = medicineSpeciality;
    }

    public Integer getIddoctor() {
        return iddoctor;
    }

    public void setIddoctor(Integer iddoctor) {
        this.iddoctor = iddoctor;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLicense_registration() {
        return license_registration;
    }

    public void setLicense_registration(String license_registration) {
        this.license_registration = license_registration;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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
