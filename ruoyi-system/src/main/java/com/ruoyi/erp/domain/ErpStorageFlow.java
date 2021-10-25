package com.ruoyi.erp.domain;

import java.math.BigDecimal;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 库存流水对象 erp_storage_flow
 * 
 * @author kuaizi
 * @date 2021-10-25
 */
public class ErpStorageFlow extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 库存流水ID */
    private Long id;

    /** 产品ID */
    @Excel(name = "产品ID")
    private Long productId;

    /** 数量 */
    @Excel(name = "数量")
    private Long amount;

    /** 流水类型: 采购入库 00, 零售退货入库 01, 工程退货入库 02, 零售出库 10, 工程出库 11, 采购出库 12 */
    @Excel(name = "流水类型: 采购入库 00, 零售退货入库 01, 工程退货入库 02, 零售出库 10, 工程出库 11, 采购出库 12")
    private Long type;

    /** 流水金额 */
    @Excel(name = "流水金额")
    private BigDecimal price;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setProductId(Long productId) 
    {
        this.productId = productId;
    }

    public Long getProductId() 
    {
        return productId;
    }
    public void setAmount(Long amount) 
    {
        this.amount = amount;
    }

    public Long getAmount() 
    {
        return amount;
    }
    public void setType(Long type) 
    {
        this.type = type;
    }

    public Long getType() 
    {
        return type;
    }
    public void setPrice(BigDecimal price) 
    {
        this.price = price;
    }

    public BigDecimal getPrice() 
    {
        return price;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("productId", getProductId())
            .append("amount", getAmount())
            .append("type", getType())
            .append("price", getPrice())
            .append("remark", getRemark())
            .toString();
    }
}
