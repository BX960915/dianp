<template>
  <div>
    <el-form class="zhanshi"
             v-for="(item,index) in dps.slice((currentPage-1)*pagesize,currentPage*pagesize)" :key="item.dpid">
      <span v-on:click="xiangqing(index)">
        <h2>标题：{{item.title}}</h2><br>
        <p>详情：{{item.xiangqing}}</p>
      </span>
    </el-form>
    <div class="foot">
      <el-row>
        <el-pagination
          @current-change="handleCurrentChange"
          :current-page="currentPage"
          :page-size="pagesize"
          :total="dps.length">
        </el-pagination>
      </el-row>
    </div>

  </div>
</template>

<script>
  export default {
    name: "AppIndex",
    data() {
      return {
        dps: [],
        currentPage: 1,
        pagesize: 10
      }
    },
    mounted: function () {
      this.loaddps()
    },
    methods: {
      xiangqing(index) {
        // this.$refs.edit.dialogFormVisible = true
        var dpid = this.dps[index].dpid
        this.$store.state.dpid = dpid
        // console.log(this.$store.state.dpid)
        this.$router.push('/xiangqing')
      },
      loaddps() {
        // var cc=this.dps
        // console.log(cc)
        var _this = this
        // console.log(this.$refs.dpid)
        this.$axios.get('/dps').then(resp => {
          if (resp && resp.status === 200) {
            _this.dps = resp.data
          }
        })
        // var cc=this.dps
        // console.log(cc)
      },
      handleCurrentChange: function (currentPage) {
        this.currentPage = currentPage
        console.log(this.currentPage)
      },
    }
  }

</script>

<style scoped>
  .zhanshi {
    border-radius: 15px;
    background-clip: padding-box;
    margin-left: 2%;
    margin-top: 1%;
    padding: 35px 35px 15px 35px;
    background: #fff;
    border: 1px solid #eaeaea;
    box-shadow: 0 0 25px #cac6c6;
  }

  .foot {
    margin-left: 30%;
    margin-top: 2%;
    position: absolute;
  }
</style>
