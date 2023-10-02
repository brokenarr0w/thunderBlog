<script setup>
import { getBlogListByPageNum,getBlogCount } from "../../api/blog";
import {ref,onMounted} from 'vue';
import BlogList from "@/components/blog/BlogList.vue";
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
</script>

<template>
  <div>
  <BlogList :getBlogList="getBlogList" :blogList="blogList" :totalNum="totalNum"></BlogList>
  </div>
</template>

<style scoped>

</style>