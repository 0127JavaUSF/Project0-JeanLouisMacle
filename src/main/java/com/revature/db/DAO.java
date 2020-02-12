package com.revature.db;

public interface DAO<T> {
	
	public void save(T t);
	
	public void update(T t);
	
//	public void get(T t);
	
	/* Not used in the project */
	//public void delete(T t);	
		
	}
