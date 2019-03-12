package org.seckill.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.seckill.bean.Manager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring-dao.xml",
        "classpath:spring/spring-service.xml"})
public class ManagerServiceTest {

    @Autowired
    private ManagerService managerService;

    @Test
    public void login() {
        String name="zhangsan";
        String pwd="123456";
        Manager manager=managerService.login(name,pwd);
        System.out.println(manager);
    }

}