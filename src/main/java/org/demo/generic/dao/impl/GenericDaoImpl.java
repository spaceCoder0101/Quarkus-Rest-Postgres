package org.demo.generic.dao.impl;


import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.demo.generic.dao.GenericDao;

public abstract class GenericDaoImpl<T> implements GenericDao<T> {

	@Inject
	protected EntityManager em;
	
	@Override
	@Transactional
	public void persist(T obj) {
		em.persist(obj);	
	}
	
	@Override
	@Transactional
	public void remove(T obj) {
		em.remove(em.contains(obj)?obj:em.merge(obj));
	}
	
	@Override
	@Transactional
	public void merge(T obj) {
		em.merge(obj);	
	}
}
