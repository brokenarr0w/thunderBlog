<script setup>
import {onMounted,ref} from 'vue'

import {getWebStats} from "@/api/admin";
import { use } from 'echarts/core'
import { PieChart } from 'echarts/charts'
import { TitleComponent } from 'echarts/components'
import { CanvasRenderer } from 'echarts/renderers'
use([TitleComponent, PieChart, CanvasRenderer])

let timeline =[
  {
    title: '项目启动',
    time: '2023-8-25',
  },
  {
    title: '网站前端完成',
    time: '2023-9-2',
  },
  {
    title: '网站后端完成',
    time: '2023-9-5',
  },
  {
    title:'网站完成',
    time: '2023-10-1'
  }

]
//响应式状态只给对象赋值组件不更新,需要给对象属性赋值组件才更新
let webStats = ref({})
let data = ref([
  {
    value: 234,
    name: '文章点赞次数'
  },
])
const option = ref({
  title: {
    text: '网站数据',
    left: 'center'
  },
  series: [
    {
      name: '网站数据',
      type: 'pie',
      data: data,
    }],
});
onMounted(async () => {
  let res = await getWebStats()
  webStats.value.blogViews = res.data.blogViews 
})

</script>

<template>
  <div class="home">

  <el-row justify="space-evenly">

    <el-col :span="11">
    <el-card style="height: 350px;overflow: auto" >
      <template #header>
        Thunder的小窝
      </template>
    <el-text>
      这个网站的制作时间线
    </el-text>
      <el-timeline style="margin-top: 10px">
      <el-timeline-item
          v-for="(item,index) in timeline"
          :key="index"
          :timestamp="item.time">
        {{item.title}}
      </el-timeline-item>
      </el-timeline>
    </el-card>

    </el-col>
    <el-col :span="11">
      <el-card style="height: 350px;overflow: auto">
        <template #header>
          网站统计数据
        </template>
        <el-statistic :value="webStats.blogViews">
          <template #title>
            文章总访问数
          </template>
        </el-statistic>

      </el-card>
    </el-col>
  </el-row>
  <el-row justify="space-evenly" style="margin-top: 10px">
    <el-col :span="24" >
    <el-card style="height: 500px;overflow: auto">
      <template #header>
        送给自己
      </template>
      <el-text>
        一纸荒唐言，道尽天下事
      </el-text>
    </el-card>
    </el-col>
  </el-row>

  </div>
</template>

<style scoped>
.pie{
  width: 600px;
  height: 400px;
}
</style>