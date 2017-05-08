package com.hibernate.factory;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Expression;

import com.back4app.entities.Campaign;
import com.back4app.entities.Client;
import com.back4app.entities.Creative;
import com.back4app.entities.Users;

public class ClientSQLObjects {

	public static Client getClientWithObjectID(String objectId){
	
		Session session = BuildFactory.getFactory().openSession();
		session.beginTransaction();
		
		Criteria criteria = session.createCriteria(Client.class);
		criteria.add(Expression.eq("object_id", objectId));
		
		List<Client> client = criteria.list();
		
		session.getTransaction();
		session.close();
		
		if(client.size() > 0 && client.size() < 2){
			return client.get(0);
		}
		else{
			return null;
		}
	}
	
	public static Creative getCreativeWithObjectID(String objectId){
		
		Session session = BuildFactory.getFactory().openSession();
		session.beginTransaction();
		
		System.out.println("Object ID inside hibernate is : "+objectId);
		
		Criteria cri = session.createCriteria(Creative.class);
		cri.add(Expression.eq("parse_campaign_id", objectId));
		
		List<Creative> creative = cri.list();
		
		session.getTransaction();
		session.close();
		
		if(creative.size() > 0){
			return creative.get(0);
		}
		else{
			return null;
		}
	}
	
	public static Boolean saveOrUpdate(Object obj) {
		Session session = null;
		try {
			session = BuildFactory.getFactory().openSession();
			session.beginTransaction();
			session.saveOrUpdate(obj);
			session.getTransaction().commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		} finally {
			session.close();
		}
	}
	
	public static Campaign getCampaignWithClientID(int clientId, String type){
		
		Session session = BuildFactory.getFactory().openSession();
		session.beginTransaction();
		
		System.out.println("client ID in hibernate is : "+ clientId);
		System.out.println("type in hibernate is : "+ type);
		
		Criteria criteria = session.createCriteria(Campaign.class);
		criteria.add(Expression.eq("client_id", clientId));
		criteria.add(Expression.eq("type", type));
		
		List<Campaign> campaign = criteria.list();
		
		session.getTransaction();
		session.close();
		
		if(campaign.size() > 0){
			return campaign.get(0);
		}
		else{
			return null;
		}
		
	}
	
	public static Users getUserWithClientID(int client_id){
		
		Session session = BuildFactory.getFactory().openSession();
		session.beginTransaction();
		
		Criteria criteria = session.createCriteria(Users.class);
		criteria.add(Expression.eq("client_id", client_id));
		List<Users> users = criteria.list();
		
		session.getTransaction();
		session.close();
		
		if(users.size() > 0 && users.size() < 2){
			return users.get(0);
		}
		else{
			return null;
		}
	}
}