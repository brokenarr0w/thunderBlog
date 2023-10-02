import axios from 'axios'

export function getCategoryList(){
    return axios({
        url:'get/categoryList',
        method: 'GET',
    })
}
export function getCategoryById(id){
    return axios({
        url: 'get/category',
        method: 'GET',
        params: {
            id
        }
    })
}
export function insertCategory(category){
    return axios({
        url: 'post/category',
        method: 'POST',
        data:category,
        headers: {
            "Content-Type": "application/json",
        }
    })
}
export function getCategoryListByPageNum(pageNum){
    return axios({
        url: 'get/categoryList/page',
        method:'GET',
        params:{
            pageNum
        }
    })
}
export function getCategorySum(){
    return axios({
        url: 'get/category/sum',
        method: 'GET'
    })
}
export function deleteCategoryById(id){
    return axios({
        url: 'delete/category',
        method: 'DELETE',
        params:{
            id: id
        }
    })
}