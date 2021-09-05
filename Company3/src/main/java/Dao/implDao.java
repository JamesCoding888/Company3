package Dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public interface implDao {
	//新增連線方法 產生 entityManager 物件
	//Java SE 1.8
//	/*  
	static EntityManager getDb() {
		EntityManagerFactory EMF = Persistence.createEntityManagerFactory("company");
		EntityManager EM = EMF.createEntityManager();
		return EM;
	}
//	*/
	//Java SE 1.7
	/*
	EntityManagerFactory EMF = Persistence.createEntityManagerFactory("company");
	*/

	//新增物件
	void add(Object o);
	//查詢物件
	Object queryId(Integer id); // 單筆
	List queryAll(); // 全部
	//修改物件
	void update(Object o);
	//刪除物件
	void delete(Integer id);
}
