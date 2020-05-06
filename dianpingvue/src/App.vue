<template>
  <div id="app">
    <!--    <img src="./assets/logo.png">-->
    <router-view></router-view>

  </div>
</template>

<script>

// import Login from "./components/Login";
  export default {
    name: 'App',
    // components: {Login}
  }

</script>

<style>
  #app {
    margin-left:10%;
    margin-right: 10%;
    padding: 0px;
    margin-top: 0px;
    border: 0px;
  }
</style>
