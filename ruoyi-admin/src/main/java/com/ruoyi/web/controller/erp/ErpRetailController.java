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
import com.ruoyi.erp.domain.ErpRetail;
import com.ruoyi.erp.service.IErpRetailService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 零售出库Controller
 * 
 * @author kuaizi
 * @date 2021-10-25
 */
@RestController
@RequestMapping("/erp/retail")
public class ErpRetailController extends BaseController
{
    @Autowired
    private IErpRetailService erpRetailService;

    /**
     * 查询零售出库列表
     */
    @PreAuthorize("@ss.hasPermi('erp:retail:list')")
    @GetMapping("/list")
    public TableDataInfo list(ErpRetail erpRetail)
    {
        startPage();
        List<ErpRetail> list = erpRetailService.selectErpRetailList(erpRetail);
        return getDataTable(list);
    }

    /**
     * 导出零售出库列表
     */
    @PreAuthorize("@ss.hasPermi('erp:retail:export')")
    @Log(title = "零售出库", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(ErpRetail erpRetail)
    {
        List<ErpRetail> list = erpRetailService.selectErpRetailList(erpRetail);
        ExcelUtil<ErpRetail> util = new ExcelUtil<ErpRetail>(ErpRetail.class);
        return util.exportExcel(list, "零售出库数据");
    }

    /**
     * 获取零售出库详细信息
     */
    @PreAuthorize("@ss.hasPermi('erp:retail:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(erpRetailService.selectErpRetailById(id));
    }

    /**
     * 新增零售出库
     */
    @PreAuthorize("@ss.hasPermi('erp:retail:add')")
    @Log(title = "零售出库", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody ErpRetail erpRetail)
    {
        return toAjax(erpRetailService.insertErpRetail(erpRetail));
    }

    /**
     * 修改零售出库
     */
    @PreAuthorize("@ss.hasPermi('erp:retail:edit')")
    @Log(title = "零售出库", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody ErpRetail erpRetail)
    {
        return toAjax(erpRetailService.updateErpRetail(erpRetail));
    }

    /**
     * 删除零售出库
     */
    @PreAuthorize("@ss.hasPermi('erp:retail:remove')")
    @Log(title = "零售出库", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(erpRetailService.deleteErpRetailByIds(ids));
    }
}
