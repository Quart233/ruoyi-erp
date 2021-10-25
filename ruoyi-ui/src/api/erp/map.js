import request from '@/utils/request'

// 查询标签映射列表
export function listMap(query) {
  return request({
    url: '/erp/map/list',
    method: 'get',
    params: query
  })
}

// 查询标签映射详细
export function getMap(tagUuid) {
  return request({
    url: '/erp/map/' + tagUuid,
    method: 'get'
  })
}

// 新增标签映射
export function addMap(data) {
  return request({
    url: '/erp/map',
    method: 'post',
    data: data
  })
}

// 修改标签映射
export function updateMap(data) {
  return request({
    url: '/erp/map',
    method: 'put',
    data: data
  })
}

// 删除标签映射
export function delMap(tagUuid) {
  return request({
    url: '/erp/map/' + tagUuid,
    method: 'delete'
  })
}

// 导出标签映射
export function exportMap(query) {
  return request({
    url: '/erp/map/export',
    method: 'get',
    params: query
  })
}