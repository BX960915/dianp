<template>
  <div>
    <el-form class="xiangqig">
      <div v-for="item in dp">
        <h3>标题：{{item.title}}</h3>
        <span>内容：{{item.xiangqing}}</span>
      </div>
      <el-divider></el-divider>
      <div>
        <el-form>
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
    <div v-for="(item1,index) in pingluns" class="huifu">
      <h3>回复人：{{item1.auther}}</h3>
      <span>回复内容：{{item1.content}}</span><br>
      <h4>作者回应：{{item1.value}}</h4>
      <el-button type="primary" icon="el-icon-edit" circle v-on:click="value(index)"></el-button>
      <el-button type="danger" icon="el-icon-delete" circle v-on:click="delhuifu(index)"></el-button>
    </div>
  </div>
</template>

<script>
  export default {
    name: "mydpxiangqing",
    data() {
      return {

        pinglun: {
          plid: '',
          value: '',
          auther: '',
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
      delhuifu(index){
        var plid = this.pingluns[index].plid
        var url=plid+'/delpinglun'
        this.$axios.post(url).then(resp => {
          if (resp && resp.status === 200) {
            this.$alert('删除成功，将跳转到上一页', '提示', {
              confirmButtonText: '确定',})
            location.reload();
          }
        })
      },
      value(index) {
        var _this = this
        var plid = this.pingluns[index].plid
        this.$store.state.plid = plid
        this.$store.state.auther = this.pingluns[index].auther
        this.$store.state.pldpid = this.pingluns[index].dpid
        this.$store.state.content = this.pingluns[index].content
        this.$router.push('/editvalue')

      },
      huifu() {
        var auther = this.$store.state.user.username
        // console.log(auther)
        var dpid = this.$store.state.dpid
        this.$axios.post('/pinglun', {
          auther: auther,
          dpid: dpid,
          content: this.pinglun.content
        }).then(resp => {
          if (resp && resp.status === 200) {
            this.$alert('回复成功，', '提示', {
              confirmButtonText: '确定',})
          }
          location.reload();
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
  .edit {
    margin-left: 90%;
  }

  .huifu {
    border-radius: 15px;
    background-clip: padding-box;
    margin-top: 1%;
    padding: 35px 35px 15px 35px;
    background: #fff;
    border: 1px solid #eaeaea;
    box-shadow: 0 0 25px #cac6c6;
  }

  .xiangqig {
    border-radius: 15px;
    background-clip: padding-box;
    margin: 90px auto;
    padding: 35px 35px 15px 35px;
    background: #fff;
    border: 1px solid #eaeaea;
    box-shadow: 0 0 25px #cac6c6;
  }
</style>
