package com.example.demo.dao;


import com.example.demo.model.Credential;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CredentialRepository extends JpaRepository<Credential, String>, CrudRepository<Credential,String> {

}