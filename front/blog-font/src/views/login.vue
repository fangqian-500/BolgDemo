<template>
  <div class="loginForm">
    <el-form ref="form" :model="form"  class="formStyle" label-width="80px">
      <el-form-item>
        <label style="font-weight: bold;font-size: 20px;word-spacing:10px;" >登录</label>
      </el-form-item>
      <el-form-item label="用户名">
        <el-input v-model="form.username"></el-input>
      </el-form-item>
        <el-form-item label="密码" >
          <el-input type="password" v-model="form.password"></el-input>
        </el-form-item>
      <el-form-item>
        <el-button type="primary" @click="onSubmit">登录</el-button>
      </el-form-item>
    </el-form>
  </div>
</template>

<script>
import axios from "axios";
import qs from 'qs';
import request from '@/utils/request'
import router from "@/router";
import cookie from "js-cookie"

export default {
  data() {
    return {
      form: {
        username: 'admin',
        password: '123456'
      },
      loginUrl:'/admin/login',
      loginUrl1:'/api/admin/login',
    }
  },
  methods: {
    onSubmit: function () {
      const userInfo = {
        username: this.form.username,
        password: this.form.password
      }

      // this.$store.dispatch('toLogin',userInfo)

     request.post(this.loginUrl,userInfo)
           .then(function (response){
             console.log('cookie = ',cookie.get('token'))
             //将返回的token存储到cookie和vuex中
             if (response.data){
                cookie.set('token',response.data)
             }
               //跳转到首页
              router.push({name:'index'})
           })
         .catch(function (error){
             console.log(error)
       })


     }
  }
}
</script>
<style>
.loginForm{
  width: 700px;
  height: 500px;
  margin-right: 0px;
  margin-left: 500px;
  border-top-width: 2px;
  margin-top: 150px;
  border-style: inset;
}
.formStyle{
  padding-top: 150px;
  width: 400px;
  height: 250px;
  padding-left: 125px;
}
</style>