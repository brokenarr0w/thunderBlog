<template>
    <div>
        <div style="text-align: center;margin-bottom: 10px;">
            <h2>具有 {{ tagName }} 标签的文章</h2>
        </div>
        <BlogList :getBlogList="getBlogList" :blogList="blogList" :totalNum="totalNum"></BlogList>
    </div>
</template>

<script setup>
import BlogList from '@/components/blog/BlogList.vue';
import { computed,  onMounted,  ref } from 'vue';
import { onBeforeRouteUpdate, useRoute } from 'vue-router';
import { getBlogListByTag, getBlogByTagCount } from '@/api/blog'
let blogList = ref([])
let totalNum = ref(0)
onMounted(() => {
    blogList.value = getBlogList(1)
})
onBeforeRouteUpdate(() => {
    blogList.value = getBlogList(1)
})

const route = useRoute()
let tagName = computed(() => route.params.name)
const getBlogList = async (pagenum) => {
    const res = await getBlogListByTag(tagName.value, pagenum)
    const count = await getBlogByTagCount(tagName.value)
    console.log(blogList);
    blogList.value = res.data
    totalNum.value = count.data
}
</script>

<style>

</style>