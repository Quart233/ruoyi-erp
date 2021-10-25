package com.ruoyi.web.controller.erp;

import java.util.List;
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
import com.ruoyi.erp.domain.ErpTaxInfo;
import com.ruoyi.erp.service.IErpTaxInfoService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 库存开票信息Controller
 * 
 * @author kuaizi
 * @date 2021-10-25
 */
@RestController
@RequestMapping("/erp/info")
public class ErpTaxInfoController extends BaseController
{
    @Autowired
    private IErpTaxInfoService erpTaxInfoService;

    /**
     * 查询库存开票信息列表
     */
    @PreAuthorize("@ss.hasPermi('erp:info:list')")
    @GetMapping("/list")
    public TableDataInfo list(ErpTaxInfo erpTaxInfo)
    {
        startPage();
        List<ErpTaxInfo> list = erpTaxInfoService.selectErpTaxInfoList(erpTaxInfo);
        return getDataTable(list);
    }

    /**
     * 导出库存开票信息列表
     */
    @PreAuthorize("@ss.hasPermi('erp:info:export')")
    @Log(title = "库存开票信息", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(ErpTaxInfo erpTaxInfo)
    {
        List<ErpTaxInfo> list = erpTaxInfoService.selectErpTaxInfoList(erpTaxInfo);
        ExcelUtil<ErpTaxInfo> util = new ExcelUtil<ErpTaxInfo>(ErpTaxInfo.class);
        return util.exportExcel(list, "库存开票信息数据");
    }

    /**
     * 获取库存开票信息详细信息
     */
    @PreAuthorize("@ss.hasPermi('erp:info:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(erpTaxInfoService.selectErpTaxInfoById(id));
    }

    /**
     * 新增库存开票信息
     */
    @PreAuthorize("@ss.hasPermi('erp:info:add')")
    @Log(title = "库存开票信息", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody ErpTaxInfo erpTaxInfo)
    {
        return toAjax(erpTaxInfoService.insertErpTaxInfo(erpTaxInfo));
    }

    /**
     * 修改库存开票信息
     */
    @PreAuthorize("@ss.hasPermi('erp:info:edit')")
    @Log(title = "库存开票信息", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody ErpTaxInfo erpTaxInfo)
    {
        return toAjax(erpTaxInfoService.updateErpTaxInfo(erpTaxInfo));
    }

    /**
     * 删除库存开票信息
     */
    @PreAuthorize("@ss.hasPermi('erp:info:remove')")
    @Log(title = "库存开票信息", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(erpTaxInfoService.deleteErpTaxInfoByIds(ids));
    }
}
