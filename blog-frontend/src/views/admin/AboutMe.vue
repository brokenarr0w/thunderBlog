<script setup>

import {MdEditor} from "md-editor-v3";
import { ref,onMounted } from "vue";
import {getAbout, saveAbout} from '@/api/about';
import 'md-editor-v3/lib/style.css';
let formData = ref('')
onMounted(async () => {
  const res = await getAbout()
  formData.value = res.data
})
const save =async () => {
  await saveAbout(formData.value).then(() => {
      ElMessage({
        message: '你对自己的评价已被记录',
        type: 'success'
      })
  })
}
</script>

<template>
  <el-text size="large">这里是网站个人信息的设置</el-text>
  <el-form label-width="120px">
    <el-text>这里是关于我的页面设置</el-text>
        <el-form-item label="标题" >
          <el-input v-model="formData.title"></el-input>
        </el-form-item>

        <el-form-item label="网易云歌曲id">
          <el-input v-model="formData.musicId"></el-input>
        </el-form-item>
        <el-form-item label="正文部分"><MdEditor v-model="formData.context"></MdEditor></el-form-item>
        <el-form-item>
          <el-button type="success" @click="save">保存</el-button>
        </el-form-item>
  </el-form>
</template>

<style scoped>

</style>