package com.ruoyi.erp.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 商品条码对象 erp_product_sn
 * 
 * @author kuaizi
 * @date 2021-10-25
 */
public class ErpProductSn extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private String snUuid;

    /** 商品sn条码 */
    @Excel(name = "商品sn条码")
    private String snCode;

    /** 产品ID */
    @Excel(name = "产品ID")
    private Long productId;

    /** 在库: 0 已出库: 1 */
    @Excel(name = "在库: 0 已出库: 1")
    private Long status;

    public void setSnUuid(String snUuid) 
    {
        this.snUuid = snUuid;
    }

    public String getSnUuid() 
    {
        return snUuid;
    }
    public void setSnCode(String snCode) 
    {
        this.snCode = snCode;
    }

    public String getSnCode() 
    {
        return snCode;
    }
    public void setProductId(Long productId) 
    {
        this.productId = productId;
    }

    public Long getProductId() 
    {
        return productId;
    }
    public void setStatus(Long status) 
    {
        this.status = status;
    }

    public Long getStatus() 
    {
        return status;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("snUuid", getSnUuid())
            .append("snCode", getSnCode())
            .append("createTime", getCreateTime())
            .append("productId", getProductId())
            .append("status", getStatus())
            .toString();
    }
}
