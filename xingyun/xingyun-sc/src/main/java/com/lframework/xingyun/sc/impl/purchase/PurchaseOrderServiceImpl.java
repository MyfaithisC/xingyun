package com.lframework.xingyun.sc.impl.purchase;


import com.lframework.starter.mybatis.annotations.OpLog;
import com.lframework.starter.mybatis.enums.OpLogType;
import com.lframework.starter.mybatis.impl.BaseMpServiceImpl;
import com.lframework.starter.mybatis.resp.PageResult;

import com.lframework.xingyun.sc.dto.purchase.PurchaseOrderFullDto;
import com.lframework.xingyun.sc.dto.purchase.PurchaseOrderWithReceiveDto;
import com.lframework.xingyun.sc.entity.PurchaseOrder;
import com.lframework.xingyun.sc.mappers.PurchaseOrderMapper;
import com.lframework.xingyun.sc.service.purchase.IPurchaseOrderService;
import com.lframework.xingyun.sc.vo.purchase.ApprovePassPurchaseOrderVo;
import com.lframework.xingyun.sc.vo.purchase.ApproveRefusePurchaseOrderVo;
import com.lframework.xingyun.sc.vo.purchase.BatchApprovePassPurchaseOrderVo;
import com.lframework.xingyun.sc.vo.purchase.BatchApproveRefusePurchaseOrderVo;
import com.lframework.xingyun.sc.vo.purchase.CreatePurchaseOrderVo;
import com.lframework.xingyun.sc.vo.purchase.PurchaseOrderSelectorVo;
import com.lframework.xingyun.sc.vo.purchase.QueryPurchaseOrderVo;
import com.lframework.xingyun.sc.vo.purchase.QueryPurchaseOrderWithRecevieVo;
import com.lframework.xingyun.sc.vo.purchase.UpdatePurchaseOrderVo;

import java.util.List;
import org.springframework.stereotype.Service;


@Service
public class PurchaseOrderServiceImpl extends BaseMpServiceImpl<PurchaseOrderMapper, PurchaseOrder>
    implements IPurchaseOrderService {



  @Override
  public PageResult<PurchaseOrder> query(Integer pageIndex, Integer pageSize,
      QueryPurchaseOrderVo vo) {

    return null;
  }

  @Override
  public List<PurchaseOrder> query(QueryPurchaseOrderVo vo) {

    return null;
  }

  @Override
  public PageResult<PurchaseOrder> selector(Integer pageIndex, Integer pageSize,
      PurchaseOrderSelectorVo vo) {

    return null;
  }

  @Override
  public PurchaseOrderFullDto getDetail(String id) {

    return null;
  }

  @Override
  public PurchaseOrderWithReceiveDto getWithReceive(String id) {

    return null;
  }

  @Override
  public PageResult<PurchaseOrder> queryWithReceive(Integer pageIndex, Integer pageSize,
      QueryPurchaseOrderWithRecevieVo vo) {

    return null;
  }

  @OpLog(type = OpLogType.OTHER, name = "创建订单，单号：{}", params = "#code")

  @Override
  public String create(CreatePurchaseOrderVo vo) {

    return null;
  }

  @OpLog(type = OpLogType.OTHER, name = "修改订单，单号：{}", params = "#code")

  @Override
  public void update(UpdatePurchaseOrderVo vo) {


  }

  @OpLog(type = OpLogType.OTHER, name = "审核通过订单，单号：{}", params = "#code")

  @Override
  public void approvePass(ApprovePassPurchaseOrderVo vo) {


  }


  @Override
  public void batchApprovePass(BatchApprovePassPurchaseOrderVo vo) {


  }


  @Override
  public void directApprovePass(CreatePurchaseOrderVo vo) {


  }

  @OpLog(type = OpLogType.OTHER, name = "审核拒绝订单，单号：{}", params = "#code")

  @Override
  public void approveRefuse(ApproveRefusePurchaseOrderVo vo) {


  }


  @Override
  public void batchApproveRefuse(BatchApproveRefusePurchaseOrderVo vo) {


  }

  @OpLog(type = OpLogType.OTHER, name = "删除订单，单号：{}", params = "#code")

  @Override
  public void deleteById(String id) {


  }


  @Override
  public void deleteByIds(List<String> ids) {


  }

  @OpLog(type = OpLogType.OTHER, name = "取消审核订单，单号：{}", params = "#code")
  @Override
  public void cancelApprovePass(String id) {


  }

  private void create(PurchaseOrder order, CreatePurchaseOrderVo vo) {

  }

  private void sendApprovePassEvent(PurchaseOrder order) {


  }
}
