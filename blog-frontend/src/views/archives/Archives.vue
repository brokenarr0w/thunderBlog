<script setup>
import { onMounted, ref } from 'vue';
import {getBlogCount,getBlogListByPageNum} from '@/api/blog'
import {useRouter} from 'vue-router'
const router = useRouter()
let blogList = ref([])
let totalNum = ref(0)
onMounted(() => {
  getBlogList(1)
})
const getBlogList =async function (pageNum){
const res =  await getBlogListByPageNum(pageNum)
const count = await getBlogCount()
blogList.value = res.data
totalNum.value = count.data

}
const handleClick = (item) => {
  router.push(`/blog/${item.id}`)
}
</script>

<template>
  <el-card>
    <template #header>
      <div style="text-align: center">
        <h2>文章归档</h2>
        <p>现在有{{totalNum}}篇文章</p>
      </div>

    </template>
    <el-timeline>
    <el-timeline-item
      v-for="item in blogList"
      :key="item.id"
      :timestamp="item.createTime"
    >
      <el-button @click="handleClick(item)" link>{{ item.title }}</el-button>
    </el-timeline-item>
  </el-timeline>
  </el-card>
  <div style="text-align: center;">
    <Pagination :totalNum="totalNum" :getBlogList="getBlogList"></Pagination>
  </div>
</template>

<style scoped>

</style>