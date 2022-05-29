package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import common.JpaUtils;
import model.Video;

public class VideoDAO extends AbstractEntityDAO<Video>{
	public VideoDAO()
	{
		super(Video.class);
	}
	
	public List<Video> findVideoByKeyword(String keyword)
	{
		EntityManager em =JpaUtils.getEntityManager();
		
		String jpql = "from Video v where v.title like :keyword";
		
		TypedQuery<Video> query = em.createQuery(jpql, Video.class);
		
		query.setParameter("keyword", "%" + keyword + "%");
		try {
			return query.getResultList();
		}
		catch(Exception e)
		{
			return null;
		}
	}
	
	public List<Video> findVideoByCategory(String category)
	{
		EntityManager em =JpaUtils.getEntityManager();
		
		String jpql = "from Video v where v.category = :category";
		
		TypedQuery<Video> query = em.createQuery(jpql, Video.class);
		query.setParameter("category", category);
		
		try {
			System.out.println("Query: " + query.getResultList());
			return query.getResultList();
		}
		catch(Exception e)
		{
			return null;
		}
	}
	
}
