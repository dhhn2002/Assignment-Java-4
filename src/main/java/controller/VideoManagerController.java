package controller;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;

import org.apache.commons.beanutils.BeanUtils;

import common.PageInfo;
import common.PageType;
import common.UploadUtils;
import dao.VideoCategoryDAO;
import dao.VideoDAO;
import model.User;
import model.Video;
import model.VideoCategory;

@WebServlet({"/videoManagement", "/videoManagement/create", 
	"/videoManagement/update", "/videoManagement/edit", 
	"/videoManagement/delete", "/videoManagement/reset",})
@MultipartConfig
public class VideoManagerController extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("isUpdateBtn", false);
		request.setAttribute("isCreateBtn", true);
		
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
		
		Video video = new Video();
		video.setPoster("images/cartoons/your-name.jpg");
		
		VideoCategoryDAO videoCategoryDao = new VideoCategoryDAO();
		List<VideoCategory> cats = videoCategoryDao.findAll();
		request.setAttribute("cats", cats);
		
		findAll(request, response);
		request.setAttribute("video", video);
		
		PageInfo.prepareAndForwardAdmin(request, response, PageType.VIDEO_MANAGER_PAGE);
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
		request.setAttribute("isUpdateBtn", false);
		request.setAttribute("isCreateBtn", true);
		
		StringBuilder sb = new StringBuilder();
		Video video = new Video();
		
		try 
		{
			BeanUtils.populate(video, request.getParameterMap());
			video.setPoster("uploads/" + UploadUtils.processUploadField("cover", request, 
					"/uploads", video.getVideoId()));
			System.out.println("Video category: " + video.getCategory());
			VideoDAO videoDao = new VideoDAO();
			videoDao.insert(video);
			
			request.setAttribute("video", video);
			
			request.setAttribute("message", "Video is inserted");
			findAll(request, response);
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
			
			Validator validator = Validation.buildDefaultValidatorFactory().getValidator();
			
			Set<ConstraintViolation<Video>> constraintViolations = validator.validate(video);
			if(!constraintViolations.isEmpty())
			{
				for(ConstraintViolation<Video> constraintViolation : constraintViolations)
				{
					sb.append(constraintViolation.getMessage() + " ");
				}
			}
			
			request.setAttribute("video", video);
			
			request.setAttribute("error", sb.toString());
			findAll(request, response);
		}
		PageInfo.prepareAndForwardAdmin(request, response, PageType.VIDEO_MANAGER_PAGE);
	}
	
	private void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("isUpdateBtn", true);
		request.setAttribute("isCreateBtn", false);
		
		Video video = new Video();
		String videoId = video.getVideoId();
		try
		{
			BeanUtils.populate(video, request.getParameterMap());
			
			VideoDAO dao = new VideoDAO();
			
			Video oldVideo = dao.findById(video.getVideoId());
			
			if(request.getPart("cover").getSize()==0)
			{
				video.setPoster(oldVideo.getPoster());
			}
			else
			{
				video.setPoster("uploads/" + 
						UploadUtils.processUploadField("cover", request, "/uploads", videoId));
			}
			dao.update(video);
			
			request.setAttribute("video", video);
			request.setAttribute("message", "Video is updated!!!");
			findAll(request, response);
		}
		catch(Exception e)
		{
			e.printStackTrace();
			
			request.setAttribute("error", "Error: " + e.getMessage());
			findAll(request, response);
		}
		PageInfo.prepareAndForwardAdmin(request, response, PageType.VIDEO_MANAGER_PAGE);
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

	private void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("isUpdateBtn", true);
		request.setAttribute("isCreateBtn", false);
		
		String id = request.getParameter("videoId");
		
		if(id==null)
		{
			request.setAttribute("error", "Video id is required!!!");
			PageInfo.prepareAndForwardAdmin(request, response, PageType.VIDEO_MANAGER_PAGE);
			return;
		}
		
		try
		{
			VideoDAO videoDao = new VideoDAO();
			Video video = videoDao.findById(id);
			request.setAttribute("video", video);
			findAll(request, response);
		}
		catch(Exception e)
		{
			e.printStackTrace();
			
			request.setAttribute("error", "Error: " + e.getMessage());
			findAll(request, response);
		}
		PageInfo.prepareAndForwardAdmin(request, response, PageType.VIDEO_MANAGER_PAGE);
	}
	
	private void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("videoId");
		
		if(id==null)
		{
			request.setAttribute("error", "Video id is required!!!");
			PageInfo.prepareAndForwardAdmin(request, response, PageType.VIDEO_MANAGER_PAGE);
			return;
		}
		
		try
		{
			VideoDAO videoDao = new VideoDAO();
			Video video = videoDao.findById(id);
			
			if(video == null)
			{
				request.setAttribute("error", "Video id is not found!!!");
				PageInfo.prepareAndForwardAdmin(request, response, PageType.VIDEO_MANAGER_PAGE);
				return;
			}
			videoDao.delete(id);
			
			request.setAttribute("message", "Video is deleted!!!");
			request.setAttribute("video", video);
			
			findAll(request, response);
		}
		catch(Exception e)
		{
			e.printStackTrace();
			
			request.setAttribute("error", "Error: " + e.getMessage());
		}
		PageInfo.prepareAndForwardAdmin(request, response, PageType.VIDEO_MANAGER_PAGE);
	}

	private void reset(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("isUpdateBtn", false);
		request.setAttribute("isCreateBtn", true);
		
		Video video = new Video();
		video.setPoster("images/cartoons/coco.jpn");
		request.setAttribute("video", video);
		findAll(request, response);
		PageInfo.prepareAndForwardAdmin(request, response, PageType.VIDEO_MANAGER_PAGE);
	}
	
}
