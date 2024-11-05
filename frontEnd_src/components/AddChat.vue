<template>
  <table width="100%" align="center" border="1">
    <tbody>
      <tr>
        <td colspan="2" align="center">
          <h4>新增留言</h4>
        </td>
      </tr>

      <tr>
        <td>NAME</td>
        <td>
          <input type="text" v-model="name" />
        </td>
      </tr>

      <tr>
        <td>SUBJECT</td>
        <td>
          <input type="text" v-model="subject" />
        </td>
      </tr>

      <tr>
        <td>CONTENT</td>
        <td>
          <input type="text" v-model="content" />
        </td>
      </tr>

      <tr>
        <td colspan="2" align="center">
          <button @click="add()">確定</button>
        </td>
      </tr>

      <tr>
        <td colspan="2" align="center">
          <label v-html="message"></label>
        </td>
      </tr>
    </tbody>
  </table>
</template>
<script>
import axios from "axios";
export default {
  name: "AddChat",
  data() {
    return {
      name: "",
      subject: "",
      content: "",
      message: "",
    };
  },
  methods: {
    add() {
      var url = "http://192.168.13.94:8080/ChatApi/addChat";
      var data = {
        name: this.name,
        subject: this.subject,
        content: this.content,
      };

      axios
        .post(url, data)
        .then((response) => (this.message = response.data))
        .catch(function (error) {
          console.log(error);
        });
    },
  },
};
</script>
<style></style>
