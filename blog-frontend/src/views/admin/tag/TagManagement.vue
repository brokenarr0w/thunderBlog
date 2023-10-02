<script setup>
import { ref,toRaw,onMounted } from 'vue';
import { getTagList,deleteTagById,InsertTag } from '@/api/tag'
let tableData = ref([])
let dialogVisible = ref(false)
let formData = ref({
  id:'',
  tagName:'',
  color:'',//16进制
})
onMounted(async () => {
  const res  = await getTagList()
  tableData.value = res.data
})
const handleEdit = (row) => {
  formData.value = JSON.parse(JSON.stringify(toRaw(row)));
  dialogVisible.value = true
}
const insertTag =async () => {
  await InsertTag(formData.value).then(() => {
    ElMessage({
    message: '你成功定义了一个标签（或许贴标签不是一个好主意）？',
    type: 'success'
    })
  }).catch((res) => {
    ElMessage({
    message: '你失败了(无表情)',
    type: 'error'
    })
  })
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
      console.log(row.id);
      tableData.value.splice(index, 1)
      await deleteTagById(row.id)

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
</script>

<template>
  <el-card>
      <template #header>
        <div style="display:flex;justify-content: space-between">
          <el-text>标签列表</el-text>
  
          <el-button type="success" text @click="dialogVisible = true">添加分类</el-button>
        </div>
      </template>
      <el-table :data="tableData" table-layout="fixed" border stripe>
        <el-table-column type="selection"></el-table-column>
            <el-table-column prop="id" width="50" />
            <el-table-column
              prop="tagName"
              label="标签名"
              width="120">
            </el-table-column>
            <el-table-column
              label="标签颜色"
              width="120"
            >
            <template #default="scope">
              <el-tag type="info" :color="scope.row.color" effect="dark" @close="">{{ scope.row.tagName }}</el-tag>
              
            </template>
            
          </el-table-column>
            <el-table-column fixed="right">
        <template #default="scope">
          <el-button link type="primary"  @click="handleEdit(scope.row)"
            >编辑</el-button
          >
          <el-button link type="primary" @click="handleDelete(scope.row,scope.$index)">删除</el-button>
        </template>
      </el-table-column>
          </el-table>
          <el-dialog
      title="添加标签"
      v-model="dialogVisible"
      >
      <el-form :model="formData" ref="form"  label-width="80px" >
      <el-row :gutter="20">
        <el-col :span="12" :offset="0">
          <el-form-item label="标签名">
          <el-input v-model="formData.tagName" placeholder=""  clearable></el-input>
        </el-form-item>
        </el-col>
        <el-col :span="12" :offset="0">
          <el-form-item label="标签颜色" >
            <el-color-picker v-model="formData.color" />
          </el-form-item>
        </el-col>
      </el-row>
    </el-form>
    <template #footer>
      <el-button @click="dialogVisible = false">取消</el-button>
      <el-button type="primary" @click="insertTag">创建</el-button>
      </template>
    </el-dialog>
    </el-card>
</template>

<style scoped>

</style>