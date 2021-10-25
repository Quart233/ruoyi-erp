package com.ruoyi.erp.mapper;

import java.util.List;
import com.ruoyi.erp.domain.ErpRetail;

/**
 * 零售出库Mapper接口
 * 
 * @author kuaizi
 * @date 2021-10-25
 */
public interface ErpRetailMapper 
{
    /**
     * 查询零售出库
     * 
     * @param id 零售出库主键
     * @return 零售出库
     */
    public ErpRetail selectErpRetailById(Long id);

    /**
     * 查询零售出库列表
     * 
     * @param erpRetail 零售出库
     * @return 零售出库集合
     */
    public List<ErpRetail> selectErpRetailList(ErpRetail erpRetail);

    /**
     * 新增零售出库
     * 
     * @param erpRetail 零售出库
     * @return 结果
     */
    public int insertErpRetail(ErpRetail erpRetail);

    /**
     * 修改零售出库
     * 
     * @param erpRetail 零售出库
     * @return 结果
     */
    public int updateErpRetail(ErpRetail erpRetail);

    /**
     * 删除零售出库
     * 
     * @param id 零售出库主键
     * @return 结果
     */
    public int deleteErpRetailById(Long id);

    /**
     * 批量删除零售出库
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteErpRetailByIds(Long[] ids);
}
