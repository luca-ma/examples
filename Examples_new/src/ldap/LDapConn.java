package ldap;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.Properties;

import javax.naming.Context;
import javax.naming.NamingEnumeration;
import javax.naming.NamingException;
import javax.naming.directory.Attribute;
import javax.naming.directory.DirContext;
import javax.naming.directory.InitialDirContext;
import javax.naming.directory.SearchControls;
import javax.naming.directory.SearchResult;

public class LDapConn {

	// private final static Charset ENCODING = StandardCharsets.UTF_8;

	private static DirContext ctx = null;
	private static String INITCTX = "com.sun.jndi.ldap.LdapCtxFactory";

	// properties def
	public static final String LDAP_SERVER_HOST = "ldap_server_host";
	public static final String LDAP_SERVER_PORT = "ldap_server_port";
	public static final String LDAP_USER = "ldap_user";
	public static final String LDAP_PASSWORD = "ldap_password";

	// LDAP properties
	private static String ldapHost = "";
	private static Integer ldapPort = 389;
	public static String ldapUserBase = "cn=Manager,dc=my-domain,dc=com";
	public static String ldapUserPswd = "pegaso";

	public static String LINE_PREFIX = "IdentityManagement,NONE,CRE,";

	public static void main(String[] args) throws NamingException, IOException {

		populateProperties();

		long iniTime = System.currentTimeMillis();

		LDapConn ldapConn = new LDapConn();
		ldapConn.openLDapConn(ldapUserBase, ldapUserPswd);

		System.out.println(">> start search LDAP ");
		String filter = "(&(cn=*)(sn=*))";
		String baseSearch_IT = "ou=unicredit_it,dc=my-domain,dc=com";
		String baseSearch_DE = "ou=unicredit_de,dc=my-domain,dc=com";
		String baseSearch_AU = "ou=unicredit_ost,dc=my-domain,dc=com";

		// String baseSearch_IT = "ou=IT,dc=maxcrc,dc=com";
		// String baseSearch_DE = "ou=O,dc=maxcrc,dc=com";
		// String baseSearch_AU = "ou=DE,dc=maxcrc,dc=com";

		// Map<String, Map<String, String>> entries = ldapConn.getEntries(
		// filter_IT, null);
		List<String> completeList = new ArrayList<String>();

		List<String> entries = ldapConn.getEntries(baseSearch_IT, filter, null);
		completeList.addAll(entries);
		System.out.println(">> FOUND: " + entries.size() + " IT entries");

		entries = ldapConn.getEntries(baseSearch_DE, filter, null);
		completeList.addAll(entries);
		System.out.println(">> FOUND: " + entries.size() + " DE entries");

		entries = ldapConn.getEntries(baseSearch_AU, filter, null);
		completeList.addAll(entries);
		System.out.println(">> FOUND: " + entries.size() + " AU entries");

		System.out.println(">> Write: " + completeList.size()
				+ " entries on csv file");

		double readAndParsingTime = (System.currentTimeMillis() - iniTime) / 1000.0;
		System.out.println("LDAp read and parse TIME: " + readAndParsingTime
				+ " sec");

		ldapConn.writeLargerTextFile("prova.csv", completeList);

		double totalTime = (System.currentTimeMillis() - iniTime) / 1000.0;
		System.out.println("TOTAL TIME: " + totalTime + " sec");
	}

	public void openLDapConn(String usr, String pswd) throws NamingException {

		Hashtable<String, String> env = new Hashtable<String, String>();
		// Specify which class to use for our JNDI provider
		env.put(Context.INITIAL_CONTEXT_FACTORY, INITCTX);
		env.put(Context.PROVIDER_URL, getLdapUrl());
		// Security Information - Log as anonymous
		env.put(Context.SECURITY_AUTHENTICATION, "simple");

		// account LDAP --> file slapd.conf -->> rootdn
		// "cn=Manager,dc=maxcrc,dc=com"

		env.put(Context.SECURITY_PRINCIPAL, usr);
		env.put(Context.SECURITY_CREDENTIALS, pswd);

		System.out.println(">>LDAPAccess  Tryng to connect to:" + getLdapUrl());

		ctx = new InitialDirContext(env);

		System.out.println(">> CONN OK");

	}

