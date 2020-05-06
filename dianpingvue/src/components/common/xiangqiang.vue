<template>
  <div>
  <el-form class="xiangqig">
    <div v-for="item in dp">
      <h3>标题：{{item.title}}</h3>
      <span>内容：{{item.xiangqing}}</span>
    </div>
    <el-divider></el-divider>
    <div >
      <el-form >
        <el-form-item label="回复">
          <el-input type="textarea" v-model="pinglun.content"></el-input>
        </el-form-item>
      </el-form>
      <div>
        <el-button v-on:click="huifu">确 定</el-button>
      </div>

    </div>
    </el-form>

    <h3>点评展示</h3>
    <el-divider></el-divider>
    <div v-for="item1 in pingluns" class="huifu">
      <h3>回复人：{{item1.auther}}</h3>
      <span>回复内容：{{item1.content}}</span>
      <h4>作者回应：{{item1.value}}</h4>
    </div>
  </div>
</template>

<script>
  export default {
    name: "xiangqiang",
    data() {
      return {
        pinglun: {
          auther:'',
          dpid: '',
          content: ''
        },
        dpid: '',
        dp: [],
        pingluns: []
      }
    },
    mounted() {
      window.addEventListener('unload', this.saveState)
      this.loaddp()
      this.loadpinglun()
    },
    methods: {
      huifu() {
        var auther=this.$store.state.user.username
        // console.log(auther)
        var dpid = this.$store.state.dpid
        this.$axios.post('/pinglun', {
          auther: auther,
          dpid: dpid,
          content: this.pinglun.content
        }).then(resp => {
          if (resp && resp.status === 200) {
            console.log("ok")
          }
        })
      },
      saveState() {
        sessionStorage.setItem('state', JSON.stringify(this.$store.state))
      },

      loaddp() {
        // console.log(this.$store.state.dpid)
        var _this = this
        // var cc=this.user
        // console.log(cc)
        var dpid = this.$store.state.dpid
        var url = dpid + '/dpmsg'
        this.$axios
          .get(url).then(resp => {
          if (resp && resp.status === 200) {
            _this.dp = resp.data
          }
        })
        // var cc=this.user
        // console.log(cc)
      },
      loadpinglun() {
        // console.log(this.$store.state.dpid)
        var _this = this
        // var cc=this.user
        // console.log(cc)
        var dpid = this.$store.state.dpid
        var url = dpid + '/pinglunmsg'
        this.$axios
          .get(url).then(resp => {
          if (resp && resp.status === 200) {
            _this.pingluns = resp.data
          }
        })
        // var cc=this.user
        // console.log(cc)
      },
    }
  }
</script>

<style scoped>
  .huifu{
    border-radius: 15px;
    background-clip: padding-box;

margin-top: 1%;
    padding: 35px 35px 15px 35px;
    background: #fff;
    border: 1px solid #eaeaea;
    box-shadow: 0 0 25px #cac6c6;
  }
.xiangqig{
  border-radius: 15px;
  background-clip: padding-box;
  margin: 90px auto;
  padding: 35px 35px 15px 35px;
  background: #fff;
  border: 1px solid #eaeaea;
  box-shadow: 0 0 25px #cac6c6;
}
</style>
