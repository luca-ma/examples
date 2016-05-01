package it.example.ejb;

import javax.ejb.Local;

@Local
public interface SessionExLocal {
	public String sayHelloLocal();
}
