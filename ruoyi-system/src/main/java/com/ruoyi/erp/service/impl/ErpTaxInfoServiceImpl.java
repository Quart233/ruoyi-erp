package com.ruoyi.erp.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.erp.mapper.ErpTaxInfoMapper;
import com.ruoyi.erp.domain.ErpTaxInfo;
import com.ruoyi.erp.service.IErpTaxInfoService;

/**
 * 库存开票信息Service业务层处理
 * 
 * @author kuaizi
 * @date 2021-10-25
 */
@Service
public class ErpTaxInfoServiceImpl implements IErpTaxInfoService 
{
    @Autowired
    private ErpTaxInfoMapper erpTaxInfoMapper;

    /**
     * 查询库存开票信息
     * 
     * @param id 库存开票信息主键
     * @return 库存开票信息
     */
    @Override
    public ErpTaxInfo selectErpTaxInfoById(Long id)
    {
        return erpTaxInfoMapper.selectErpTaxInfoById(id);
    }

    /**
     * 查询库存开票信息列表
     * 
     * @param erpTaxInfo 库存开票信息
     * @return 库存开票信息
     */
    @Override
    public List<ErpTaxInfo> selectErpTaxInfoList(ErpTaxInfo erpTaxInfo)
    {
        return erpTaxInfoMapper.selectErpTaxInfoList(erpTaxInfo);
    }

    /**
     * 新增库存开票信息
     * 
     * @param erpTaxInfo 库存开票信息
     * @return 结果
     */
    @Override
    public int insertErpTaxInfo(ErpTaxInfo erpTaxInfo)
    {
        return erpTaxInfoMapper.insertErpTaxInfo(erpTaxInfo);
    }

    /**
     * 修改库存开票信息
     * 
     * @param erpTaxInfo 库存开票信息
     * @return 结果
     */
    @Override
    public int updateErpTaxInfo(ErpTaxInfo erpTaxInfo)
    {
        return erpTaxInfoMapper.updateErpTaxInfo(erpTaxInfo);
    }

    /**
     * 批量删除库存开票信息
     * 
     * @param ids 需要删除的库存开票信息主键
     * @return 结果
     */
    @Override
    public int deleteErpTaxInfoByIds(Long[] ids)
    {
        return erpTaxInfoMapper.deleteErpTaxInfoByIds(ids);
    }

    /**
     * 删除库存开票信息信息
     * 
     * @param id 库存开票信息主键
     * @return 结果
     */
    @Override
    public int deleteErpTaxInfoById(Long id)
    {
        return erpTaxInfoMapper.deleteErpTaxInfoById(id);
    }
}
