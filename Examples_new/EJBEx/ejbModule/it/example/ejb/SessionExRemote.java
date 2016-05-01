package it.example.ejb;

import javax.ejb.Remote;
import javax.enterprise.context.SessionScoped;

@Remote
@SessionScoped
public interface SessionExRemote {

	public String sayHelloRemote();
}
