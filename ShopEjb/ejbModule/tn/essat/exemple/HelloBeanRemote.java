package tn.essat.exemple;

import javax.ejb.Remote;

@Remote
public interface HelloBeanRemote {
	 String sayhello();
	 int add(int a,int b);
}
