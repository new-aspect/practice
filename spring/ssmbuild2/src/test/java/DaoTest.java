import com.nzhao.dao.BookMapping;
import com.nzhao.pojo.Books;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(value = "classpath:applicationContext.xml")
public class DaoTest {

    @Autowired
    BookMapping bookMapping;

    @Test
    public void test(){
//        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
//        BookMapping bookMapping = applicationContext.getBean(BookMapping.class);
        List<Books> books = bookMapping.queryAll();
        System.out.println(books);
    }
}
