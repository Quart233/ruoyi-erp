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
import com.ruoyi.erp.domain.ErpStorageFlow;
import com.ruoyi.erp.service.IErpStorageFlowService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 库存流水Controller
 * 
 * @author kuaizi
 * @date 2021-10-25
 */
@RestController
@RequestMapping("/erp/flow")
public class ErpStorageFlowController extends BaseController
{
    @Autowired
    private IErpStorageFlowService erpStorageFlowService;

    /**
     * 查询库存流水列表
     */
    @PreAuthorize("@ss.hasPermi('erp:flow:list')")
    @GetMapping("/list")
    public TableDataInfo list(ErpStorageFlow erpStorageFlow)
    {
        startPage();
        List<ErpStorageFlow> list = erpStorageFlowService.selectErpStorageFlowList(erpStorageFlow);
        return getDataTable(list);
    }

    /**
     * 导出库存流水列表
     */
    @PreAuthorize("@ss.hasPermi('erp:flow:export')")
    @Log(title = "库存流水", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(ErpStorageFlow erpStorageFlow)
    {
        List<ErpStorageFlow> list = erpStorageFlowService.selectErpStorageFlowList(erpStorageFlow);
        ExcelUtil<ErpStorageFlow> util = new ExcelUtil<ErpStorageFlow>(ErpStorageFlow.class);
        return util.exportExcel(list, "库存流水数据");
    }

    /**
     * 获取库存流水详细信息
     */
    @PreAuthorize("@ss.hasPermi('erp:flow:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(erpStorageFlowService.selectErpStorageFlowById(id));
    }

    /**
     * 新增库存流水
     */
    @PreAuthorize("@ss.hasPermi('erp:flow:add')")
    @Log(title = "库存流水", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody ErpStorageFlow erpStorageFlow)
    {
        return toAjax(erpStorageFlowService.insertErpStorageFlow(erpStorageFlow));
    }

    /**
     * 修改库存流水
     */
    @PreAuthorize("@ss.hasPermi('erp:flow:edit')")
    @Log(title = "库存流水", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody ErpStorageFlow erpStorageFlow)
    {
        return toAjax(erpStorageFlowService.updateErpStorageFlow(erpStorageFlow));
    }

    /**
     * 删除库存流水
     */
    @PreAuthorize("@ss.hasPermi('erp:flow:remove')")
    @Log(title = "库存流水", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(erpStorageFlowService.deleteErpStorageFlowByIds(ids));
    }
}
