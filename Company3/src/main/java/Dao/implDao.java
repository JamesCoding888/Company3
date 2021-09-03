package Dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public interface implDao {
	//新增連線方法 產生 entityManager 物件
	static EntityManager getDb() {
		EntityManagerFactory EMF = Persistence.createEntityManagerFactory("company");
		EntityManager EM = EMF.createEntityManager();
		return EM;
	}
	//新增物件
	
	//查詢物件
	
	//修改物件
	
	//刪除物件
}
