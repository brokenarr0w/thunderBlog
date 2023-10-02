# thunderBlog
## 摘要
这是一个学习的产物，我想着既然已经写出来了不如部署出来方便以后写点东西，于是这个项目诞生了。
本博客使用springboot3+vue前后端分离架构构建。

## 技术栈
* 核心框架：spring
* orm框架：mybatis
* 前端框架：vue
* 状态库：vuex
* 前端路由：vue-router
* token：sa-token
* 工具库：hutool
* 前端ui库：element-plus
## 相关JS
* 打字机效果：[typeit](https://github.com/alexmacarthur/typeit)
* 播放器：[Aplayer](https://github.com/DIYgod/APlayer) 和 [meting-js](https://github.com/metowolf/MetingJS)

## 使用
运行
注：在这之前请将项目里的几处写死的ip地址更改
搜索base_url修改即可
```
cd frontend_blog
npm install
npm run dev
```
后端项目：文件上传那里的目录我直接写死了，如果要用请修改
直接用idea打开运行即可
npm会报错误，但不影响运行，猜测是typeit的问题。
## 其他
如果你对本项目有什么建议或者想法，又或者发现了什么bug，欢迎提issue
