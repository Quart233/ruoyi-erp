package com.ruoyi.erp.service;

import java.util.List;
import com.ruoyi.erp.domain.ErpClient;

/**
 * 库存客户Service接口
 * 
 * @author kuaizi
 * @date 2021-10-25
 */
public interface IErpClientService 
{
    /**
     * 查询库存客户
     * 
     * @param id 库存客户主键
     * @return 库存客户
     */
    public ErpClient selectErpClientById(Long id);

    /**
     * 查询库存客户列表
     * 
     * @param erpClient 库存客户
     * @return 库存客户集合
     */
    public List<ErpClient> selectErpClientList(ErpClient erpClient);

    /**
     * 新增库存客户
     * 
     * @param erpClient 库存客户
     * @return 结果
     */
    public int insertErpClient(ErpClient erpClient);

    /**
     * 修改库存客户
     * 
     * @param erpClient 库存客户
     * @return 结果
     */
    public int updateErpClient(ErpClient erpClient);

    /**
     * 批量删除库存客户
     * 
     * @param ids 需要删除的库存客户主键集合
     * @return 结果
     */
    public int deleteErpClientByIds(Long[] ids);

    /**
     * 删除库存客户信息
     * 
     * @param id 库存客户主键
     * @return 结果
     */
    public int deleteErpClientById(Long id);
}
