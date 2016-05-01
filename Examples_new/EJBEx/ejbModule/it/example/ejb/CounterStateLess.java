package it.example.ejb;

import javax.annotation.Resource;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.transaction.HeuristicMixedException;
import javax.transaction.HeuristicRollbackException;
import javax.transaction.NotSupportedException;
import javax.transaction.RollbackException;
import javax.transaction.SystemException;
import javax.transaction.UserTransaction;

/**
 * Session Bean implementation class Counter
 */
@Stateless
@LocalBean
@TransactionManagement(TransactionManagementType.BEAN)
public class CounterStateLess implements CounterStatelessRemote {

	@Resource
	private UserTransaction userTx;
	/**
	 * Default constructor.
	 */
	public CounterStateLess() {
		// TODO Auto-generated constructor stub
	}

	private int count = 0;

	public int getIncrement() throws SystemException, NotSupportedException, SecurityException, IllegalStateException, RollbackException, HeuristicMixedException, HeuristicRollbackException, InterruptedException {
		userTx.setTransactionTimeout(10);
		userTx.begin();
		Thread.currentThread().sleep(20000);
		++count;
		userTx.commit();
		return count;
	}

}
