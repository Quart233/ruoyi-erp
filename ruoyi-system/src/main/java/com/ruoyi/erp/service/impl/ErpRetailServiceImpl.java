package com.ruoyi.erp.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.erp.mapper.ErpRetailMapper;
import com.ruoyi.erp.domain.ErpRetail;
import com.ruoyi.erp.service.IErpRetailService;

/**
 * 零售出库Service业务层处理
 * 
 * @author kuaizi
 * @date 2021-10-25
 */
@Service
public class ErpRetailServiceImpl implements IErpRetailService 
{
    @Autowired
    private ErpRetailMapper erpRetailMapper;

    /**
     * 查询零售出库
     * 
     * @param id 零售出库主键
     * @return 零售出库
     */
    @Override
    public ErpRetail selectErpRetailById(Long id)
    {
        return erpRetailMapper.selectErpRetailById(id);
    }

    /**
     * 查询零售出库列表
     * 
     * @param erpRetail 零售出库
     * @return 零售出库
     */
    @Override
    public List<ErpRetail> selectErpRetailList(ErpRetail erpRetail)
    {
        return erpRetailMapper.selectErpRetailList(erpRetail);
    }

    /**
     * 新增零售出库
     * 
     * @param erpRetail 零售出库
     * @return 结果
     */
    @Override
    public int insertErpRetail(ErpRetail erpRetail)
    {
        erpRetail.setCreateTime(DateUtils.getNowDate());
        return erpRetailMapper.insertErpRetail(erpRetail);
    }

    /**
     * 修改零售出库
     * 
     * @param erpRetail 零售出库
     * @return 结果
     */
    @Override
    public int updateErpRetail(ErpRetail erpRetail)
    {
        return erpRetailMapper.updateErpRetail(erpRetail);
    }

    /**
     * 批量删除零售出库
     * 
     * @param ids 需要删除的零售出库主键
     * @return 结果
     */
    @Override
    public int deleteErpRetailByIds(Long[] ids)
    {
        return erpRetailMapper.deleteErpRetailByIds(ids);
    }

    /**
     * 删除零售出库信息
     * 
     * @param id 零售出库主键
     * @return 结果
     */
    @Override
    public int deleteErpRetailById(Long id)
    {
        return erpRetailMapper.deleteErpRetailById(id);
    }
}
