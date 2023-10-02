<script setup>

import {reactive} from "vue";
import {useStore} from "vuex";
import {useRouter} from "vue-router";
import {ElMessage} from "element-plus";
const router = useRouter()
const store = useStore()
let form = reactive({
  username: '',
  password:'',
})
const login = async () =>{
  try{
    await store.dispatch('userLogin',{username:form.username,password:form.password})
    await router.push('/admin')
  }catch (err){
    ElMessage.error("登录失败")
  }
}
</script>

<template>
  <div class="page">
  <div class="login">
    <div class="box">
      <p class="table">Thunder</p>
      <br>
      <el-form :model="form">
      <el-form-item>
      <el-input type="text" placeholder="账号" class="input" v-model="form.username" clearable/>
      </el-form-item>
        <el-form-item>
        <el-input type="password" placeholder="密码" class="input" v-model="form.password" show-password clearable/>
        </el-form-item>
      <br>
        <el-form-item style="justify-content: center;">
      <el-button class="go" @click="login">登录</el-button>
        </el-form-item>
      </el-form>
    </div>
  </div>
  </div>
</template>

<style scoped>
.page{
  height: 100%;
  width: 100%;
  display: flex;
  flex-wrap: wrap;
  justify-content: center;
  align-content: center;
}
*{
  padding: 0;
  margin: 0;
  text-decoration: none;
}
.login{
  width: 550px;
  height: 400px;
  display: flex;
  justify-content: center;
  align-items: center;
  background: linear-gradient(
      to right bottom,
      rgba(255,255,255,.7),
      rgba(255,255,255,.5),
      rgba(255,255,255,.4)
  );
  /* 使背景模糊化 */
  backdrop-filter: blur(10px);
  box-shadow: 0 0 20px #a29bfe;
  border-radius: 15px;
}

@media screen and (max-width: 767px) {
  .login{
    width: 100vw;
    height: 100vh;
  }
}
.table{
  font: 900 40px '';
  text-align: center;
  letter-spacing: 5px;
  color: #3d3d3d;
}

.box{
  overflow: hidden;
  display: flex;
  flex-direction: column;
}

.input{
  width: 400px;
  height: 100%;
  margin-bottom: 20px;
  outline: none;
  border: 0;
  padding: 10px;
  background-color: transparent;
  border-bottom: 3px solid rgb(150, 150, 240);
  font: 900 16px '';
}

.go{
  text-align: center;
  display: block;

  height: 48px;
  padding: 12px;
  font: 900 20px '';
  border-radius: 10px;
  margin-top: 20px;
  color: #fff;
  letter-spacing: 3px;
  background-image: linear-gradient(to left,
  #fd79a8,#a29bf6);
}
::v-deep   .el-form-item__content{
  justify-content: center
}
</style>