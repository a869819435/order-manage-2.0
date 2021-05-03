import request from '@/utils/request'

// 查询团队职务信息列表
export function listPost(query) {
  return request({
    url: '/team/post/list',
    method: 'get',
    params: query
  })
}

// 查询团队职务信息详细
export function getPost(id) {
  return request({
    url: '/team/post/' + id,
    method: 'get'
  })
}

// 新增团队职务信息
export function addPost(data) {
  return request({
    url: '/team/post',
    method: 'post',
    data: data
  })
}

// 修改团队职务信息
export function updatePost(data) {
  return request({
    url: '/team/post',
    method: 'put',
    data: data
  })
}

// 删除团队职务信息
export function delPost(id) {
  return request({
    url: '/team/post/' + id,
    method: 'delete'
  })
}

// 导出团队职务信息
export function exportPost(query) {
  return request({
    url: '/team/post/export',
    method: 'get',
    params: query
  })
}