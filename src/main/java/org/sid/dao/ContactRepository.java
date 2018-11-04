package org.sid.dao;

import org.sid.entities.Contact;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ContactRepository extends JpaRepository<Contact, Integer> {

    @Query("SELECT  c from Contact c WHERE c.nom like :x")
    public Page<Contact> findByName(@Param("x") String mc, Pageable pageable);
}
