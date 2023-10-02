import axios from "axios";

export function getTagList(){
    return axios({
        url: 'get/tagList',
        method: 'GET'
    })
}
export function getBlogTags(name){
    return axios({
        url: 'get/blog/tag',
        method: 'GET',
        params:{
            name: name
        }
    })
}
export function deleteTagById(id){
    return axios({
        url: 'delete/tag',
        method: 'DELETE',
        params:{
            id
        }
    })
}
export function InsertTag(tag){
    return axios({
        url: 'post/tag',
        method: 'POST',
        headers:{
        'Content-Type': 'application/json'
        },
        data:tag
    })
}