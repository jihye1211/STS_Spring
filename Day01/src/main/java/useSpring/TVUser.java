package useSpring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class TVUser {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext factory = new GenericXmlApplicationContext("app.xml");
		TV tv = (TV) factory.getBean("tv");
		tv.powerOn();
		tv.powerOff();
		tv.volumeUp();
	}

}
