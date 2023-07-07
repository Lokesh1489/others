package com.softtek.app.Springboot1;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.FileSystemResource;

public class Demo {

	public static void main(String[] args) {
		BeanFactory factory=new XmlBeanFactory(new FileSystemResource("/Springboot1/src/main/java/com/softtek/app/config/Applicationcontext.xml"));
		Object object = factory.getBean("wmg");
		WishMessageGenerator generator=(WishMessageGenerator)object;
		String result=generator.generateWishMessage("raja");
		System.out.println(result);
		
	}

}
