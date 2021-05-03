import request from '@/utils/request'

// 查询技能分类列表
export function listSkiil(query) {
  return request({
    url: '/classify/skiil/list',
    method: 'get',
    params: query
  })
}

// 查询技能分类详细
export function getSkiil(id) {
  return request({
    url: '/classify/skiil/' + id,
    method: 'get'
  })
}

// 新增技能分类
export function addSkiil(data) {
  return request({
    url: '/classify/skiil',
    method: 'post',
    data: data
  })
}

// 修改技能分类
export function updateSkiil(data) {
  return request({
    url: '/classify/skiil',
    method: 'put',
    data: data
  })
}

// 删除技能分类
export function delSkiil(id) {
  return request({
    url: '/classify/skiil/' + id,
    method: 'delete'
  })
}

// 导出技能分类
export function exportSkiil(query) {
  return request({
    url: '/classify/skiil/export',
    method: 'get',
    params: query
  })
}