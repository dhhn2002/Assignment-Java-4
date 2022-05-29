package controller;

import java.io.IOException;
import java.lang.reflect.Field;
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

@WebServlet({"/videoCategoryManagement", "/videoCategoryManagement/create", 
	"/videoCategoryManagement/update", "/videoCategoryManagement/edit", 
	"/videoCategoryManagement/delete", "/videoCategoryManagement/reset",})
@MultipartConfig
public class VideoCategoryManagerController extends HttpServlet {
	
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
		
		VideoCategory videoCategory = new VideoCategory();
		
		findAll(request, response);
		request.setAttribute("videoCategory", videoCategory);
		
		PageInfo.prepareAndForwardAdmin(request, response, PageType.VIDEO_CATEGORY_MANAGER_PAGE);
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
		
		VideoCategory videoCategory = new VideoCategory();
		
		try 
		{
			BeanUtils.populate(videoCategory, request.getParameterMap());
			
			VideoCategoryDAO videoCategoryDao = new VideoCategoryDAO();
			videoCategoryDao.insert(videoCategory);
			
			request.setAttribute("videoCategory", videoCategory);
			
			request.setAttribute("message", "Video category is inserted");
			findAll(request, response);
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
			
			Validator validator = Validation.buildDefaultValidatorFactory().getValidator();
			
			Set<ConstraintViolation<VideoCategory>> constraintViolations = validator.validate(videoCategory);
			if(!constraintViolations.isEmpty())
			{
				for(ConstraintViolation<VideoCategory> constraintViolation : constraintViolations)
				{
					sb.append(constraintViolation.getMessage());
				}
			}

			request.setAttribute("videoCategory", videoCategory);
			
			request.setAttribute("error", sb.toString());
			findAll(request, response);
		}
		PageInfo.prepareAndForwardAdmin(request, response, PageType.VIDEO_CATEGORY_MANAGER_PAGE);
	}
	
	private void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("isShowIdField", true);
		StringBuilder sb = new StringBuilder();
		VideoCategory videoCategory = new VideoCategory();
		try
		{
			BeanUtils.populate(videoCategory, request.getParameterMap());
			
			VideoCategoryDAO videoCategoryDao = new VideoCategoryDAO();
			videoCategoryDao.update(videoCategory);
			
			request.setAttribute("videoCategory", videoCategory);
			request.setAttribute("message", "Video category is updated!!!");
			findAll(request, response);
		}
		catch(Exception e)
		{
			e.printStackTrace();
			
			Validator validator = Validation.buildDefaultValidatorFactory().getValidator();
			
			Set<ConstraintViolation<VideoCategory>> constraintViolations = validator.validate(videoCategory);
			if(!constraintViolations.isEmpty())
			{
				for(ConstraintViolation<VideoCategory> constraintViolation : constraintViolations)
				{
					sb.append(constraintViolation.getMessage());
				}
			}

			request.setAttribute("videoCategory", videoCategory);
			
			request.setAttribute("error", sb.toString());
			findAll(request, response);
		}
		PageInfo.prepareAndForwardAdmin(request, response, PageType.VIDEO_CATEGORY_MANAGER_PAGE);
	}
	
	private void findAll(HttpServletRequest request, HttpServletResponse response) {
		try
		{
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
		String id = request.getParameter("categoryId");
		request.setAttribute("isShowIdField", true);
		if(id==null)
		{
			request.setAttribute("error", "Video category id is required!!!");
			PageInfo.prepareAndForwardAdmin(request, response, PageType.VIDEO_CATEGORY_MANAGER_PAGE);
			return;
		}
		
		try
		{
			VideoCategoryDAO videoCategoryDao = new VideoCategoryDAO();
			VideoCategory videoCategory = videoCategoryDao.findById(Integer.parseInt(id));
			request.setAttribute("videoCategory", videoCategory);
			findAll(request, response);
		}
		catch(Exception e)
		{
			e.printStackTrace();
			
			request.setAttribute("error", "Error: " + e.getMessage());
		}
		PageInfo.prepareAndForwardAdmin(request, response, PageType.VIDEO_CATEGORY_MANAGER_PAGE);
	}
	
	private void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("categoryId");
		
		if(id==null)
		{
			request.setAttribute("error", "Video category id is required!!!");
			PageInfo.prepareAndForwardAdmin(request, response, PageType.VIDEO_CATEGORY_MANAGER_PAGE);
			return;
		}
		
		try
		{
			VideoCategoryDAO videoCategoryDao = new VideoCategoryDAO();
			VideoCategory videoCategory = videoCategoryDao.findById(Integer.parseInt(id));
			
			if(videoCategory == null)
			{
				request.setAttribute("error", "Video category id is not found!!!");
				PageInfo.prepareAndForwardAdmin(request, response, PageType.VIDEO_CATEGORY_MANAGER_PAGE);
				return;
			}
			videoCategoryDao.delete(Integer.parseInt(id));
			
			request.setAttribute("message", "Video category is deleted!!!");
			request.setAttribute("videoCategory", videoCategory);
			
			findAll(request, response);
		}
		catch(Exception e)
		{
			e.printStackTrace();
			
			request.setAttribute("error", "Error: " + e.getMessage());
		}
		PageInfo.prepareAndForwardAdmin(request, response, PageType.VIDEO_CATEGORY_MANAGER_PAGE);
	}

	private void reset(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		VideoCategory videoCategory = new VideoCategory();
		request.setAttribute("videoCategory", videoCategory);
		findAll(request, response);
		PageInfo.prepareAndForwardAdmin(request, response, PageType.VIDEO_CATEGORY_MANAGER_PAGE);
	}
	
}