	public void closeLDapConn() {

		if (ctx != null) {
			try {
				ctx.close();
				System.out
						.println(">>LDAPAccess<< \t[closeConnection()] Connection Ldap closed ");
			} catch (NamingException exc) {
				System.out
						.println(">>LDAPAccess<< Error closing LDAP connection: "
								+ exc.getMessage() != null ? exc.getMessage()
								: "");
			}
		}
	}

	public String getLdapUrl() {
		try {
			return "ldap://" + ldapHost + ":" + String.valueOf(ldapPort);
		} catch (NullPointerException e) {
			System.out.println("LDAP HOST or LDAP PORT not defined!");
			return "ldap://localhost:389";
		}
	}

	// public Map<String, Map<String, String>> getEntries(String filter,
	// String[] attributes) throws NamingException, NullPointerException {
	public List<String> getEntries(String baseSearch, String filter,
			String[] attributes) throws NamingException, NullPointerException {

		// HashMap<String, Map<String, String>> ht = null;
		SearchControls searchCtrl = new SearchControls();
		// searchCtrl.setSearchScope(SearchControls.OBJECT_SCOPE);
		// searchCtrl.setReturningAttributes(attributes);

		long iniSearch = System.currentTimeMillis();
		NamingEnumeration<SearchResult> searchEnum = ctx.search(baseSearch,
				filter, searchCtrl);

		double searchTime = (System.currentTimeMillis() - iniSearch) / 1000.0;
		System.out.println("LDAP Search TIME: " + searchTime + " sec");

		List<String> rows = new ArrayList<String>();

		// System.out.println("search found: "+searchEnum.)
		int numSearch = 0;
		StringBuffer row = new StringBuffer();
		String oriDom = "";
		String publicNum = "";
		String alias = "";
		String country = "";
		String destDom = "";
		String transRule = "";
		Integer totUsers = 0;
		Integer smartUser = 0;
		while (searchEnum.hasMoreElements()) {

			numSearch++;
			SearchResult sr1 = (SearchResult) searchEnum.nextElement();

			// row.append(sr1.getNameInNamespace()).append(",");

			// Map<String, String> attrMap = new HashMap<String, String>();
			NamingEnumeration<? extends Attribute> e2 = sr1.getAttributes()
					.getAll();

			String userType = null;
			while (e2.hasMoreElements()) {
				Attribute attr = (Attribute) e2.nextElement();

				// country=???;
				if (attr.getID().toString().equals("telephoneNumber")) {
					publicNum = attr.get().toString();
				}
				if (attr.getID().toString().equals("labeledURI")) {
					alias = attr.get().toString();
					country = alias.substring(alias.lastIndexOf(".") + 1);
				}
				boolean isBusCat = attr.getID().toString()
						.equals("businessCategory");
				if (isBusCat) {
					userType = attr.get().toString();
					if (attr.get().toString().equals("userSmart"))
						smartUser++;
				}

			}

			// /========= create csv rows for different user

			// 1) Only LYNC -- 2ROWS

			// each "onlyLYNC" Unicredit user is described by two rows:
			// the first row contains the Ingress Domain field set to all.all
			// the second row contains the "Ingress Domain field set to cli.cli.

			// SMART USER APPEND 3 ROW for ONE entry

			// FIRST ROW LYNC --> country domain

			row.append(LINE_PREFIX);
			row.append("LYNCUnicredit.com").append(",").append(publicNum)
					.append(",").append(" ").append(",").append(" ")
					.append(",").append("CLI").append(",").append(" ");
			rows.add(row.toString());
			row.setLength(0);

			// SECOND ROW country domain --> LYNC
			row.append(LINE_PREFIX);
			row.append(country).append(",").append(publicNum).append(",")
					.append(" ").append(",").append(alias).append(",")
					.append("URI").append(",").append("LYNCUnicredit.com");
			rows.add(row.toString());
			row.setLength(0);

			// THIRD ROW row useful to permit CLI routing
			row.append(LINE_PREFIX);
			row.append("CLI.CLI").append(",").append(publicNum).append(",")
					.append(" ").append(",").append(alias).append(",")
					.append("NONE").append(",").append(country);
			rows.add(row.toString());
			row.setLength(0);

			oriDom = "--";
			publicNum = "--";
			alias = "--";
			country = "--";
			destDom = "--";
			transRule = "--";

			// ht.put(sr1.getNameInNamespace(), attrMap);
			// rows.add(row.toString());
			totUsers++;
		}
		// System.out.println("search found: " + numSearch);

		double searchAndElab = (System.currentTimeMillis() - iniSearch) / 1000.0;
		System.out.println("LDAP Search TIME + ELABORATION : " + searchAndElab
				+ " sec" + ", TotUsers:" + totUsers + ", smartUSers:"
				+ smartUser);
		return rows;
	}

