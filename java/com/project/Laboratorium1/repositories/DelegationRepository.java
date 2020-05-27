package com.project.Laboratorium1.repositories;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.project.Laboratorium1.model.Delegation;
import com.project.Laboratorium1.model.TransportType;
import com.project.Laboratorium1.model.User;

@Repository
public interface DelegationRepository extends JpaRepository<Delegation, Long> {

	@Query(value = "from Delegation d "
			+ "where user_user_id = ?1")
	List<Delegation> findByUserByOrderByDateTimeStartDesc(Long user_id);
	
	List<Delegation> findAllByOrderByDateTimeStartDesc();
	@Transactional
	@Modifying
	@Query("update Delegation d set d.description = ?1, d.dateTimeStart = ?2, "
			+ "d.dateTimeStop = ?3, d.travelDietAmount = ?4, d.breakfastNumber = ?5, "
			+ "d.dinnerNumber = ?6, d.supperNumber = ?7, d.transportType = ?8, "
			+ "d.ticketPrice = ?9, d.autoCapacity = ?10, d.km = ?11, d.accomodationPrice = ?12, "
			+ "d.otherTicketsPrice = ?13, d.otherOutlayDesc = ?14, d.otherOutlayPrice = ?15 where d.delegationId = ?16")
	void updateDelegation(String description,Timestamp dateTimeStart,Timestamp dateTimeStop,Double travelDietAmount,
			Integer breakfastNumber,Integer dinnerNumber,Integer supperNumber,TransportType transportType,
			Double ticketPrice,Boolean autoCapacity,Long km,Double accomodationPrice,
			Double otherTicketsPrice,Double otherOutlayDesc,Double otherOutlayPrice, long delegationId);
	@Transactional
	@Modifying
	Integer deleteByDelegationId(Long delegation_id);
	@Transactional
	@Modifying
	@Query(value = "delete from Delegation d "
			+ "where user_user_id = ?1")
	Integer deleteByUser_UserId(Long userid);
}
