import request from '@/utils/request'

// 查询工单评价列表
export function listIncome(query) {
  return request({
    url: '/order/income/list',
    method: 'get',
    params: query
  })
}

// 查询工单评价详细
export function getIncome(id) {
  return request({
    url: '/order/income/' + id,
    method: 'get'
  })
}

// 新增工单评价
export function addIncome(data) {
  return request({
    url: '/order/income',
    method: 'post',
    data: data
  })
}

// 修改工单评价
export function updateIncome(data) {
  return request({
    url: '/order/income',
    method: 'put',
    data: data
  })
}

// 删除工单评价
export function delIncome(id) {
  return request({
    url: '/order/income/' + id,
    method: 'delete'
  })
}

// 导出工单评价
export function exportIncome(query) {
  return request({
    url: '/order/income/export',
    method: 'get',
    params: query
  })
}