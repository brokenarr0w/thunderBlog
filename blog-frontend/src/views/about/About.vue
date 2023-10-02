<script setup>
import { ref,onMounted } from 'vue';
import {getAbout} from '@/api/about'

let about = ref({})
onMounted(async () => {
 const res= await getAbout()
 console.log("这个页面会报meting-js的一个错误，暂不知原因但不影响使用");
 about.value = res.data
})
</script>

<template>
  <el-card>
    <template #header>
      <div class="header">
        <el-text size="large" tag="b" style="text-align: center">{{about.title}}</el-text>
      </div>
    </template>
    <div class="typo content">
      <meting-js server="netease" type="playlist" list-folded="true" id="8622155520">
      </meting-js>
      <v-md-editor :model-value="about.context" mode="preview"></v-md-editor>
    </div>
  </el-card>
</template>

<style scoped>
.header {
  text-align: center;
}
</style>