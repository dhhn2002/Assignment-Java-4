package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.PageInfo;
import common.PageType;
import dao.VideoCategoryDAO;
import dao.VideoDAO;
import model.Video;
import model.VideoCategory;

@WebServlet("/Category")
public class CategoryController extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		VideoCategoryDAO videoCategoryDao = new VideoCategoryDAO();
		List<VideoCategory> cats = videoCategoryDao.findAll();
		request.setAttribute("cats", cats);
		
		try {
			VideoDAO videoDao = new VideoDAO();
			
			List<Video> list = videoDao.findAll();
			
			request.setAttribute("videos", list);
		} catch (Exception e) {
			e.printStackTrace();
			
			request.setAttribute("error", "Error: " + e.getMessage());
		}
		
		PageInfo.prepareAndForward(request, response, PageType.CATEGORY_PAGE);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
