package com.healthcare.cadusers.entities;

import jakarta.persistence.*;

@Entity(name = "medicine_speciality")
public class MedicineSpeciality {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idspeciality;
    @Column(length = 100)
    private String speciality_desc;

    public MedicineSpeciality() {
    }

    public MedicineSpeciality(String speciality_desc) {
        this.speciality_desc = speciality_desc;
    }

    public Integer getIdspeciality() {
        return idspeciality;
    }

    public void setIdspeciality(Integer idspeciality) {
        this.idspeciality = idspeciality;
    }

    public String getSpeciality_desc() {
        return speciality_desc;
    }

    public void setSpeciality_desc(String speciality_desc) {
        this.speciality_desc = speciality_desc;
    }
}
