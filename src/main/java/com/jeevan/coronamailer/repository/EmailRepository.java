package com.jeevan.coronamailer.repository;

import com.jeevan.coronamailer.model.EmailModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmailRepository extends JpaRepository<EmailModel,Integer> {

    public boolean existsByEmail(String email);
}
