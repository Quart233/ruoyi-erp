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
import com.ruoyi.erp.domain.ErpProductSn;
import com.ruoyi.erp.service.IErpProductSnService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 商品条码Controller
 * 
 * @author kuaizi
 * @date 2021-10-25
 */
@RestController
@RequestMapping("/erp/sn")
public class ErpProductSnController extends BaseController
{
    @Autowired
    private IErpProductSnService erpProductSnService;

    /**
     * 查询商品条码列表
     */
    @PreAuthorize("@ss.hasPermi('erp:sn:list')")
    @GetMapping("/list")
    public TableDataInfo list(ErpProductSn erpProductSn)
    {
        startPage();
        List<ErpProductSn> list = erpProductSnService.selectErpProductSnList(erpProductSn);
        return getDataTable(list);
    }

    /**
     * 导出商品条码列表
     */
    @PreAuthorize("@ss.hasPermi('erp:sn:export')")
    @Log(title = "商品条码", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(ErpProductSn erpProductSn)
    {
        List<ErpProductSn> list = erpProductSnService.selectErpProductSnList(erpProductSn);
        ExcelUtil<ErpProductSn> util = new ExcelUtil<ErpProductSn>(ErpProductSn.class);
        return util.exportExcel(list, "商品条码数据");
    }

    /**
     * 获取商品条码详细信息
     */
    @PreAuthorize("@ss.hasPermi('erp:sn:query')")
    @GetMapping(value = "/{snUuid}")
    public AjaxResult getInfo(@PathVariable("snUuid") String snUuid)
    {
        return AjaxResult.success(erpProductSnService.selectErpProductSnBySnUuid(snUuid));
    }

    /**
     * 新增商品条码
     */
    @PreAuthorize("@ss.hasPermi('erp:sn:add')")
    @Log(title = "商品条码", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody ErpProductSn erpProductSn)
    {
        return toAjax(erpProductSnService.insertErpProductSn(erpProductSn));
    }

    /**
     * 修改商品条码
     */
    @PreAuthorize("@ss.hasPermi('erp:sn:edit')")
    @Log(title = "商品条码", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody ErpProductSn erpProductSn)
    {
        return toAjax(erpProductSnService.updateErpProductSn(erpProductSn));
    }

    /**
     * 删除商品条码
     */
    @PreAuthorize("@ss.hasPermi('erp:sn:remove')")
    @Log(title = "商品条码", businessType = BusinessType.DELETE)
	@DeleteMapping("/{snUuids}")
    public AjaxResult remove(@PathVariable String[] snUuids)
    {
        return toAjax(erpProductSnService.deleteErpProductSnBySnUuids(snUuids));
    }
}
