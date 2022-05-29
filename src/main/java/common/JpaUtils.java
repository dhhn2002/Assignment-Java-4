package common;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

public class JpaUtils {
	public static EntityManager getEntityManager()
	{
		return Persistence.createEntityManagerFactory("ASM_Java4").createEntityManager();
	}
}
