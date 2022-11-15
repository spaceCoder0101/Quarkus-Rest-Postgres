package org.demo.controller;

import java.util.List;
import java.util.logging.Logger;

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

import io.quarkus.arc.log.LoggerName;
import io.quarkus.logging.Log;

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
	public List<User> getAll(){
		return dao.findAll();
	}
	
	@POST
	public void create(User u) {
		Log.info("*****************************************");
		Log.info(u.getId()+"-"+u.getEmail()+"-"+u.getPassword());
		Log.info("*****************************************");
		dao.persist(u);
	}
	
	@DELETE
	public void delete(User u) {
		dao.remove(u);
	}
	
	@PUT
	public void update(User u) {
		dao.merge(u);
	}
	
}
