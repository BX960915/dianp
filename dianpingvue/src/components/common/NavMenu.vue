<template>
  <div>
    <div class="menu">
      <el-menu class="menu"
               :default-active="'/index'"
               router
               mode="horizontal"
      >
        <el-menu-item
          v-for="(item,i) in navList" :key="i" :index="item.name">
          {{ item.navItem }}
        </el-menu-item>
        <i class="el-icon-switch-button" v-on:click="logout" style="float:right;font-size: 40px;color: #222;padding: 10px"></i>

        <span
          style="position: absolute;padding-top: 20px;right: 43%;font-size: 20px;font-weight: bold">点评 - 知识的互动</span>
      </el-menu>
    </div>
    <el-divider class="line"></el-divider>
  </div>
</template>

<script>
  export default {
    name: 'NavMenu',
    data() {
      return {
        navList: [
          {name: '/index', navItem: '首页'},
          {name: '/faxian', navItem: '发现'},
          {name: '/fabudp', navItem: '发布点评'},
          {name: '/admin', navItem: '个人中心'}
        ]
      }
    },
    methods:{
      logout () {
        var _this = this
            _this.$store.commit('logout')
            _this.$router.replace('/login')
      }

    }
  }
</script>

<style scoped>
  .line {
    margin-top: 0px;
  }

  a {
    text-decoration: none;
  }

  span {
    pointer-events: none;
  }
</style>

