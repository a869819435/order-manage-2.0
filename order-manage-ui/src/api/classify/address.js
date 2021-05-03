import request from '@/utils/request'

// 查询地址分类列表
export function listAddress(query) {
  return request({
    url: '/classify/address/list',
    method: 'get',
    params: query
  })
}

// 查询地址分类详细
export function getAddress(id) {
  return request({
    url: '/classify/address/' + id,
    method: 'get'
  })
}

// 新增地址分类
export function addAddress(data) {
  return request({
    url: '/classify/address',
    method: 'post',
    data: data
  })
}

// 修改地址分类
export function updateAddress(data) {
  return request({
    url: '/classify/address',
    method: 'put',
    data: data
  })
}

// 删除地址分类
export function delAddress(id) {
  return request({
    url: '/classify/address/' + id,
    method: 'delete'
  })
}

// 导出地址分类
export function exportAddress(query) {
  return request({
    url: '/classify/address/export',
    method: 'get',
    params: query
  })
}