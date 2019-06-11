package com.myRootPackage.Trying;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

@Path("/")
public class CommentsResource {

	@GET
	public String Test() {
		
		return "It worked";
	}
	
	
	@GET
	@Path("/{commentid}")
	public String Test2(@PathParam("commentid") int id,@PathParam("messageid") int id2 ){
		
		return "Comment Id is" +id+ "messageId is"+id2;
	}
	
}
