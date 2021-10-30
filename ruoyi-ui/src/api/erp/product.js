import request from '@/utils/request'

// 按标签查询产品
export function querPorductByTags(data) {
  return request({
    url: '/erp/product/querPorductByTags',
    method: 'post',
    data: data
  })
}

// 查询库存产品列表
export function listProduct(query) {
  return request({
    url: '/erp/product/list',
    method: 'get',
    params: query
  })
}

// 查询库存产品详细
export function getProduct(id) {
  return request({
    url: '/erp/product/' + id,
    method: 'get'
  })
}

// 新增库存产品
export function addProduct(data) {
  return request({
    url: '/erp/product',
    method: 'post',
    data: data
  })
}

// 修改库存产品
export function updateProduct(data) {
  return request({
    url: '/erp/product',
    method: 'put',
    data: data
  })
}

// 删除库存产品
export function delProduct(id) {
  return request({
    url: '/erp/product/' + id,
    method: 'delete'
  })
}

// 导出库存产品
export function exportProduct(query) {
  return request({
    url: '/erp/product/export',
    method: 'get',
    params: query
  })
}