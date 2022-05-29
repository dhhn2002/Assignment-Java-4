package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.PageInfo;
import common.PageType;
import dao.VideoDAO;
import model.Video;

@WebServlet("/VideoDetail")
public class VideoDetailController extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String videoId = request.getParameter("id");
		VideoDAO videoDao = new VideoDAO();
		Video foundVideo = videoDao.findById(videoId);
		request.setAttribute("video", foundVideo);
		PageInfo.prepareAndForward(request, response, PageType.VIDEO_DETAIL_PAGE);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
