package com.pss_lab.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pss_lab.model.Delegation;

@Repository
public interface DelegationRepository extends JpaRepository<Delegation, Long> {

}
