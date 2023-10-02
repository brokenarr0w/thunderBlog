import axios from "axios";
export function getBlogList(pageNum){
    return axios({
        url:'get/blogs',
        method:'GET',
        params:{
            pageNum
        }
    })
}