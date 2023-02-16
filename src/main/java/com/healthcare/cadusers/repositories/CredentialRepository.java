package com.healthcare.cadusers.repositories;

import com.healthcare.cadusers.entities.Credential;
import org.springframework.data.repository.CrudRepository;

public interface CredentialRepository extends CrudRepository<Credential, Integer> {
}
