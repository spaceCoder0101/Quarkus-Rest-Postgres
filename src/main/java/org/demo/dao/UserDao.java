package org.demo.dao;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;

import org.demo.generic.dao.impl.GenericDaoImpl;
import org.demo.model.User;

@ApplicationScoped
public class UserDao extends GenericDaoImpl<User>{
	
	@Transactional
	public List<User> findAll(){
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<User> cq = cb.createQuery(User.class);
		Root<User> root = cq.from(User.class);
		cq.select(root);
		return em.createQuery(cq).getResultList();
	}
}
