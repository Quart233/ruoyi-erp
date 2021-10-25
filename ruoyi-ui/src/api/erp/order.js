import request from '@/utils/request'

// 查询库存销售订单列表
export function listOrder(query) {
  return request({
    url: '/erp/order/list',
    method: 'get',
    params: query
  })
}

// 查询库存销售订单详细
export function getOrder(id) {
  return request({
    url: '/erp/order/' + id,
    method: 'get'
  })
}

// 新增库存销售订单
export function addOrder(data) {
  return request({
    url: '/erp/order',
    method: 'post',
    data: data
  })
}

// 修改库存销售订单
export function updateOrder(data) {
  return request({
    url: '/erp/order',
    method: 'put',
    data: data
  })
}

// 删除库存销售订单
export function delOrder(id) {
  return request({
    url: '/erp/order/' + id,
    method: 'delete'
  })
}

// 导出库存销售订单
export function exportOrder(query) {
  return request({
    url: '/erp/order/export',
    method: 'get',
    params: query
  })
}