package org.sree.javabrains;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.FileSystemResource;

public class DrawingApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//Traingle triangle = new Traingle();
		//triangle.draw();
		//BeanFactory factory = new XmlBeanFactory(new FileSystemResource("spring.xml"));
		ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
		Triangle triangle = (Triangle) context.getBean("triangle2");
		/*Triangle triangle1 = (Triangle) context.getBean("triangle-alias");*/
		triangle.draw();
		/*triangle1.draw();*/
	}

}
