package com.ruoyi.erp.domain;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 库存产品对象 erp_product
 * 
 * @author kuaizi
 * @date 2021-10-25
 */
public class ErpProduct extends BaseEntity
{
    public ErpProduct() {
        super();
    }

    private static final long serialVersionUID = 1L;

    /** 产品ID */
    private Long id;

    /** 名称 */
    @Excel(name = "名称")
    private String productName;

    /** 型号 */
    @Excel(name = "型号")
    private String productModel;

    /** 单位 */
    @Excel(name = "单位")
    private String productUnit;

    /** 销售价格 */
    @Excel(name = "销售价格")
    private BigDecimal productPrice;

    /** 备注 */
    @Excel(name = "备注")
    private String productRemark;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setProductName(String productName) 
    {
        this.productName = productName;
    }

    public String getProductName() 
    {
        return productName;
    }
    public void setProductModel(String productModel) 
    {
        this.productModel = productModel;
    }

    public String getProductModel() 
    {
        return productModel;
    }
    public void setProductUnit(String productUnit) 
    {
        this.productUnit = productUnit;
    }

    public String getProductUnit() 
    {
        return productUnit;
    }
    public void setProductPrice(BigDecimal productPrice) 
    {
        this.productPrice = productPrice;
    }

    public BigDecimal getProductPrice() 
    {
        return productPrice;
    }
    public void setProductRemark(String productRemark) 
    {
        this.productRemark = productRemark;
    }

    public String getProductRemark() 
    {
        return productRemark;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("productName", getProductName())
            .append("productModel", getProductModel())
            .append("productUnit", getProductUnit())
            .append("productPrice", getProductPrice())
            .append("productRemark", getProductRemark())
            .toString();
    }

    public List<ErpTags> tags = new ArrayList<ErpTags>();

    public void setTags(List<ErpTags> tags) {
        this.tags = tags;
    }

    public List<ErpTags> getTags() {
        return tags;
    }
}
