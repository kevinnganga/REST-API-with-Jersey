package com.myRootPackage.ExceptionsHandling;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class DataNotFoundExceptionMapper implements ExceptionMapper<DataNotFoundException> {

	@Override
	public Response toResponse(DataNotFoundException ex) {
		// TODO Auto-generated method stub
		ErrorMessage errors=new ErrorMessage(ex.getMessage(), 404, "www.gmail.com");
		return Response.status(Status.NOT_FOUND)
				.entity(errors)
				.build();
	}
	
	

}
