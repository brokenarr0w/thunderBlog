<script setup>
import { ref,onMounted } from 'vue';
import {getMomentList,insertMoment,deleteMomentById} from '@/api/moment'
let dialogVisible = ref(false)
let formData = ref({
    id:'',
    content:"",
    createTime:"",
    words: '0',
    likes: '0'
})
let tableData = ref([])
onMounted(async () => {
  const res = await getMomentList()
  tableData.value = res.data
})
const handleEdit = (row) => {
  formData.value = JSON.parse(JSON.stringify(row));
  dialogVisible.value = true
}
const handleDelete = async (row,index) => {
  ElMessageBox.confirm(
    '是否要删除该标签',
    '提示',
    {
      confirmButtonText: '残忍的删除',
      cancelButtonText: '不，只是点错了',
      type: 'warning',
      center: true,
    }
  )
    .then(async () => {
      tableData.value.splice(index, 1)
      await deleteMomentById(row.id)

      ElMessage({
        type: 'success',
        message: '这个标签永远消失了。。。',
      })
    })
    .catch(() => {
      ElMessage({
        type: 'info',
        message: '这个标签安全了...暂时',
      })
    })
}
const saveWords = (event) => {
  formData.value.words = formData.value.content.length
}
const createMoment =async () => {
  await insertMoment(formData.value).then(() => {
    ElMessage({
    message: '你成功发送了一条动态',
    type: 'success'
    })
  }).catch((res) => {
    console.log(res);
    ElMessage({
    message: '你失败了(无表情)',
    type: 'error'
    })
  })

}
</script>

<template>
 <el-card shadow="always">
  <template #header>
    <div style="display:flex;justify-content: space-between">
        <el-text>动态列表</el-text>

        <el-button type="success" text @click="dialogVisible = true">添加动态</el-button>
      </div>
    </template>
  <el-table :data="tableData">
    <el-table-column type="selection"></el-table-column>
    <el-table-column prop="content" label="内容"></el-table-column>
    <el-table-column prop="createTime" label="创建时间"></el-table-column>
    <el-table-column prop="likes" label="点赞数"></el-table-column>
    <el-table-column prop="words" label="字数"></el-table-column>
    <el-table-column fixed="right">
        <template #default="scope">
          <el-button link type="primary"  @click="handleEdit(scope.row)"
            >编辑</el-button
          >
          <el-button link type="primary" @click="handleDelete(scope.row,scope.$index)">删除</el-button>
        </template>
      </el-table-column>
  </el-table>
   </el-card>
   <el-dialog
    title="更新动态"
    v-model="dialogVisible"
    width="60%"
>
    <el-row :gutter="20">
      <el-col :span="24" :offset="0">
        <el-form-item label="文章正文" prop="content">
          <v-md-editor v-model="formData.content" height="400px" @blur="saveWords(event)"></v-md-editor>
          </el-form-item>
      </el-col>
      <el-col :span="12" :offset="0">
          <el-form-item label="创建时间" prop="createTime">
            <el-date-picker v-model="formData.createTime" type="date" placeholder="选择一个时间" clearable />
          </el-form-item>
          </el-col>
          <el-col :span="12" :offset="0">
            <el-form-item label="字数">
              <el-statistic :value="formData.words" />
            </el-form-item>
          </el-col>
          
    </el-row>
    
    <template #footer>
    <span>
      <el-button @click="dialogVisible = false">取消</el-button>
      <el-button type="primary" @click="createMoment">创建</el-button>
    </span>
    </template>
   </el-dialog>
   
</template>

 
  

<style scoped>

</style>