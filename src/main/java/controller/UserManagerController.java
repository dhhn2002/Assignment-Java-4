package controller;

import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.Validation;
import javax.validation.Validator;

import org.apache.commons.beanutils.BeanUtils;

import common.PageInfo;
import common.PageType;
import common.UploadUtils;
import dao.UserDAO;
import dao.VideoDAO;
import model.User;
import model.Video;

@WebServlet({"/userManagement", "/userManagement/create", 
	"/userManagement/update", "/userManagement/edit", 
	"/userManagement/delete", "/userManagement/reset",})
public class UserManagerController extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = request.getRequestURL().toString();
		
		if(url.contains("edit"))
		{
			edit(request, response);
			return;
		}
		
		if(url.contains("delete"))
		{
			delete(request, response);
			return;
		}
		
		if(url.contains("reset"))
		{
			reset(request, response);
			return;
		}
		
		User user = new User();
		
		findAll(request, response);
		request.setAttribute("user", user);
		
		PageInfo.prepareAndForwardAdmin(request, response, PageType.USER_MANAGER_PAGE);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = request.getRequestURL().toString();

		if(url.contains("create"))
		{
			create(request, response);
			return;
		}
		
		if(url.contains("update"))
		{
			update(request, response);
			return;
		}
		
		if(url.contains("delete"))
		{
			delete(request, response);
			return;
		}
		
		if(url.contains("reset"))
		{
			reset(request, response);
			return;
		}
	}

	private void create(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		StringBuilder sb = new StringBuilder();
		User user = new User();
		try 
		{
			BeanUtils.populate(user, request.getParameterMap());
			UserDAO userDao = new UserDAO();
			userDao.insert(user);
			
			request.setAttribute("user", user);
			
			request.setAttribute("message", "User is inserted");
			findAll(request, response);
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
			
			Validator validator = Validation.buildDefaultValidatorFactory().getValidator();
			
			Set<ConstraintViolation<User>> constraintViolations = validator.validate(user);
			if(!constraintViolations.isEmpty())
			{
				for(ConstraintViolation<User> constraintViolation : constraintViolations)
				{
					sb.append(constraintViolation.getMessage() + " ");
				}
			}
			
			request.setAttribute("user", user);
			
			request.setAttribute("error", sb.toString());
			findAll(request, response);
		}
		PageInfo.prepareAndForwardAdmin(request, response, PageType.USER_MANAGER_PAGE);
	}
	
	private void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		StringBuilder sb = new StringBuilder();
		User user = new User();
		try
		{
			BeanUtils.populate(user, request.getParameterMap());

			UserDAO userDao = new UserDAO();
			int userId = userDao.getIdByUsername(user.getUsername());
			user.setUserId(userId);
			
			userDao.update(user);
			
			request.setAttribute("user", user);
			request.setAttribute("message", "User is updated!!!");
			findAll(request, response);
		}
		catch(Exception e)
		{
			e.printStackTrace();
			
			Validator validator = Validation.buildDefaultValidatorFactory().getValidator();
			
			Set<ConstraintViolation<User>> constraintViolations = validator.validate(user);
			if(!constraintViolations.isEmpty())
			{
				for(ConstraintViolation<User> constraintViolation : constraintViolations)
				{
					sb.append(constraintViolation.getMessage());
				}
			}
			
			request.setAttribute("user", user);
			
			request.setAttribute("error", sb.toString());
			findAll(request, response);
		}
		PageInfo.prepareAndForwardAdmin(request, response, PageType.USER_MANAGER_PAGE);
	}

	private void findAll(HttpServletRequest request, HttpServletResponse response) {
		try
		{
			UserDAO userDao = new UserDAO();
			
			List<User> list = userDao.findAll();
			
			request.setAttribute("users", list);
		}
		catch(Exception e)
		{
			e.printStackTrace();
			
			request.setAttribute("error", "Error: " + e.getMessage());
		}
	}
	
	private void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userId = request.getParameter("userId");
		
		if(userId==null)
		{
			request.setAttribute("error", "User ID is required!!!");
			PageInfo.prepareAndForwardAdmin(request, response, PageType.USER_MANAGER_PAGE);
			return;
		}
		
		try
		{
			UserDAO userDao = new UserDAO();
			User user = userDao.findById(Integer.parseInt(userId));
			request.setAttribute("user", user);
			findAll(request, response);
		}
		catch(Exception e)
		{
			e.printStackTrace();
			
			request.setAttribute("error", "Error: " + e.getMessage());
		}
		PageInfo.prepareAndForwardAdmin(request, response, PageType.USER_MANAGER_PAGE);
	}

	private void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userId = request.getParameter("userId");
		
		if(userId==null)
		{
			request.setAttribute("error", "Username is required!!!");
			PageInfo.prepareAndForwardAdmin(request, response, PageType.USER_MANAGER_PAGE);
			return;
		}
		
		try
		{
			UserDAO userDao = new UserDAO();
			User user = userDao.findById(Integer.parseInt(userId));
			
			if(user == null)
			{
				request.setAttribute("error", "User is not found!!!");
				PageInfo.prepareAndForwardAdmin(request, response, PageType.USER_MANAGER_PAGE);
				return;
			}
			userDao.delete(Integer.parseInt(userId));
			
			request.setAttribute("message", "User is deleted!!!");
			request.setAttribute("user", user);
			
			findAll(request, response);
		}
		catch(Exception e)
		{
			e.printStackTrace();
			
			request.setAttribute("error", "Error: " + e.getMessage());
		}
		PageInfo.prepareAndForwardAdmin(request, response, PageType.USER_MANAGER_PAGE);
	}

	private void reset(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		User user = new User();
		request.setAttribute("user", user);
		findAll(request, response);
		PageInfo.prepareAndForwardAdmin(request, response, PageType.USER_MANAGER_PAGE);
	}
	
}
