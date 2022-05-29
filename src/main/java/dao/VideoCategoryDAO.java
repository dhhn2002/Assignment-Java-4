package dao;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import common.JpaUtils;
import model.User;
import model.VideoCategory;

public class VideoCategoryDAO extends AbstractEntityDAO<VideoCategory>{
	public VideoCategoryDAO()
	{
		super(VideoCategory.class);
	}
	

	public int getIdByCategoryName(String categoryName)
	{
		EntityManager em =JpaUtils.getEntityManager();
		
		String jpql = "select vc from VideoCategory vc where vc.categoryName = :categoryName";
		
		TypedQuery<VideoCategory> query = em.createQuery(jpql, VideoCategory.class);
		
		query.setParameter("categoryName", categoryName);
		try {
			return query.getSingleResult().getCategoryId();
		}
		catch(Exception e)
		{
			return 0;
		}
	}
}
