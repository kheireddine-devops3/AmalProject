package com.amal.amalproject.models;
import java.util.ArrayList;

	public interface Iservice <T>{
	    
	    void add(T t);
	    void delete(T t);
	    T readById(int id);
	    ArrayList<T>readAll();
	    void update(T t);
	    
	}

