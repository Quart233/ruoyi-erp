package com.ruoyi.web.controller.erp;

import java.util.List;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
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
import com.ruoyi.erp.domain.ErpProduct;
import com.ruoyi.erp.service.IErpProductService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 库存产品Controller
 * 
 * @author kuaizi
 * @date 2021-10-25
 */
@Api("产品信息管理")
@RestController
@RequestMapping("/erp/product")
public class ErpProductController extends BaseController
{
    @Autowired
    private IErpProductService erpProductService;

    /**
     * 查询库存产品列表
     */
    @ApiOperation("查询库存产品列表")
    @PreAuthorize("@ss.hasPermi('erp:product:list')")
    @GetMapping("/list")
    public TableDataInfo list(ErpProduct erpProduct)
    {
        startPage();
        List<ErpProduct> list = erpProductService.selectErpProductList(erpProduct);
        return getDataTable(list);
    }

    /**
     * 导出库存产品列表
     */
    @PreAuthorize("@ss.hasPermi('erp:product:export')")
    @Log(title = "库存产品", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(ErpProduct erpProduct)
    {
        List<ErpProduct> list = erpProductService.selectErpProductList(erpProduct);
        ExcelUtil<ErpProduct> util = new ExcelUtil<ErpProduct>(ErpProduct.class);
        return util.exportExcel(list, "库存产品数据");
    }

    /**
     * 获取库存产品详细信息
     */
    @PreAuthorize("@ss.hasPermi('erp:product:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(erpProductService.selectErpProductById(id));
    }

    /**
     * 新增库存产品
     */
    @PreAuthorize("@ss.hasPermi('erp:product:add')")
    @Log(title = "库存产品", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody ErpProduct erpProduct)
    {
        return toAjax(erpProductService.insertErpProduct(erpProduct));
    }

    /**
     * 修改库存产品
     */
    @PreAuthorize("@ss.hasPermi('erp:product:edit')")
    @Log(title = "库存产品", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody ErpProduct erpProduct)
    {
        return toAjax(erpProductService.updateErpProduct(erpProduct));
    }

    /**
     * 删除库存产品
     */
    @PreAuthorize("@ss.hasPermi('erp:product:remove')")
    @Log(title = "库存产品", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(erpProductService.deleteErpProductByIds(ids));
    }
}
