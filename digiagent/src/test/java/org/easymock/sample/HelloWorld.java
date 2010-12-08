package org.easymock.sample;

import java.io.IOException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HelloWorld extends HttpServlet {
	private static final long serialVersionUID = -609190001215724357L;
	private String name;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws IOException {
		name = "Server: " + request.getParameter("name");
		System.out.println(name);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
