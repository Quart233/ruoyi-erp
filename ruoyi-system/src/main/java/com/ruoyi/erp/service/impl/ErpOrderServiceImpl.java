package com.ruoyi.erp.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.erp.mapper.ErpOrderMapper;
import com.ruoyi.erp.domain.ErpOrder;
import com.ruoyi.erp.service.IErpOrderService;

/**
 * 库存销售订单Service业务层处理
 * 
 * @author kuaizi
 * @date 2021-10-25
 */
@Service
public class ErpOrderServiceImpl implements IErpOrderService 
{
    @Autowired
    private ErpOrderMapper erpOrderMapper;

    /**
     * 查询库存销售订单
     * 
     * @param id 库存销售订单主键
     * @return 库存销售订单
     */
    @Override
    public ErpOrder selectErpOrderById(Long id)
    {
        return erpOrderMapper.selectErpOrderById(id);
    }

    /**
     * 查询库存销售订单列表
     * 
     * @param erpOrder 库存销售订单
     * @return 库存销售订单
     */
    @Override
    public List<ErpOrder> selectErpOrderList(ErpOrder erpOrder)
    {
        return erpOrderMapper.selectErpOrderList(erpOrder);
    }

    /**
     * 新增库存销售订单
     * 
     * @param erpOrder 库存销售订单
     * @return 结果
     */
    @Override
    public int insertErpOrder(ErpOrder erpOrder)
    {
        erpOrder.setCreateTime(DateUtils.getNowDate());
        return erpOrderMapper.insertErpOrder(erpOrder);
    }

    /**
     * 修改库存销售订单
     * 
     * @param erpOrder 库存销售订单
     * @return 结果
     */
    @Override
    public int updateErpOrder(ErpOrder erpOrder)
    {
        return erpOrderMapper.updateErpOrder(erpOrder);
    }

    /**
     * 批量删除库存销售订单
     * 
     * @param ids 需要删除的库存销售订单主键
     * @return 结果
     */
    @Override
    public int deleteErpOrderByIds(Long[] ids)
    {
        return erpOrderMapper.deleteErpOrderByIds(ids);
    }

    /**
     * 删除库存销售订单信息
     * 
     * @param id 库存销售订单主键
     * @return 结果
     */
    @Override
    public int deleteErpOrderById(Long id)
    {
        return erpOrderMapper.deleteErpOrderById(id);
    }
}
