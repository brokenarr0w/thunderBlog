<script setup>
import { onMounted,ref } from "vue";
import { getWebSetting} from '@/api/admin'
import TypeIt from 'Typeit'
let data = ref('')
onMounted(async ()=> {
  const res = await getWebSetting()
  data.value = res.data
  await new TypeIt('#typed-out',{
    strings: [`${data.value.rollText}`],
    loop: true,
    lifeLike: true,
    speed: 150
  }).go()
})
const base_url = 'http://47.115.205.26/'
</script>

<template>
  <div>
  
  <el-card shadow="hover" :body-style="{padding:0}">
    <img class="image"
        :src="base_url+'avatar.jpg'"/>
    <div class="name">
      <h3>{{data.name}}</h3>
    </div>
    <div class="bottom">
        <el-text id="typed-out" size="small"></el-text>
    </div>
    <el-divider/>
    <div style="display: flex;"><el-avatar style="margin-right: 15px;">
        <el-link :href="data.github" :underline="false">github</el-link>
      </el-avatar>
      <el-avatar style="margin-right: 12px;"><el-link :href="data.netease" :underline="false">网易</el-link></el-avatar>
      <el-avatar style="margin-right: 12px;">
                <el-link :href="data.qq" :underline="false">qq</el-link>
              </el-avatar>
      <el-avatar>
              <el-link :href="data.bilibili" :underline="false">bilibili</el-link>
      </el-avatar></div>
      

    <div style="margin-top: 5px;">
      <el-collapse accordion  >
        <el-collapse-item>
          <template #title>
            最喜欢的游戏
          </template>
          <div>{{data.diy1}}</div>
        </el-collapse-item>
        <el-collapse-item>
          <template #title>
            挚爱之人
          </template>
          <div>{{data.diy2}}</div>
        </el-collapse-item>
      </el-collapse>
    </div>
  </el-card>
  <div>

  </div>
  </div>
</template>

<style scoped>
a{
  text-decoration-line:none ;
}
.image{
  width: 100%;
}
.bottom{
  margin-top: 10px;
  line-height: 18px;
  display: flex;
  justify-content: center;
  align-items: center;
}
.name{
  display: flex;
  padding-top: 20px;
  justify-content: space-around;
  font-weight: bold;
}
.cursorChar {
    display: inline-block;
    margin-left: 2px;
}

.avatar{
  margin-left: 5px;
}
</style>