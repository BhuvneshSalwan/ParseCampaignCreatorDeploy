package com.back4app.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "fb_adsets")
public class Adset {

	@Id
	@GeneratedValue
	@Column(name = "id")
	int id;
	
	@Column(name = "client_id")
	int client_id;
	
	@Column(name = "campaign_id")
	String campaign_id;
	
	@Column(name = "daily_budget")
	Double daily_budget;
	
	@Column(name = "gender")
	String gender;
	
	@Column(name = "age_min")
	int age_min;
	
	@Column(name = "age_max")
	int age_max;
	
	@Column(name = "cities")
	String cities;
	
	@Column(name = "is_updated")
	int is_updated;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "created_at")
	Date created_at;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "updated_at")
	Date updated_at;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "start_date")
	Date start_date;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "end_date")
	Date end_date;
	
	@Column(name = "specific_targeting")
	String specific_targeting;
	
	@Column(name = "parse_campaign_id")
	String parse_campaign_id;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getClient_id() {
		return client_id;
	}

	public void setClient_id(int client_id) {
		this.client_id = client_id;
	}

	public String getCampaign_id() {
		return campaign_id;
	}

	public void setCampaign_id(String campaign_id) {
		this.campaign_id = campaign_id;
	}

	public Double getDaily_budget() {
		return daily_budget;
	}

	public void setDaily_budget(Double daily_budget) {
		this.daily_budget = daily_budget;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public int getAge_min() {
		return age_min;
	}

	public void setAge_min(int age_min) {
		this.age_min = age_min;
	}

	public int getAge_max() {
		return age_max;
	}

	public void setAge_max(int age_max) {
		this.age_max = age_max;
	}

	public String getCities() {
		return cities;
	}

	public void setCities(String cities) {
		this.cities = cities;
	}

	public int getIs_updated() {
		return is_updated;
	}

	public void setIs_updated(int is_updated) {
		this.is_updated = is_updated;
	}

	public Date getCreated_at() {
		return created_at;
	}

	public void setCreated_at(Date created_at) {
		this.created_at = created_at;
	}

	public Date getUpdated_at() {
		return updated_at;
	}

	public void setUpdated_at(Date updated_at) {
		this.updated_at = updated_at;
	}

	public Date getStart_date() {
		return start_date;
	}

	public void setStart_date(Date start_date) {
		this.start_date = start_date;
	}

	public Date getEnd_date() {
		return end_date;
	}

	public void setEnd_date(Date end_date) {
		this.end_date = end_date;
	}

	public String getSpecific_targeting() {
		return specific_targeting;
	}

	public void setSpecific_targeting(String specific_targeting) {
		this.specific_targeting = specific_targeting;
	}

	public String getParse_campaign_id() {
		return parse_campaign_id;
	}

	public void setParse_campaign_id(String parse_campaign_id) {
		this.parse_campaign_id = parse_campaign_id;
	}
	
}