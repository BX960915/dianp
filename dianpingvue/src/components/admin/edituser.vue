<template>
  <div>
    <h3>信息更新</h3>
    <el-form ref="form" :model="user" label-width="80px">
      <el-form-item label="邮箱" prop="email">
      <el-input v-model="user.email" ></el-input>
    </el-form-item>
      <el-form-item label="简介" prop="jianjie">
        <el-input v-model="user.jianjie"></el-input>
      </el-form-item>
      <el-form-item label="地址" prop="address">
        <el-input v-model="user.address"></el-input>
      </el-form-item>
      <el-form-item label="头像"  prop="img" >
        <el-input v-model="user.img" autocomplete="off" placeholder="图片 URL"></el-input>
        <img-upload @onUpload="uploadImg" ref="imgUpload"></img-upload>
      </el-form-item>

      <el-form-item label="性别" prop="gender">
        <el-select v-model="user.gender" placeholder="请选择">
          <el-option label="男" value="男"></el-option>
          <el-option label="女" value="女"></el-option>
        </el-select>
      </el-form-item>
      <el-form-item label="确认ID" prop="id">
        <el-input v-model="user.id"></el-input>
      </el-form-item>
      <el-form-item>
        <el-button type="primary" @click="onSubmit">确认修改</el-button>
      </el-form-item>
    </el-form>
  </div>
</template>

<script>
  import ImgUpload from "../ImgUpload";
  export default {
    name: "edituser",
    components: {ImgUpload},
    component:{
      ImgUpload
    },
    data() {
      return {
        user: {
          id:'',
          gender: '',
          email: '',
          address: '',
          jianjie: '',
          img:''
        },
      }
    },
    // mounted: function () {
    //   this.loaduser()
    // },
    methods:{
      // loaduser() {
      //   var _this = this
      //   console.log(this.$store.state.user.username)
      //   var username = this.$store.state.user.username
      //   var url = username + '/usermsg'
      //   this.$axios
      //     .get(url).then(resp => {
      //     if (resp && resp.status === 200) {
      //       _this.user = resp.data
      //     }
      //   })
      // },
      uploadImg () {
        this.user.img = this.$refs.imgUpload.url
      },

      onSubmit() {
        console.log(this.$store.state.user.username)
        var username = this.$store.state.user.username
        this.$axios.post('/edituser', {
          id:this.user.id,
          gender: this.user.gender,
          email: this.user.email,
          address: this.user.address,
          jianjie: this.user.jianjie,
          img:this.user.img
        }).then(resp => {
          if (resp.data.code === 200) {
            this.$alert('修改成功', '提示', {
              confirmButtonText: '确定',})
          }
        })
      }
    }

  }
</script>
