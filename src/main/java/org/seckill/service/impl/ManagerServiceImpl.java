package org.seckill.service.impl;

import org.seckill.bean.Manager;
import org.seckill.dao.ManagerDao;
import org.seckill.service.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ManagerServiceImpl implements ManagerService {

    @Autowired
    private ManagerDao managerDao;

    @Override
    public Manager getById(long id) {
        return managerDao.queryById(id);
    }

    @Override
    public List<Manager> getAll() {
        return managerDao.queryAll(0,2);
    }

    @Override
    public Manager login(String name, String pwd) {
        Manager manager=managerDao.queryByname(name);
        if(manager!=null && manager.getPwd().equals(pwd))
            return manager;
        else
            return null;
    }
}
