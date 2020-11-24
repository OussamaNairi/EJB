package tn.essat.exemple;

import javax.ejb.Local;

@Local
public interface HelloBeanLocal {
      String sayhello();
}
