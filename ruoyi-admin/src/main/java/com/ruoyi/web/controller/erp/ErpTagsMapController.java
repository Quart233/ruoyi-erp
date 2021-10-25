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
import com.ruoyi.erp.domain.ErpTagsMap;
import com.ruoyi.erp.service.IErpTagsMapService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 标签映射Controller
 * 
 * @author kuaizi
 * @date 2021-10-25
 */
@RestController
@RequestMapping("/erp/map")
public class ErpTagsMapController extends BaseController
{
    @Autowired
    private IErpTagsMapService erpTagsMapService;

    /**
     * 查询标签映射列表
     */
    @PreAuthorize("@ss.hasPermi('erp:map:list')")
    @GetMapping("/list")
    public TableDataInfo list(ErpTagsMap erpTagsMap)
    {
        startPage();
        List<ErpTagsMap> list = erpTagsMapService.selectErpTagsMapList(erpTagsMap);
        return getDataTable(list);
    }

    /**
     * 导出标签映射列表
     */
    @PreAuthorize("@ss.hasPermi('erp:map:export')")
    @Log(title = "标签映射", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(ErpTagsMap erpTagsMap)
    {
        List<ErpTagsMap> list = erpTagsMapService.selectErpTagsMapList(erpTagsMap);
        ExcelUtil<ErpTagsMap> util = new ExcelUtil<ErpTagsMap>(ErpTagsMap.class);
        return util.exportExcel(list, "标签映射数据");
    }

    /**
     * 获取标签映射详细信息
     */
    @PreAuthorize("@ss.hasPermi('erp:map:query')")
    @GetMapping(value = "/{tagUuid}")
    public AjaxResult getInfo(@PathVariable("tagUuid") String tagUuid)
    {
        return AjaxResult.success(erpTagsMapService.selectErpTagsMapByTagUuid(tagUuid));
    }

    /**
     * 新增标签映射
     */
    @PreAuthorize("@ss.hasPermi('erp:map:add')")
    @Log(title = "标签映射", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody ErpTagsMap erpTagsMap)
    {
        return toAjax(erpTagsMapService.insertErpTagsMap(erpTagsMap));
    }

    /**
     * 修改标签映射
     */
    @PreAuthorize("@ss.hasPermi('erp:map:edit')")
    @Log(title = "标签映射", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody ErpTagsMap erpTagsMap)
    {
        return toAjax(erpTagsMapService.updateErpTagsMap(erpTagsMap));
    }

    /**
     * 删除标签映射
     */
    @PreAuthorize("@ss.hasPermi('erp:map:remove')")
    @Log(title = "标签映射", businessType = BusinessType.DELETE)
	@DeleteMapping("/{tagUuids}")
    public AjaxResult remove(@PathVariable String[] tagUuids)
    {
        return toAjax(erpTagsMapService.deleteErpTagsMapByTagUuids(tagUuids));
    }
}
