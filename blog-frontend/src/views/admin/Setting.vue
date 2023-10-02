<script setup>
import { onMounted, ref } from 'vue';
import {useStore} from 'vuex'
import {getWebSetting } from '@/api/admin'
const store = useStore()
let formData = ref({
  blogName: '',
  webTitleSuffix:'',
  playlistServer: '',
  playlistId:'',
  rollText: '',
  name:'',
  github: '',
  qq: '',
  bilibili: '',
  netease:'',
  diy1:'',
  diy2:'',
})
onMounted(async () => {
  const res = await getWebSetting()
  formData.value = res.data
  store.commit('saveSiteInfo',formData.value)

})
</script>
<template>
<el-text size="large">网站相关设置</el-text>
  <div id="drag-drop"></div>
<el-form v-model="formData" label-width="80px">
  <el-row>
    <el-col :span="8">
      <el-form-item label="博客名称">
        <el-input v-model="formData.blogName"></el-input>
      </el-form-item>
    </el-col>
    <el-col :span="8" :offset="1">
      <el-form-item label="网站标题后缀">
        <el-input v-model="formData.webTitleSuffix"></el-input>
      </el-form-item>
    </el-col>
  </el-row>
  <el-divider>播放器相关</el-divider>
  <el-row>
    <el-col :span="8">
      <el-form-item label="播放器平台">
        <el-input v-model="formData.playlistServer"></el-input>
      </el-form-item>
    </el-col>
    <el-col :span="8" :offset="1">
      <el-form-item label="歌单id">
        <el-input v-model="formData.playlistId"></el-input>
      </el-form-item>
    </el-col>
  </el-row>
  <el-divider>个人卡片</el-divider>
  <el-row>
    <el-col :span="4">
      <el-form-item label="名称">
        <el-input v-model="formData.name"></el-input>
      </el-form-item>
    </el-col>
    <el-col :span="6" :offset="1">
      <el-form-item label="滚动个签">
        <el-input v-model="formData.rollText"></el-input>
      </el-form-item>
    </el-col>
    <el-col :span="6" :offset="1">
      <el-form-item label="Github">
        <el-input v-model="formData.github"></el-input>
      </el-form-item>
    </el-col>
  </el-row>
  <el-row>
    <el-col :span="6">
      <el-form-item label="QQ">
        <el-input v-model="formData.qq"></el-input>
      </el-form-item>
    </el-col>
    <el-col :span="6" :offset="1">
      <el-form-item label="bilibili">
        <el-input v-model="formData.bilibili"></el-input>
      </el-form-item>
    </el-col>
    <el-col :span="6" :offset="1">
      <el-form-item label="网易云音乐">
          <el-input v-model="formData.netease"></el-input>
      </el-form-item>
    </el-col>
  </el-row>
  <el-row :gutter="10">
    <el-col :span="6">
      <el-form-item label="卡片上的自定义内容1">
        <el-input type="textarea" v-model="formData.diy1"></el-input>
      </el-form-item>
    </el-col>
    <el-col :span="6">
      <el-form-item label="卡片上的自定义内容2">
        <el-input type="textarea" v-model="formData.diy2"></el-input>
      </el-form-item>
    </el-col>
  </el-row>
  <el-row>
    <el-form-item>
      <el-button type="primary">保存</el-button>
    </el-form-item>
  </el-row>
</el-form>
</template>
<style>

</style>