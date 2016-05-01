package it.example.client;

import it.example.ejb.CounterStateFul;
import it.example.ejb.CounterStateLess;
import it.example.ejb.CounterStatefulRemote;
import it.example.ejb.CounterStatelessRemote;
import it.example.ejb.SessionExRemote;
import it.example.ejb.util.ClientUtil;

import javax.naming.Context;
import javax.naming.NamingException;
import javax.transaction.HeuristicMixedException;
import javax.transaction.HeuristicRollbackException;
import javax.transaction.NotSupportedException;
import javax.transaction.RollbackException;
import javax.transaction.SystemException;

public class EjbClient {

	public static void main(String[] args) throws NamingException,
			ClassNotFoundException, SystemException, NotSupportedException, SecurityException, IllegalStateException, RollbackException, HeuristicMixedException, HeuristicRollbackException {

		Context context = null;

		// 1. Obtaining Context
		context = ClientUtil.getInitialContext();

		// lookup SessionEX EJB stateless
		// String lookupName = doLookup(SessionEx.class.getSimpleName(),
		// SessionExRemote.class.getName(), false);
		// SessionExRemote bean = (SessionExRemote) context.lookup(lookupName);
		// System.out.println(bean.sayHelloRemote()); // 4. Call business logic

		// Example STATEFUL
		System.out.println("stateful counter client");
		String lookupName = doLookup(CounterStateFul.class.getSimpleName(),
				CounterStatefulRemote.class.getName(), true);
		CounterStatefulRemote statefCounter = (CounterStatefulRemote) context
				.lookup(lookupName);
		System.out.println("counterStateFul val session1:"
				+ statefCounter.getIncrement());
		System.out.println("counterStateFul val session1:"
				+ statefCounter.getIncrement());

		CounterStatefulRemote statefCounter1 = (CounterStatefulRemote) context
				.lookup(lookupName);
		System.out.println("counterStateFul val session2:"
				+ statefCounter1.getIncrement()); // 4. Call business
		// logic

		// Example STATEless
		System.out.println("stateless counter client");
		try {
			lookupName = doLookup(CounterStateLess.class.getSimpleName(),
					CounterStatelessRemote.class.getName(), false);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		CounterStatelessRemote stateLCounter = null;
		try {
			stateLCounter = (CounterStatelessRemote) context
					.lookup(lookupName);
		
		
		System.out.println("counter Stateless val session 1:"
				+ stateLCounter.getIncrement()); // 4. Call business
		// logic
		System.out.println("counter Stateless val session1:"
				+ stateLCounter.getIncrement()); // 4. Call business
		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private static String doLookup(String remoteBeanName,
			String remoteBeanIntName, Boolean stateful)
			throws ClassNotFoundException {

		// 2. Generate JNDI Lookup name
		String lookupName = getLookupName(remoteBeanName, remoteBeanIntName,
				stateful);

		// 3. Lookup and cast

		return lookupName;

	}

	private static String getLookupName(String beanName, String remoteIntName,
			Boolean stateful) {
		/*
		 * The app name is the EAR name of the deployed EJB without .ear suffix.
		 * Since we haven't deployed the application as a .ear, the app name for
		 * us will be an empty string
		 */
		String appName = "";

		/*
		 * The module name is the JAR name of the deployed EJB without the .jar
		 * suffix.
		 */
		String moduleName = "ejbex";// ?

		/*
		 * AS7 allows each deployment to have an (optional) distinct name. This
		 * can be an empty string if distinct name is not specified.
		 */
		String distinctName = "";

		// Fully qualified remote interface name
		final String interfaceName = SessionExRemote.class.getName();

		String name = "ejb:" + appName + "/" + moduleName + "/" + distinctName
				+ "/" + beanName + "!" + remoteIntName;
		if (stateful) {
			name = name + "?stateful";
		}

		return name;
	}
}
