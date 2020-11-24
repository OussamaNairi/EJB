package tn.essat.service;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

/**
 * Session Bean implementation class CalculatriceService
 */
@Stateless
@LocalBean
public class CalculatriceService {
  public double add(double x,double y) {
	  
	  return x+y;
  }
 public double mult(double x,double y) {
	  
	  return x*y;
  }
 public double sub(double x,double y) {
	  
	  return x-y;
 }
}
