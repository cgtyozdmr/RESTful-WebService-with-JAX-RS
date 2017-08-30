package com.mkyong.rest;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

@Path("/users")
public class UserRestService {

	@GET
	@Path("{id}")
	public Response getUserById(@PathParam("id") String id) {

		return Response.status(200).entity("getUserById cagrildi, id : " + id)
				.build();

	}

	@GET
	@Path("{gun}/{ay}/{yil}")
	public Response getUserHistory(@PathParam("gun") int gun,
			@PathParam("ay") int ay, @PathParam("yil") int yil) {

		String date = gun + "/" + ay + "/" + yil;

		return Response.status(200)
				.entity("getUserHistory cagrildi, gun/ay/yil : " + date)
				.build();

	}
	
}