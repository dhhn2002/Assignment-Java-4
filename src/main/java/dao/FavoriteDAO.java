package dao;

import model.Favorite;

public class FavoriteDAO extends AbstractEntityDAO<Favorite>{
	public FavoriteDAO()
	{
		super(Favorite.class);
	}
}
