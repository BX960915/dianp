<template>
  <div>
    <div v-for="item in user">
      <el-form class="header" label-position="center">
        <h2 class="usertitle">我的主页</h2>
        <el-divider class="line"></el-divider>
        <div class="block">
<!--          <el-card style="width: 135px;margin-bottom: 20px;height: 233px;float: left;margin-right: 15px" class="book"-->
<!--                   bodyStyle="padding:10px" shadow="hover">-->
            <div class="cover">
              <el-avatar shape="square" :size="150" :src="item.img" >
              </el-avatar>
<!--              <img :src="item.img" alt="封面">-->
            </div>
<!--          </el-card>-->
<!--          <el-avatar shape="square" :size="150" :src="squareUrl" >-->
<!--          </el-avatar>-->
<!--            <img :src="squareUrl" alt="封面">-->

        </div>
        <div class="usermain">
          <h3>我的ID：{{item.id}}</h3>
          <h3>昵称：{{item.username}}</h3>
          <h3>性别：{{item.gender}}</h3>

        </div>
        <div class="userright">
          <h4>邮箱：{{item.email}}</h4>
          <h4>简介：{{item.jianjie}}</h4>
          <h4>地址：{{item.address}}</h4>
        </div>
        <div class="button">
          <el-button type="primary" icon="el-icon-edit" circle v-on:click="edituser"></el-button>
        </div>
      </el-form>
    </div>
    <el-container>
      <!--        <el-main>Main</el-main>-->
      <el-container>
        <el-aside width="70%">
          <h2 style="position: center">我的提问</h2>
          <div v-on:click="xiangqing(index)" v-for="(item,index) in dps"  >
          <el-form class="aside" label-position="center"
                   label-width="0px">
            <h3 >{{item.title}}</h3>
            <span>{{item.xiangqing}}</span>
            <div class="del">
              <el-button type="danger" icon="el-icon-delete" circle v-on:click="deldp(index)"></el-button>
            </div>
          </el-form>
          </div>
        </el-aside>
        <el-main>

          <div v-for="item in user">
            <div class="cover">
              <img :src="item.img" alt="封面">
            </div>
          </div>

        </el-main>
      </el-container>
    </el-container>

  </div>

</template>

<script>
  import ImgUpload from "../ImgUpload";
  export default {
    name: "adminindex",
    component:{
      ImgUpload
    },
    data() {
      return {

        squareUrl: "http://localhost:8089/api/file/gbtufx.JPG",
        user: [],
        dps:[]

      }
    },
    mounted: function () {
      this.loaduser()
      this.loaddp()
    },
    methods:

      {
        uploadImg () {
          this.form.cover = this.$refs.imgUpload.url
        },
        xiangqing(index) {
          // this.$refs.edit.dialogFormVisible = true
          var dpid = this.dps[index].dpid
          this.$store.state.dpid = dpid
          // console.log(this.$store.state.dpid)
          this.$router.push('/mydpxiangqing')
        },

        deldp(index){
          var dpid = this.dps[index].dpid
          // console.log(dpid)
          var url= dpid+'/deldp'
          this.$axios.post(url).then(resp=>{
            if (resp && resp.status === 200){
              this.$alert('删除成功', '提示', {
                confirmButtonText: '确定',})

            }
          })
        },
        edituser() {
          var _this = this
          var userid = this.user.id
          console.log(userid)
          this.$router.push('/edituser')
        },
        loaduser() {
          var _this = this
          // console.log(this.$store.state.user.username)
          var username = this.$store.state.user.username
          var url = username + '/usermsg'
          this.$axios
            .get(url).then(resp => {
            if (resp && resp.status === 200) {
              _this.user = resp.data
            }
          })
        },
        loaddp() {
          var _this = this
          // var cc=this.user
          // console.log(cc)
          console.log(this.$store.state.user.username)
          var auther = this.$store.state.user.username
          var url = auther + '/mydpmsg'
          this.$axios
            .get(url).then(resp => {
            if (resp && resp.status === 200) {
              _this.dps = resp.data
            }
          })
          // var cc=this.user
          // console.log(cc)
        }
      }
  }
</script>

<style scoped>
  .button {
    margin-top: 180px;
    margin-left: 90%;
  }

  .userright {
    position: absolute;
    margin-top: 40px;
    margin-left: 40%;
  }

  .usertitle {
    position: center;
    margin: 0px auto 0px auto;
    text-align: center;
    color: #505458;
  }
.del{
  margin-left:90%;
}
  .aside {
    margin-top: 10px;
    border-radius: 15px;
    background-clip: padding-box;
    width: 90%;
    padding: 35px 35px 15px 35px;
    background: #fff;
    border: 1px solid #eaeaea;
    box-shadow: 0 0 25px #cac6c6;
  }

  .header {
    border-radius: 15px;
    background-clip: padding-box;
    width: 96%;
    height: 300px;
    padding: 35px 35px 15px 35px;
    background: #fff;
    border: 1px solid #eaeaea;
    box-shadow: 0 0 25px #cac6c6;
  }

  .block {
    margin-top: 40px;
    margin-left: 0px;
    position: absolute;
  }

  .usermain {
    width: 25%;
    position: absolute;
    margin-top: 40px;
    margin-left: 12%;
  }

  .el-footer {
    background-color: #ff3f2b;
    color: #333;
    text-align: center;
    line-height: 60px;
  }


  .el-main {
    background-color: #E9EEF3;
    color: #333;
    text-align: center;
    line-height: 160px;
  }

  body > .el-container {
    margin-bottom: 40px;
  }

  .el-container:nth-child(5) .el-aside,
  .el-container:nth-child(6) .el-aside {
    line-height: 260px;
  }

  .el-container:nth-child(7) .el-aside {
    line-height: 320px;
  }

</style>
