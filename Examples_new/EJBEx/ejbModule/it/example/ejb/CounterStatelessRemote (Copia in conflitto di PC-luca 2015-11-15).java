package it.example.ejb;

import javax.ejb.Remote;

@Remote
public interface CounterStatelessRemote {

	public int getIncrement();

}
