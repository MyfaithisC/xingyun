package com.lframework.xingyun.basedata.impl.product;


import com.lframework.starter.mybatis.annotations.OpLog;
import com.lframework.starter.mybatis.enums.OpLogType;
import com.lframework.starter.mybatis.impl.BaseMpServiceImpl;
import com.lframework.starter.mybatis.resp.PageResult;

import com.lframework.xingyun.basedata.dto.product.poly.ProductPolyDto;

import com.lframework.xingyun.basedata.entity.ProductPoly;

import com.lframework.xingyun.basedata.mappers.ProductPolyMapper;

import com.lframework.xingyun.basedata.service.product.IProductPolyService;

import com.lframework.xingyun.basedata.vo.product.poly.CreateProductPolyVo;
import com.lframework.xingyun.basedata.vo.product.poly.QueryProductPolyVo;
import com.lframework.xingyun.basedata.vo.product.poly.UpdateProductPolyVo;

import java.io.Serializable;

import java.util.List;

import lombok.extern.slf4j.Slf4j;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.stereotype.Service;


@Slf4j
@Service
public class ProductPolyServiceImpl extends BaseMpServiceImpl<ProductPolyMapper, ProductPoly>
    implements IProductPolyService {




  @Override
  public PageResult<ProductPoly> query(Integer pageIndex, Integer pageSize,
      QueryProductPolyVo vo) {

    return null;
  }

  @Override
  public List<ProductPoly> query(QueryProductPolyVo vo) {

    return null;
  }

  @Override
  public ProductPolyDto findById(String id) {

    return null;
  }

  @Override
  public List<String> getIdNotInPolyProperty(String propertyId) {

    return null;
  }

  @Override
  public List<String> getIdByCategoryId(String categoryId) {

    return null;
  }

  @OpLog(type = OpLogType.OTHER, name = "新增商品SPU，ID：{}, 货号：{}", params = {"#id", "#code"})
  @Override
  public String create(CreateProductPolyVo vo) {

    return null;
  }

  @OpLog(type = OpLogType.OTHER, name = "修改商品SPU，ID：{}", params = {"#id"})
  @Override
  public void update(UpdateProductPolyVo vo) {

  }

  private ProductPolyDto convertDto(ProductPolyDto dto) {

    return null;
  }

  @CacheEvict(value = ProductPolyDto.CACHE_NAME, key = "#key")
  @Override
  public void cleanCacheByKey(Serializable key) {

  }
}
