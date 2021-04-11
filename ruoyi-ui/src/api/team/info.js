import request from '@/utils/request'

// 查询团队信息列表
export function listInfo(query) {
  return request({
    url: '/team/info/list',
    method: 'get',
    params: query
  })
}

// 查询团队信息详细
export function getInfo(id) {
  return request({
    url: '/team/info/' + id,
    method: 'get'
  })
}

// 新增团队信息
export function addInfo(data) {
  return request({
    url: '/team/info',
    method: 'post',
    data: data
  })
}

// 修改团队信息
export function updateInfo(data) {
  return request({
    url: '/team/info',
    method: 'put',
    data: data
  })
}

// 删除团队信息
export function delInfo(id) {
  return request({
    url: '/team/info/' + id,
    method: 'delete'
  })
}

// 导出团队信息
export function exportInfo(query) {
  return request({
    url: '/team/info/export',
    method: 'get',
    params: query
  })
}