<script setup>
import { defineProps } from 'vue'
import { viewBlog } from '@/api/blog'
import router from "@/router";
const props = defineProps(['blogList'])
const base_url = 'http://47.115.205.26/'
async function toBlog(blog) {
  await viewBlog(blog.id)
  router.push(`/blog/${blog.id}`)
}
const toBlogList = (item) => {

  router.push(`/tag/${item.tagName}`)
}
const toBlogListByCategory = (item) => {
  router.push(`/category/${item.categoryName}`)
}
</script>

<template>
  <div class="content">
    <el-card v-for="item in blogList" style="margin-bottom: 10px;">
      <template #header>
        <div class="card-header">
          <div class="title">
            <a @click="toBlog(item)" style="cursor: pointer;">
              <h2>{{ item.title }}</h2>
            </a>
          </div>
          <div class="message">
            <i class="iconfont icon-shijian"><el-text size="small">{{ item.createTime }}</el-text></i>
            <i class="iconfont icon-yanjing"><el-text size="small">{{ item.views }}</el-text></i>
            <i class="iconfont icon-xiaojuchang"><el-text size="small">字数 = {{ item.words }}字</el-text></i>
            <i class="iconfont icon-shijian1"><el-text size="small">阅读时长 = {{ item.words / 8 }}分钟</el-text></i>
          </div>
          <el-tag>
            <i class="iconfont icon-wenjuan"></i>
            <el-button @click="toBlogListByCategory(item)" type="primary" link>
              {{ item.categoryName }}
            </el-button>
          </el-tag>
          <div class="typo">
            <h2>{{ item.description }}</h2>
            <el-image :src="base_url + item.firstPicture" fit="scale-down" :lazy="true"
              style="margin:0 auto;max-height: 50%;"></el-image>
          </div>
          <div class="button">
            <a @click="toBlog(item)" class="color-btn"><span class="text">阅读本文</span></a>
          </div>
        </div>
      </template>
      <el-tag v-for="tag in item.tags" :color="tag.color">
        <el-button @click="toBlogList(tag)" type="primary" link>
          {{ tag.tagName }}

        </el-button>
      </el-tag>
    </el-card>
  </div>
</template>

<style scoped>
.card-header {
  position: relative;
}

.content {
  margin-left: 20px;
  padding-right: 20px;
}

.title {
  display: flex;
  width: 100%;
  justify-content: center;
}

.message {
  display: flex;
  justify-content: center;
}

.button {
  display: flex;
  justify-content: center;
}

a {
  text-decoration-line: none;
}

.text {
  position: relative;
  bottom: 2px;
}
</style>