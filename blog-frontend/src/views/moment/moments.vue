<script setup>
import { getMomentListByPageNum, likeMoment, getMomentCount } from '@/api/moment'
import { onMounted, ref } from 'vue';
import { useRoute } from 'vue-router';
const route = useRoute()
let momentList = ref([])
let pageNum = ref()
let totalNum = ref(0)

onMounted(async () => {
  const res = await getMomentListByPageNum(1)
  const count = await getMomentCount()

  momentList.value = res.data
  totalNum.value = count.data
})
const handleCurrentChange = async (newpage) => {
  const res = await getMomentListByPageNum(newpage)
  if(route.name === 'home'){
    window.scrollTo({
      behavior: 'smooth',
      top: store.state.clientSize.clientHeight
    })
  }else{
    window.scrollTo({
      behavior: 'smooth',
      top: 0
    })
  }
  momentList.value = res.data
}
const like = async (item) => {
  const res = await likeMoment(item.id)
  ElMessage({
    message: "点赞" + res.msg + "喵~",
    type: 'success'
  })
}
</script>

<template>
  <el-card>
    <el-timeline>
      <el-timeline-item v-for="item in momentList" :timestamp="item.createTime" placement="top">

        <div>
          <el-card>
            <v-md-editor :model-value="item.content" mode="preview"></v-md-editor>
            <el-button @click="like(item)">点赞</el-button>   
          </el-card>
        </div>
        <el-divider>我是分割线</el-divider>
      </el-timeline-item>

    </el-timeline>

  </el-card>

  <div style="display: flex;justify-content: center;">
    <el-pagination :total="totalNum" background :page-size="5" :current-page="pageNum"
      @current-change="handleCurrentChange" layout="prev, pager, next"></el-pagination>
  </div>
</template>

<style scoped></style>