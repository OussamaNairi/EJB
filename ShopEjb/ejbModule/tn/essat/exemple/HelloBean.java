package tn.essat.exemple;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

/**
 * Session Bean implementation class HelloBean
 */
@Stateless
@LocalBean
public class HelloBean implements HelloBeanRemote, HelloBeanLocal {

	@Override
	public String sayhello() {
		// TODO Auto-generated method stub
		return "Hello Bean";
	}

	@Override
	public int add(int a, int b) {
		// TODO Auto-generated method stub
		return a+b;
	}

}
