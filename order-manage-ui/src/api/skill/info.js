import request from '@/utils/request'

// 查询技能列表
export function listInfo(query) {
  return request({
    url: '/skill/info/list',
    method: 'get',
    params: query
  })
}

// 查询技能详细
export function getInfo(id) {
  return request({
    url: '/skill/info/' + id,
    method: 'get'
  })
}

// 新增技能
export function addInfo(data) {
  return request({
    url: '/skill/info',
    method: 'post',
    data: data
  })
}

// 修改技能
export function updateInfo(data) {
  return request({
    url: '/skill/info',
    method: 'put',
    data: data
  })
}

// 删除技能
export function delInfo(id) {
  return request({
    url: '/skill/info/' + id,
    method: 'delete'
  })
}

// 导出技能
export function exportInfo(query) {
  return request({
    url: '/skill/info/export',
    method: 'get',
    params: query
  })
}