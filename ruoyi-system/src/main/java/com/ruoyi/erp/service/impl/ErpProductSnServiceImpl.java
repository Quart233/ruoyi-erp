package com.ruoyi.erp.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.erp.mapper.ErpProductSnMapper;
import com.ruoyi.erp.domain.ErpProductSn;
import com.ruoyi.erp.service.IErpProductSnService;

/**
 * 商品条码Service业务层处理
 * 
 * @author kuaizi
 * @date 2021-10-25
 */
@Service
public class ErpProductSnServiceImpl implements IErpProductSnService 
{
    @Autowired
    private ErpProductSnMapper erpProductSnMapper;

    /**
     * 查询商品条码
     * 
     * @param snUuid 商品条码主键
     * @return 商品条码
     */
    @Override
    public ErpProductSn selectErpProductSnBySnUuid(String snUuid)
    {
        return erpProductSnMapper.selectErpProductSnBySnUuid(snUuid);
    }

    /**
     * 查询商品条码列表
     * 
     * @param erpProductSn 商品条码
     * @return 商品条码
     */
    @Override
    public List<ErpProductSn> selectErpProductSnList(ErpProductSn erpProductSn)
    {
        return erpProductSnMapper.selectErpProductSnList(erpProductSn);
    }

    /**
     * 新增商品条码
     * 
     * @param erpProductSn 商品条码
     * @return 结果
     */
    @Override
    public int insertErpProductSn(ErpProductSn erpProductSn)
    {
        erpProductSn.setCreateTime(DateUtils.getNowDate());
        return erpProductSnMapper.insertErpProductSn(erpProductSn);
    }

    /**
     * 修改商品条码
     * 
     * @param erpProductSn 商品条码
     * @return 结果
     */
    @Override
    public int updateErpProductSn(ErpProductSn erpProductSn)
    {
        return erpProductSnMapper.updateErpProductSn(erpProductSn);
    }

    /**
     * 批量删除商品条码
     * 
     * @param snUuids 需要删除的商品条码主键
     * @return 结果
     */
    @Override
    public int deleteErpProductSnBySnUuids(String[] snUuids)
    {
        return erpProductSnMapper.deleteErpProductSnBySnUuids(snUuids);
    }

    /**
     * 删除商品条码信息
     * 
     * @param snUuid 商品条码主键
     * @return 结果
     */
    @Override
    public int deleteErpProductSnBySnUuid(String snUuid)
    {
        return erpProductSnMapper.deleteErpProductSnBySnUuid(snUuid);
    }
}
