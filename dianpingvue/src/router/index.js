import Vue from 'vue'
import VueRouter from "vue-router";
import Login from "../components/Login";
import Home from "../components/Home";
import AppIndex from "../components/home/AppIndex";
import FindIndex from "../components/faxian/FindIndex";
import fabudpindex from "../components/fabudp/fabudpindex";
import adminindex from "../components/admin/adminindex";
import xiangqiang from "../components/common/xiangqiang";
import edituser from "../components/admin/edituser";
import mydpxiangqing from "../components/common/mydpxiangqing";
import ImgUpload from "../components/ImgUpload";
import editvalue from "../components/common/editvalue";
Vue.use(VueRouter)

export default new VueRouter(

  {
    mode: 'history',
    routes: [
      {
        path:'/',
        // 默认地址设置
        redirect:'/login'
      },
      {
        path:'/editvalue',
        name:'editvalue',
        component: editvalue,
        meta: {
          requireAuth: true
        }
      },
      {
        path:'/ImgUpload',
        name:'ImgUpload',
        component:ImgUpload,
        meta: {
          requireAuth: true
        }
      },
      {
        path:'/mydpxiangqing',
        name:'mydpxiangqing',
        component:mydpxiangqing,
        meta: {
          requireAuth: true
        }
      },

      {
        path:'/edituser',
        name:'edituser',
        component: edituser,
        meta: {
          requireAuth: true
        }
      },
      {
        path:'/xiangqing',
        name:'xiangqing',
        component:xiangqiang,
        meta: {
          requireAuth: true
        }
      },
      {
        path: '/home',
        name: 'Home',
        component: Home,
        redirect: '/index',
        children: [
          {
            path: '/index',
            name: 'AppIndex',
            component: AppIndex,
            meta: {
              requireAuth: true
            }
          },

          {
            path: '/faxian',
            name: 'faxian',
            component: FindIndex,

            meta: {
              requireAuth: true
            }
          },
          {
            path: '/fabudp',
            name: 'fabudp',
            component: fabudpindex,
            meta: {
              requireAuth: true
            }
          },
          {
            path: '/admin',
            name: 'admin',
            component: adminindex,
            meta: {
              requireAuth: true
            }
          },
        ]
      },
      {
        path: '/login',
        name: 'Login',
        component: Login
      }
    ]
  }
)
