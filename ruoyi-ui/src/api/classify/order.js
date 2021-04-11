import request from '@/utils/request'

// 查询工单分类列表
export function listOrder(query) {
  return request({
    url: '/classify/order/list',
    method: 'get',
    params: query
  })
}

// 查询工单分类详细
export function getOrder(id) {
  return request({
    url: '/classify/order/' + id,
    method: 'get'
  })
}

// 新增工单分类
export function addOrder(data) {
  return request({
    url: '/classify/order',
    method: 'post',
    data: data
  })
}

// 修改工单分类
export function updateOrder(data) {
  return request({
    url: '/classify/order',
    method: 'put',
    data: data
  })
}

// 删除工单分类
export function delOrder(id) {
  return request({
    url: '/classify/order/' + id,
    method: 'delete'
  })
}

// 导出工单分类
export function exportOrder(query) {
  return request({
    url: '/classify/order/export',
    method: 'get',
    params: query
  })
}