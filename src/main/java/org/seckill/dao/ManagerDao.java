package org.seckill.dao;

import org.apache.ibatis.annotations.Param;
import org.seckill.bean.Manager;

import java.util.List;

public interface ManagerDao {

    /**
     * 根据ID查询管理员
     *
     * @param id
     * @return
     */
    Manager queryById(long id);

    /**
     * 根据偏移量查询管理员
     *
     * @param offset
     * @param limit
     * @return
     */
    List<Manager> queryAll(@Param("offset") int offset, @Param("limit") int limit);

    /**
     * 根据用户名查询管理员
     * @param name
     * @return
     */
    Manager queryByname(@Param("name") String name);
}
