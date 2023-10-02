<script setup>
  import {useStore} from "vuex";
  import {computed} from "vue";
  const store = useStore()
  const base_url = "http://47.115.205.26/"
  const obj =[
      {
        url:'img1.jpg'
      },
    {
      url:'img2.jpg'
    },
    {
      url: 'img3.jpg'
    }
  ]
  const clientHeight = computed(() =>{
    return store.state.clientSize.clientHeight+'px'
  })

  const scrollToMain = () => {
    window.scrollTo({
      top: store.state.clientSize.clientHeight,
      behavior: "smooth",
    })
  }
</script>

<template>
  <div>
    <el-carousel :style="{'height':clientHeight}">
      <el-carousel-item v-for="item in obj" :style="{'height':clientHeight}">
        <el-image :src="base_url + item.url" fit="fill" style="opacity: 0.5;"></el-image>
      </el-carousel-item>
    </el-carousel>
  </div>
  <div class="wrapper">
    <i class="iconfont icon-bottom" style="font-size: 40px" @click="scrollToMain"></i>
  </div>
  <div class="title">
      <h1 class="context">Thunder</h1>
  </div>
</template>

<style scoped>
.wrapper {
  position: absolute;
  width: 100px;
  height: 50px;
  bottom: 40px;
  left: 0;
  right: 0;
  margin: auto;
  font-size: 26px;
  z-index: 100;
}
.title{
  position: absolute;
  left: 38%;
  top: 42%;
}
.title .context{
  color: #fff;
  font-size: 4rem;
}
</style>