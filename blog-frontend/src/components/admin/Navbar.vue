<script setup>
import {defineProps,ref} from 'vue'
import {useRouter} from "vue-router";
const router = useRouter()

const props = defineProps(['title'])
const onBack = () => {
  router.back()
}
</script>

<template>
  <div>
    <el-page-header @back="onBack">
      <template #content>
        <el-text>{{props.title}}</el-text>
      </template>
    </el-page-header>
  </div>
</template>

<style scoped>

</style>