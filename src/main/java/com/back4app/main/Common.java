package com.back4app.main;

import java.util.ArrayList;

import org.bson.Document;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.back4app.entities.Adset;
import com.back4app.entities.Campaign;
import com.back4app.entities.Client;
import com.back4app.entities.Creative;
import com.back4app.entities.Users;
import com.back4app.mongo.MongoDAO;
import com.back4app.mongoOperation.MongoOp;
import com.hibernate.factory.BuildFactory;
import com.hibernate.factory.ClientSQLObjects;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Updates;

public class Common {

	public void createCampaign() throws JSONException{
		
		ArrayList<Document> getCampaigns = MongoOp.getCampaignData(1);
		
		System.out.println(getCampaigns.size());
		
		if(getCampaigns.size() > 0){
		
			SessionFactory factory = BuildFactory.getFactory();	
			
			System.out.println(factory);
			
			for(Document campaign : getCampaigns){
				
				Campaign sqlCampaign = new Campaign();
				Adset sqlAdset = new Adset();
				Creative sqlCreative = new Creative();
				
				System.out.println("The client object id outside is : "+campaign.getString("_id"));
				
				sqlCampaign.setObjective("LINK_CLICKS");
				
				if(campaign.containsKey("_created_at")){
					sqlCampaign.setCreated_at(campaign.getDate("_created_at"));
				}else{
					sqlCampaign.setCreated_at(null);
				}
				
				if(campaign.containsKey("_updated_at")){
					sqlCampaign.setUpdated_at(campaign.getDate("_updated_at"));
				}else{
					sqlCampaign.setUpdated_at(null);
				}
				
				if(campaign.containsKey("referrer")){
					sqlCampaign.setReferrer(campaign.getString("referrer"));
				}else{
					sqlCampaign.setReferrer(null);
				}
				
				if(campaign.containsKey("ext_id")){
					sqlCampaign.setExt_id(campaign.getString("ext_id"));
				}else{
					sqlCampaign.setExt_id(null);
				}
				
				sqlCampaign.setStatus("2");
				sqlCampaign.setIs_updated("1");
				sqlCampaign.setIs_catalog_created("0");
				
				if(campaign.containsKey("product_type")){
					sqlCampaign.setProduct_type(campaign.getString("product_type"));
				}else{
					sqlCampaign.setUpdated_at(null);
				}
				
				if(campaign.containsKey("type")){
					sqlCampaign.setType(String.valueOf(campaign.get("type")));
				}else{
					sqlCampaign.setType(null);
				}
				
				//Adset Parameters
				
				sqlAdset.setDaily_budget(5.0);
				
				if(campaign.containsKey("gender")){
					sqlAdset.setGender(campaign.getString("gender"));
				}else{
					sqlAdset.setGender(null);
				}
				
				if(campaign.containsKey("min_age")){
					sqlAdset.setAge_min((Integer) campaign.get("min_age"));
				}else{
					sqlAdset.setAge_min(18);
		 		}
				
				if(campaign.containsKey("max_age")){
					sqlAdset.setAge_max((Integer) campaign.get("max_age"));
				}else{
					sqlAdset.setAge_max(65);
				}
				
				sqlAdset.setCities("[1035921,1023040,1017930,1027234]");
				
				sqlAdset.setIs_updated(1);
				
				if(campaign.containsKey("_created_at")){
					sqlAdset.setCreated_at(campaign.getDate("_created_at"));
					sqlAdset.setStart_date(campaign.getDate("_created_at"));
				}else{
					sqlAdset.setCreated_at(null);
					sqlAdset.setStart_date(null);
				}
				
				if(campaign.containsKey("_updated_at")){
					sqlAdset.setUpdated_at(campaign.getDate("_updated_at"));
				}else{
					sqlAdset.setUpdated_at(null);
				}
				
				if(campaign.containsKey("specific_targeting")){
					sqlAdset.setSpecific_targeting(String.valueOf(campaign.get("specific_targeting"))); 
				}else{
					sqlAdset.setSpecific_targeting(null);
				}
				
				// Creative Data 
				if(campaign.containsKey("ad_text")){
					sqlCreative.setAd_text(campaign.getString("ad_text"));
				}else{
					sqlCreative.setAd_text(null);
				}
				
				sqlCreative.setIs_updated(1);
				
				sqlCreative.setIs_updated_creative(1);
				
				sqlCreative.setIs_updated_ad(1);
				
				if(campaign.containsKey("_created_at")){
					sqlCreative.setCreated_at(campaign.getDate("_created_at"));
				}else{
					sqlCreative.setCreated_at(null);
				}
				
				if(campaign.containsKey("_updated_at")){
					sqlCreative.setUpdated_at(campaign.getDate("_updated_at"));
				}else{
					sqlCreative.setUpdated_at(null);
				}
				
				if(campaign.containsKey("products")){
					
					System.out.println(campaign.get("products"));
					
					ArrayList<Document> products = (ArrayList<Document>) campaign.get("products");
					
					JSONArray productArr = new JSONArray();
					
					for(Document product : products){
					
						System.out.println(product.toJson());
						
						productArr.put(new JSONObject(product.toJson()));
						
					}
					
					System.out.println("The document array value is : "+productArr.toString());
					
					sqlCreative.setProducts(productArr.toString());
				
				}else{
					sqlCreative.setProducts(null);
				}
				
				if(campaign.containsKey("_id")){
					sqlCreative.setParse_campaign_id(campaign.getString("_id"));
				}else{
					sqlCreative.setParse_campaign_id(null);
				}
				
				if(campaign.containsKey("campaign_name")){
					sqlCreative.setCreative_name(campaign.getString("campaign_name"));
				}else{
					sqlCreative.setCreative_name(null);
				}
				
				if(campaign.containsKey("status")){
					try{
						if(campaign.getInteger("status") == 1){
							sqlCreative.setStatus(2);
						}
						else{
							sqlCreative.setStatus(campaign.getInteger("status"));
						}
					}catch(Exception e){
						if(campaign.getLong("status").intValue() == 1){
							sqlCreative.setStatus(2);
						}
						else{
							sqlCreative.setStatus(campaign.getLong("status").intValue());
						}
					}
				}else{
					sqlCreative.setStatus(2);
				}
				
				if(campaign.containsKey("product_type")){
					sqlCreative.setProduct_type(campaign.getString("product_type"));
				}else{
					sqlCreative.setProduct_type(null);
				}
				
				if(campaign.containsKey("rule")){
					sqlCreative.setRule(campaign.getString("rule"));
				}else{
					sqlCreative.setRule(null);
				}
				
				if(campaign.containsKey("gender")){
					sqlCreative.setGender(campaign.getString("gender"));
				}else{
					sqlCreative.setGender(null);
				}
				
				Client clientFetched = (Client)ClientSQLObjects.getClientWithObjectID(campaign.getString("client_id"));
				
				if(null == clientFetched){
					continue;
				}
				
				System.out.println("clientFetched : " + clientFetched);
				
				if( null != clientFetched){
					
					System.out.println(clientFetched.getId());
					
				}
				
				Campaign campaignFetched = (Campaign) ClientSQLObjects.getCampaignWithClientID(clientFetched.getId(), String.valueOf(campaign.getInteger("type")));
		
				System.out.println("campaignFetched : " + campaignFetched);
				
				if( null != campaignFetched){
					
					System.out.println(campaignFetched.getId());
					
				}
				
				if( null == campaignFetched){
					
					Session session = BuildFactory.getFactory().openSession();
					session.beginTransaction();
					
					sqlCampaign.setClient_id(clientFetched.getId());
					sqlCampaign.setCampaign_name(clientFetched.getId()+"_"+clientFetched.getWebsite());
					int CampaignIDMySQL = (Integer) session.save(sqlCampaign);
					
					System.out.println("Campaign Created with Campaign ID : "+CampaignIDMySQL);
					
					if(CampaignIDMySQL == 0){
						session.getTransaction().rollback();
						continue;
					}
					
					sqlAdset.setClient_id(clientFetched.getId());
					sqlAdset.setCampaign_id(String.valueOf(CampaignIDMySQL));
					int AdsetIDMySQL = (Integer) session.save(sqlAdset);
					
					System.out.println("Adset Created with Adset ID : "+AdsetIDMySQL);
					
					if(AdsetIDMySQL == 0){
						session.getTransaction().rollback();
						continue;
					}
					
					sqlCreative.setCampaign_id(CampaignIDMySQL);
					int CreativeIDMySQL = (Integer) session.save(sqlCreative);
					
					System.out.println("Creative Created with Creative ID : "+CreativeIDMySQL);
					
					if(CreativeIDMySQL == 0){
						session.getTransaction().rollback();
						continue;
					}
					
					session.getTransaction().commit();
					session.close();
				
					MongoDAO.collection.updateOne(Filters.eq("_id", campaign.getString("_id")), Updates.set("is_updated", 0));
					
					System.out.println("The Campaign with object ID : "+campaign.getString("_id")+" is successfully created.");
					
				}
				else{
						
					Session session = BuildFactory.getFactory().openSession();
					session.beginTransaction();
							
					sqlCreative.setCampaign_id(campaignFetched.getId());
					int CreativeIDMySQL = (Integer) session.save(sqlCreative);
							
					System.out.println("Creative Created with Creative ID : "+CreativeIDMySQL);
							
					if(CreativeIDMySQL == 0){
						session.getTransaction().rollback();
						continue;
					}
							
					session.getTransaction().commit();
					session.close();
					
					MongoDAO.collection.updateOne(Filters.eq("_id", campaign.getString("_id")), Updates.set("is_updated", 0));
					
					System.out.println("The Campaign with object ID : "+campaign.getString("_id")+" is successfully created.");
							
				}
				
			}
			
		}else{
			System.out.println("No Creation is requested in Parse.");
		}
			
	}
	
