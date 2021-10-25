package com.ruoyi.erp.mapper;

import java.util.List;
import com.ruoyi.erp.domain.ErpTagsMap;

/**
 * 标签映射Mapper接口
 * 
 * @author kuaizi
 * @date 2021-10-25
 */
public interface ErpTagsMapMapper 
{
    /**
     * 查询标签映射
     * 
     * @param tagUuid 标签映射主键
     * @return 标签映射
     */
    public ErpTagsMap selectErpTagsMapByTagUuid(String tagUuid);

    /**
     * 查询标签映射列表
     * 
     * @param erpTagsMap 标签映射
     * @return 标签映射集合
     */
    public List<ErpTagsMap> selectErpTagsMapList(ErpTagsMap erpTagsMap);

    /**
     * 新增标签映射
     * 
     * @param erpTagsMap 标签映射
     * @return 结果
     */
    public int insertErpTagsMap(ErpTagsMap erpTagsMap);

    /**
     * 修改标签映射
     * 
     * @param erpTagsMap 标签映射
     * @return 结果
     */
    public int updateErpTagsMap(ErpTagsMap erpTagsMap);

    /**
     * 删除标签映射
     * 
     * @param tagUuid 标签映射主键
     * @return 结果
     */
    public int deleteErpTagsMapByTagUuid(String tagUuid);

    /**
     * 批量删除标签映射
     * 
     * @param tagUuids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteErpTagsMapByTagUuids(String[] tagUuids);
}
