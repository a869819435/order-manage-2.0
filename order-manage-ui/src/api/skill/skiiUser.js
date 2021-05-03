import request from '@/utils/request'

// 查询技能-技师信息列表
export function listSkiiUser(query) {
  return request({
    url: '/skill/skiiUser/list',
    method: 'get',
    params: query
  })
}

// 查询技能-技师信息详细
export function getSkiiUser(id) {
  return request({
    url: '/skill/skiiUser/' + id,
    method: 'get'
  })
}

// 新增技能-技师信息
export function addSkiiUser(data) {
  return request({
    url: '/skill/skiiUser',
    method: 'post',
    data: data
  })
}

// 修改技能-技师信息
export function updateSkiiUser(data) {
  return request({
    url: '/skill/skiiUser',
    method: 'put',
    data: data
  })
}

// 删除技能-技师信息
export function delSkiiUser(id) {
  return request({
    url: '/skill/skiiUser/' + id,
    method: 'delete'
  })
}

// 导出技能-技师信息
export function exportSkiiUser(query) {
  return request({
    url: '/skill/skiiUser/export',
    method: 'get',
    params: query
  })
}