	void writeLargerTextFile(String aFileName, List<String> aLines)
			throws IOException {

		// JDK 1.7
		// Path path = Paths.get(aFileName); jdk 7
		//
		// try {
		// Files.delete(path);
		// } catch (NoSuchFileException x) {
		// System.out.println(" no such" + " file or directory:" + path);
		// } catch (IOException x) {
		// // File permission problems are caught here.
		// x.printStackTrace();
		// }
		File file = new File(aFileName);
		try {
			if (file.delete())
				System.out.println("File was successfully deleted.");
			else
				System.err.println("File was not deleted.");
		} catch (Exception e1) {
			e1.printStackTrace();
		}

		// JDK 1.7
		// try {
		// BufferedWriter writer = Files.newBufferedWriter(path, ENCODING);
		// writer.write("######################");
		// writer.newLine();
		// writer.write("### num of rows:" + aLines.size() + " ###");
		// writer.newLine();
		// writer.write("######################");
		// writer.write("### IDM # NONE # CRE # ORI_DOM # E164 # PNP # ALIAS # TRANS RULE # DEST DOM ###");
		// writer.write("######################");
		// writer.newLine();
		// for (String line : aLines) {
		// writer.write(line);
		// writer.newLine();
		// }
		// } catch (Exception e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// }

		if (!file.exists()) {
			file.createNewFile();
		}

		FileWriter fw = new FileWriter(file.getAbsoluteFile());
		BufferedWriter writer = new BufferedWriter(fw);
		try {
			// writer.write("######################");
			// writer.newLine();
			// writer.write("### num of rows:" + aLines.size() + " ###");
			// writer.newLine();
			// writer.write("######################");
			// writer.write("### IDM # NONE # CRE # ORI_DOM # E164 # PNP # ALIAS # TRANS RULE # DEST DOM ###");
			// writer.write("######################");
			// writer.newLine();
			for (String line : aLines) {
				writer.write(line);
				writer.newLine();
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		writer.close();

		System.out.println("Done");

	}

	public static void populateProperties() {

		Properties connProp = new Properties();
		InputStream input = null;
		try {
			String usrDir = System.getProperty("user.dir");
			input = new FileInputStream(usrDir + File.separator +
			// "src"+ File.separator + "ldap" + File.separator+
					"ldapconn.properties");

			connProp.load(input);

			ldapHost = connProp.getProperty(LDAP_SERVER_HOST);
			ldapPort = Integer.valueOf(connProp.getProperty(LDAP_SERVER_PORT));
			ldapUserBase = connProp.getProperty(LDAP_USER);
			ldapUserPswd = connProp.getProperty(LDAP_PASSWORD);

		} catch (IOException ex) {
			ex.printStackTrace();
		} finally {
			if (input != null) {
				try {
					input.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

	}
}
