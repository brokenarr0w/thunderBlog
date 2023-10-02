<template>
    <div >
        <div style="text-align: center;margin-bottom: 10px;">
            <h2>分类 {{ categoryName }} 下的文章</h2>
        </div>
        <BlogList :getBlogList="getBlogList" :blogList="blogList" :totalNum="totalNum"></BlogList>
    </div>
</template>

<script setup>
import BlogList from '@/components/blog/BlogList.vue';
import { computed,  onMounted,  ref } from 'vue';
import { onBeforeRouteUpdate, useRoute } from 'vue-router';
import { getBlogListByCategoryName, getBlogByCategoryCount } from '@/api/blog'
let blogList = ref([])
let totalNum = ref(0)
onMounted(() => {
    blogList.value = getBlogList(1)
})
onBeforeRouteUpdate(() => {
    blogList.value = getBlogList(1)
})

const route = useRoute()
let categoryName = computed(() => route.params.name)
const getBlogList = async (pagenum) => {
    const res = await getBlogListByCategoryName(categoryName.value, pagenum)
    const count = await getBlogByCategoryCount(categoryName.value)
    blogList.value = res.data
    totalNum.value =count.data
}
</script>

<style scoped></style>