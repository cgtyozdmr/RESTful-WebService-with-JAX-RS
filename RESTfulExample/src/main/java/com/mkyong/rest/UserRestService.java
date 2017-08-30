package com.mkyong.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

@Path("/users")
public class UserRestService {

	@GET
	public Response getUser() {

		return Response.status(200).entity("getUser metodu cagrildi").build();

	}

	@GET
	@Path("/vip")
	public Response getUserVIP() {

		return Response.status(200).entity("VIP metodu cagrildi").build();

	}

	@GET
	@Path("{name}")
	public Response getUserByName(@PathParam("name") String name) {

		return Response.status(200)
				.entity("getUserByName metodu cagrildi, isim : " + name).build();

	}

	@GET
	@Path("{id : \\d+}")//d+ sadece nümerik olacaðýný gösterir
	public Response getUserById(@PathParam("id") String id) {

		return Response.status(200).entity("idye gore metot cagrildi, id : " + id)
				.build();

	}

	@GET
	@Path("/username/{username : [a-zA-Z][a-zA-Z_0-9]}")//ilk karakter alfanümerik ikincisi farketmez toplam 2 karakter olmalý
	public Response getUserByUserName(@PathParam("username") String username) {

		return Response.status(200)
				.entity("usernameye gore metot cagrildi, username : " + username)
				.build();

	}

	@GET
	@Path("/books/{isbn : \\d+}")//d+ olduðu için isbn sadece nümerik karakter alabilir.
	public Response getUserBookByISBN(@PathParam("isbn") String isbn) {

		return Response.status(200)
				.entity("kitabin id sine gore metot cagrildi, isbn : " + isbn).build();

	}

}