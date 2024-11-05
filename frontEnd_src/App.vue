<template>
  <div id="app">
    <header><h3>頁首</h3></header>

    <aside>
      <p><router-link to="/">Index</router-link></p>
      <p><router-link to="/allchat">所有留言</router-link></p>
      <p><router-link to="/addchat">新增留言</router-link></p>
      <p><router-link to="/updatechat">修改留言</router-link></p>
      <p><router-link to="/deletechat">刪除留言</router-link></p>
    </aside>

    <main><router-view></router-view></main>

    <footer><h3>頁尾</h3></footer>
  </div>
</template>
<script></script>
<style>
@charset "UTF-8";
* {
  margin: 0;
  padding: 0;
}
body {
  width: 100%;
  min-width: 600px;
  max-width: 960px;
  background: #eff8e2;
  margin: 0 auto;
}
header {
  width: 100%;
  background: #828471;
}
aside {
  width: 28%;
  height: 600px;
  background: #9ad34a;
  float: left;
}
main {
  width: 70%;
  height: 600px;
  background: #bfe38c;
  float: right;
}
footer {
  width: 100%;
  background: #828471;
  clear: both;
}
</style>