	public void updateCampaign() throws JSONException{
		
		ArrayList<Document> getCampaigns = MongoOp.getCampaignData(2);
		
		System.out.println(getCampaigns.size());
		
		if(getCampaigns.size() > 0){
		
			SessionFactory factory = BuildFactory.getFactory();	
			
			System.out.println(factory);
			
			for(Document campaign : getCampaigns){
				
				Creative sqlCreative = (Creative) ClientSQLObjects.getCreativeWithObjectID(campaign.getString("_id"));
				
				if(null != sqlCreative){
				
					System.out.println("The client object id outside is : "+campaign.getString("_id"));
					
					// Creative Data
					
					if(campaign.containsKey("ad_text")){
						sqlCreative.setAd_text(campaign.getString("ad_text"));
					}else{
						sqlCreative.setAd_text(null);
					}
					
					if(campaign.containsKey("is_updated_ad")){
						try{
							if(campaign.getInteger("is_updated_ad") == 1){
								sqlCreative.setIs_updated_ad(2);
							}
							else{
								sqlCreative.setIs_updated_ad(campaign.getInteger("is_updated_ad"));
							}
						}catch(Exception e){
							if(campaign.getLong("is_updated_ad").intValue() == 1){
								sqlCreative.setIs_updated_ad(2);
							}
							else{
								sqlCreative.setIs_updated_ad(campaign.getLong("is_updated_ad").intValue());
							}
						}
					}else{
						sqlCreative.setIs_updated_ad(0);
					}
					
					if(campaign.containsKey("is_updated_creative")){
						try{
							if(campaign.getInteger("is_updated_creative") == 1){
								sqlCreative.setIs_updated_creative(2);
							}
							else{
								sqlCreative.setIs_updated_creative(campaign.getInteger("is_updated_creative"));
							}
						}catch(Exception e){
							if(campaign.getLong("is_updated_creative").intValue() == 1){
								sqlCreative.setIs_updated_creative(2);
							}
							else{
								sqlCreative.setIs_updated_creative(campaign.getLong("is_updated_creative").intValue());
							}
						}
					}else{
						sqlCreative.setIs_updated_creative(0);
					}
					
					sqlCreative.setIs_updated(2);
					
					if(campaign.containsKey("_created_at")){
						sqlCreative.setCreated_at(campaign.getDate("_created_at"));
					}else{
						sqlCreative.setCreated_at(null);
					}
					
					if(campaign.containsKey("_updated_at")){
						sqlCreative.setUpdated_at(campaign.getDate("_updated_at"));
					}else{
						sqlCreative.setUpdated_at(null);
					}
					
					if(campaign.containsKey("products")){
						
						System.out.println(campaign.get("products"));
						
						ArrayList<Document> products = (ArrayList<Document>) campaign.get("products");
						
						JSONArray productArr = new JSONArray();
						
						for(Document product : products){
						
							System.out.println(product.toJson());
							
							productArr.put(new JSONObject(product.toJson()));
							
						}
						
						System.out.println("The document array value is : "+productArr.toString());
						
						sqlCreative.setProducts(productArr.toString());
					
					}else{
						sqlCreative.setProducts(null);
					}
					
					if(campaign.containsKey("_id")){
						sqlCreative.setParse_campaign_id(campaign.getString("_id"));
					}else{
						sqlCreative.setParse_campaign_id(null);
					}
					
					if(campaign.containsKey("campaign_name")){
						sqlCreative.setCreative_name(campaign.getString("campaign_name"));
					}else{
						sqlCreative.setCreative_name(null);
					}
					
					if(campaign.containsKey("status")){
						try{
							sqlCreative.setStatus(campaign.getInteger("status"));
						}catch(Exception e){
							sqlCreative.setStatus(campaign.getLong("status").intValue());
						}
					}else{
						sqlCreative.setStatus(2);
					}
					
					if(campaign.containsKey("product_type")){
						sqlCreative.setProduct_type(campaign.getString("product_type"));
					}else{
						sqlCreative.setProduct_type(null);
					}
					
					if(campaign.containsKey("rule")){
						sqlCreative.setRule(campaign.getString("rule"));
					}else{ 
						sqlCreative.setRule(null);
					}
					
					if(campaign.containsKey("gender")){
						sqlCreative.setGender(campaign.getString("gender"));
					}else{
						sqlCreative.setGender(null);
					}
					
					if(ClientSQLObjects.saveOrUpdate(sqlCreative)){ 
						System.out.println("Creative with Object ID : "+ campaign.getString("_id") + " is updated successfully.");
						
					MongoDAO.collection.updateOne(Filters.eq("_id", campaign.getString("_id")), Updates.combine(Updates.set("is_updated", 0), Updates.set("is_updated_creative", 0), Updates.set("is_updated_ad", 0)));
						
					}
					
					else{
						System.out.println("HIBERNATE EXCEPTION : Email need to be sent as there is no craetive found in MySQL with object ID: "+campaign.getString("_id"));
					}
					
					
				}
				else{
					System.out.println("Email need to be sent as there is no craetive found in MySQL with object ID: "+campaign.getString("_id"));
				}
				
			}
			
		}else{
			System.out.println("No Creation is requested in Parse.");
		}
	}
} 