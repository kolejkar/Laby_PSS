package com.project.Laboratorium1.services;

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Description;
import org.springframework.stereotype.Service;

import com.project.Laboratorium1.model.Delegation;
import com.project.Laboratorium1.model.User;
import com.project.Laboratorium1.repositories.DelegationRepository;
import com.project.Laboratorium1.repositories.UserRepository;

@Service
public class DelegationService implements IDelegationService {

	@Autowired
	DelegationRepository delegationRepository;

	@Autowired
	UserRepository userRepository;

	@Override
	public void save(long userId, Delegation delegation) {
		delegation.setDateTimeStart(new Timestamp(Calendar.getInstance().getTime().getTime()));
		delegation.setDateTimeStop(new Timestamp(Calendar.getInstance().getTime().getTime()));
		delegation.setUser(userRepository.findById(userId).get());
		delegationRepository.save(delegation);
	}

	@Override
	public boolean deleteById(long delegationId) {
		// TODO Auto-generated method stub

		
		if (delegationRepository.deleteByDelegationId(delegationId) == 0)
			return false;
		else
			return true;
	}

	@Override
	public void updateDelegation(long DelegationId, Delegation delegation) {
		
		delegation.setDateTimeStart(new Timestamp(Calendar.getInstance().getTime().getTime()));
		delegation.setDateTimeStop(new Timestamp(Calendar.getInstance().getTime().getTime()));
	
		Delegation delegation2 = delegationRepository.findById(DelegationId).get();
		if(delegation2.getDescription()!=delegation.getDescription())delegation2.setDescription(delegation.getDescription());
		if(delegation2.getDateTimeStart()!=delegation.getDateTimeStart())delegation2.setDateTimeStart(delegation.getDateTimeStart());
		if(delegation2.getDateTimeStop()!=delegation.getDateTimeStop())delegation2.setDateTimeStop(delegation.getDateTimeStop());
		if(delegation2.getTravelDietAmount()!=delegation.getTravelDietAmount())delegation2.setTravelDietAmount(delegation.getTravelDietAmount());
		if(delegation2.getBreakfastNumber()!=delegation.getBreakfastNumber())delegation2.setBreakfastNumber(delegation.getBreakfastNumber());
		if(delegation2.getDinnerNumber()!=delegation.getDinnerNumber())delegation2.setDinnerNumber(delegation.getDinnerNumber());
		if(delegation2.getSupperNumber()!=delegation.getSupperNumber())delegation2.setSupperNumber(delegation.getSupperNumber());
		if(delegation2.getTransportType()!=delegation.getTransportType())delegation2.setTransportType(delegation.getTransportType());
		if(delegation2.getTicketPrice()!=delegation.getTicketPrice())delegation2.setTicketPrice(delegation.getTicketPrice());
		if(delegation2.getAutoCapacity()!=delegation.getAutoCapacity())delegation2.setAutoCapacity(delegation.getAutoCapacity());
		if(delegation2.getKm()!=delegation.getKm())delegation2.setKm(delegation.getKm());
		if(delegation2.getAccomodationPrice()!=delegation.getAccomodationPrice())delegation2.setAccomodationPrice(delegation.getAccomodationPrice());
		if(delegation2.getOtherTicketsPrice()!=delegation.getOtherTicketsPrice())delegation2.setOtherTicketsPrice(delegation.getOtherTicketsPrice());
		if(delegation2.getOtherOutlayDesc()!=delegation.getOtherOutlayDesc())delegation2.setOtherOutlayDesc(delegation.getOtherOutlayDesc());
		if(delegation2.getOtherOutlayPrice()!=delegation.getOtherOutlayPrice())delegation2.setOtherOutlayPrice(delegation.getOtherOutlayPrice());
		

		delegationRepository.updateDelegation(delegation2.getDescription(), delegation2.getDateTimeStart(),
				delegation2.getDateTimeStop(), delegation2.getTravelDietAmount(), delegation2.getBreakfastNumber(),
				delegation2.getDinnerNumber(), delegation2.getSupperNumber(), delegation2.getTransportType(),
				delegation2.getTicketPrice(), delegation2.getAutoCapacity(), delegation2.getKm(),
				delegation2.getAccomodationPrice(), delegation2.getOtherTicketsPrice(), delegation2.getOtherOutlayDesc(),
				delegation2.getOtherOutlayPrice(), DelegationId);

	}

	@Override
	public List<Delegation> findAll() {
		// TODO Auto-generated method stub
		return delegationRepository.findAll();
	}

	@Override
	public List<Delegation> findAllOrderByDateStartDesc() {
		// TODO Auto-generated method stub
		return delegationRepository.findAllByOrderByDateTimeStartDesc();
	}

	@Override
	public List<Delegation> findByUserOrderByDateStartDesc(Long userId) {
		// TODO Auto-generated method stub
		return delegationRepository.findByUserByOrderByDateTimeStartDesc(userId);
	}

	@Override
	public boolean deleteByUser(long userId) {
		// TODO Auto-generated method stub
		if (delegationRepository.deleteByUser_UserId(userId) == 0)
			return false;
		else
			return true;
	}

}
