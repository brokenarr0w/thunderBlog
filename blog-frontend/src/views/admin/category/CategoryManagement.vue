<script setup>
import { ref,onMounted } from 'vue';
import {getCategoryList,insertCategory,deleteCategoryById} from '@/api/category'
let tableData = ref([])
let dialogVisible = ref(false)
let formData = ref({
  id:'',
  categoryName:'',
})
onMounted(async () => {
  const res =await getCategoryList()
  tableData.value = res.data
})
const handleEdit = (row) => {
  formData.value = JSON.parse(JSON.stringify(row));
  dialogVisible.value = true
}
const handleDelete = async (row,index) => {
  ElMessageBox.confirm(
    '是否要删除这个分类（所有这个分类的文章都会被删除）',
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
      await deleteCategoryById(row.id)

      ElMessage({
        type: 'success',
        message: '这个分类走了。。。',
      })
    })
    .catch(() => {
      ElMessage({
        type: 'info',
        message: '这个分类安全了...暂时',
      })
    })
}
const createCategory =async () => {
const res = await insertCategory(formData.value)
ElMessage({
  message: '恭喜你为一些碎碎念又找到了一个新归宿',
  type: 'success'
})
}
const formRef= ref(null)
</script>

<template>

<el-card>
    <template #header>
      <div style="display:flex;justify-content: space-between">
        <el-text>分类列表</el-text>

        <el-button type="success" text @click="dialogVisible = true">添加分类</el-button>
      </div>
    </template>
    <el-table :data="tableData" table-layout="fixed" border stripe>
      <el-table-column type="selection"></el-table-column>
          <el-table-column prop="id" width="50" />
          <el-table-column
            prop="categoryName"
            label="类别名"
            width="120">
          </el-table-column>
          <el-table-column fixed="right">
      <template #default="scope">
        <el-button link type="primary" size="small" @click="handleEdit(scope.row)"
          >编辑</el-button
        >
        <el-button link type="primary" size="small" @click="handleDelete(scope.row,scope.$index)">删除</el-button>
      </template>
    </el-table-column>
        </el-table>
    <el-dialog
      title="添加类别"
      v-model="dialogVisible"
      >
      <el-form :model="formData" ref="formRef"  label-width="80px" >
      <el-row :gutter="20">
        <el-col :span="12" :offset="0">
          <el-form-item label="类别名" prop="title">
          <el-input v-model="formData.categoryName" clearable ></el-input>
        </el-form-item>
        </el-col>
      </el-row>
      

    </el-form>
    <template #footer>
      <el-button @click="dialogVisible = false">取消</el-button>
      <el-button type="primary" @click="createCategory">创建</el-button>
      </template>
    </el-dialog>
          
  </el-card>
</template>

<style scoped>

</style>