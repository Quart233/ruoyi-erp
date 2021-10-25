package com.ruoyi.erp.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.erp.mapper.ErpProductMapper;
import com.ruoyi.erp.domain.ErpProduct;
import com.ruoyi.erp.service.IErpProductService;

/**
 * 库存产品Service业务层处理
 * 
 * @author kuaizi
 * @date 2021-10-25
 */
@Service
public class ErpProductServiceImpl implements IErpProductService 
{
    @Autowired
    private ErpProductMapper erpProductMapper;

    /**
     * 查询库存产品
     * 
     * @param id 库存产品主键
     * @return 库存产品
     */
    @Override
    public ErpProduct selectErpProductById(Long id)
    {
        return erpProductMapper.selectErpProductById(id);
    }

    /**
     * 查询库存产品列表
     * 
     * @param erpProduct 库存产品
     * @return 库存产品
     */
    @Override
    public List<ErpProduct> selectErpProductList(ErpProduct erpProduct)
    {
        return erpProductMapper.selectErpProductList(erpProduct);
    }

    /**
     * 新增库存产品
     * 
     * @param erpProduct 库存产品
     * @return 结果
     */
    @Override
    public int insertErpProduct(ErpProduct erpProduct)
    {
        return erpProductMapper.insertErpProduct(erpProduct);
    }

    /**
     * 修改库存产品
     * 
     * @param erpProduct 库存产品
     * @return 结果
     */
    @Override
    public int updateErpProduct(ErpProduct erpProduct)
    {
        return erpProductMapper.updateErpProduct(erpProduct);
    }

    /**
     * 批量删除库存产品
     * 
     * @param ids 需要删除的库存产品主键
     * @return 结果
     */
    @Override
    public int deleteErpProductByIds(Long[] ids)
    {
        return erpProductMapper.deleteErpProductByIds(ids);
    }

    /**
     * 删除库存产品信息
     * 
     * @param id 库存产品主键
     * @return 结果
     */
    @Override
    public int deleteErpProductById(Long id)
    {
        return erpProductMapper.deleteErpProductById(id);
    }
}
