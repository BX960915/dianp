<template>
  <div>
  <div  class="huifu" v-for="item in pls">
    <h3>回复人：{{item.auther}}</h3>
    <span>回复内容：{{item.content}}</span><br>
  </div >

    <el-form class="huifu">
      <el-form-item label="编写认证信息">
        <el-input type="textarea" v-model="pinglun.value"></el-input>
      </el-form-item>
      <el-form-item>
        <el-button type="primary" @click="onSubmit">确认</el-button>
<!--        <el-button type="danger" icon="el-icon-delete" circle v-on:click="delhuifu"></el-button>-->
      </el-form-item>

    </el-form>
  </div>
</template>

<script>
    export default {
        name: "editvalue",
      data() {
        return {
          pinglun: {
            plid:'',
            value:'',
            auther:'',
            dpid: '',
            content: ''
          },
         pls: []
        }
      },
      mounted() {
        window.addEventListener('unload', this.saveState)
        this.loadpinglun()
      },
      methods:{
        loadpinglun() {
          // console.log(this.$store.state.dpid)
          var _this = this
          // var cc=this.user
          // console.log(cc)
          var plid = this.$store.state.plid
          console.log(plid)
          var url = plid + '/plvalue'
          this.$axios
            .get(url).then(resp => {
            if (resp && resp.status === 200) {
              _this.pls = resp.data
            }
          })
          // var cc=this.user
          // console.log(cc)
        },
        onSubmit(){
          this.$axios.post('/value', {
            plid: this.$store.state.plid,
            auther:this.$store.state.auther,
            dpid:this.$store.state.pldpid,
            content:this.$store.state.content,
            value: this.pinglun.value
          }).then(resp => {
            if (resp && resp.status === 200) {
              this.$alert('成功', '提示', {
                confirmButtonText: '确定',})

            }
          })
        },
        // delhuifu(){
        //   var plid=this.$store.state.plid
        //   var url=plid+'/delpinglun'
        //   this.$axios.post(url).then(resp => {
        //     if (resp && resp.status === 200) {
        //       this.$alert('删除成功，将跳转到上一页', '提示', {
        //         confirmButtonText: '确定',})
        //       this.$router.push('/mydpxiangqing')
        //     }
        //   })
        // }
      }
    }
</script>

<style scoped>
  .del{
    margin-left:90%;
  }
  .huifu{
    border-radius: 15px;
    background-clip: padding-box;
    margin-top: 3%;
    padding: 35px 35px 15px 35px;
    background: #fff;
    border: 1px solid #eaeaea;
    box-shadow: 0 0 25px #cac6c6;
  }
</style>
