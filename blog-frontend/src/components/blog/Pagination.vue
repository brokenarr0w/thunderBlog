<script setup>
import { ref,defineProps } from 'vue';
import { useRoute } from 'vue-router';
import { useStore } from 'vuex';
const store = useStore()
const route = useRoute()
let pageNum = ref(1)
const props = defineProps(['totalNum','getBlogList'])
const handleCurrentChange = (newpage) => {
  scrollToTop()
  pageNum.value = newpage
  props.getBlogList(newpage)

}
const scrollToTop = () => {
  if(route.name === 'home'){
    window.scrollTo({
      behavior: 'smooth',
      top: store.state.clientSize.clientHeight
    })
  }else{
    console.log(1);
    window.scrollTo({
      behavior: 'smooth',
      top: 0
    })
  }
}
</script>

<template>
<div>
  <el-row style=" justify-content: center; margin-top: 20px;">
   <el-pagination  :total="totalNum"
  background
  :page-size="5"
  :current-page="pageNum"
  @current-change="handleCurrentChange"
   layout="prev, pager, next">

   </el-pagination>
  </el-row>
</div>
</template>

<style scoped>

</style>