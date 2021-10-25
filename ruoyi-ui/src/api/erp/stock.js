import request from '@/utils/request'

// 查询进货流水单列表
export function listStock(query) {
  return request({
    url: '/erp/stock/list',
    method: 'get',
    params: query
  })
}

// 查询进货流水单详细
export function getStock(id) {
  return request({
    url: '/erp/stock/' + id,
    method: 'get'
  })
}

// 新增进货流水单
export function addStock(data) {
  return request({
    url: '/erp/stock',
    method: 'post',
    data: data
  })
}

// 修改进货流水单
export function updateStock(data) {
  return request({
    url: '/erp/stock',
    method: 'put',
    data: data
  })
}

// 删除进货流水单
export function delStock(id) {
  return request({
    url: '/erp/stock/' + id,
    method: 'delete'
  })
}

// 导出进货流水单
export function exportStock(query) {
  return request({
    url: '/erp/stock/export',
    method: 'get',
    params: query
  })
}