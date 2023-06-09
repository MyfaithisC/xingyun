package com.lframework.xingyun.api.controller.purchase;

import com.lframework.common.exceptions.impl.DefaultClientException;
import com.lframework.common.utils.CollectionUtil;
import com.lframework.common.utils.StringUtil;
import com.lframework.starter.mybatis.resp.PageResult;
import com.lframework.starter.mybatis.utils.PageResultUtil;
import com.lframework.starter.security.controller.DefaultBaseController;
import com.lframework.starter.web.components.excel.ExcelMultipartWriterSheetBuilder;
import com.lframework.starter.web.resp.InvokeResult;
import com.lframework.starter.web.resp.InvokeResultBuilder;
import com.lframework.starter.web.utils.ExcelUtil;
import com.lframework.xingyun.api.bo.purchase.GetPurchaseOrderBo;
import com.lframework.xingyun.api.bo.purchase.PrintPurchaseOrderBo;
import com.lframework.xingyun.api.bo.purchase.PurchaseOrderWithReceiveBo;
import com.lframework.xingyun.api.bo.purchase.PurchaseProductBo;
import com.lframework.xingyun.api.bo.purchase.QueryPurchaseOrderBo;
import com.lframework.xingyun.api.bo.purchase.QueryPurchaseOrderWithReceiveBo;
import com.lframework.xingyun.api.excel.purchase.PurchaseOrderExportModel;
import com.lframework.xingyun.api.excel.purchase.PurchaseOrderImportListener;
import com.lframework.xingyun.api.excel.purchase.PurchaseOrderImportModel;
import com.lframework.xingyun.api.print.A4ExcelPortraitPrintBo;
import com.lframework.xingyun.basedata.dto.product.info.PurchaseProductDto;
import com.lframework.xingyun.basedata.service.product.IProductService;
import com.lframework.xingyun.basedata.vo.product.info.QueryPurchaseProductVo;
import com.lframework.xingyun.sc.dto.purchase.PurchaseOrderFullDto;
import com.lframework.xingyun.sc.dto.purchase.PurchaseOrderWithReceiveDto;
import com.lframework.xingyun.sc.entity.PurchaseOrder;
import com.lframework.xingyun.sc.service.purchase.IPurchaseOrderService;
import com.lframework.xingyun.sc.vo.purchase.ApprovePassPurchaseOrderVo;
import com.lframework.xingyun.sc.vo.purchase.ApproveRefusePurchaseOrderVo;
import com.lframework.xingyun.sc.vo.purchase.BatchApprovePassPurchaseOrderVo;
import com.lframework.xingyun.sc.vo.purchase.BatchApproveRefusePurchaseOrderVo;
import com.lframework.xingyun.sc.vo.purchase.CreatePurchaseOrderVo;
import com.lframework.xingyun.sc.vo.purchase.QueryPurchaseOrderVo;
import com.lframework.xingyun.sc.vo.purchase.QueryPurchaseOrderWithRecevieVo;
import com.lframework.xingyun.sc.vo.purchase.UpdatePurchaseOrderVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 * 采购订单管理
 *
 * @author zmj
 */
@Api(tags = "采购订单管理")
@Validated
@RestController
@RequestMapping("/purchase/order")
public class PurchaseOrderController extends DefaultBaseController {

  @Autowired
  private IPurchaseOrderService purchaseOrderService;

  @Autowired
  private IProductService productService;



  /**
   * 订单列表
   */
  @ApiOperation("订单列表")
  @PreAuthorize("@permission.valid('purchase:order:query')")
  @GetMapping("/query")
  public InvokeResult<PageResult<QueryPurchaseOrderBo>> query(@Valid QueryPurchaseOrderVo vo) {

    throw new DefaultClientException("订单列表待完成!");
  }


  /**
   * 根据关键字查询商品
   */
  @ApiOperation("根据关键字查询商品")
  @ApiImplicitParams({
      @ApiImplicitParam(value = "仓库ID", name = "scId", paramType = "query", required = true),
      @ApiImplicitParam(value = "关键字", name = "condition", paramType = "query", required = true)})
  @PreAuthorize("@permission.valid('purchase:order:add', 'purchase:order:modify', 'purchase:receive:add', 'purchase:receive:modify', 'purchase:return:add', 'purchase:return:modify')")
  @GetMapping("/product/search")
  public InvokeResult<List<PurchaseProductBo>> searchProducts(
      @NotBlank(message = "仓库ID不能为空！") String scId,
      String condition) {

    throw new DefaultClientException("根据关键字查询商品待完成!");
  }

