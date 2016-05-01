package concurrent.intro.servlet;

import java.io.IOException;
import java.math.BigInteger;
import java.util.Set;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import net.jcip.annotations.ThreadSafe;

/**
 * example of stateless Servlet --> Thread safe
 * http://jcip.net/listings.html
 * @author luca
 *
 */

@ThreadSafe
public class StatelessFActorizer1 implements Servlet{

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ServletConfig getServletConfig() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getServletInfo() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void init(ServletConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void service(ServletRequest req, ServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

	  BigInteger i = extractFromRequest(req);
      BigInteger[] factors = factor(i);
      encodeIntoResponse(resp, factors);
  }

  void encodeIntoResponse(ServletResponse resp, BigInteger[] factors) {
  }

  BigInteger extractFromRequest(ServletRequest req) {
      return new BigInteger("7");
  }

  BigInteger[] factor(BigInteger i) {
      // Doesn't really factor
      return new BigInteger[] { i };
  }


}
