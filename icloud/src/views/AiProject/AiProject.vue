<template>
    <div class="“common-layout">
      <el-container>
        <el-aside width="400px">
          <el-container>
            <el-input
             v-model="paintingInput"
            maxlength="100"
            :rows="30"
            show-word-limit
            type="textarea"
            placeholder="请输入描述">
          </el-input>
            <el-button icon="Edit" size="large" round @click="postData">导入描述</el-button>
          </el-container>
        </el-aside>
  
        <el-container>
          <el-header >
            <el-button icon="search" size="large"  round @click="getImage">生成图片</el-button>
          </el-header>
          <el-main >
            <img v-if="image" :src="image" alt="image" />
          </el-main>
        </el-container>
      </el-container>
    </div>
  </template>
  <script >
  export default {
    data() {
      return {
        paintingInput: '',
        image: '',
        postData:{
          data: ''
        }
      }
    }, 
  
    methods: {
    async postData() {
      try {
        const response = await axios.post('/api/data', this.paintingInput)
        console.log(response)
      } catch (error) {
        console.error(error)
      }
    },

    async getImage() {
      try {
        const response = await axios.get('/api/image')
        this.image = response.data
      } catch (error) {
        console.error(error)
      }
    }
  }
}
  </script>