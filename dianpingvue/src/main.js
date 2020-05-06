// The Vue build version to load with the `import` command
// (runtime-only or standalone) has been set in webpack.base.conf with an alias.
import Vue from 'vue'
import App from './App'
import router from './router'
import ElementUI from 'element-ui'
import 'element-ui/lib/theme-chalk/index.css'
import store from './store'

Vue.use(ElementUI)
var axios = require('axios')
axios.defaults.baseURL = 'http://localhost:8089/api'//记住这混蛋defaults
Vue.prototype.$axios =axios
Vue.config.productionTip = false


router.beforeEach((to, from, next) => {
    if (to.meta.requireAuth) {
      if (store.state.user.username) {
        next()
      } else {
        next({
          path: 'login',
          query: {redirect: to.fullPath}
        })
      }
    } else {
      next()
    }
  }
)
new Vue({
  el: '#app',
  router,
  store,
  render : h=>h(App),
  components: { App },
  template: '<App/>'
})
