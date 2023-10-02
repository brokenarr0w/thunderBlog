 import axios from 'axios'

 export function getArchives(){
    return axios({
        URL:'get/archives',
        method:'GET',
    })
 }