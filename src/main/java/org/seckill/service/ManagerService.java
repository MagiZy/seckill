package org.seckill.service;

import org.seckill.bean.Manager;

import java.util.List;


public interface ManagerService {

    /**
     * 根据ID查询管理员
     * @param id
     * @return
     */
    Manager getById(long id);

    /**
     * 查询所有管理员
     * @return
     */
    List<Manager> getAll();

    /**
     * 管理员登录
     * @param name
     * @return
     */
    Manager login(String name, String pwd);
}
