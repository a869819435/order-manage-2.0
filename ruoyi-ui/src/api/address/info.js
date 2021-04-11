import request from '@/utils/request'

// 查询地址经纬度信息列表
export function listInfo(query) {
  return request({
    url: '/address/info/list',
    method: 'get',
    params: query
  })
}

// 查询地址经纬度信息详细
export function getInfo(id) {
  return request({
    url: '/address/info/' + id,
    method: 'get'
  })
}

// 新增地址经纬度信息
export function addInfo(data) {
  return request({
    url: '/address/info',
    method: 'post',
    data: data
  })
}

// 修改地址经纬度信息
export function updateInfo(data) {
  return request({
    url: '/address/info',
    method: 'put',
    data: data
  })
}

// 删除地址经纬度信息
export function delInfo(id) {
  return request({
    url: '/address/info/' + id,
    method: 'delete'
  })
}

// 导出地址经纬度信息
export function exportInfo(query) {
  return request({
    url: '/address/info/export',
    method: 'get',
    params: query
  })
}