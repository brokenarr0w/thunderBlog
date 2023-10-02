
import axios from "axios";
export function getBlogById(id){
    return axios({
        url:'get/blog',
        method:'GET',
        params:{
            id
        }
    })
}
export function getBlogListByCategoryName(categoryName,pageNum) {
    return axios({
        url: 'get/category/blog',
        method: 'GET',
        params: {
            categoryName,pageNum
        }
    })
}
export function getBlogList(){
    return axios({
        url: 'get/blogs',
        method: 'GET'
    })
}
export function getBlogListByPageNum(pageNum){
    return axios({
        url:'get/blogList',
        method: 'get',
        params:{
            pageNum
        }
    })
}
export function insertBlog(blog){
    return axios({
        url: 'post/blog',
        method: 'POST',
        data: blog,
        headers: {
            "Content-Type": "application/json",
        }
    })
}
export function deleteBlogById(id){
    return axios({
        url: 'delete/blog',
        method: 'DELETE',
        params:{
            id
        }
    })
}
export function getBlogCount(){
    return axios({
        url: 'get/blog/count',
        method: 'GET',
    })
}
export function UploadImage(image){
    return axios({
        url: 'post/image',
        method: 'POST',
        data: image,

    })
}
export function getBlogByCategoryCount(categoryName){
    return axios({
        url: 'get/category/blog/count',
        method: 'GET',
        params:{
            categoryName
        }
    })
}
export function viewBlog(id){
    return axios({
        url: 'view/blog',
        method: 'GET',
        params:{
            id
        }
    })
}


export function getBlogListByTag(tagName,pageNum){
    return axios({
        url: 'get/tag/blog',
        method: 'GET',
        params:{
            tagName,pageNum
        }
    })
}
export function getBlogByTagCount(tagName){
    return axios({
        url: 'get/tag/blog/count',
        method: 'GET',
        params:{
            tagName
        }
    })
}
export function getNewBlogs(){
    return axios({
        url: 'get/blog/new',
        method: 'GET'
    })
}
export function getTopBlogs(){
    return axios({
        url: 'get/blog/top',
        method: 'GET'
    })
}