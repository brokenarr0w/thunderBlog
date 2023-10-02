<script setup>
import { getTagList } from '@/api/tag'
import { ref, onMounted } from 'vue';
import {useRouter} from 'vue-router';
const tagList = ref([])
const router = useRouter()
onMounted(async () => {
  const res = await getTagList()
  tagList.value = res.data
})
const toBlogList = (item) => {
  router.push(`/tag/${item.tagName}`)
}
</script>

<template>
  <el-card shadow="hover" :body-style="{ padding: '20px' }" style="margin-top: 10px;">
    <template #header>
      <div style="background: #f3f4f5">
        <i class="iconfont icon-shoucang" style="margin-left: 10px;"></i>
        <el-text>标签云</el-text>
      </div>
    </template>
    <div>
      <el-tag v-for="item in tagList" :color="item.color" style="margin-left: 5px;">
        <el-button @click="toBlogList(item)" type="primary" link>
          {{ item.tagName }}
        </el-button>
      </el-tag>
    </div>
  </el-card>
</template>

<style scoped>
:deep(.el-card__header) {
  padding: 0;
}
</style>