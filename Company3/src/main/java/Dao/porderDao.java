package Dao;
import java.util.List; 
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import Model.porder;
public class porderDao implements implDao {
	public static void main(String[] args) {
		// 測試新增 add(Object o) 
		/*
		porder p = new porder("A", 2,3,4);
		new porderDao().add(p);
		*/
		// 測試修改 update(Object o)
		/*
		porder p = (porder)new porderDao().queryId(70);
		p.setDesk("C桌");
		new porderDao().update(p);	
		*/
		// 測試查詢 queryId(Integer id)
		/*
		System.out.println(new porderDao().queryId(74));
		*/
		// 測試刪除 delete(Object o)
		/*
		porder p = (porder)new porderDao().queryId(56);
		p.setDesk("B桌");
		new memberDao().update(p);
		*/
		// JPQL 語法 - List queryAll()
		/*
		System.out.println(new porderDao().queryAll());
		*/
		// JPQL 語法 - 範圍查詢	01	
		/*
		String JPQL = "select p from porder p where p.A=2";		 
		EntityManager em = implDao.getDb();
		Query q = em.createQuery(JPQL);
		List l = q.getResultList();
		System.out.println(l);
		*/
		// JPQL 語法 - 範圍查詢	02
		/*
		String JPQL = "select p from porder p where p.sum>=550 and p.sum<=1830";
		EntityManager em = implDao.getDb();
		Query q = em.createQuery(JPQL);
		List l = q.getResultList();
		System.out.println(l);
		*/
		// JPQL 語法 - 範圍查詢	03
		/*
		String JPQL2 = "select p from porder p where p.sum>=?1 and p.sum<=?2";
		EntityManager em2 = implDao.getDb();
		Query q2 = em.createQuery(JPQL2);
		q2.setParameter(1, 500);
		q2.setParameter(2, 1900);
		List l2 = q2.getResultList();
		System.out.println(l2.size());
		*/
		// 印出內容
		/*
		Object[] o = l.toArray();
		for(Object u:o) {
			porder p = (porder)u;
			System.out.println(p.getId()+"\t"+p.getDesk());
		}
		porder[] p = (porder[])l.toArray(new porder[l.size()]);
		for(porder i:p) {
			System.out.println(i.getId()+"\t"+i.getDesk());
		}
		*/
		// 測試 queryAllShow		
		// System.out.println(porderDao.queryAllShow());
		// 測試 querySum2
		System.out.println(porderDao.querySum2(1000, 1500));
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
		porder p = em.find(porder.class, id);
		return p;
	}
	
	@Override
	public List queryAll() {
		String JPQL = "select p from porder p";
		EntityManager em = implDao.getDb();
		Query q = em.createQuery(JPQL);
		List l = q.getResultList();
		return l;
	}	
	
	public static String queryAllShow() {
		String show = "";
		List l = new porderDao().queryAll();
		porder[] p = (porder[])l.toArray(new porder[l.size()]);
		for(int i=0 ; i < p.length ; i++) {
			show = show + "<tr><td>" + p[i].getId() +
							"<td>" + p[i].getDesk() +
							"<td>" + p[i].getA() +
							"<td>" + p[i].getB() +
							"<td>" + p[i].getC() +
							"<td>" + p[i].getSum() ;			
		}
		return show;
	}
	
	public static List querySum1(int start, int end) {
		String JPQL = "select p from porder p where p.sum>=?1 and p.sum<=?2";
		EntityManager em = implDao.getDb();
		Query q = em.createQuery(JPQL);
		q.setParameter(1, start);
		q.setParameter(2, end);
		List l = q.getResultList();
		return l;
	}
	public static String querySum2(int start, int end) {
		String show = "";
		List l = porderDao.querySum1(start, end);
		porder[] p = (porder[])l.toArray(new porder[l.size()]);
		for(int i=0 ; i < p.length ; i++) {
			show = show + "<tr><td>" + p[i].getId() +
							"<td>" + p[i].getDesk() +
							"<td>" + p[i].getA() +
							"<td>" + p[i].getB() +
							"<td>" + p[i].getC() +
							"<td>" + p[i].getSum() ;			
		}
		return show;
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
		EntityTransaction et = em.getTransaction();
		porder p = em.find(porder.class, id);
		et.begin();
		em.remove(p);
		et.commit();
	}

}
