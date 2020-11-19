import com.nzhao.dao.BookMapping;
import com.nzhao.pojo.Books;
import com.nzhao.service.BookService;
import com.nzhao.service.impl.BookServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;


public class MYTest {

    @Test
    public void test(){
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        BookService bookService = (BookService)context.getBean("bookService");
        List<Books> books = bookService.queryAllBook();
        System.out.println(books.toString());
    }

    @Test
    public void test2(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        BookMapping bookMapping = applicationContext.getBean(BookMapping.class);
        List<Books> books = bookMapping.queryAllBook();
        System.out.println(books);
    }
}
