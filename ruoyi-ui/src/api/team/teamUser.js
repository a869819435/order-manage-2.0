import request from '@/utils/request'

// 查询团队成员信息列表
export function listTeamUser(query) {
  return request({
    url: '/team/teamUser/list',
    method: 'get',
    params: query
  })
}

// 查询团队成员信息详细
export function getTeamUser(id) {
  return request({
    url: '/team/teamUser/' + id,
    method: 'get'
  })
}

// 新增团队成员信息
export function addTeamUser(data) {
  return request({
    url: '/team/teamUser',
    method: 'post',
    data: data
  })
}

// 修改团队成员信息
export function updateTeamUser(data) {
  return request({
    url: '/team/teamUser',
    method: 'put',
    data: data
  })
}

// 删除团队成员信息
export function delTeamUser(id) {
  return request({
    url: '/team/teamUser/' + id,
    method: 'delete'
  })
}

// 导出团队成员信息
export function exportTeamUser(query) {
  return request({
    url: '/team/teamUser/export',
    method: 'get',
    params: query
  })
}