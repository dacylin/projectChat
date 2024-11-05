<template>
  <table width="100%" align="center" border="1">
    <tbody>
      <tr>
        <td colspan="2" align="center">
          <h4>刪除留言</h4>
        </td>
      </tr>

      <tr>
        <td>ID</td>
        <td>
          <input type="text" v-model="id" />
        </td>
      </tr>

      <tr>
        <td colspan="2" align="center">
          <button @click="deleteMessage()">確定</button>
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
  name: "DeleteChat",
  data() {
    return {
      id: "",
      message: "",
    };
  },

  methods: {
    deleteMessage() {
      axios
        .delete("http://192.168.13.94:8080/ChatApi/delete/" + this.id)
        .then((response) => (this.message = response.data))
        .catch(function (error) {
          console.log(error);
        });
    },
  },
};
</script>
<style></style>