  /**
   * 查询商品列表
   */
  @ApiOperation("查询商品列表")
  @PreAuthorize("@permission.valid('purchase:order:add', 'purchase:order:modify', 'purchase:receive:add', 'purchase:receive:modify', 'purchase:return:add', 'purchase:return:modify')")
  @GetMapping("/product/list")
  public InvokeResult<PageResult<PurchaseProductBo>> queryProductList(
      @Valid QueryPurchaseProductVo vo) {

    throw new DefaultClientException("查询商品列表待完成!");
  }

  /**
   * 根据ID查询
   */
  @ApiOperation("根据ID查询")
  @ApiImplicitParam(value = "ID", name = "id", paramType = "query", required = true)
  @PreAuthorize("@permission.valid('purchase:order:query')")
  @GetMapping
  public InvokeResult<GetPurchaseOrderBo> findById(@NotBlank(message = "订单ID不能为空！") String id) {

    throw new DefaultClientException("根据ID查询待完成!");
  }

  /**
   * 根据ID查询（收货业务）
   */
  @ApiOperation("根据ID查询（收货业务）")
  @ApiImplicitParam(value = "ID", name = "id", paramType = "query", required = true)
  @PreAuthorize("@permission.valid('purchase:receive:add', 'purchase:receive:modify')")
  @GetMapping("/receive")
  public InvokeResult<PurchaseOrderWithReceiveBo> getWithReceive(
      @NotBlank(message = "订单ID不能为空！") String id) {

    throw new DefaultClientException("根据ID查询（收货业务)待完成!");
  }

  /**
   * 查询列表（收货业务）
   */
  @ApiOperation("查询列表（收货业务）")
  @PreAuthorize("@permission.valid('purchase:receive:add', 'purchase:receive:modify')")
  @GetMapping("/query/receive")
  public InvokeResult<PageResult<QueryPurchaseOrderWithReceiveBo>> getWithReceive(
      @Valid QueryPurchaseOrderWithRecevieVo vo) {

    throw new DefaultClientException("查询列表（收货业务）待完成!");
  }

  /**
   * 创建订单
   */
  @ApiOperation("创建订单")
  @PreAuthorize("@permission.valid('purchase:order:add')")
  @PostMapping
  public InvokeResult<String> create(@RequestBody @Valid CreatePurchaseOrderVo vo) {

    throw new DefaultClientException("创建订单待完成");
  }

  /**
   * 修改订单
   */
  @ApiOperation("修改订单")
  @PreAuthorize("@permission.valid('purchase:order:modify')")
  @PutMapping
  public InvokeResult<Void> update(@RequestBody @Valid UpdatePurchaseOrderVo vo) {

    throw new DefaultClientException("修改订单完成待完成");
  }

  /**
   * 审核通过订单
   */
  @ApiOperation("审核通过订单")
  @PreAuthorize("@permission.valid('purchase:order:approve')")
  @PatchMapping("/approve/pass")
  public InvokeResult<Void> approvePass(@RequestBody @Valid ApprovePassPurchaseOrderVo vo) {

    throw new DefaultClientException("审核通过订单完成待完成");
  }

  /**
   * 批量审核通过订单
   */
  @ApiOperation("批量审核通过订单")
  @PreAuthorize("@permission.valid('purchase:order:approve')")
  @PatchMapping("/approve/pass/batch")
  public InvokeResult<Void> batchApprovePass(
      @RequestBody @Valid BatchApprovePassPurchaseOrderVo vo) {

    throw new DefaultClientException("批量审核通过订单待完成");
  }

  /**
   * 直接审核通过订单
   */
  @ApiOperation("直接审核通过订单")
  @PreAuthorize("@permission.valid('purchase:order:approve')")
  @PostMapping("/approve/pass/direct")
  public InvokeResult<Void> directApprovePass(@RequestBody @Valid CreatePurchaseOrderVo vo) {

    throw new DefaultClientException("直接审核通过订单待完成");
  }

  /**
   * 审核拒绝订单
   */
  @ApiOperation("审核拒绝订单")
  @PreAuthorize("@permission.valid('purchase:order:approve')")
  @PatchMapping("/approve/refuse")
  public InvokeResult<Void> approveRefuse(@RequestBody @Valid ApproveRefusePurchaseOrderVo vo) {

    throw new DefaultClientException("审核拒绝订单待完成");
  }

