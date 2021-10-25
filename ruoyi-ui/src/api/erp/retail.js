import request from '@/utils/request'

// 查询零售出库列表
export function listRetail(query) {
  return request({
    url: '/erp/retail/list',
    method: 'get',
    params: query
  })
}

// 查询零售出库详细
export function getRetail(id) {
  return request({
    url: '/erp/retail/' + id,
    method: 'get'
  })
}

// 新增零售出库
export function addRetail(data) {
  return request({
    url: '/erp/retail',
    method: 'post',
    data: data
  })
}

// 修改零售出库
export function updateRetail(data) {
  return request({
    url: '/erp/retail',
    method: 'put',
    data: data
  })
}

// 删除零售出库
export function delRetail(id) {
  return request({
    url: '/erp/retail/' + id,
    method: 'delete'
  })
}

// 导出零售出库
export function exportRetail(query) {
  return request({
    url: '/erp/retail/export',
    method: 'get',
    params: query
  })
}