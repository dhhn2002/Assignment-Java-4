package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import common.AES;
import common.PageInfo;
import dao.UserDAO;
import model.User;

@WebServlet("/Register")
public class RegisterController extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/sites/user/register.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		User user = new User();
		user.setAdmin(false);
		try 
		{
			BeanUtils.populate(user, request.getParameterMap());
//			
//			String pass = request.getParameter("password");
//			String hashPass = AES.encrypt(pass);
//			user.setPassword(hashPass);
			
			UserDAO userDao = new UserDAO();
			userDao.insert(user);
			request.setAttribute("message", "Dang ky thanh cong!!!");
			request.getRequestDispatcher("/Login").forward(request, response);
			return;
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
			request.setAttribute("error", "Register error: " +e.getMessage());
		}
		request.setAttribute("user", user);
		request.getRequestDispatcher("/sites/user/register.jsp").forward(request, response);
	}

}
