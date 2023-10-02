<script setup>
import { ref, onMounted } from 'vue'
import { getBlogList, deleteBlogById,insertBlog,UploadImage } from '@/api/blog'
import { getCategoryList } from '@/api/category'
import { getTagList } from '@/api/tag'
import {compress} from 'image-conversion';
const dialogVisible = ref(false)
let tableData = ref([])
let CategoryList = ref([])
let tagsList = ref([])
let file = ref([])
const base_url = "http://47.115.205.26/"
onMounted(async () => {
  const res = await getBlogList()
  const categoryResult = await getCategoryList()
  const tagsResult = await getTagList()
  tableData.value = res.data
  CategoryList.value = categoryResult.data
  tagsList.value = tagsResult.data
})
let formData = ref({
  id: '',
  title: '',
  firstPicture: '',
  description: '',
  content: '',
  categoryName: '',
  categoryId: '',
  createTime: '',
  tags: [],
  views:0,
  isTop: false
})
const handleEdit = async (row) => {
  formData.value = JSON.parse(JSON.stringify(row));
  dialogVisible.value = true
}
const handleDelete = async (row, index) => {
  ElMessageBox.confirm(
    '确定要删除本文章吗 ：D',
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
      await deleteBlogById(row.id)

      ElMessage({
        type: 'success',
        message: '这篇文章永远消失于这个世界',
      })
    })
    .catch(() => {
      ElMessage({
        type: 'info',
        message: '这篇文章安全了...暂时',
      })
    })
}
const InsertBlog =async () => {
  await insertBlog(formData.value).then((res)=> {
    if(res.code == "400"){
    throw new Error;
    }
    ElMessage({
        type: 'success',
        message: '这个世界上又多了些碎碎念',
      })
  })
  .catch((res) => {
    ElMessage({
        type: 'error',
        message: '有一股神秘力量阻止了碎碎念的发布，详情请打开开发者工具查看',
      })
    })
    
}
const resetForm = () => {
  formRef.value.resetFields();
}
const formRef = ref(null)
const saveWords = () => {
  formData.value.words = formData.value.content.length
}
const beforeAvatarUpload =async (file) => {
  const res =await compress(file.raw,0.6)
  const temp = new File([res],file.name,{
    type: res.type
  })
   let data = new FormData()
  data.append("image",temp)
   const img = await UploadImage(data)
  formData.value.firstPicture=img.data
}
const handleUploadImage = (event, insertImage, files) => {
  files.forEach(async file => {
    const res =await compress(file,0.6)
  const temp = new File([res],file.name,{
    type: res.type
  })
   let data = new FormData()
  data.append("image",temp)
   const img = await UploadImage(data)
    insertImage({
      url: base_url+img.data,
      desc: '测试'
    })
  });
}
</script>

<template>
  <el-card>
    
    <template #header>
      <div style="display:flex;justify-content: space-between">
        <el-text>博客列表</el-text>
        <el-button type="success" text @click="dialogVisible = true">添加文章</el-button>
      </div>
    </template>
    <el-table :data="tableData" border stripe>
      <el-table-column prop="id" width="50" ></el-table-column>
      <el-table-column prop="title" label="标题" width="120">
      </el-table-column>
      <el-table-column prop="description" label="摘要" width="240">
      </el-table-column>
      <el-table-column prop="content" label="正文" width="360">
      </el-table-column>
      <el-table-column prop="createTime" label="创建时间" width="120">
      </el-table-column>
      <el-table-column prop="categoryName" label="类别" width="120">
      </el-table-column>
      <el-table-column>
        <template #default="scope">
          <el-button link type="primary" size="small" @click="handleEdit(scope.row)">编辑</el-button>
          <el-button link type="primary" size="small" @click="handleDelete(scope.row, scope.$index)">删除</el-button>
        </template>
      </el-table-column>
    </el-table>

  </el-card>

  <el-dialog title="新增文章" v-model="dialogVisible" width="70%">
    <el-form ref="formRef" :model="formData" label-width="80px">

      <el-row :gutter="20">
        <el-col :span="12" :offset="0">
          <el-form-item label="标题" prop="title">
            <el-input v-model="formData.title"></el-input>
          </el-form-item>
        </el-col>
        <el-col :span="12" :offset="0">
          <el-form-item label="摘要" prop="description">
            <el-input v-model="formData.description" type="textarea"></el-input>
          </el-form-item>
        </el-col>
        <el-col :span="24" :offset="0">
          <el-form-item label="文章正文" prop="content">
            <v-md-editor v-model="formData.content" :disabled-menus="[]" @change="saveWords" height="400px" @upload-image="handleUploadImage"></v-md-editor>
          </el-form-item>
        </el-col>
        <el-col :span="6" :offset="0">
          <el-form-item label="分类" prop="categoryName">
            <el-select v-model="formData.categoryId" :aria-label="formData.categoryName" placeholder="选择分类" clearable filterable size="default">
              <el-option v-for="item in CategoryList" :label="item.categoryName" :value="item.id">
              </el-option>
            </el-select>
          </el-form-item>
        </el-col>
        <el-col :span="6" :offset="0">
          <el-form-item label="标签" prop="tags">
            <el-select v-model="formData.tags" placeholder="选择标签" value-key="id" clearable filterable multiple>
              <el-option v-for="item in tagsList" :key="item.id" :label="item.tagName" :value="item">
                <!-- 这里的value必须是item本身，方便上面的value-key赋值 -->
              </el-option>
            </el-select>
          </el-form-item>
        </el-col>
        <el-col :span="6" :offset="0">
          <el-form-item label="创建时间" prop="createTime">
            <el-date-picker v-model="formData.createTime" type="date" placeholder="选择一个时间" clearable />
          </el-form-item>
        </el-col>
        <el-col :span="6" :offset="0">
          <el-form-item label="是否置顶" prop="isTop">
            <el-checkbox v-model="formData.isTop" :indeterminate="false"></el-checkbox>
          </el-form-item>
        </el-col>
        <el-col :span="15" :offset="0">
          <el-form-item label="文章首图">
            <el-upload action
             ref="upload"
               :limit="1"
               :auto-upload="false"
               :on-change="beforeAvatarUpload"
               :file-list="file">
              <template #trigger><el-button size="small" type="primary">选择一张图片</el-button></template>
              <template #tip>
                <div class="el-upload__tip">只允许图片格式上传 </div>
              </template>
            </el-upload>
            <el-image :src="base_url+formData.firstPicture" fit="fill" :lazy="true"></el-image>
            
          </el-form-item>
        </el-col>
        <el-col :span="5" :offset="0">
        <el-form-item label="字数">
          <el-statistic :value="formData.words" />
        </el-form-item>
        
        </el-col>
        
      </el-row>


    </el-form>
    <template #footer>
      <span>
        <el-button @click="dialogVisible = false">取消</el-button>
        <el-button type="primary" @click="InsertBlog">创建</el-button>
        <el-button @click="resetForm" type="success">重置</el-button>
      </span>
    </template>
  </el-dialog>
</template>

<style scoped></style>