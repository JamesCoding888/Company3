package Dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import Model.member;
public class memberDao implements implDao{

	public static void main(String[] args) {
		// 驗證 Hibernate 藉由 Persistence.xml 配置 Mysql 連線
		EntityManagerFactory em = Persistence.createEntityManagerFactory("company");
		// 印出記憶體位置
		System.out.println(em);
		EntityManager E = em.createEntityManager();
		// 印出 Entity manager 物件
		System.out.println(E);
		System.out.println(E.find(member.class,53));
		//查詢
		/*
		member m = E.find(member.class, 52);
		System.out.println(m.getId()+"\t"+m.getName());
		*/
		//修改
		/*
		m.setPassword("3333");
		m.setAddress("BAB");
		EntityTransaction et = E.getTransaction();
		et.begin();
		E.merge(m);
		et.commit();
		*/
		//刪除
		EntityTransaction et = E.getTransaction();
		member m = E.find(member.class, 52);
		et.begin();
		E.remove(m);
		et.commit();
		//新增
		/*
		member m = new member("teacher","aaa","1234","taipei","111","33");
		EntityTransaction et = E.getTransaction();
		et.begin();
		E.persist(m);
		et.commit();
		*/
	}


	
}
