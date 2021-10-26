package com.ruoyi.erp.domain;

import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * 库存产品对象 erp_product
 * 
 * @author kuaizi
 * @date 2021-10-25
 */
public class ErpProductExtend extends ErpProduct
{
    public List<ErpTags> tags = new ArrayList<ErpTags>();
}
