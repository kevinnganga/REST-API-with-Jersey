package com.myRootPackage.Trying;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.core.UriInfo;

import com.myRootPackage.ExceptionsHandling.DataNotFoundException;
import com.myRootPackage.Model.UnitsService;

@Path("/messages")
public class UnitsResource {
	
	UnitsService mstservice=new UnitsService();
	
	@GET
	@Produces({MediaType.APPLICATION_JSON,MediaType.TEXT_XML})
	public List<Units> getAllUnits() {
		System.out.println(mstservice.AllUnits());
		return mstservice.AllUnits();
	}
	
	
	@GET
	@Path("/message/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Units getunit(@PathParam("id") String id) {
		
		return mstservice.OneUnit(id);
	}
	
	

	
//	@POST
//	@Path("/insert")
//	@Consumes({MediaType.APPLICATION_JSON , MediaType.APPLICATION_XML})
//	public Units AddNewunit(Units un) {
//		System.out.println( un);
//		 mstservice.AddUnit(un);
//		 return un;
//	}
	
	//SENDING BACK THE URI OF THE RESOURCE and the status code which is "created"
	@POST
	@Path("/insert")
	@Consumes({MediaType.APPLICATION_JSON , MediaType.APPLICATION_XML})
	public Response AddNewunit(Units un ,@Context UriInfo urlinfo) {
		
		Units unit=mstservice.AddUnit(un);
		String nid=String.valueOf(unit.getName());//to get the value of the unit 
												  //name added to the DB
		URI uri=urlinfo.getAbsolutePathBuilder().path(nid).build();
		return Response.created(uri)
						.entity(unit)
						.build();
		 
		 
	}
	
	@PUT
	@Path("/update")
	@Consumes({MediaType.APPLICATION_JSON , MediaType.APPLICATION_XML})
	public Units Updateunit(Units un) {
		System.out.println( un);
		 mstservice.UpdateUnit(un);
		 return un;
	}
	
	
	@DELETE
	@Path("/delete/{id}")
	public Units Deleteunit(@PathParam("id") String id) {
		
		return mstservice.deleteUnit(id);
		
	}
	
	//GETING THE ABSOLUTE PATH OF THE URL ADDITION TIPS!!!!!!!!!!!!!!!!!!!
	@GET
	@Path("/url")
	public String getUrlPath(@Context UriInfo printingPath) {
		
		String urlPath=printingPath.getAbsolutePath().toString();
		return "The path is : " +urlPath;
	}
	
	
	
	@Path("/{messageid}/comments")
	public  CommentsResource getCommentResource() {
		
		return new CommentsResource();
		
	}
	
	

}
