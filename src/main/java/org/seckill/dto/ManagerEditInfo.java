package org.seckill.dto;

public class ManagerEditInfo {

    //修改状态
    private boolean state;
    //状态信息
    private String msg;

    public ManagerEditInfo(boolean state, String msg) {
        this.state = state;
        this.msg = msg;
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
