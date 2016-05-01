import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import util.IpAddUtil;


public class IpAddUtilTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public final void testIsValidIp() {
		String validIpAdd = "10.0.0.1";
		String invalidIpAss = "10.0.0.1.1";
		assertTrue(IpAddUtil.isValidIp("178.12.2.1"));
		assertTrue(IpAddUtil.isValidIp(validIpAdd));
		
		assertFalse(IpAddUtil.isValidIp(invalidIpAss));
		invalidIpAss = "300.1.1.1";
		assertFalse(IpAddUtil.isValidIp(invalidIpAss));
		
		//logical address
		assertFalse(IpAddUtil.isValidIp("pippo"));
		assertTrue(IpAddUtil.isValidIp("localhost"));
	}

}
