package com.myRootPackage.RestClient;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation.Builder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.myRootPackage.Trying.Units;

public class RestClient {
	
	public static void main(String[] args) {
		
		
		Client client=ClientBuilder.newClient();
		
		//WebTarget target = client.target("http://localhost:8080/Trying/webapi/messages/message/RUBY");
//		Builder builder = target.request();
//		Response response = builder.get();
//		Units unit = response.readEntity(Units.class);
		
	String un=client.target("http://localhost:8080/Trying/webapi/messages/message/RUBY")
				.request(MediaType.APPLICATION_JSON)
				.get(String.class);
		System.out.println(un);
		
		
//	WebTarget Basetarget = client.target("http://localhost:8080/Trying/webapi/");
//		WebTarget unitTarget = Basetarget.path("message/messages/");
//		WebTarget SinglemessageId = unitTarget.path("{unitId}");
//		
//		Units unt=SinglemessageId
//					.resolveTemplate("unitId", "RUBY")
//					.request(MediaType.APPLICATION_JSON)
//					.get(Units.class);
//					
//		
//		System.out.println(unt.getDepartment());
		
		
		
	}

}
