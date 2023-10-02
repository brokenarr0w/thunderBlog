<script setup>
import {ref,onMounted} from 'vue'
import {useStore} from "vuex";
import Header from "@/components/index/Header.vue";
import Introduction from "@/components/sidebar/Introduction.vue";
import RandomBlog from "@/components/sidebar/RandomBlog.vue";
import Tags from "@/components/sidebar/Tags.vue";
import {getNewBlogs} from '@/api/blog'
import { useRoute } from 'vue-router';
const blogName = ref('Thunder')
const categoryList =[]
let newBlogs = ref()
const store = useStore()
const route = useRoute()
store.commit("saveClientSize",{clientHeight:document.body.clientHeight,clientWidth:document.body.clientWidth})
onMounted(async () => {
  const res = await getNewBlogs()

  console.log("%c欢迎来到Thunder的小站",'color:skyblue;font-size:1.25rem');
   newBlogs.value = res.data
  store.commit("saveClientSize",{clientHeight:document.body.clientHeight,clientWidth:document.body.clientWidth})
  window.onresize = (() =>{
    store.commit("saveClientSize",{clientHeight:document.body.clientHeight,clientWidth:document.body.clientWidth})
  })

})

</script>

<template>
  <div>
  <Nav :blogName="blogName" :categoryList="categoryList"/>
  <div class="m-mobile-hide">
    <Header v-if="$route.name === 'home'"/>
  </div>
  <el-main style="padding-top: 40px; background-color: #e6dbdb86;">
    <el-row :gutter="20">
      <!--  左侧  -->
      <el-col :span="1"></el-col>
      <el-col :span="4" style="margin-top: 40px;" class="m-mobile-hide">
        <introduction :class="{'m-display-none':store.state.focusMode}"/>
      </el-col>
      <!--  中间    -->
      <el-col :span="15" :xs="24" style="margin-top: 40px;">
          <router-view :key="route.fullPath"/>
      </el-col>
      <!--  右侧    -->
      <el-col :span="4" style="margin-top: 40px;" class="m-mobile-hide">
        <RandomBlog/>
        <Tags/>
      </el-col>
    </el-row>
  </el-main>
  <Footer :newBlogs="newBlogs"></Footer>
  <el-backtop :right="100" :bottom="100" />
  </div>
</template>

<style scoped>

</style>