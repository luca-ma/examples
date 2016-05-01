package it.example.ejb;

import javax.ejb.Remote;
import javax.ejb.Stateless;

/**
 * Session Bean implementation class SessionEx
 */
@Stateless//(mappedName = "sessionEx")
//@LocalBean
@Remote(SessionExRemote.class)
public class SessionEx implements SessionExRemote, SessionExLocal {

    /**
     * Default constructor. 
     */
    public SessionEx() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public String sayHelloLocal() {

		return "LOCAL HELLO";
	}

	@Override
	public String sayHelloRemote() {
		
		return "REMOTE HELLO";
	}

}
