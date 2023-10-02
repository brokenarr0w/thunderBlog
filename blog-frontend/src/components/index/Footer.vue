<script setup>
import { onMounted, ref,defineProps } from 'vue';
import { useRouter } from 'vue-router';
import {getHitokoto} from '@/api/index'
const router = useRouter()
defineProps(['newBlogs'])
const sentence = ref({})
const handleClick = (item) => {
    if(router.name === 'home'){
    window.scrollTo({
      behavior: 'smooth',
      top: store.state.clientSize.clientHeight
    })
  }else{
    window.scrollTo({
      behavior: 'smooth',
      top: 0
    })
  router.push({
    path:`/blog/${item.id}`,
  })
}
}
onMounted(async () => {
  const res =await getHitokoto()
  sentence.value = res
})
</script>

<template>
  <div class="footer-container">
  <el-row>
    <el-col :span="4"></el-col>
  <el-col :span="4" class="qrcode">
    <el-text class="text">这里应该是一个微信小程序的二维码(待填坑)</el-text>
  </el-col>
    <el-divider direction="vertical"/>
    <el-col :span="4" class="newBlog">
      <div style="text-align: center">
        <el-text class="text" size="large">
          最新博客
        </el-text>
        <div v-for="item in newBlogs">
          <el-text >
            <el-button @click="handleClick(item)" link>{{ item.title }}</el-button>
        </el-text>
        </div>
        
      </div>
    </el-col>
    <el-divider direction="vertical"/>
    <el-col :span="4" style="text-align: center;color: rgba(255,255,255,.9)">
      <div>
        <el-text>{{sentence.hitokoto}}</el-text>
      </div>
      <div>-- <el-text>{{ sentence.from }}</el-text></div>
    </el-col>
    <el-col :span="6"></el-col>
  </el-row>
  </div>
</template>

<style scoped>
.footer-container{
  background: #1b1c1d;
  width: 100%;
}
.text{
  color: #fff;
}
</style>