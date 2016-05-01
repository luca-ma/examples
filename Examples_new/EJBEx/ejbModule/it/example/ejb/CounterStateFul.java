package it.example.ejb;

import javax.ejb.LocalBean;
import javax.ejb.Stateful;
import javax.enterprise.context.SessionScoped;

/**
 * Session Bean implementation class Counter
 */
@Stateful
@LocalBean
@SessionScoped
public class CounterStateFul implements CounterStatefulRemote, CounterStatefulLocal {

    /**
     * Default constructor. 
     */
    public CounterStateFul() {
        // TODO Auto-generated constructor stub
    }

    private int count = 0;

    
    public int getIncrement() {
        return ++count;
    }

}
