import request from '@/utils/request'

// 查询商品条码列表
export function listSn(query) {
  return request({
    url: '/erp/sn/list',
    method: 'get',
    params: query
  })
}

// 查询商品条码详细
export function getSn(snUuid) {
  return request({
    url: '/erp/sn/' + snUuid,
    method: 'get'
  })
}

// 新增商品条码
export function addSn(data) {
  return request({
    url: '/erp/sn',
    method: 'post',
    data: data
  })
}

// 修改商品条码
export function updateSn(data) {
  return request({
    url: '/erp/sn',
    method: 'put',
    data: data
  })
}

// 删除商品条码
export function delSn(snUuid) {
  return request({
    url: '/erp/sn/' + snUuid,
    method: 'delete'
  })
}

// 导出商品条码
export function exportSn(query) {
  return request({
    url: '/erp/sn/export',
    method: 'get',
    params: query
  })
}