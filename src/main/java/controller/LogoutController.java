package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.CookieUtils;
import common.SessionUtils;

@WebServlet("/Logout")
public class LogoutController extends HttpServlet {
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CookieUtils.add("username", null, 0, response);
		SessionUtils.invalidate(request);
		request.setAttribute("isLogin", false);
		request.getRequestDispatcher("/Home").forward(request, response);
	}

}
