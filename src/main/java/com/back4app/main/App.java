package com.back4app.main;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

import com.back4app.mongo.MongoDAO;

public class App{

	public static void main(String arg[]){
		
//		TimerTask tasknew = new App();
//		
//		Timer timer = new Timer();
//		timer.schedule(tasknew, new Date(), 1000*60*5);
		
//	}

//	@Override
//	public void run() {
		
		Common common = new Common();
		try{ 
			common.createCampaign(); 
		}catch(Exception e){
			System.out.println(e);
		}
		try{
			System.out.println("");
			System.out.println("");	
			System.out.println("Inside the update campaigns");	
			System.out.println("");
			System.out.println("");
			common.updateCampaign();
			}catch(Exception e){
				System.out.println(e);
			}
			MongoDAO.database = null;
			MongoDAO.collection = null;
			MongoDAO.client.close();
		
//	}
	}
}
