import request from '@/utils/request'

// 查询技师列表
export function listSkiller(query) {
  return request({
    url: '/skill/skiller/list',
    method: 'get',
    params: query
  })
}

// 查询技师详细
export function getSkiller(id) {
  return request({
    url: '/skill/skiller/' + id,
    method: 'get'
  })
}

// 新增技师
export function addSkiller(data) {
  return request({
    url: '/skill/skiller',
    method: 'post',
    data: data
  })
}

// 修改技师
export function updateSkiller(data) {
  return request({
    url: '/skill/skiller',
    method: 'put',
    data: data
  })
}

// 删除技师
export function delSkiller(id) {
  return request({
    url: '/skill/skiller/' + id,
    method: 'delete'
  })
}

// 导出技师
export function exportSkiller(query) {
  return request({
    url: '/skill/skiller/export',
    method: 'get',
    params: query
  })
}