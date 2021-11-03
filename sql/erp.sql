-- --------------------------------------------------------
-- 主机:                           TenHK
-- 服务器版本:                        10.6.4-MariaDB-1:10.6.4+maria~focal - mariadb.org binary distribution
-- 服务器操作系统:                      debian-linux-gnu
-- HeidiSQL 版本:                  11.3.0.6295
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

-- 导出  表 ry-vue.erp_client 结构
CREATE TABLE IF NOT EXISTS `erp_client` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '客户ID',
  `client_nickname` varchar(50) DEFAULT NULL COMMENT '客户名称',
  `client_phone` varchar(50) DEFAULT NULL COMMENT '客户手机',
  `shipping_address` varchar(255) DEFAULT NULL COMMENT '客户收货地址',
  `gender` int(11) DEFAULT NULL COMMENT '性别 先生:0 女士:1',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb4 COMMENT='库存客户表';

-- 数据导出被取消选择。

-- 导出  表 ry-vue.erp_order 结构
CREATE TABLE IF NOT EXISTS `erp_order` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '销售订单ID',
  `order_name` varchar(255) DEFAULT NULL COMMENT '订单名称',
  `create_time` datetime(6) DEFAULT NULL COMMENT '创建时间',
  `tax_info_id` int(11) DEFAULT NULL COMMENT '开票信息ID',
  `total_price` double(16,2) DEFAULT NULL COMMENT '订单金额',
  `actual_payment` double(16,2) DEFAULT NULL COMMENT '实付金额',
  `handler_name` varchar(125) DEFAULT NULL COMMENT '经手人姓名',
  `client_id` int(11) DEFAULT NULL COMMENT '客户ID',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb4 COMMENT='库存销售订单表';

-- 数据导出被取消选择。

-- 导出  表 ry-vue.erp_product 结构
CREATE TABLE IF NOT EXISTS `erp_product` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '产品ID',
  `product_name` varchar(50) DEFAULT NULL COMMENT '名称',
  `product_model` varchar(50) DEFAULT NULL COMMENT '型号',
  `product_unit` varchar(50) DEFAULT NULL COMMENT '单位',
  `product_price` double(16,2) unsigned DEFAULT NULL COMMENT '销售价格',
  `product_remark` varchar(120) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COMMENT='库存产品表';

-- 数据导出被取消选择。

-- 导出  表 ry-vue.erp_product_sn 结构
CREATE TABLE IF NOT EXISTS `erp_product_sn` (
  `sn_uuid` varchar(255) NOT NULL,
  `sn_code` varchar(255) DEFAULT NULL COMMENT '商品sn条码',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `product_id` int(11) DEFAULT NULL COMMENT '产品ID',
  `status` int(11) DEFAULT NULL COMMENT '在库: 0 已出库: 1',
  PRIMARY KEY (`sn_uuid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='商品条码表';

-- 数据导出被取消选择。

-- 导出  表 ry-vue.erp_retail 结构
CREATE TABLE IF NOT EXISTS `erp_retail` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '零售出货单ID',
  `flow_id` int(11) DEFAULT NULL COMMENT '库存流水ID',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `actual_payment` double(16,2) DEFAULT NULL COMMENT '实付金额',
  `handler_name` varchar(50) DEFAULT NULL COMMENT '经手人',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  `sn_uuid` varchar(255) DEFAULT NULL COMMENT '商品条码 UUID',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='零售出库表';

-- 数据导出被取消选择。

-- 导出  表 ry-vue.erp_stock_order 结构
CREATE TABLE IF NOT EXISTS `erp_stock_order` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '进货单ID',
  `flow_id` int(11) DEFAULT NULL COMMENT '订单流水ID',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `total_price` double(16,2) DEFAULT NULL COMMENT '应付总金额',
  `actual_payment` double(16,2) DEFAULT NULL COMMENT '实付总金额',
  `supplier_name` varchar(50) DEFAULT NULL COMMENT '供应商名称',
  `handler_name` varchar(120) DEFAULT NULL COMMENT '经手人',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='进货流水单表';

-- 数据导出被取消选择。

-- 导出  表 ry-vue.erp_storage_flow 结构
CREATE TABLE IF NOT EXISTS `erp_storage_flow` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '库存流水ID',
  `product_id` int(11) DEFAULT NULL COMMENT '产品ID',
  `amount` int(11) DEFAULT NULL COMMENT '数量',
  `order_type` int(11) DEFAULT NULL COMMENT '流水类型: 采购入库 00, 零售退货入库 01, 工程退货入库 02, 零售出库 10, 工程出库 11, 采购出库 12',
  `price` double(16,2) DEFAULT NULL COMMENT '流水金额',
  `remark` varchar(120) DEFAULT NULL COMMENT '备注',
  `order_id` int(11) DEFAULT NULL COMMENT '订单ID',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb4 COMMENT='库存流水表';

-- 数据导出被取消选择。

-- 导出  表 ry-vue.erp_tags 结构
CREATE TABLE IF NOT EXISTS `erp_tags` (
  `tag_uuid` varchar(255) NOT NULL DEFAULT uuid() COMMENT '标签 UUID',
  `tag_name` varchar(255) DEFAULT NULL COMMENT '标签名',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  `color` varchar(255) CHARACTER SET utf8mb3 DEFAULT NULL COMMENT '标签颜色',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`tag_uuid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='标签表';

-- 数据导出被取消选择。

-- 导出  表 ry-vue.erp_tags_map 结构
CREATE TABLE IF NOT EXISTS `erp_tags_map` (
  `tag_uuid` varchar(255) DEFAULT NULL COMMENT '产品条码 UUID',
  `product_id` int(11) DEFAULT NULL COMMENT '产品 ID'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='标签映射表';

-- 数据导出被取消选择。

-- 导出  表 ry-vue.erp_tax_info 结构
CREATE TABLE IF NOT EXISTS `erp_tax_info` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '开票信息 ID',
  `taxpayer_id` varchar(255) DEFAULT NULL COMMENT '纳税人识别号',
  `company_name` varchar(120) DEFAULT NULL COMMENT '公司名称',
  `company_address` varchar(120) DEFAULT NULL COMMENT '公司地址',
  `contact_tel` varchar(50) DEFAULT NULL COMMENT '联系电话',
  `bank_account` varchar(120) DEFAULT NULL COMMENT '银行账户',
  `deposit_bank` varchar(120) DEFAULT NULL COMMENT '开户行',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb4 COMMENT='库存开票信息表';

-- 数据导出被取消选择。

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;
