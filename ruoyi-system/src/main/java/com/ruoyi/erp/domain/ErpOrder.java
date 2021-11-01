package com.ruoyi.erp.domain;

import java.math.BigDecimal;
import java.util.ArrayList;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 库存销售订单对象 erp_order
 * 
 * @author kuaizi
 * @date 2021-10-25
 */
public class ErpOrder extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 销售订单ID */
    private Long id;

    /** 库存流水ID */
    @Excel(name = "库存流水ID")
    private Long detailId;

    /** 开票信息ID */
    @Excel(name = "开票信息ID")
    private Long taxInfoId;

    /** 订单金额 */
    @Excel(name = "订单金额")
    private BigDecimal totalPrice;

    /** 实付金额 */
    @Excel(name = "实付金额")
    private BigDecimal actualPayment;

    /** 经手人姓名 */
    @Excel(name = "经手人姓名")
    private String handlerName;

    /** 客户ID */
    @Excel(name = "客户ID")
    private Long clientId;

    /** 客户信息 */
    private ErpClient clientInfo;
    /** 是否需要开票 */
    private boolean taxNeed;
    /** 产品清单 */
    private ArrayList<ErpProduct> productList;
    /** 开票信息 */
    private ErpTaxInfo taxInfo;

    public void setId(Long id)
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setDetailId(Long detailId) 
    {
        this.detailId = detailId;
    }

    public Long getDetailId() 
    {
        return detailId;
    }
    public void setTaxInfoId(Long taxInfoId) 
    {
        this.taxInfoId = taxInfoId;
    }

    public Long getTaxInfoId() 
    {
        return taxInfoId;
    }
    public void setTotalPrice(BigDecimal totalPrice) 
    {
        this.totalPrice = totalPrice;
    }

    public BigDecimal getTotalPrice() 
    {
        return totalPrice;
    }
    public void setActualPayment(BigDecimal actualPayment) 
    {
        this.actualPayment = actualPayment;
    }

    public BigDecimal getActualPayment() 
    {
        return actualPayment;
    }
    public void setHandlerName(String handlerName) 
    {
        this.handlerName = handlerName;
    }

    public String getHandlerName() 
    {
        return handlerName;
    }
    public void setClientId(Long clientId) 
    {
        this.clientId = clientId;
    }

    public Long getClientId() 
    {
        return clientId;
    }

    public void setClientInfo(ErpClient clientInfo) {
        this.clientInfo = clientInfo;
    }

    public ErpClient getClientInfo() {
        return clientInfo;
    }

    public void setTaxInfo(ErpTaxInfo taxInfo) {
        this.taxInfo = taxInfo;
    }

    public ErpTaxInfo getTaxInfo() {
        return taxInfo;
    }

    public void setTaxNeed(boolean taxNeed) {
        this.taxNeed = taxNeed;
    }

    public boolean getTaxNeed()
    {
        return taxNeed;
    }

    public void setProductList(ArrayList<ErpProduct> productList) {
        this.productList = productList;
    }

    public ArrayList<ErpProduct> getProductList() {
        return productList;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("detailId", getDetailId())
            .append("createTime", getCreateTime())
            .append("taxInfoId", getTaxInfoId())
            .append("totalPrice", getTotalPrice())
            .append("actualPayment", getActualPayment())
            .append("handlerName", getHandlerName())
            .append("clientId", getClientId())
            .append("remark", getRemark())
            .toString();
    }
}
