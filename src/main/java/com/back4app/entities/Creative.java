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
@Table(name = "fb_creative")
public class Creative {
	
	@Id
	@GeneratedValue
	@Column(name = "id")
	int id;
	
	@Column(name = "ad_text")
	String ad_text;
	
	@Column(name = "is_updated")
	Integer is_updated;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "created_at")
	Date created_at;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "updated_at")
	Date updated_at;
	
	@Column(name = "products")
	String products;
	
	@Column(name = "fb_page_id")
	String fb_page_id;
	
	@Column(name = "campaign_id")
	Integer campaign_id;
	
	@Column(name = "parse_campaign_id")
	String parse_campaign_id;
	
	@Column(name = "creative_name")
	String creative_name;
	
	@Column(name = "status")
	Integer status;
	
	@Column(name = "is_updated_creative")
	Integer is_updated_creative;
	
	@Column(name = "is_updated_ad")
	Integer is_updated_ad;
	
	@Column(name = "facebook_creative_id")
	String facebook_creative_id;
	
	@Column(name = "instagram_id")
	String instagram_id;
	
	@Column(name = "product_type")
	String product_type;
	
	@Column(name = "rule")
	String rule;
	
	@Column(name = "gender")
	String gender;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAd_text() {
		return ad_text;
	}

	public void setAd_text(String ad_text) {
		this.ad_text = ad_text;
	}

	public Integer getIs_updated() {
		return is_updated;
	}

	public void setIs_updated(Integer is_updated) {
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

	public String getProducts() {
		return products;
	}

	public void setProducts(String products) {
		this.products = products;
	}

	public String getFb_page_id() {
		return fb_page_id;
	}

	public void setFb_page_id(String fb_page_id) {
		this.fb_page_id = fb_page_id;
	}

	public Integer getCampaign_id() {
		return campaign_id;
	}

	public void setCampaign_id(Integer campaign_id) {
		this.campaign_id = campaign_id;
	}

	public String getParse_campaign_id() {
		return parse_campaign_id;
	}

	public void setParse_campaign_id(String parse_campaign_id) {
		this.parse_campaign_id = parse_campaign_id;
	}

	public String getCreative_name() {
		return creative_name;
	}

	public void setCreative_name(String creative_name) {
		this.creative_name = creative_name;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Integer getIs_updated_creative() {
		return is_updated_creative;
	}

	public void setIs_updated_creative(Integer is_updated_creative) {
		this.is_updated_creative = is_updated_creative;
	}

	public Integer getIs_updated_ad() {
		return is_updated_ad;
	}

	public void setIs_updated_ad(Integer is_updated_ad) {
		this.is_updated_ad = is_updated_ad;
	}

	public String getFacebook_creative_id() {
		return facebook_creative_id;
	}

	public void setFacebook_creative_id(String facebook_creative_id) {
		this.facebook_creative_id = facebook_creative_id;
	}

	public String getInstagram_id() {
		return instagram_id;
	}

	public void setInstagram_id(String instagram_id) {
		this.instagram_id = instagram_id;
	}

	public String getProduct_type() {
		return product_type;
	}

	public void setProduct_type(String product_type) {
		this.product_type = product_type;
	}

	public String getRule() {
		return rule;
	}

	public void setRule(String rule) {
		this.rule = rule;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

}