package com.healthcare.cadusers.entities;

import jakarta.persistence.*;

@Entity(name = "clinic_doctors")
public class Doctor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column
    private Integer idclinic;
    @Column
    private Integer idspeciality;
    @Column(length = 100)
    private String name;
    @Column(length = 50)
    private String license_registration;
    @Column(columnDefinition = "CHAR default 'T'", length = 1, nullable = false)
    private String status;

}
