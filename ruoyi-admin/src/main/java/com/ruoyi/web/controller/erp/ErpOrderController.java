package com.ruoyi.web.controller.erp;

import java.util.List;

import com.ruoyi.erp.domain.ErpStorageFlow;
import com.ruoyi.erp.service.IErpClientService;
import com.ruoyi.erp.service.IErpStorageFlowService;
import com.ruoyi.erp.service.IErpTaxInfoService;
import com.ruoyi.framework.web.domain.server.Sys;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.erp.domain.ErpOrder;
import com.ruoyi.erp.service.IErpOrderService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 库存销售订单Controller
 * 
 * @author kuaizi
 * @date 2021-10-25
 */
@RestController
@RequestMapping("/erp/order")
public class ErpOrderController extends BaseController
{
    @Autowired
    private IErpOrderService erpOrderService;

    @Autowired
    private IErpClientService erpClientService;

    @Autowired
    private IErpTaxInfoService erpTaxInfoService;

    @Autowired
    private IErpStorageFlowService erpStorageFlowService;

    /**
     * 查询库存销售订单列表
     */
    @PreAuthorize("@ss.hasPermi('erp:order:list')")
    @GetMapping("/list")
    public TableDataInfo list(ErpOrder erpOrder)
    {
        startPage();
        List<ErpOrder> list = erpOrderService.selectErpOrderList(erpOrder);
        return getDataTable(list);
    }

    /**
     * 导出库存销售订单列表
     */
    @PreAuthorize("@ss.hasPermi('erp:order:export')")
    @Log(title = "库存销售订单", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(ErpOrder erpOrder)
    {
        List<ErpOrder> list = erpOrderService.selectErpOrderList(erpOrder);
        ExcelUtil<ErpOrder> util = new ExcelUtil<ErpOrder>(ErpOrder.class);
        return util.exportExcel(list, "库存销售订单数据");
    }

    /**
     * 获取库存销售订单详细信息
     */
    @PreAuthorize("@ss.hasPermi('erp:order:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(erpOrderService.selectErpOrderById(id));
    }

    /**
     * 新增库存销售订单
     */
    @Transactional()
    @PreAuthorize("@ss.hasPermi('erp:order:add')")
    @Log(title = "库存销售订单", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody ErpOrder erpOrder)
    {
        try {
            Long clientID = erpOrder.getClientInfo().getId();

            // 如果是新客户
            if (clientID == null) {
                erpClientService.insertErpClient(erpOrder.getClientInfo());
                clientID = erpOrder.getClientInfo().getId();
                System.out.println(String.format("clientID: %s", clientID));
            }

            // 关联客户
            erpOrder.setClientId(clientID);

            // 如果需要开票
            if (erpOrder.getTaxNeed()) {
                erpTaxInfoService.insertErpTaxInfo(erpOrder.getTaxInfo());
                Long taxInfoID = erpOrder.getTaxInfo().getId();
                erpOrder.setTaxInfoId(taxInfoID);
            }

            // 新增销售订单
            erpOrderService.insertErpOrder(erpOrder);

            // 新增库存流水
            erpOrder.getProductList().stream().forEach(erpProduct -> {
                ErpStorageFlow erpStorageFlow = new ErpStorageFlow();
                erpStorageFlow.setType((long) 11);
                erpStorageFlow.setOrderId(erpOrder.getId());
                erpStorageFlow.setProductId(erpProduct.getId());
                erpStorageFlow.setAmount(erpProduct.getProductAmount());
                erpStorageFlow.setPrice(erpProduct.getProductPrice());
                erpStorageFlowService.insertErpStorageFlow(erpStorageFlow);
            });
        } catch (Exception e) {
            return AjaxResult.error(e.toString());
        }
        return toAjax(1);
    }

    /**
     * 修改库存销售订单
     */
    @PreAuthorize("@ss.hasPermi('erp:order:edit')")
    @Log(title = "库存销售订单", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody ErpOrder erpOrder)
    {
        return toAjax(erpOrderService.updateErpOrder(erpOrder));
    }

    /**
     * 删除库存销售订单
     */
    @PreAuthorize("@ss.hasPermi('erp:order:remove')")
    @Log(title = "库存销售订单", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(erpOrderService.deleteErpOrderByIds(ids));
    }
}
