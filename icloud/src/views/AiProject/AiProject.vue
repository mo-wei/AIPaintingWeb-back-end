<template>
  <div class="“common-layout">
    <el-container>
      <el-header >
        <el-container>
          <el-input
            v-model="paintingInput"
            maxlength="100"
            :rows="30"
            show-word-limit
            placeholder="请输入描述"
          >
          </el-input>
        </el-container>
      </el-header>

      <el-container>
        <el-header>
          <el-button icon="search" size="large" round @click="getImage"
            >生成图片</el-button
          >
        </el-header>
        <el-main>
          <img :src="urlx" alt="image" />
        </el-main>
        <el-button type="text" @click="download()"
            >下载</el-button
          >
      </el-container>
    </el-container>
  </div>
</template>
  <script>

export default {
  data() {
    return {
      paintingInput: "",
      imageUrl: "",
      urlx: require("../../assets/css/AIpaitings/0.jpg"),
      file: "",
    };
  },

  methods: {
    async getImage() {
      var url =
        "http://localhost:8989/AIPainting/sendImage" +
        "?description=" +
        this.paintingInput;
      this.axios({
        method: "GET",
        url: url,
      }).then(() => {
        alert("生成中");
        (this.paintingInput = "");
      });
    },
    download() {
      let a = document.createElement("a");
      a.href = require("../../assets/css/AIpaitings/0.jpg");
      //路径中'/'为根目录，即index.html所在的目录
      a.download = "painting.jpg";
      a.click();
    },
  },
};
</script>