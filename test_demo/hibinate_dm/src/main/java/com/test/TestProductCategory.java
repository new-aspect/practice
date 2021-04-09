package com.test;

import com.pojo.ProductCategory;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class TestProductCategory {
	SessionFactory sf = null;
	Session session = null;
	@Before
	public void before() {
		//(1)��ȡ������hibernate.cfg.xml�����ļ�
		Configuration config = new Configuration().configure();
		//(2)��hibernate.cfg.xml�е�<mapping resource="com/xx/User.hbm.xml"/>��ȡ������ӳ����Ϣ*/
		//(3)�����ỰSessionFactory����
		sf = config.buildSessionFactory();
		//(4)����Session����
		session = sf.openSession();
	}
	//���Բ���
	@Test
	public void testInsert() {
		ProductCategory pCategory = new ProductCategory(null, "����");
		session.save(pCategory);
	}
	//�����޸�
	@Test
	public void testUpdate() {
		ProductCategory pCategory = null; 
		pCategory = (ProductCategory)session.get(ProductCategory.class,new Long(4));
		System.out.println(pCategory);
		pCategory.setName("Ӣ��");
		System.out.println(pCategory);
		session.update(pCategory);
	}
	//����ȫ��
	@Test
	public void testSelectAll() {
		String hql = "from ProductCategory";
		Query query = session.createQuery(hql);
	    List<ProductCategory> list = query.list();
	    for(ProductCategory pCategory:list) {
	    	System.out.println(pCategory);
	    }
	}
	//����ɾ��
    @Test
    public  void testDelete(){
    	ProductCategory pCategory = null; 
		pCategory = (ProductCategory)session.get(ProductCategory.class,new Long(5));
    	if(pCategory!=null) {
    		session.delete(pCategory);
    	}
    }
	@After
	public void after() {
	    if (session != null) { 
	    	session.flush();
	        session.clear();
	        //�ر�session����
		    session.close();
		    //�ر�sessionFactory����
	       sf.close();
	    }
	}
	public static void main(String[] args) {
		TestProductCategory test = new TestProductCategory();
		test.before();
		test.testInsert();
		test.testUpdate();
        test.testSelectAll();
        test.testDelete();
        test.after();
	}
}
