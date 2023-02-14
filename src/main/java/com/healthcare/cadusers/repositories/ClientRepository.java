package com.healthcare.cadusers.repositories;


import com.healthcare.cadusers.entities.Client;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends CrudRepository <Client, Integer> {

}
