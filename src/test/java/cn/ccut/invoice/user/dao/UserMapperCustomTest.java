package cn.ccut.invoice.user.dao;

import cn.ccut.invoice.user.model.User;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UserMapperCustomTest {

    @Test
    public void findByEmail() {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring/applicationContext-dao.xml");

        UserMapperCustom userMapperCustom = (UserMapperCustom) context.getBean("userMapperCustom");

        User user = userMapperCustom.findByEmail("1922823903@qq.com");

        System.out.println(user.getName()+user.getEmail());
    }
}