package dao;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import common.JpaUtils;
import model.User;

public class UserDAO extends AbstractEntityDAO<User>{
	public UserDAO()
	{
		super(User.class);
	}
	
	public User isAdmin(String username)
	{
		EntityManager em =JpaUtils.getEntityManager();
		
		String jpql = "select u from User u where u.username = :username and u.admin = 1";
		
		TypedQuery<User> query = em.createQuery(jpql, User.class);
		
		query.setParameter("username", username);
		try {
			return query.getSingleResult();
		}
		catch(Exception e)
		{
			return null;
		}
	}
	
	public int getIdByUsername(String username)
	{
		EntityManager em =JpaUtils.getEntityManager();
		
		String jpql = "select u from User u where u.username = :username";
		
		TypedQuery<User> query = em.createQuery(jpql, User.class);
		
		query.setParameter("username", username);
		try {
			return query.getSingleResult().getUserId();
		}
		catch(Exception e)
		{
			return 0;
		}
	}
}
