<template>
  <div>
    <el-carousel width="100%" height="500px">
      <el-carousel-item v-for="item in imgArray" :key="item">
        <img :src="item" class="rightImg">
      </el-carousel-item>
    </el-carousel>
  </div>
  </template>
  <script>
  
  export default {
    name: "item",
    data() {
      return {
        imgArray: [
          require('../../assets/css/image/painting.jpg'),
          require('../../assets/css/image/painting (2).jpg'),
          require('../../assets/css/image/painting (1).jpg'),
          require('../../assets/css/image/painting (3).jpg'),
        ]
      }
    }
  }
  </script>
  <style>
  .rightImg {
    margin: 10px 10px;
  }
    .el-carousel__item h3 {
      color: #ffffff;
      font-size: 18px;
      opacity: 0.75;
      line-height: 500px;
      margin: 0;
    }
    
    .el-carousel__item:nth-child(2n) {
      background-color: #fcfdff;
    }
    
    .el-carousel__item:nth-child(2n+1) {
      background-color: #ffffff;
    }
  </style>