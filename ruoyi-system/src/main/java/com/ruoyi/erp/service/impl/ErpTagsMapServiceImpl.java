package com.ruoyi.erp.service.impl;

import java.util.List;

import com.ruoyi.erp.domain.ErpTags;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.erp.mapper.ErpTagsMapMapper;
import com.ruoyi.erp.domain.ErpTagsMap;
import com.ruoyi.erp.service.IErpTagsMapService;

/**
 * 标签映射Service业务层处理
 * 
 * @author kuaizi
 * @date 2021-10-25
 */
@Service
public class ErpTagsMapServiceImpl implements IErpTagsMapService 
{
    @Autowired
    private ErpTagsMapMapper erpTagsMapMapper;

    /**
     * 查询标签映射
     * 
     * @param tagUuid 标签映射主键
     * @return 标签映射
     */
    @Override
    public ErpTagsMap selectErpTagsMapByTagUuid(String tagUuid)
    {
        return erpTagsMapMapper.selectErpTagsMapByTagUuid(tagUuid);
    }

    /**
     * 查询标签映射列表
     * 
     * @param erpTagsMap 标签映射
     * @return 标签映射
     */
    @Override
    public List<ErpTagsMap> selectErpTagsMapList(ErpTagsMap erpTagsMap)
    {
        return erpTagsMapMapper.selectErpTagsMapList(erpTagsMap);
    }

    /**
     * 新增标签映射
     * 
     * @param erpTagsMap 标签映射
     * @return 结果
     */
    @Override
    public int insertErpTagsMap(ErpTagsMap erpTagsMap)
    {
        return erpTagsMapMapper.insertErpTagsMap(erpTagsMap);
    }

    /**
     * 修改标签映射
     * 
     * @param erpTagsMap 标签映射
     * @return 结果
     */
    @Override
    public int updateErpTagsMap(ErpTagsMap erpTagsMap)
    {
        return erpTagsMapMapper.updateErpTagsMap(erpTagsMap);
    }

    /**
     * 批量删除标签映射
     * 
     * @param tagUuids 需要删除的标签映射主键
     * @return 结果
     */
    @Override
    public int deleteErpTagsMapByTagUuids(String[] tagUuids)
    {
        return erpTagsMapMapper.deleteErpTagsMapByTagUuids(tagUuids);
    }

    /**
     * 删除标签映射信息
     * 
     * @param tagUuid 标签映射主键
     * @return 结果
     */
    @Override
    public int deleteErpTagsMapByTagUuid(String tagUuid)
    {
        return erpTagsMapMapper.deleteErpTagsMapByTagUuid(tagUuid);
    }

    @Override
    public List<ErpTagsMap> selectErpTagsMapListByProductID(long productID) {
        return erpTagsMapMapper.selectErpTagsMapListByProductID(productID);
    }

    @Override
    public List<ErpTags> selectProductTagListByProdProductID(Long id) {
        return erpTagsMapMapper.selectProductTagListByProdProductID(id);
    }
}
