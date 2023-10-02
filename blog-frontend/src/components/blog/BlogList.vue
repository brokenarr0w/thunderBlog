<script setup>
import Pagination from "@/components/blog/Pagination.vue";
import BlogItem from "@/components/blog/BlogItem.vue";
let props = defineProps(['blogList','totalNum','getBlogList'])
</script>

<template>
  <div >
    <BlogItem :blogList="blogList"/>
    <Pagination :getBlogList="props.getBlogList" :totalNum="totalNum"/>
  </div>
</template>

<style scoped>

</style>