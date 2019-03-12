package org.seckill.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.seckill.bean.Manager;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

import java.util.List;


@RunWith(SpringJUnit4ClassRunner.class)
//告诉junit spring配置文件
@ContextConfiguration({"classpath:spring/spring-dao.xml"})
public class ManagerDaoTest {

    @Resource
    private ManagerDao managerDao;

    @Test
    public void queryById() {
        long id=10000;
        Manager manager=managerDao.queryById(id);
        System.out.println(manager.getName()+""+manager.getPwd());
    }

    @Test
    public void queryAll() {
        List<Manager> managers=managerDao.queryAll(0,2);
        for(Manager manager:managers){
            System.out.println(manager);
        }
    }

    @Test
    public void queryByname() {
        String name1="zhangsan";
        String name2="zhangsi";
        Manager manager1=managerDao.queryByname(name1);
        Manager manager2=managerDao.queryByname(name2);
        System.out.println(manager1);
        System.out.println(manager2);
    }
}