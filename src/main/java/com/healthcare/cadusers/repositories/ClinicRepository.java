package com.healthcare.cadusers.repositories;

import com.healthcare.cadusers.entities.Clinic;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClinicRepository extends CrudRepository<Clinic, Integer> {
}
