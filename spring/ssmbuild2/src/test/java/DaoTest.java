import com.nzhao.dao.BookMapping;
import com.nzhao.pojo.Books;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class DaoTest {

    @Test
    public void test(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        BookMapping bookMapping = applicationContext.getBean(BookMapping.class);
        List<Books> books = bookMapping.queryAll();
        System.out.println(books);
    }
}
