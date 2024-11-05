<template>
  <table width="100%" align="center" border="1">
    <tbody>
      <tr>
        <td colspan="2" align="center">
          <h4>修改留言</h4>
        </td>
      </tr>

      <tr>
        <td>ID</td>
        <td>
          <input type="text" v-model="id" />
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
          <button @click="update()">確定</button>
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
  name: "UpdateChat",
  data() {
    return {
      id: "",
      content: "",
      message: "",
    };
  },

  methods: {
    update() {
      axios
        .put(
          "http://192.168.13.94:8080/ChatApi/update/" +
            this.id +
            "/" +
            this.content
        )
        .then((responese) => (this.message = responese.data))
        .catch(function (error) {
          console.log(error);
        });
    },
  },
};
</script>
<style></style>
