import {Login} from "@/api/login";
import {ElMessage} from "element-plus";
import {getWebStats} from "@/api/admin";
export default {
    async userLogin(context,user){
        try{
            console.log(user)
            const res = await Login(user.username,user.password)
            console.log(res);
            context.commit('saveToken',res.data.tokenValue)
        }catch (err){
            throw new Error(err)
        }
    },

}