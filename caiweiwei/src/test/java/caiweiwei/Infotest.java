package caiweiwei;

import org.apache.log4j.PropertyConfigurator;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.alibaba.fastjson.JSON;
import com.caiwei.dao.StaffDao;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:spring-mybatis.xml")//spring容器初始化
public class Infotest {
    @Autowired
    StaffDao loginMapper;
    
    @Test
    public void loginTest() {       
        PropertyConfigurator.configure(Test.class.getClassLoader().getResource("log4j.properties"));
        String staffId="B00000001";        
        System.out.println(JSON.toJSONString(loginMapper.queryStaffInfo(staffId)));

   }
}
