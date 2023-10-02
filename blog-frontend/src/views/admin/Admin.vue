<script setup>

import Sidebar from "@/components/admin/Sidebar.vue";
import Navbar from "@/components/admin/Navbar.vue";
import {ref,onUpdated} from 'vue'
const title = ref("")
onUpdated(() => {
  title.value = document.title
})
</script>

<template>
  <el-container style="height: 100%">
  <el-aside width="200px"><Sidebar/></el-aside>
    <el-container>
      <el-header style="align-items: center;display: flex"><Navbar :title="title"></Navbar></el-header>
  <el-main>
    <router-view/>
  </el-main>

    </el-container>
  </el-container>
</template>

<style scoped>

</style>