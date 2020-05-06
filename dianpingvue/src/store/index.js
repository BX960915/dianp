import Vue from 'vue'
import Vuex from 'vuex'

Vue.use(Vuex)

export default new Vuex.Store({
  state:sessionStorage.getItem('state') ? JSON.parse(sessionStorage.getItem('state')):  {
    user: {
      username: window.localStorage.getItem('user' || '[]') == null ? '' : JSON.parse(window.localStorage.getItem('user' || '[]')).username
    },
    dpid:'',
    userid:'',
    plid:'',
    auther:'',
    pldpid:'',
    content:''

  },
  mutations: {
    login (state, data) {
      state.user = data
      window.localStorage.setItem('user', JSON.stringify(data))
    },
    logout (state) {
      state.user = []
      window.localStorage.removeItem('user')
    }

  }
})
