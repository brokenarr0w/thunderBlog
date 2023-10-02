import axios from "axios";
export function getAbout(){
    return axios({
        url:'get/about',
        method:'GET'
    })
}
export function saveAbout(about){
    return axios({
        url:'post/about',
        method: 'POST',
        data: about,
        headers: {
            'Content-Type': 'application/json'
        }
})
    
}