package com.ruoyi.erp.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 标签对象 erp_tags
 * 
 * @author kuaizi
 * @date 2021-10-25
 */
public class ErpTags extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 标签 UUID */
    private String tagUuid;

    /** 标签名 */
    @Excel(name = "标签名")
    private String tagName;

    /** 颜色 */
    @Excel(name = "颜色")
    private String color;

    public void setColor(String color) {
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    public void setTagUuid(String tagUuid)
    {
        this.tagUuid = tagUuid;
    }

    public String getTagUuid() 
    {
        return tagUuid;
    }
    public void setTagName(String tagName) 
    {
        this.tagName = tagName;
    }

    public String getTagName() 
    {
        return tagName;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("tagUuid", getTagUuid())
            .append("tagName", getTagName())
            .append("remark", getRemark())
            .append("createTime", getCreateTime())
            .toString();
    }
}
