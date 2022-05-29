package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import common.AES;
import common.CookieUtils;
import common.PageInfo;
import common.PageType;
import common.SessionUtils;
import dao.UserDAO;
import dao.VideoCategoryDAO;
import dao.VideoDAO;
import model.FormUser;
import model.User;
import model.Video;
import model.VideoCategory;

@WebServlet("/Login")
public class LoginController extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		String username = CookieUtils.get(request, "username");
		
		if(username==null)
		{
			request.getRequestDispatcher("/sites/user/login.jsp").forward(request, response);
			return;
		}
		SessionUtils.add(request, "username", username);
		PageInfo.prepareAndForward(request, response, PageType.HOME_PAGE);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			FormUser fUser = new FormUser();
			BeanUtils.populate(fUser, request.getParameterMap());
			
			UserDAO userDao = new UserDAO();
			int userId = userDao.getIdByUsername(fUser.getUsername());
			User user = userDao.findById(userId);
			
			request.setAttribute("currentUserName", user.getUsername());
			
			if(user!=null && user.getPassword().equals(fUser.getPassword()))
			{
				if(userDao.isAdmin(fUser.getUsername())!=null)
				{
					Video video = new Video();
					video.setPoster("images/cartoons/your-name.jpg");
					
					VideoCategoryDAO videoCategoryDao = new VideoCategoryDAO();
					List<VideoCategory> cats = videoCategoryDao.findAll();
					request.setAttribute("cats", cats);
					
					findAll(request, response);
					request.setAttribute("video", video);
					
					PageInfo.prepareAndForwardAdmin(request, response, PageType.VIDEO_MANAGER_PAGE);
					return;
				}
				else
				{
					SessionUtils.add(request, "username", user.getUsername());
					
					if(fUser.isRemember())
					{
						CookieUtils.add("username", fUser.getUsername(), 3, response);
					}
					else
					{
						CookieUtils.add("username", fUser.getUsername(), 0, response);
					}
					request.setAttribute("isLogin", true);
					request.setAttribute("name", user.getFullname());
					request.getRequestDispatcher("/Home").forward(request, response);
					return;
				}
			}
			else {
				request.setAttribute("error", "Tai khoan hoac mat khau khong chinh xac!!!");
			}
		} 
		catch (Exception e) 
		{
			request.setAttribute("error", e.getMessage());
		}
		request.getRequestDispatcher("/sites/user/login.jsp").forward(request, response);
	}
	
	private void findAll(HttpServletRequest request, HttpServletResponse response) {
		try
		{
			VideoDAO dao = new VideoDAO();
			
			List<Video> list = dao.findAll();
			
			request.setAttribute("videos", list);

			VideoCategoryDAO videoCategoryDao = new VideoCategoryDAO();
			List<VideoCategory> cats = videoCategoryDao.findAll();
			request.setAttribute("cats", cats);
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
			
			request.setAttribute("error", "Error: " + e.getMessage());
		}
		
	}

}
