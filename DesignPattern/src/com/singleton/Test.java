package com.singleton;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Test {

	public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {

		SingletonDemo demo = SingletonDemo.getInstance();

		SingletonDemo demo1 = SingletonDemo.getInstance();

		System.out.println(demo);
		System.out.println(demo1);

		System.out.println(demo.equals(demo1));
		System.out.println(demo == demo1);

		String filePath = System.getProperty("user.home") + "/Downloads/Preparation/textNotes/DesignPattern/a.txt";

		System.out.println(System.getProperty("user.home"));

		System.out.println(filePath);

		SingletonDemo demo3 = null;

		try {
			ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(filePath));
			objectOutputStream.writeObject(demo);

		} catch (IOException e) {
			e.printStackTrace();
		}

		try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(filePath))) {

			demo3 = (SingletonDemo) objectInputStream.readObject();
		}

		System.out.println(demo);
		System.out.println(demo3);

		System.out.println(demo == demo3);

		SingletonDemo demo4 = null;
		try {
			demo4 = (SingletonDemo) demo.clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		System.out.println(demo4);
	}

}
