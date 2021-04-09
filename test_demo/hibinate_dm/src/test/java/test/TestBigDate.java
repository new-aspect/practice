package com.test;

import com.pojo.BigData;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.*;
import java.util.List;

public class TestBigDate {
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
	//���Բ�����ֶα�
	@Test
	public void testInsert() {
		try {
		String filePath = "D:\\DM8�ص�.jpg";
		File file = new File(filePath);
		String filePath2 = "D:\\���β�Ʒ���.txt";
		File file2 = new File(filePath2);
		InputStream in;
		in = new BufferedInputStream(new FileInputStream(file));
		byte[] bytes1 = new byte[102400];
		byte[] bytes2 = new byte[102400];
		in.read(bytes1);
		InputStream in2 = new BufferedInputStream(new FileInputStream(file));
		in2.read(bytes2);
		BufferedReader reader = new BufferedReader(new InputStreamReader
				(new FileInputStream(file2),"UTF-8"));
		StringBuffer stringBuffer = new StringBuffer("");
		String str = null;
		while((str = reader.readLine())!=null) {
			stringBuffer.append(str);
			stringBuffer.append("\n");
		}
		BigData bigData = new BigData(null,bytes1,bytes2,stringBuffer.toString());
		session.save(bigData);
		in.close();
		in2.close();
		reader.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e){
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	//���Բ�ѯ���ֶα�
	@Test
	public void testSelect() {
		String hql = "from BigData";
		Query query = session.createQuery(hql);
		List<BigData> list = query.list();
		try {
			for(BigData big:list) {
				//��ӡ��id
				System.out.println("id = "+big.getId());
				//��photo����Ϣ �����ָ��·��
				FileOutputStream fos = new FileOutputStream("D:/"+big.getId()+"_DM8�ص�.jpg");
				fos.write(big.getPhoto());
				//��describe����Ϣ �����ָ��·��
				FileOutputStream fos2 = new FileOutputStream("D:/"+big.getId()+"_Blob_DM8�ص�.jpg");
				fos2.write(big.getDescribe());
				//��photo����Ϣ ���������̨
				System.out.println("txt="+big.getTxt());
				fos.close();
				fos2.close();
		}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	@After
	public void after() {
	    if (session != null) { 
	    	session.flush();
	        session.clear();
	        //�ر�session����
		    session.close();
		    // �ر�sessionFactory����
		    sf.close();
	    }
	}
	public static void main(String[] args) {
		TestBigDate test = new TestBigDate();
		test.before();
		test.testInsert();
		test.testSelect();
		test.after();
	}
}
