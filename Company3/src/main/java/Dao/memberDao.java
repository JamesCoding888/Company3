package Dao;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import Model.member;
public class memberDao implements implDao{

	public static void main(String[] args) {
		// 將 Persistence.xml 中的 company 打包成 EntityManagerFactory 
		EntityManagerFactory em = Persistence.createEntityManagerFactory("company");
		// 確認  EntityManagerFactory 是否 Object 有成功建立
		System.out.println(em);
		// 確認是否 Entity manager 物件在資料庫 member 的第53行有資料
		EntityManager E = em.createEntityManager();
		System.out.println(E);
		System.out.println(E.find(member.class, 53));
		// 新增
		/*
		member m1 = new member("teacher","aaa","1234","taipei","111","33");
		EntityTransaction etAdd = E.getTransaction();
		etAdd.begin();
		E.persist(m1);
		etAdd.commit();
		*/

		// 修改
		/*
		member m1 = E.find(member.class, 55);
		m1.setPassword("3333333");
		m1.setAddress("BAB");
		EntityTransaction etUpdate = E.getTransaction();
		etUpdate.begin();
		E.merge(m1);
		etUpdate.commit();
		*/
		// 查詢
		/*
		member query = E.find(member.class, 55);
		System.out.println(query.getId()+"\t"+query.getName());
		*/
		// 刪除
//		/*
		EntityTransaction etDelete = E.getTransaction();
		member m1 = E.find(member.class, 55);
		etDelete.begin();
		E.remove(m1);
		etDelete.commit();
//		*/	
		
		
		// 測試新增 add(Object o) 
		/*
		member m1 = new member("teacher","aaa","1234","taipei","111","33");
		new memberDao().add(m1);
		*/
		
		// 測試查詢 queryId(Integer id)
		/*
		System.out.println(new memberDao().queryId(56));
		*/
		// 測試修改 update(Object o)
		/*
		member m2 = (member)new memberDao().queryId(56);
		m2.setAddress("Taipei101");
		new memberDao().update(m2);
		*/
		// 測試刪除 delete(Object o)
		/*		
		new memberDao().delete(51);
		*/
		// JPQL 語法 - List queryAll()
		System.out.println(new memberDao().queryAll());
		// 查詢是否帳號密碼有在 member 資料庫中
		System.out.println(memberDao.queryUser("ff", "123"));
		// 查詢是否帳號有在 member 資料庫中
		System.out.println(memberDao.queryUser("ff2"));
		
	}
	
	public static member queryUser(String username, String password) {
		member m1 = null;
		String JPQL = "select m from member m where m.username=?1 and m.password=?2";
		EntityManager em = implDao.getDb();
		Query q = em.createQuery(JPQL);
		q.setParameter(1, username);
		q.setParameter(2, password);
		List l = q.getResultList();
		if(l.size()!=0) {
			member[] m2 = (member[])l.toArray(new member[l.size()]);
			m1=m2[0];
		}
		return m1;
	}
	// 帳號重複
	public static member queryUser(String username) {
		member m1 = null;
		String JPQL = "select m from member m where m.username=?1";
		EntityManager em = implDao.getDb();
		Query q = em.createQuery(JPQL);
		q.setParameter(1, username);
		List l = q.getResultList();
		if(l.size()!=0) {
			member[] m2 = (member[])l.toArray(new member[l.size()]);
			m1=m2[0];
		}
		return m1;
	}
	
	
	@Override
	public void add(Object o) {
		EntityManager em = implDao.getDb();
		EntityTransaction et = em.getTransaction();
		et.begin();
		em.persist(o);
		et.commit();
	}

	@Override
	public Object queryId(Integer id) {
		EntityManager em = implDao.getDb();
		member m = em.find(member.class, id);
		return m;
	}

	@Override
	public List queryAll() {
		String JPQL = "select p from member p";
		EntityManager em = implDao.getDb();
		Query q = em.createQuery(JPQL);
		List l = q.getResultList();
		return l;
	}
		

	@Override
	public void update(Object o) {
		EntityManager em = implDao.getDb();
		EntityTransaction et = em.getTransaction();
		et.begin();
		em.merge(o);
		et.commit();		
	}
	@Override
	public void delete(Integer id) {
		EntityManager em = implDao.getDb();
		member m = em.find(member.class, id);
		EntityTransaction et = em.getTransaction();
		et.begin();
		em.remove(m);
		et.commit();		
	}
}
