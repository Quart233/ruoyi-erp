-- 注意此脚本只用于验证表关系，请勿在生产环境中执行
TRUNCATE erp_client;
TRUNCATE erp_tax_info;
TRUNCATE erp_order;
TRUNCATE erp_storage_flow;

START TRANSACTION;
-- 新增客户信息
INSERT INTO erp_client (client_nickname, client_phone, shipping_address, gender) VALUES ("客户姓名", 13450774120, "送货地址", 0);

-- 新增开票信息
INSERT INTO erp_tax_info (taxpayer_id, company_name, company_address, contact_tel, bank_account, deposit_bank) VALUES ("914406067578958547", "公司名称", "公司地址", "联系电话", "银行账户", "开户行");

-- 新增订单
INSERT INTO erp_order (order_name, tax_info_id, total_price, actual_payment, handler_name, client_id, remark) VALUES ("订单名称", 1, 399.00, 399.00, "经手人", 1, "测试订单");

-- 新增订单流水
INSERT INTO erp_storage_flow(product_id, amount, order_type, price, order_id, remark) VALUES (1, 1, 10, 399.00, 1, "零售出库");
INSERT INTO erp_storage_flow(product_id, amount, order_type, price, order_id, remark) VALUES (1, 1, 10, 399.00, 1, "零售出库");

COMMIT