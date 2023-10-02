<template>

<div>
    <el-card shadow="always" :body-style="{ padding: '20px' }">
        <template #header>
        <div style="text-align: center;">
            <h1>{{blog.title}}</h1>
        </div>
        <div style="text-align: center;">
          <i class="iconfont icon-shijian mr"><el-text size="small">{{ blog.createTime }}</el-text></i>
          <i class="iconfont icon-yanjing mr"><el-text size="small">{{ blog.views }}</el-text></i>
          <i class="iconfont icon-xiaojuchang mr"><el-text size="small">字数 = {{blog.words}}字</el-text></i>
          <i class="iconfont icon-shijian1 mr"><el-text size ="small">阅读时长 = {{parseInt(blog.words/8)}}分钟</el-text></i>
        </div>
        </template>
        <div class="typo js-toc-content">
          <span>{{blog.description}}</span>
          <v-md-editor :model-value="blog.content" mode="preview" ref="preview"></v-md-editor>

        </div>
    </el-card>
    
    </div>
</template>

<script setup>
import {getBlogById} from '@/api/blog'
import { onMounted, ref } from 'vue';
import {useRouter} from 'vue-router'
import { useStore } from 'vuex';
const router = useRouter()
const store = useStore()
let blog = ref({})
onMounted(async () => {
  const res = await getBlogById(router.currentRoute.value.params.id)
  blog.value=res.data;
  store.commit('saveisBlogFinished',true)
    })
</script>

<style scoped>
.mr{
    margin-right: 5px;
}
</style>