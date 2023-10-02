<script setup>
import {useRouter} from "vue-router";

const router = useRouter()
let routes = router.options.routes
let menuList = routes[0].children
menuList.forEach((value) => {
  if(value.children){
    value.children.forEach(item => {
      if(item.hidden){
        value.children.pop()
      }
    })
  }
})
</script>

<template>
  <el-menu
      default-active="0"
      :unique-opened="true"
      class="el-menu-vertical-demo"
      style="height: 100%;"
      active-text-color="#ffd04b"
      background-color="#545c64"
      text-color="#fff"
  >
    <template v-for="(item, index) in menuList" :key="index">
      <router-link :to="item.path" v-if="!item.children" :key="index">
        <el-menu-item :index="index + ''">
          <el-icon><component :is="item.icon"></component></el-icon>
          <span>{{ item.meta.title }}</span>
        </el-menu-item>
      </router-link>

      <el-sub-menu :index="index + ''" v-else>
        <template #title>
          <el-icon><component :is="item.icon"></component></el-icon>
          <span>{{ item.meta.title }}</span>
        </template>
        <router-link
            :to="item.path + '/' + sub.path"
            v-for="(sub, subIndex) in item.children"
            :key="subIndex"
        >
          <el-menu-item :index="index + '-' + subIndex">
            <el-icon><component :is="sub.icon"></component></el-icon>
            <span>{{ sub.meta.title }}</span>
          </el-menu-item>
        </router-link>
      </el-sub-menu>
    </template>
  </el-menu>
</template>

<style scoped>

</style>