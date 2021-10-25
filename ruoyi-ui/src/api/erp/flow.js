import request from '@/utils/request'

// 查询库存流水列表
export function listFlow(query) {
  return request({
    url: '/erp/flow/list',
    method: 'get',
    params: query
  })
}

// 查询库存流水详细
export function getFlow(id) {
  return request({
    url: '/erp/flow/' + id,
    method: 'get'
  })
}

// 新增库存流水
export function addFlow(data) {
  return request({
    url: '/erp/flow',
    method: 'post',
    data: data
  })
}

// 修改库存流水
export function updateFlow(data) {
  return request({
    url: '/erp/flow',
    method: 'put',
    data: data
  })
}

// 删除库存流水
export function delFlow(id) {
  return request({
    url: '/erp/flow/' + id,
    method: 'delete'
  })
}

// 导出库存流水
export function exportFlow(query) {
  return request({
    url: '/erp/flow/export',
    method: 'get',
    params: query
  })
}