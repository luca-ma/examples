package it.example.ejb;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

/**
 * Session Bean implementation class Counter
 */
@Stateless
@LocalBean
public class CounterStateLess implements CounterStatelessRemote {

	/**
	 * Default constructor.
	 */
	public CounterStateLess() {
		// TODO Auto-generated constructor stub
	}

	private int count = 0;

	public int getIncrement() {
		return ++count;
	}

}
