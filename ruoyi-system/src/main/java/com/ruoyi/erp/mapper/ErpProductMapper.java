package com.ruoyi.erp.mapper;

import java.util.List;
import com.ruoyi.erp.domain.ErpProduct;

/**
 * 库存产品Mapper接口
 * 
 * @author kuaizi
 * @date 2021-10-25
 */
public interface ErpProductMapper 
{
    /**
     * 查询库存产品
     * 
     * @param id 库存产品主键
     * @return 库存产品
     */
    public ErpProduct selectErpProductById(Long id);

    /**
     * 查询库存产品列表
     * 
     * @param erpProduct 库存产品
     * @return 库存产品集合
     */
    public List<ErpProduct> selectErpProductList(ErpProduct erpProduct);

    /**
     * 新增库存产品
     * 
     * @param erpProduct 库存产品
     * @return 结果
     */
    public int insertErpProduct(ErpProduct erpProduct);

    /**
     * 修改库存产品
     * 
     * @param erpProduct 库存产品
     * @return 结果
     */
    public int updateErpProduct(ErpProduct erpProduct);

    /**
     * 删除库存产品
     * 
     * @param id 库存产品主键
     * @return 结果
     */
    public int deleteErpProductById(Long id);

    /**
     * 批量删除库存产品
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteErpProductByIds(Long[] ids);

    List<ErpProduct> selectProductListByTag(ErpProduct erpProduct);

    /**
     * 根据订单号查询产品列表
     *
     * @param  id 订单id
     * @return 结果
     */
    List<ErpProduct> selectErpProductByOrderId(Long id);
}
