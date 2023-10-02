import axios from "axios";
export function getHitokoto(){
    return axios({
        url: 'https://v1.hitokoto.cn/?c=a',
        method:'GET'
    })
}
export function getSite(){
    return axios({
        url: 'site',
        method: 'GET'
    })
}
export function viewSite(){
    return axios({
        url: 'view/site',
        method: 'GET'
    })
}