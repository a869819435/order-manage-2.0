import request from '@/utils/request'

// 查询交易记录列表
export function listTrading(query) {
  return request({
    url: '/system/trading/list',
    method: 'get',
    params: query
  })
}

// 查询交易记录详细
export function getTrading(id) {
  return request({
    url: '/system/trading/' + id,
    method: 'get'
  })
}

// 新增交易记录
export function addTrading(data) {
  return request({
    url: '/system/trading',
    method: 'post',
    data: data
  })
}

// 修改交易记录
export function updateTrading(data) {
  return request({
    url: '/system/trading',
    method: 'put',
    data: data
  })
}

// 删除交易记录
export function delTrading(id) {
  return request({
    url: '/system/trading/' + id,
    method: 'delete'
  })
}

// 导出交易记录
export function exportTrading(query) {
  return request({
    url: '/system/trading/export',
    method: 'get',
    params: query
  })
}