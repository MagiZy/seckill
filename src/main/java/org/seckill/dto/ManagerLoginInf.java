package org.seckill.dto;

import org.seckill.bean.Manager;

//封装管理员登录信息
public class ManagerLoginInf {

    //管理员实体
    private Manager manager;
    //登录状态
    private boolean state;
    //登录状态标识
    private String msg;

    public ManagerLoginInf(Manager manager, boolean state, String msg) {
        this.manager = manager;
        this.state = state;
        this.msg = msg;
    }

    public ManagerLoginInf(boolean state, String msg) {
        this.state = state;
        this.msg = msg;
    }

    public Manager getManager() {
        return manager;
    }

    public void setManager(Manager manager) {
        this.manager = manager;
    }

    public boolean isState() {
        return state;
    }

    public void setState(boolean state) {
        this.state = state;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
