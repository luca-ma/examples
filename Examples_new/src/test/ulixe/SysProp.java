package test.ulixe;
/**
 * test ulixe java 6
 * 
 * Spuntare il comando che esegue il codice in modo da ottenere in output “test”
A.	java prop = "scjp" SysProp --> print null
B.	java -Dprop=scjp SysProp   --> print scjp
C.	java -Dprop(scjp) SysProp --> print null
D.	nessuno dei precedenti

A system property can be set or overridden by specifying the -D option to the java command when running your program.
COPY
java -Dmy.prop="my value" MyApp



// Get the value of the system property
String prop = System.getProperty("my.prop");
// my value
 * 
 * In eclipse x impostare Systemproperties -->  run configuration -> arguments -> vm arguments
 *  In eclipse x impostare argomenti di programma (quelli che si leggono in args-->  run configuration -> arguments -> program arguments


 * @author luca
 *
 */
public class SysProp {
	public static void main(String[] args) {
		String sysProperty = System.getProperty("prop");
		System.out.println(sysProperty);
	}
}
