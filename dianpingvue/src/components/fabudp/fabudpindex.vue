<template>
<!--  <el-form :model="dp" :rules="rules" ref="dp" class="editdp" >-->
    <el-form :model="dp" status-icon :rules="rules" ref="dp" class="editdp" >
    <h2>写问题，求点评：</h2>

      <el-form-item label="标题" prop="title">
        <el-input  v-model="dp.title" autocomplete="off"></el-input>
      </el-form-item>
      <el-form-item label="正文详情">
        <el-input type="textarea" :autosize="{ minRows: 24}" v-model="dp.xiangqing"></el-input>
      </el-form-item>

    <div>
      <span>分类：</span>
      <el-select v-model="dp.cid" placeholder="请选择分类">
        <el-option label="文学" value="1"></el-option>
        <el-option label="游戏" value="2"></el-option>
        <el-option label="音乐" value="3"></el-option>
        <el-option label="电影" value="4"></el-option>
        <el-option label="生活" value="5"></el-option>
        <el-option label="科技" value="6"></el-option>
      </el-select>

    </div>
    <el-form-item>
      <el-button type="primary" v-on:click="onSubmit('dp')">确 定</el-button>
    </el-form-item>
  </el-form>
</template>

<script>

  export default {
    name: 'fabudpindex',
    data() {
      var checkAge = (rule, value, callback) => {
          if (value === '') {
            callback(new Error('请输入标题'));
          }
            callback();
      };
      return {
        dp: {
          auther: '',
          title: '',
          xiangqing: '',
          cid: ''
        },
        rules: {
          title: [
            // {required: true, message: '请输入问题名称', trigger: 'blur'},
            // {min: 3, max: 5, message: '长度在 3 到 5 个字符', trigger: 'blur'}
            { validator: checkAge, trigger: 'blur' }
          ],
        }
      }
    },
    methods: {
      onSubmit(dp){
        this.$refs[dp].validate((valid) => {
          if (valid) {
            // alert('submit!');
            console.log(this.$store.state.user.username)
              var username = this.$store.state.user.username
              this.$axios.post('/dp', {
                auther: username,
                title: this.dp.title,
                xiangqing: this.dp.xiangqing,
                cid: this.dp.cid
              }).then(resp => {
                if (resp && resp.status === 200) {
                  this.$alert('发布成功', '提示', {
                    confirmButtonText: '确定',})
                }
              }
              )
          } else {
            console.log('error submit!!');
            return false;
          }
        });
      }
      // onSubmit(dp) {
      //   console.log(this.$store.state.user.username)
      //   var username = this.$store.state.user.username
      //   this.$axios.post('/dp', {
      //     auther: username,
      //     title: this.dp.title,
      //     xiangqing: this.dp.xiangqing,
      //     cid: this.dp.cid
      //   }).then(resp => {
      //     if (resp && resp.status === 200) {
      //       this.$alert('发布成功', '提示', {
      //         confirmButtonText: '确定',})
      //
      //     }
      //   }
      //   )
      //
      // }
    }
  }
</script>

<style scoped>
  .editdp {
    border-radius: 15px;
    background-clip: padding-box;
    padding: 35px 35px 15px 35px;
    background: #fff;
    border: 1px solid #eaeaea;
    box-shadow: 0 0 25px #cac6c6;
  }
</style>
