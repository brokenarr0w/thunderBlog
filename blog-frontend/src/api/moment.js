import axios from "axios";

export function getMomentListByPageNum(pageNum){
    return axios({
        url:`get/moment`,
        method:'GET',
        params:{
            pageNum
        }
    })
}
export function getMomentList(){
    return axios({
        url: 'get/moments',
        method: 'GET',
    })
}

export function likeMoment(id){
    return axios({
        url:'moment/like',
        method:'GET',
        params:{
            id
        }
    })
}
export function insertMoment(moment){
    return axios({
        url: 'post/moment',
        method: 'POST',
        data: moment,
        headers: {
            'Content-Type': 'application/json'
        }
    })
}
export function deleteMomentById(id){
    return axios({
        url: 'delete/moment',
        method: 'DELETE',
        params:{
            id,
        }
    })
}
export function getMomentCount(){
    return axios({
        url: 'get/moment/count',
        method: 'GET',
    })
}