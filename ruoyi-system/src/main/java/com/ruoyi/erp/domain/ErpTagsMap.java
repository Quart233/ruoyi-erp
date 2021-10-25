package com.ruoyi.erp.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 标签映射对象 erp_tags_map
 * 
 * @author kuaizi
 * @date 2021-10-25
 */
public class ErpTagsMap extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 产品条码 UUID */
    @Excel(name = "产品条码 UUID")
    private String tagUuid;

    /** 产品 ID */
    @Excel(name = "产品 ID")
    private String productId;

    public void setTagUuid(String tagUuid) 
    {
        this.tagUuid = tagUuid;
    }

    public String getTagUuid() 
    {
        return tagUuid;
    }
    public void setProductId(String productId) 
    {
        this.productId = productId;
    }

    public String getProductId() 
    {
        return productId;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("tagUuid", getTagUuid())
            .append("productId", getProductId())
            .toString();
    }
}
