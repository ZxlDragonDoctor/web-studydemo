import com.zxl.webspring.webspring.eneity.Passenger;
import org.junit.jupiter.api.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class XmlClasspathTest {
    @Test
    public void Test01(){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        Passenger passenger = (Passenger) context.getBean("passenger");
        System.out.println(passenger.getName());
    }
}