import request from '@/utils/request'

// 查询库存客户列表
export function listClient(query) {
  return request({
    url: '/erp/client/list',
    method: 'get',
    params: query
  })
}

// 查询库存客户详细
export function getClient(id) {
  return request({
    url: '/erp/client/' + id,
    method: 'get'
  })
}

// 新增库存客户
export function addClient(data) {
  return request({
    url: '/erp/client',
    method: 'post',
    data: data
  })
}

// 修改库存客户
export function updateClient(data) {
  return request({
    url: '/erp/client',
    method: 'put',
    data: data
  })
}

// 删除库存客户
export function delClient(id) {
  return request({
    url: '/erp/client/' + id,
    method: 'delete'
  })
}

// 导出库存客户
export function exportClient(query) {
  return request({
    url: '/erp/client/export',
    method: 'get',
    params: query
  })
}