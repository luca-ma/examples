package it.example.ejb;

import javax.ejb.Remote;
import javax.transaction.HeuristicMixedException;
import javax.transaction.HeuristicRollbackException;
import javax.transaction.NotSupportedException;
import javax.transaction.RollbackException;
import javax.transaction.SystemException;

@Remote
public interface CounterStatelessRemote {

	public int getIncrement() throws SystemException, NotSupportedException, SecurityException, IllegalStateException, RollbackException, HeuristicMixedException, HeuristicRollbackException, InterruptedException;

}
