package com.healthcare.cadusers.repositories;

import com.healthcare.cadusers.entities.Doctor;
import org.springframework.data.repository.CrudRepository;

public interface DoctorRepository extends CrudRepository<Doctor, Integer> {
}
