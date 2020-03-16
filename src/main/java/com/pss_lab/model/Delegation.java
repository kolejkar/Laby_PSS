package com.pss_lab.model;

import java.io.Serializable;
import javax.persistence. *;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

import java.sql.*;

//@Data
@Entity
@Table(name="delegation")
public class Delegation {
	
	public enum Transport
	{
		Auto,
		Pociąg,
		Autobus
		
	}
	
	@Id
	private Long delegationId;
	
	@ManyToOne
	@JoinColumn(name = "user_id", nullable = false)
	@JsonIgnoreProperties(value = {"delegations"})
	private User user;
	
	String description; // - opcjonalne
	
	@Column(nullable = false)
	Timestamp dateTimeStart; // - obowiązkowe
	
	@Column(nullable = false)
	Timestamp dateTimeStop; // - obowiązkowe
	
	@Column(precision = 9, scale = 2)
	float travelDietAmount = 30; // - domyślnie 30zł
		
	int breakfastNumber = 0; // - domyślnie 0
	
	int dinnerNumber = 0; // - domyślnie 0
	
	int  supperNumber = 0; // - domyślnie 0
	
	Transport transportType; // - opcjonalne: Auto, Pociąg, Autobus
	
	@Column(precision = 9, scale = 2)
	float ticketPrice; // - jeśli Pociąg lub autobus
	
	Boolean autoCapacity; // - typ wyliczeniowy: >= 900m3, < 900m3
	
	float km; // - jeśli Auto
	
	@Column(precision = 9, scale = 2)
	float accomodationPrice; // - opcjonalne
	
	@Column(precision = 9, scale = 2)
	float otherTicketsPrice; // - opcjonalne
	
	float otherOutlayDesc; // - opcjonalne
	
	float otherOutlayPrice; // - opcjonalne
	
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Timestamp getDateTimeStart() {
		return dateTimeStart;
	}
	public void setDateTimeStart(Timestamp dateTimeStart) {
		this.dateTimeStart = dateTimeStart;
	}
	public Timestamp getDateTimeStop() {
		return dateTimeStop;
	}
	public void setDateTimeStop(Timestamp dateTimeStop) {
		this.dateTimeStop = dateTimeStop;
	}
	public float getTravelDietAmount() {
		return travelDietAmount;
	}
	public void setTravelDietAmount(float travelDietAmount) {
		this.travelDietAmount = travelDietAmount;
	}
	public int getBreakfastNumber() {
		return breakfastNumber;
	}
	public void setBreakfastNumber(int breakfastNumber) {
		this.breakfastNumber = breakfastNumber;
	}
	public int getDinnerNumber() {
		return dinnerNumber;
	}
	public void setDinnerNumber(int dinnerNumber) {
		this.dinnerNumber = dinnerNumber;
	}
	public int getSupperNumber() {
		return supperNumber;
	}
	public void setSupperNumber(int supperNumber) {
		this.supperNumber = supperNumber;
	}
	public Transport getTransportType() {
		return transportType;
	}
	public void setTransportType(Transport transportType) {
		this.transportType = transportType;
	}
	public float getTicketPrice() {
		return ticketPrice;
	}
	public void setTicketPrice(float ticketPrice) {
		if (transportType == Transport.Autobus || transportType==Transport.Pociąg)
			this.ticketPrice = ticketPrice;
	}
	public Boolean getAutoCapacity() {
		return autoCapacity;
	}
	public void setAutoCapacity(Boolean autoCapacity) {
		this.autoCapacity = autoCapacity;
	}
	public float getKm() {
		return km;
	}
	public void setKm(float km) {
		if (transportType == Transport.Auto)
		this.km = km;
	}
	public float getAccomodationPrice() {
		return accomodationPrice;
	}
	public void setAccomodationPrice(float accomodationPrice) {
		this.accomodationPrice = accomodationPrice;
	}
	public float getOtherTicketsPrice() {
		return otherTicketsPrice;
	}
	public void setOtherTicketsPrice(float otherTicketsPrice) {
		this.otherTicketsPrice = otherTicketsPrice;
	}
	public float getOtherOutlayDesc() {
		return otherOutlayDesc;
	}
	public void setOtherOutlayDesc(float otherOutlayDesc) {
		this.otherOutlayDesc = otherOutlayDesc;
	}
	public float getOtherOutlayPrice() {
		return otherOutlayPrice;
	}
	public void setOtherOutlayPrice(float otherOutlayPrice) {
		this.otherOutlayPrice = otherOutlayPrice;
	}
	public Long getDelegationId() {
		return delegationId;
	}
	public void setDelegationId(Long delegationId) {
		this.delegationId = delegationId;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
}
