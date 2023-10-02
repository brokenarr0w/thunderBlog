import axios from "axios";
export function getWebStats(){
    return axios({
        url: 'get/webStats',
        method: 'GET'
    })
}
export function getWebSetting(){
    return axios({
        url: 'get/webSetting',
        method: 'GET',
    })
}
export function getBlogTotalNum(){
    return axios({
        url: 'get/blogs/sum',
        method: 'GET'
    })
}

export function deleteBlogById(id){
    return axios({
        url: 'post/delete/blog',
        method: 'POST',
        params:{
            id
        }

    })
}