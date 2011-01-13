package org.easymock.sample;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import junit.framework.TestCase;

import org.easymock.EasyMock;

public class ServletTest extends TestCase {

	public void testServlet() throws IOException {
		HttpServletRequest request = EasyMock.createMock(HttpServletRequest.class);
		HttpServletResponse response = EasyMock.createMock(HttpServletResponse.class);
		
		EasyMock.expect(request.getParameter("name")).andReturn("OK").anyTimes();
		
		EasyMock.replay(request);
		EasyMock.replay(response);
		HelloWorld hello = new HelloWorld();
		
		hello.doGet(request, response);

		EasyMock.verify(request);
		EasyMock.verify(response);
		assertEquals("Server: OK", hello.getName());
	}
}
