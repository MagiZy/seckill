package org.seckill.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.seckill.bean.Seckill;
import org.seckill.dto.Exposer;
import org.seckill.dto.SeckillExecution;
import org.seckill.exception.RepeatKillException;
import org.seckill.exception.SeckillCloseException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring-dao.xml",
                       "classpath:spring/spring-service.xml"})
public class SeckillServiceTest {
    private final Logger logger= LoggerFactory.getLogger(this.getClass());

    @Autowired
    private SeckillService seckillService;

    @Test
    public void getSeckillList() {
        List<Seckill> list=seckillService.getSeckillList();
        System.out.println(list);
    }

    @Test
    public void getById() {
        long id=1000;
        Seckill seckill=seckillService.getById(id);
        System.out.println(seckill);
    }

    @Test//完整逻辑代码测试，注意可重复执行
    public void testSeckillLogic() {
        long seckillId=1000;
        Exposer exposer=seckillService.exportSeckillUrl(seckillId);
        if (exposer.isExposed())
        {
            System.out.println(exposer);
            long userPhone=13476191876L;
            String md5=exposer.getMd5();
            try {
                SeckillExecution seckillExecution = seckillService.executeSeckillProcedure(seckillId, userPhone, md5);
                System.out.println(seckillExecution);
            }catch (RepeatKillException e)
            {
                e.printStackTrace();
            }catch (SeckillCloseException e1)
            {
                e1.printStackTrace();
            }
        }else {
            //秒杀未开启
            System.out.println(exposer);
        }
    }

    @Test
    public void executeSeckill() {
        long seckillId=1000;
        long userPhone=13476191876L;
        String md5="bf204e2683e7452aa7db1a50b5713bae";

        try {
            SeckillExecution seckillExecution = seckillService.executeSeckill(seckillId, userPhone, md5);

            System.out.println(seckillExecution);
        }catch (RepeatKillException e)
        {
            e.printStackTrace();
        }catch (SeckillCloseException e1)
        {
            e1.printStackTrace();
        }
    }

    @Test
    public void executeSeckillProcedure(){
        long seckillId=1001;
        long phone=12345678901L;
        Exposer exposer=seckillService.exportSeckillUrl(seckillId);
        if(exposer.isExposed()){
            String md5=exposer.getMd5();
            SeckillExecution execution=seckillService.executeSeckillProcedure(seckillId,phone,md5);
            System.out.println(execution.getStateInfo());
        }
    }

    @Test
    public void updateSeckill(){
        long id=1001;
        String name="100元秒杀笔记本电脑";
        int number=10;
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd");
        Date startTime= null;
        Date endTime= null;
        try {
            startTime = simpleDateFormat.parse("2019-01-06");
            endTime = simpleDateFormat.parse("2019-01-07");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        int num=seckillService.updateSeckill(id,name,number,startTime,endTime);
        System.out.println(num);
    }
}