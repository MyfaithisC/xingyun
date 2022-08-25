ERP 项目说明



## ERP后台 xingyun

### 系统功能
| 系统功能   | 功能描述                          |
|--------|-------------------------------|
| 系统管理   | 系统设置、菜单、部门、角色、岗位、用户、操作日志      |
| 基础信息   | 仓库、供应商、客户、会员基础信息              |
| 商品中心   | 商品主数据、类目、品牌、销售属性、属性（自定义属性）    |
| 采购管理   | 采购订单、收货单、退货单                  |
| 销售管理   | 销售订单、出库单、退货单                  |
| 零售管理   | 零售出库单、退货单                     |
| 库存管理   | 商品库存、商品批次库存、批次库存变动记录          |
| 库存盘点   | 盘点参数设置、预先盘点单管理、盘点任务管理、盘点单管理   |
| 库存调整   | 库存成本调整                        |
| 结算管理   | 供应商费用单、预付款单、对账单、结算单、收入/支出项目   |
| BPM工作流 | 整合AgileBPM工作流管理平台实现工作流的设计、审批等 |

### 主要技术框架

* Springboot 2.2.2.RELEASE
* MyBatis-plus 3.4.2
* Spring-session-data-redis 2.2.0.RELEASE
* HuTool 5.7.17
* Lombok 1.18.10
* EasyExcel 2.2.10（内置了两种导出excel方式：一次性导出、分段导出（只支持简单表头））

### 开发环境

* JDK 1.8
* Mysql 5.7.18
* Redis 4.0.8（版本可以根据自己的redis进行调整，项目本身依赖Redis的功能很简单，就是两部分：缓存、Session，不会出现大的兼容问题）

### 集成第三方库

<a href="https://gitee.com/agile-bpm/agile-bpm-basic" target="_blank">AgileBPM</a> 工作流管理平台

<a href="https://gitee.com/dromara/sa-token" target="_blank">Sa-Token</a> 统一用户鉴权

<a href="https://gitee.com/ld/J2Cache" target="_blank">J2Cache</a> 基于内存和Redis的两级Java缓存框架

<a href="https://gitee.com/xiaoym/knife4j" target="_blank">knife4j</a> knife4j是为Java MVC框架集成Swagger生成Api文档的工具



## 前端 xingyun-front

### 基础环境

* node 版本     v14.18.2

### 安装运行

* npm install 
* npm run dev 
