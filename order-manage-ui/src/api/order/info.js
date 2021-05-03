import request from '@/utils/request'

// 查询工单信息列表
export function listInfo(query) {
  return request({
    url: '/order/info/list',
    method: 'get',
    params: query
  })
}

// 查询工单信息详细
export function getInfo(id) {
  return request({
    url: '/order/info/' + id,
    method: 'get'
  })
}

// 新增工单信息
export function addInfo(data) {
  return request({
    url: '/order/info',
    method: 'post',
    data: data
  })
}

// 修改工单信息
export function updateInfo(data) {
  return request({
    url: '/order/info',
    method: 'put',
    data: data
  })
}

// 删除工单信息
export function delInfo(id) {
  return request({
    url: '/order/info/' + id,
    method: 'delete'
  })
}

// 导出工单信息
export function exportInfo(query) {
  return request({
    url: '/order/info/export',
    method: 'get',
    params: query
  })
}