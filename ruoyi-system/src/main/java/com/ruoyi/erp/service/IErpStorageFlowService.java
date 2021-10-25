package com.ruoyi.erp.service;

import java.util.List;
import com.ruoyi.erp.domain.ErpStorageFlow;

/**
 * 库存流水Service接口
 * 
 * @author kuaizi
 * @date 2021-10-25
 */
public interface IErpStorageFlowService 
{
    /**
     * 查询库存流水
     * 
     * @param id 库存流水主键
     * @return 库存流水
     */
    public ErpStorageFlow selectErpStorageFlowById(Long id);

    /**
     * 查询库存流水列表
     * 
     * @param erpStorageFlow 库存流水
     * @return 库存流水集合
     */
    public List<ErpStorageFlow> selectErpStorageFlowList(ErpStorageFlow erpStorageFlow);

    /**
     * 新增库存流水
     * 
     * @param erpStorageFlow 库存流水
     * @return 结果
     */
    public int insertErpStorageFlow(ErpStorageFlow erpStorageFlow);

    /**
     * 修改库存流水
     * 
     * @param erpStorageFlow 库存流水
     * @return 结果
     */
    public int updateErpStorageFlow(ErpStorageFlow erpStorageFlow);

    /**
     * 批量删除库存流水
     * 
     * @param ids 需要删除的库存流水主键集合
     * @return 结果
     */
    public int deleteErpStorageFlowByIds(Long[] ids);

    /**
     * 删除库存流水信息
     * 
     * @param id 库存流水主键
     * @return 结果
     */
    public int deleteErpStorageFlowById(Long id);
}
