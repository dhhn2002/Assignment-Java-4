package common;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.collections.map.HashedMap;

public class PageInfo {
	public static Map<PageType, PageInfo> pageRoute = new HashedMap();
	
	static {
		pageRoute.put(PageType.HOME_PAGE, new PageInfo("Flix Home", "/sites/home/home.jsp", "/script/homeScript.jsp", "/resource/homeResource.jsp"));
		pageRoute.put(PageType.LIST_PAGE, new PageInfo("All movies", "/sites/list/list.jsp", "/script/dropdownScript.jsp", "/resource/listResource.jsp"));
		pageRoute.put(PageType.CATEGORY_PAGE, new PageInfo("Category", "/sites/category/category.jsp", "/script/dropdownScript.jsp", "/resource/categoryResource.jsp"));
		pageRoute.put(PageType.FAVORITES_PAGE, new PageInfo("Favorites", "/sites/favorites/favorites.jsp", "/script/dropdownScript.jsp", "/resource/favoritesResource.jsp"));
		pageRoute.put(PageType.VIDEO_MANAGER_PAGE, new PageInfo("Video Manager", "/admin/video/video.jsp", "/script/videoManagementScript.jsp", null));
		pageRoute.put(PageType.VIDEO_CATEGORY_MANAGER_PAGE, new PageInfo("Video Category Manager", "/admin/videoCategory/videoCategory.jsp", null, null));
		pageRoute.put(PageType.USER_MANAGER_PAGE, new PageInfo("User Manager", "/admin/userManager/userManager.jsp", null, null));
		pageRoute.put(PageType.VIDEO_DETAIL_PAGE, new PageInfo("Video Detail", "/sites/videoDetail/videoDetail.jsp", null, "/resource/videoDetailResource.jsp"));
		pageRoute.put(PageType.FOUND_VIDEO_PAGE, new PageInfo("Found video", "/sites/foundVideoPage/foundVideoPage.jsp", "/script/dropdownScript.jsp", "/resource/foundVideoResource.jsp"));
		pageRoute.put(PageType.WATCH_VIDEO_PAGE, new PageInfo("Watch video", "/sites/watchVideo/watchVideo.jsp", null, "/resource/watchVideoResource.jsp"));
	}
	
	public static void prepareAndForwardAdmin(HttpServletRequest request, HttpServletResponse response, 
			PageType pageType) throws ServletException, IOException
	{
		PageInfo page = pageRoute.get(pageType);
		
		request.setAttribute("page", page);
		
		request.getRequestDispatcher("/admin/admin-layout.jsp").forward(request, response);
	}
	
	public static void prepareAndForward(HttpServletRequest request, HttpServletResponse response, 
			PageType pageType) throws ServletException, IOException
	{
		PageInfo page = pageRoute.get(pageType);
		
		request.setAttribute("page", page);
		
		request.getRequestDispatcher("/sites/user-layout.jsp").forward(request, response);
	}
	
	private String title;
	private String contentUrl; 
	private String scriptUrl;
	private String resource;
	
	public PageInfo(String title, String contentUrl, String scriptUrl, String resource) {
		super();
		this.title = title;
		this.contentUrl = contentUrl;
		this.scriptUrl = scriptUrl;
		this.resource = resource;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContentUrl() {
		return contentUrl;
	}
	public void setContentUrl(String contentUrl) {
		this.contentUrl = contentUrl;
	}
	public String getScriptUrl() {
		return scriptUrl;
	}
	public void setScriptUrl(String scriptUrl) {
		this.scriptUrl = scriptUrl;
	}
	public String getresource() {
		return resource;
	}
	public void setresource(String resource) {
		this.resource = resource;
	}
}
