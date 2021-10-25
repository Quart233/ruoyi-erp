package com.ruoyi.erp.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.erp.mapper.ErpStorageFlowMapper;
import com.ruoyi.erp.domain.ErpStorageFlow;
import com.ruoyi.erp.service.IErpStorageFlowService;

/**
 * 库存流水Service业务层处理
 * 
 * @author kuaizi
 * @date 2021-10-25
 */
@Service
public class ErpStorageFlowServiceImpl implements IErpStorageFlowService 
{
    @Autowired
    private ErpStorageFlowMapper erpStorageFlowMapper;

    /**
     * 查询库存流水
     * 
     * @param id 库存流水主键
     * @return 库存流水
     */
    @Override
    public ErpStorageFlow selectErpStorageFlowById(Long id)
    {
        return erpStorageFlowMapper.selectErpStorageFlowById(id);
    }

    /**
     * 查询库存流水列表
     * 
     * @param erpStorageFlow 库存流水
     * @return 库存流水
     */
    @Override
    public List<ErpStorageFlow> selectErpStorageFlowList(ErpStorageFlow erpStorageFlow)
    {
        return erpStorageFlowMapper.selectErpStorageFlowList(erpStorageFlow);
    }

    /**
     * 新增库存流水
     * 
     * @param erpStorageFlow 库存流水
     * @return 结果
     */
    @Override
    public int insertErpStorageFlow(ErpStorageFlow erpStorageFlow)
    {
        return erpStorageFlowMapper.insertErpStorageFlow(erpStorageFlow);
    }

    /**
     * 修改库存流水
     * 
     * @param erpStorageFlow 库存流水
     * @return 结果
     */
    @Override
    public int updateErpStorageFlow(ErpStorageFlow erpStorageFlow)
    {
        return erpStorageFlowMapper.updateErpStorageFlow(erpStorageFlow);
    }

    /**
     * 批量删除库存流水
     * 
     * @param ids 需要删除的库存流水主键
     * @return 结果
     */
    @Override
    public int deleteErpStorageFlowByIds(Long[] ids)
    {
        return erpStorageFlowMapper.deleteErpStorageFlowByIds(ids);
    }

    /**
     * 删除库存流水信息
     * 
     * @param id 库存流水主键
     * @return 结果
     */
    @Override
    public int deleteErpStorageFlowById(Long id)
    {
        return erpStorageFlowMapper.deleteErpStorageFlowById(id);
    }
}
