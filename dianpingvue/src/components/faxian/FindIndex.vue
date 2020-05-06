<template>
<el-container>
  <el-aside style="width: 200px;margin-top: 20px">
    <switch></switch>
    <SideMenu @indexSelect="listByCategory" ref="sideMenu"></SideMenu>
  </el-aside>
  <el-main>
    <dpzhanshi class="dp-areas" ref="dpArea"></dpzhanshi>
<!--    <books class="books-area"></books>-->
  </el-main>
</el-container>
</template>

<script>
import SideMenu from "./SideMenu";
import Dpzhanshi from "./dpzhanshi";
  export default {
    name: 'FindIndex',
    components:{
      Dpzhanshi,
      SideMenu
    },
    methods: {
      listByCategory () {
        var _this = this
        var cid = this.$refs.sideMenu.cid
        var url = cid + '/dps'
        this.$axios.get(url).then(resp => {
          if (resp && resp.status === 200) {
            _this.$refs.dpArea.dps = resp.data
          }
        })
      }
    }

  }
</script>

<style scoped>

</style>
