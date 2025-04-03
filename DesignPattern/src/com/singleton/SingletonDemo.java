package com.singleton;

import java.io.Serializable;

public class SingletonDemo implements Serializable, Cloneable{

	private static final long serialVersionUID = 1L;
	
	private static SingletonDemo instance = null;

	private SingletonDemo() {}

	public static SingletonDemo getInstance() {

		if (instance == null) {

			synchronized (SingletonDemo.class) {

				if (instance == null) {
					
					instance = new SingletonDemo();
				}
			}
		}

		return instance;
	}
	// Prevents breaking Singleton pattern during Deserialization
	protected Object readResolve() {

		return instance;
	}
	 
	 //
	 @Override
	protected Object clone() throws CloneNotSupportedException {
		//return super.clone();
		 
		 throw new CloneNotSupportedException();
	}
	 

}
