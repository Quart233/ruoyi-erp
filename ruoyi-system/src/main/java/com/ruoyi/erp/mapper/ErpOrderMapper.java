package com.ruoyi.erp.mapper;

import java.util.List;
import com.ruoyi.erp.domain.ErpOrder;

/**
 * 库存销售订单Mapper接口
 * 
 * @author kuaizi
 * @date 2021-10-25
 */
public interface ErpOrderMapper 
{
    /**
     * 查询库存销售订单
     * 
     * @param id 库存销售订单主键
     * @return 库存销售订单
     */
    public ErpOrder selectErpOrderById(Long id);

    /**
     * 查询库存销售订单列表
     * 
     * @param erpOrder 库存销售订单
     * @return 库存销售订单集合
     */
    public List<ErpOrder> selectErpOrderList(ErpOrder erpOrder);

    /**
     * 新增库存销售订单
     * 
     * @param erpOrder 库存销售订单
     * @return 结果
     */
    public int insertErpOrder(ErpOrder erpOrder);

    /**
     * 修改库存销售订单
     * 
     * @param erpOrder 库存销售订单
     * @return 结果
     */
    public int updateErpOrder(ErpOrder erpOrder);

    /**
     * 删除库存销售订单
     * 
     * @param id 库存销售订单主键
     * @return 结果
     */
    public int deleteErpOrderById(Long id);

    /**
     * 批量删除库存销售订单
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteErpOrderByIds(Long[] ids);
}
