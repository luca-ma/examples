package it.example.ejb;

import javax.ejb.Remote;

@Remote
public interface CounterStatefulRemote {

	public int getIncrement();

}
