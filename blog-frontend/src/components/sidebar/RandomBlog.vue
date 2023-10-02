<script setup>
import { getTopBlogs } from '@/api/blog';
import { onMounted, ref } from 'vue';
import { useRouter } from 'vue-router';
const router = useRouter()
let blogList = ref()
const base_url = 'http://47.115.205.26/'
onMounted(async () => {
  const res = await getTopBlogs()
  blogList.value = res.data
})
const handleClick = (item) => {
  router.push(`/blog/${item.id}`)
}
</script>

<template>
  <el-card>
    <template #header>
      <div style="background: #f3f4f5">
        <i class="iconfont icon-chuangzuo" style="margin-left: 10px">
        <el-text>随机放一些感兴趣的文章</el-text>
      </i></div>
    </template>
    <div v-for="item in blogList" class="m-item" @click="handleClick(item)">
      <div  class="img" :style="{'background-image':'url('+ base_url + item.firstPicture + ')'}">
      <div class="info">
        <div class="date">
            {{ item.createTime }}
        </div>
        <div class="title">
            {{ item.title  }}
        </div>
      </div>
      </div>
    </div>
    
  </el-card>
</template>

<style scoped>
:deep(.el-card__header){
  padding: 0;
}
.title{
  cursor: pointer;
}
.img{
  position: absolute;
		top: 0;
		left: 0;
		right: 0;
		bottom: 0;
		object-fit: cover;
		background-position-x: center;
		background-position-y: center;
		background-size: cover;
}
.m-item{
  margin-top: 1rem;
		height: 4rem;
		position: relative;
		overflow: hidden;
		border-radius: 5px;
		cursor: pointer;
		user-select: none;
}
.info{
  z-index: 1;
		background: linear-gradient(to bottom, rgba(0, 0, 0, 0), rgba(0, 0, 0, 0.8));
		position: absolute;
		left: 0;
		right: 0;
		bottom: 0;
		padding: .5rem !important;
		font-size: 12px;
		color: white;
}
.info .title{
  overflow: hidden;
		text-overflow: ellipsis;
		display: -webkit-box;
		-webkit-box-orient: vertical;
		-webkit-line-clamp: 1;
		word-break: break-word;
}
</style>