package caiweiwei;

import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.PropertyConfigurator;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.caiwei.dao.StaffDao;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:spring-mybatis.xml")//spring容器初始化
public class LoginTest {
    @Autowired
    StaffDao loginrMapper;
    
    @Test
    public void loginTest() {       
        PropertyConfigurator.configure(Test.class.getClassLoader().getResource("log4j.properties"));
        Map<String, String> map = new HashMap<String,String>();
        map.put("staffId", "B00000001");
        map.put("password", "1518290");
        
        System.out.println("是个什么玩意：  "+ loginrMapper.queryStaff(map));

   }
}