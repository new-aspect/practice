import com.nzhao.dao.BookMapping;
import com.nzhao.pojo.Books;
import com.nzhao.service.BookService;
import com.nzhao.service.impl.BookServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class MYTest {

    @Autowired
    BookMapping bookMapping;

    @Autowired
    BookService bookService;

    @Test
    public void test(){
//        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
//        BookService bookService = (BookService)context.getBean("bookService");
        List<Books> books = bookService.queryAllBook();
        System.out.println(books.toString());
    }

    @Test
    public void test2(){
//        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
//        BookMapping bookMapping = applicationContext.getBean(BookMapping.class);
        List<Books> books = bookMapping.queryAllBook();
        System.out.println(books);
    }

    @Test
    public void test3(){
        List<Books> queryBookByNameList = bookMapping.queryBookByName("Java");
        System.out.println(queryBookByNameList);
    }
}
