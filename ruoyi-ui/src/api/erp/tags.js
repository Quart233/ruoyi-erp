import request from '@/utils/request'

// 查询标签列表
export function listTags(query) {
  return request({
    url: '/erp/tags/list',
    method: 'get',
    params: query
  })
}

// 查询标签详细
export function getTags(tagUuid) {
  return request({
    url: '/erp/tags/' + tagUuid,
    method: 'get'
  })
}

// 新增标签
export function addTags(data) {
  return request({
    url: '/erp/tags',
    method: 'post',
    data: data
  })
}

// 修改标签
export function updateTags(data) {
  return request({
    url: '/erp/tags',
    method: 'put',
    data: data
  })
}

// 删除标签
export function delTags(tagUuid) {
  return request({
    url: '/erp/tags/' + tagUuid,
    method: 'delete'
  })
}

// 导出标签
export function exportTags(query) {
  return request({
    url: '/erp/tags/export',
    method: 'get',
    params: query
  })
}