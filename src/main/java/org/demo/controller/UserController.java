package org.demo.controller;

import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import org.demo.dao.UserDao;
import org.demo.model.User;

@Path("/user")
public class UserController {

	@Inject
	UserDao dao;
	
	@GET
	@Path("/")
	public String user_home() {
		return "Home page User! Hi from live coding";
	}
	
	@GET
	@Path("/all")
	@Produces("application/json")
	public List<User> getAll(){
		return dao.findAll();
	}
	
	@Transactional
	@POST
	@Path("/")
	@Produces("application/json")
	@Consumes("application/json")
	public void create(User u) {
		dao.persist(u);
	}
	
	@DELETE
	@Path("/")
	@Produces("application/json")
	@Consumes("application/json")
	public void delete(User u) {
		dao.remove(u);
	}
	
	@PUT
	@Path("/")
	@Produces("application/json")
	@Consumes("application/json")
	public void update(User u) {
		dao.merge(u);
	}
	
}
