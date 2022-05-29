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

@WebServlet("/FindVideo")
public class FindVideoByKeywordController extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		VideoCategoryDAO videoCategoryDao = new VideoCategoryDAO();
		List<VideoCategory> cats = videoCategoryDao.findAll();
		request.setAttribute("cats", cats);
		
		String keyword = request.getParameter("find-input");
		
		VideoDAO videoDao = new VideoDAO();
		List<Video> videos = videoDao.findVideoByKeyword(keyword);
		
		request.setAttribute("keyword", keyword);

		request.setAttribute("videos", videos);	
		
		PageInfo.prepareAndForward(request, response, PageType.FOUND_VIDEO_PAGE);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
