<template>
  <table width="100%" align="center" border="1">
    <tbody>
      <tr>
        <td colspan="4" align="center">
          <h4>留言板</h4>
        </td>
      </tr>

      <tr align="center">
        <td>ID</td>
        <td>NAME</td>
        <td>SUBJECT</td>
        <td>CONTENT</td>
      </tr>

      <tr v-for="chat in paginatedData" align="center">
        <td>{{ chat.id }}</td>
        <td>{{ chat.name }}</td>
        <td>{{ chat.subject }}</td>
        <td>{{ chat.content }}</td>
      </tr>
    </tbody>
  </table>

  <div>
    <button @click="gotoPage(currentPage - 1)" :disableed="currentPage == 1">
      上一頁
    </button>

    <button
      v-for="page in totalPage"
      :key="page"
      @click="gotoPage(page)"
      :class="{ active: currentPage == page }"
    >
      {{ page }}
    </button>

    <button
      @click="gotoPage(currentPage + 1)"
      :disableed="currentPage == totalPage"
    >
      下一頁
    </button>
  </div>
</template>
<script>
import axios from "axios";
export default {
  name: "AllChat",
  data() {
    return {
      id: "",
      name: "",
      subject: "",
      content: "",
      info: [],
      currentPage: 1,
      pageSize: 5,
    };
  },

  computed: {
    totalPage() {
      return Math.ceil(this.info.length / this.pageSize);
    },
    paginatedData() {
      const start = (this.currentPage - 1) * this.pageSize;
      const end = start + this.pageSize;
      return this.info.slice(start, end);
    },
  },
  mounted() {
    axios
      .get("http://192.168.13.94:8080/ChatApi/allChat")
      .then((response) => (this.info = response.data))
      .catch(function (error) {
        console.log(error);
      });
  },

  methods: {
    gotoPage(page) {
      if (page >= 1 && page <= this.totalPage) {
        this.currentPage = page;
      }
    },
  },
};
</script>
<style></style>
