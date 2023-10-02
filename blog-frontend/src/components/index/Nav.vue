<script setup>
 import {useStore} from "vuex";
 import {computed,onMounted, ref} from "vue";
 import {getCategoryList} from '@/api/category'
 import {useRouter} from 'vue-router';
 const router = useRouter()
let categoryList = ref()
onMounted(async () => {
  const res = await getCategoryList()
  categoryList.value = res.data
})
 const store = useStore()
const clientWidth = computed(()=>{
  return store.state.clientSize.clientWidth
})  
 const props = defineProps(['blogName'])
 const mobileHide = true
 function categoryRoute(name){
    router.push(`/category/${name}`)
 }
</script>

<template>
  <div>
  <el-header ref="header" class="header-container" style="z-index: 1000" :class="{'transparent':$route.name==='home' && clientWidth>768}" >
    <div class="navBar">
      <router-link to="/" >
        <el-text size="large" class="logo">{{props.blogName}}</el-text>
      </router-link>
      <router-link to="/home" class="item" :class="{'m-mobile-hide': mobileHide,'active':$route.name==='home'}">
        <i class="iconfont icon-shouye"><span>首页</span></i>
      </router-link>
      <el-dropdown trigger="click" @command="categoryRoute">
        <el-text :class="{'m-mobile-hide': mobileHide,'active':$route.name==='category'}" class="item">
        <i class="iconfont icon-chuangzuo"></i><span>分类</span><i class="iconfont icon-shaixuan"></i>
        </el-text>
        <template #dropdown>
        <el-dropdown-menu>
          <el-dropdown-item v-for="item in categoryList" :command="item.categoryName" :key="item.id">{{ item.categoryName }}</el-dropdown-item>
        </el-dropdown-menu>
      </template>
      </el-dropdown>
      <router-link to="/moments" class="item" :class="{'m-mobile-hide': mobileHide,'active':$route.name==='moments'}">
        <i class="iconfont icon-fuzhi"></i><span>动态</span>
      </router-link>
      <router-link to="/archives" class="item" :class="{'m-mobile-hide': mobileHide,'active':$route.name==='archives'}">
        <i class="iconfont icon-xiaoxi"></i><span>归档</span>
      </router-link>
      <router-link to="/about" class="item" :class="{'m-mobile-hide': mobileHide,'active':$route.name==='about'}">
        <i class="iconfont icon-wode"></i><span>关于我</span>
      </router-link>
      <div class="m-right-top m-mobile-show">
        <button></button>
      </div>
    </div>

  </el-header>
  </div>
</template>

<style scoped>
.header-container {
  border:0 solid transparent;
  transition: .3s ease-out;
  background: #1b1c1d;
  position: fixed;
  top: 0;
  left: 0;
  width: 100%;
}

.navBar{
  height:8vh;
  display: flex;
  justify-content: flex-start;
  align-items: center;
}
.item {
  color: #1abc9c;
  cursor: pointer;
  margin-left: 50px;
}
.item:hover{
  color: #fff;
}
a{
  text-decoration-line: none ;
}
.logo{
  color: #48dbfb;
  font-weight: bold;
}
</style>