  /**
   * 批量审核拒绝订单
   */
  @ApiOperation("批量审核拒绝订单")
  @PreAuthorize("@permission.valid('purchase:order:approve')")
  @PatchMapping("/approve/refuse/batch")
  public InvokeResult<Void> batchApproveRefuse(
      @RequestBody @Valid BatchApproveRefusePurchaseOrderVo vo) {

    throw new DefaultClientException("批量审核拒绝订单待完成");
  }

  /**
   * 删除订单
   */
  @ApiOperation("删除订单")
  @ApiImplicitParam(value = "ID", name = "id", paramType = "query", required = true)
  @PreAuthorize("@permission.valid('purchase:order:delete')")
  @DeleteMapping
  public InvokeResult<Void> deleteById(@NotBlank(message = "订单ID不能为空！") String id) {

    throw new DefaultClientException("删除订单待完成");
  }

  /**
   * 批量删除订单
   */
  @ApiOperation("批量删除订单")
  @PreAuthorize("@permission.valid('purchase:order:delete')")
  @DeleteMapping("/batch")
  public InvokeResult<Void> deleteByIds(
      @ApiParam(value = "ID", required = true) @RequestBody @NotEmpty(message = "请选择需要删除的订单！") List<String> ids) {

    throw new DefaultClientException("批量删除订单待完成");
  }

  /**
   * 取消审核订单
   */
  @ApiOperation("取消审核订单")
  @ApiImplicitParam(value = "ID", name = "id", paramType = "query", required = true)
  @PreAuthorize("@permission.valid('purchase:order:approve')")
  @PatchMapping("/approve/cancel")
  public InvokeResult<Void> cancelApprovePass(@NotBlank(message = "订单ID不能为空！") String id) {

    throw new DefaultClientException("取消审核订单待完成");
  }

  @ApiOperation("下载导入模板")
  @PreAuthorize("@permission.valid('purchase:order:import')")
  @GetMapping("/import/template")
  public void downloadImportTemplate() {
    ExcelUtil.exportXls("采购订单导入模板", PurchaseOrderImportModel.class);
  }

  @ApiOperation("导入")
  @PreAuthorize("@permission.valid('purchase:order:import')")
  @PostMapping("/import")
  public InvokeResult<Void> importExcel(@NotBlank(message = "ID不能为空") String id,
      @NotNull(message = "请上传文件") MultipartFile file) {

    PurchaseOrderImportListener listener = new PurchaseOrderImportListener();
    listener.setTaskId(id);
    ExcelUtil.read(file, PurchaseOrderImportModel.class, listener).sheet().doRead();

    return InvokeResultBuilder.success();
  }

  /**
   * 打印
   */
  @ApiOperation("打印")
  @ApiImplicitParam(value = "ID", name = "id", paramType = "query", required = true)
  @PreAuthorize("@permission.valid('purchase:order:query')")
  @GetMapping("/print")
  public InvokeResult<A4ExcelPortraitPrintBo<PrintPurchaseOrderBo>> print(
          @NotBlank(message = "订单ID不能为空！") String id) {

    PurchaseOrderFullDto data = purchaseOrderService.getDetail(id);
    if (data == null) {
      throw new DefaultClientException("订单不存在！");
    }

    PrintPurchaseOrderBo result = new PrintPurchaseOrderBo(data);

    A4ExcelPortraitPrintBo<PrintPurchaseOrderBo> printResult = new A4ExcelPortraitPrintBo<>(
            "print/purchase-order.ftl", result);

    return InvokeResultBuilder.success(printResult);
  }

  /**
   * 导出
   */
  @ApiOperation("导出")
  @PreAuthorize("@permission.valid('purchase:order:export')")
  @PostMapping("/export")
  public void export(@Valid QueryPurchaseOrderVo vo) {

    ExcelMultipartWriterSheetBuilder builder = ExcelUtil.multipartExportXls("采购单信息",
            PurchaseOrderExportModel.class);

    try {
      int pageIndex = 1;
      while (true) {
        PageResult<PurchaseOrder> pageResult = purchaseOrderService.query(pageIndex,
                getExportSize(), vo);
        List<PurchaseOrder> datas = pageResult.getDatas();
        List<PurchaseOrderExportModel> models = datas.stream().map(PurchaseOrderExportModel::new)
                .collect(Collectors.toList());
        builder.doWrite(models);

        if (!pageResult.isHasNext()) {
          break;
        }
        pageIndex++;
      }
    } finally {
      builder.finish();
    }
  }
}
