import request from '@/utils/request'

// 查询库存开票信息列表
export function listInfo(query) {
  return request({
    url: '/erp/info/list',
    method: 'get',
    params: query
  })
}

// 查询库存开票信息详细
export function getInfo(id) {
  return request({
    url: '/erp/info/' + id,
    method: 'get'
  })
}

// 新增库存开票信息
export function addInfo(data) {
  return request({
    url: '/erp/info',
    method: 'post',
    data: data
  })
}

// 修改库存开票信息
export function updateInfo(data) {
  return request({
    url: '/erp/info',
    method: 'put',
    data: data
  })
}

// 删除库存开票信息
export function delInfo(id) {
  return request({
    url: '/erp/info/' + id,
    method: 'delete'
  })
}

// 导出库存开票信息
export function exportInfo(query) {
  return request({
    url: '/erp/info/export',
    method: 'get',
    params: query
  })
}