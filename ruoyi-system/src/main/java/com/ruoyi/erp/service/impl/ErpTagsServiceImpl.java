package com.ruoyi.erp.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.erp.mapper.ErpTagsMapper;
import com.ruoyi.erp.domain.ErpTags;
import com.ruoyi.erp.service.IErpTagsService;

/**
 * 标签Service业务层处理
 * 
 * @author kuaizi
 * @date 2021-10-25
 */
@Service
public class ErpTagsServiceImpl implements IErpTagsService 
{
    @Autowired
    private ErpTagsMapper erpTagsMapper;

    /**
     * 查询标签
     * 
     * @param tagUuid 标签主键
     * @return 标签
     */
    @Override
    public ErpTags selectErpTagsByTagUuid(String tagUuid)
    {
        return erpTagsMapper.selectErpTagsByTagUuid(tagUuid);
    }

    /**
     * 查询标签列表
     * 
     * @param erpTags 标签
     * @return 标签
     */
    @Override
    public List<ErpTags> selectErpTagsList(ErpTags erpTags)
    {
        return erpTagsMapper.selectErpTagsList(erpTags);
    }

    /**
     * 新增标签
     * 
     * @param erpTags 标签
     * @return 结果
     */
    @Override
    public int insertErpTags(ErpTags erpTags)
    {
        erpTags.setCreateTime(DateUtils.getNowDate());
        return erpTagsMapper.insertErpTags(erpTags);
    }

    /**
     * 修改标签
     * 
     * @param erpTags 标签
     * @return 结果
     */
    @Override
    public int updateErpTags(ErpTags erpTags)
    {
        return erpTagsMapper.updateErpTags(erpTags);
    }

    /**
     * 批量删除标签
     * 
     * @param tagUuids 需要删除的标签主键
     * @return 结果
     */
    @Override
    public int deleteErpTagsByTagUuids(String[] tagUuids)
    {
        return erpTagsMapper.deleteErpTagsByTagUuids(tagUuids);
    }

    /**
     * 删除标签信息
     * 
     * @param tagUuid 标签主键
     * @return 结果
     */
    @Override
    public int deleteErpTagsByTagUuid(String tagUuid)
    {
        return erpTagsMapper.deleteErpTagsByTagUuid(tagUuid);
    }
}
