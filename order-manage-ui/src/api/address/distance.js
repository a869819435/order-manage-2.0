import request from '@/utils/request'

// 查询地址间距信息列表
export function listDistance(query) {
  return request({
    url: '/address/distance/list',
    method: 'get',
    params: query
  })
}

// 查询地址间距信息详细
export function getDistance(id) {
  return request({
    url: '/address/distance/' + id,
    method: 'get'
  })
}

// 新增地址间距信息
export function addDistance(data) {
  return request({
    url: '/address/distance',
    method: 'post',
    data: data
  })
}

// 修改地址间距信息
export function updateDistance(data) {
  return request({
    url: '/address/distance',
    method: 'put',
    data: data
  })
}

// 删除地址间距信息
export function delDistance(id) {
  return request({
    url: '/address/distance/' + id,
    method: 'delete'
  })
}

// 导出地址间距信息
export function exportDistance(query) {
  return request({
    url: '/address/distance/export',
    method: 'get',
    params: query
  })
}
