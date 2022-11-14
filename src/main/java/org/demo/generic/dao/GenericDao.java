package org.demo.generic.dao;

public interface GenericDao<T> {

	public void persist (T obj);
	public void remove (T obj);
	public void merge (T obj);

}