import axios from "axios";
export function Login(username,password){
    return axios({
        url: '/login',
        method: 'POST',
        data: {
            username:username,
            password:password,
        },
        headers: {
            "Content-Type": "application/x-www-form-urlencoded",
        }
    })
}