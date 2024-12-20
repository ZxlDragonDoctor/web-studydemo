import com.zxl.webspring.webspring.eneity.Passenger;
import com.zxl.webspring.webspring.eneity.Robot;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import java.util.concurrent.ExecutorService;

public class FlightSystemTest {

    @Test
    public void testPassenger() {
        String xmlPath = "src/main/webapp/WEB-INF/applicationContext2.xml";
        ApplicationContext context = new FileSystemXmlApplicationContext(xmlPath);
        Passenger passenger = (Passenger) context.getBean("passenger");
        System.out.println(passenger.getCountry().getName());
        System.out.println(passenger.getCountry().getCodeName());
        System.out.println(passenger.getName());
    }

//   测试工厂注入的bean
    @Test
    public void testRobot() {
        String xmlPath = "src/main/webapp/WEB-INF/applicationContext2.xml";
        ApplicationContext context = new FileSystemXmlApplicationContext(xmlPath);
        Robot robot = context.getBean("robot",Robot.class);
        robot.say();
    }

    @Test
    public void testES() {
        String xmlPath = "src/main/webapp/WEB-INF/applicationContext2.xml";
        ApplicationContext context = new FileSystemXmlApplicationContext(xmlPath);
        ExecutorService es = (ExecutorService) context.getBean("executorService");
        System.out.println(es.getClass().getName());
    }
}