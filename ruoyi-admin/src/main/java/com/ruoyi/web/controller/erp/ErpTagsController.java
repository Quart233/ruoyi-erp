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
import com.ruoyi.erp.domain.ErpTags;
import com.ruoyi.erp.service.IErpTagsService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 标签Controller
 * 
 * @author kuaizi
 * @date 2021-10-25
 */
@RestController
@RequestMapping("/erp/tags")
public class ErpTagsController extends BaseController
{
    @Autowired
    private IErpTagsService erpTagsService;

    /**
     * 查询标签列表
     */
    @PreAuthorize("@ss.hasPermi('erp:tags:list')")
    @GetMapping("/list")
    public TableDataInfo list(ErpTags erpTags)
    {
        startPage();
        List<ErpTags> list = erpTagsService.selectErpTagsList(erpTags);
        return getDataTable(list);
    }

    /**
     * 导出标签列表
     */
    @PreAuthorize("@ss.hasPermi('erp:tags:export')")
    @Log(title = "标签", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(ErpTags erpTags)
    {
        List<ErpTags> list = erpTagsService.selectErpTagsList(erpTags);
        ExcelUtil<ErpTags> util = new ExcelUtil<ErpTags>(ErpTags.class);
        return util.exportExcel(list, "标签数据");
    }

    /**
     * 获取标签详细信息
     */
    @PreAuthorize("@ss.hasPermi('erp:tags:query')")
    @GetMapping(value = "/{tagUuid}")
    public AjaxResult getInfo(@PathVariable("tagUuid") String tagUuid)
    {
        return AjaxResult.success(erpTagsService.selectErpTagsByTagUuid(tagUuid));
    }

    /**
     * 新增标签
     */
    @PreAuthorize("@ss.hasPermi('erp:tags:add')")
    @Log(title = "标签", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody ErpTags erpTags)
    {
        return toAjax(erpTagsService.insertErpTags(erpTags));
    }

    /**
     * 修改标签
     */
    @PreAuthorize("@ss.hasPermi('erp:tags:edit')")
    @Log(title = "标签", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody ErpTags erpTags)
    {
        return toAjax(erpTagsService.updateErpTags(erpTags));
    }

    /**
     * 删除标签
     */
    @PreAuthorize("@ss.hasPermi('erp:tags:remove')")
    @Log(title = "标签", businessType = BusinessType.DELETE)
	@DeleteMapping("/{tagUuids}")
    public AjaxResult remove(@PathVariable String[] tagUuids)
    {
        return toAjax(erpTagsService.deleteErpTagsByTagUuids(tagUuids));
    }
}
