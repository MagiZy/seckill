package org.seckill.dao;

import org.apache.ibatis.annotations.Param;
import org.seckill.bean.Seckill;

import java.util.Date;
import java.util.List;
import java.util.Map;

public interface SeckillDao {

    /**
     * 减库存
     * @param seckillId
     * @param killTime
     * @return
     */
    int reduceNumber(@Param("seckillId") long seckillId, @Param("killTime") Date killTime);

    /**
     *修改编号ID的商品信息
     * @param seckillId
     * @return
     */
    int updateSeckill(@Param("seckillId") long seckillId, @Param("name") String name, @Param("number") int number,
                        @Param("startTime") Date startTime, @Param("endTime") Date endTime);

    /**
     * 增加秒杀商品
     * @param name
     * @param number
     * @param startTime
     * @param endTime
     * @return
     */
    int addSeckill(@Param("name") String name, @Param("number") int number,
                   @Param("startTime") Date startTime, @Param("endTime") Date endTime);

    /**
     * 根据ID查询秒杀对象
     * @param seckillId
     * @return
     */
    Seckill queryById(long seckillId);

    /**
     * 根据偏移量查询秒杀商品列表
     * @param offset
     * @param limit
     * @return
     */
    List<Seckill> queryAll(@Param("offset") int offset, @Param("limit") int limit);

    /**
     * 使用存储过程执行秒杀
     * @param paramMap
     */
    void killByProcedure(Map<String, Object> paramMap);
}
