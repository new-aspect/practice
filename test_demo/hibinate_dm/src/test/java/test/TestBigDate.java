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
		//(1)读取并解析hibernate.cfg.xml配置文件
		Configuration config = new Configuration().configure();
		//(2)由hibernate.cfg.xml中的<mapping resource="com/xx/User.hbm.xml"/>读取并解析映射信息*/
		//(3)创建会话SessionFactory对象
		sf = config.buildSessionFactory();
		//(4)加载Session对象
		session = sf.openSession();
	}
	//测试插入大字段表
	@Test
	public void testInsert() {
		try {
		String filePath = "D:\\DM8特点.jpg";
		File file = new File(filePath);
		String filePath2 = "D:\\达梦产品简介.txt";
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
	//测试查询大字段表
	@Test
	public void testSelect() {
		String hql = "from BigData";
		Query query = session.createQuery(hql);
		List<BigData> list = query.list();
		try {
			for(BigData big:list) {
				//打印出id
				System.out.println("id = "+big.getId());
				//将photo列信息 输出到指定路径
				FileOutputStream fos = new FileOutputStream("D:/"+big.getId()+"_DM8特点.jpg");
				fos.write(big.getPhoto());
				//将describe列信息 输出到指定路径
				FileOutputStream fos2 = new FileOutputStream("D:/"+big.getId()+"_Blob_DM8特点.jpg");
				fos2.write(big.getDescribe());
				//将photo列信息 输出到控制台
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
	        //关闭session对象
		    session.close();
		    // 关闭sessionFactory对象
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
