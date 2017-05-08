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
@Table(name = "fb_campaign")
public class Campaign {

	@Id
	@GeneratedValue
	@Column(name = "id")
	int id;
	
	@Column(name = "client_id")
	int client_id;
	
	@Column(name = "objective")
	String objective;
	
	@Column(name = "status")
	String status;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "created_at")
	Date created_at;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "updated_at")
	Date updated_at;
	
	@Column(name = "object_id")
	String object_id;
	
	@Column(name = "referrer")
	String referrer;
	
	@Column(name = "ext_id")
	String ext_id;
	
	@Column(name = "is_updated")
	String is_updated;
	
	@Column(name = "product_type")
	String product_type;
	
	@Column(name = "campaign_name")
	String campaign_name;
	
	@Column(name = "type")
	String type;
	
	@Column(name = "is_catalog_created")
	String is_catalog_created;
	
	@Column(name = "fb_campaign_id")
	String fb_campaign_id;

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

	public String getObjective() {
		return objective;
	}

	public void setObjective(String objective) {
		this.objective = objective;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
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

	public String getObject_id() {
		return object_id;
	}

	public void setObject_id(String object_id) {
		this.object_id = object_id;
	}

	public String getReferrer() {
		return referrer;
	}

	public void setReferrer(String referrer) {
		this.referrer = referrer;
	}

	public String getExt_id() {
		return ext_id;
	}

	public void setExt_id(String ext_id) {
		this.ext_id = ext_id;
	}

	public String getIs_updated() {
		return is_updated;
	}

	public void setIs_updated(String is_updated) {
		this.is_updated = is_updated;
	}

	public String getProduct_type() {
		return product_type;
	}

	public void setProduct_type(String product_type) {
		this.product_type = product_type;
	}

	public String getCampaign_name() {
		return campaign_name;
	}

	public void setCampaign_name(String campaign_name) {
		this.campaign_name = campaign_name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getIs_catalog_created() {
		return is_catalog_created;
	}

	public void setIs_catalog_created(String is_catalog_created) {
		this.is_catalog_created = is_catalog_created;
	}

	public String getFb_campaign_id() {
		return fb_campaign_id;
	}

	public void setFb_campaign_id(String fb_campaign_id) {
		this.fb_campaign_id = fb_campaign_id;
	}
	
}