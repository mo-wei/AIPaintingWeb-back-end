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
            placeholder="请输入描述"
          >
          </el-input>
        </el-container>
      </el-aside>

      <el-container>
        <el-header>
          <el-button icon="search" size="large" round @click="getImage"
            >生成图片</el-button
          >
          <el-button type="text" @click="download()"
            >下载</el-button
          >
        </el-header>
        <el-main>
          <img :src="urlx" alt="image" />
        </el-main>
      </el-container>
    </el-container>
  </div>
</template>
  <script>
import { Message } from "element-ui";
import Vue from "vue";
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
      }).then((res) => {
        alert(res.data);
        (this.paintingInput = ""), (this.imageUrl = res.data);
      });
    },
    submitForm() {
      let formData = new FormData();
      formData.append("ifile", this.file);
      formData.append("path", "/");

      let config = {
        headers: {
          "Content-Type": "multipart/form-data",
          satoken: sessionStorage.getItem("saToken"),
        },
      };
      console.log(config);
      var url = "http://localhost:8989/upload";
      this.$http.post(url, formData, config).then((res) => {
        console.log(res);
        let data = res.data;
        if (data.code !== 10000) {
          this.$message.error(data.message);
        } else {
          this.getFileAndFolder();
          this.$message({
            message: "上传成功",
            type: "success",
          });
        }
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