package org.seckill.web;


import org.seckill.bean.Manager;
import org.seckill.bean.Seckill;
import org.seckill.dto.ManagerEditInfo;
import org.seckill.dto.ManagerLoginInf;
import org.seckill.service.ManagerService;
import org.seckill.service.SeckillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


@Controller
@RequestMapping(value = "/seckill")
public class ManagerController {

    @Autowired
    private SeckillService seckillService;
    @Autowired
    private ManagerService managerService;

//    @InitBinder
//    protected void initBinder(HttpServletRequest request, ServletRequestDataBinder binder) throws Exception {
//        DateFormat fmt = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        CustomDateEditor dateEditor = new CustomDateEditor(fmt, true);
//        binder.registerCustomEditor(Date.class, dateEditor);
//    }

    @RequestMapping(value = "/checklogin",
            method = RequestMethod.POST,
            produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public ManagerLoginInf checklogin(@RequestParam("manager_name") String manager_name, @RequestParam("manager_pwd")String manager_pwd ,
                                      HttpServletRequest request) {

        Manager manager=managerService.login(manager_name,manager_pwd);

        if(manager!=null){
            request.getSession().setAttribute("manager",manager);
            return new ManagerLoginInf(manager,true,"success");
        }else{
            return new ManagerLoginInf(false,"fail");
        }
    }

    @RequestMapping(value = "/login",method = RequestMethod.GET)
    public String index(){
        return "login";
    }

    @RequestMapping(value = "/manager",method = RequestMethod.GET)
    public String managerPage(Model model){
        //获取列表页
        List<Seckill> list = seckillService.getSeckillList();
        model.addAttribute("list", list);
        return "manager";
    }

    @RequestMapping(value = "/manager/{seckillId}/edit",method = RequestMethod.GET)
    public String editPage(@PathVariable("seckillId") Long seckillId,Model model){
        Seckill seckill=seckillService.getById(seckillId);
        model.addAttribute("seckill",seckill);
        return "edit";
    }

    @RequestMapping(value = "/manager/{seckillId}/edit.do",
            method = RequestMethod.POST,
            produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public ManagerEditInfo editInfo(@PathVariable("seckillId") Long seckillId,
                                    @RequestParam("name")String name,
                                    @RequestParam("number")int number,
                                    @RequestParam("startTime") String startTime,
                                    @RequestParam("endTime") String endTime){
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd");

        Date start_time=null;
        Date end_time=null;
        try {
            start_time = simpleDateFormat.parse(startTime);
            end_time = simpleDateFormat.parse(endTime);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        int num=seckillService.updateSeckill(seckillId,name,number,start_time,end_time);
        if(num>=1){
            return new ManagerEditInfo(true,"修改成功");
        }else if(num==0){
            return new ManagerEditInfo(true,"无改动");
        }else {
            return new ManagerEditInfo(false,"修改失败");
        }
    }
}