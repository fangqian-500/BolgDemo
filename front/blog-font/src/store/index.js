import Vue from 'vue'
import Vuex from 'vuex'
import cookie from "js-cookie";

Vue.use(Vuex)

export default new Vuex.Store({
  state: {
    token: cookie.get('token'),
    loginStatus: false
  },
  getters: {
  },
  mutations: {
    SET_TOKEN(state,token){
      state.token = token
    },

    SET_LOGINSTATUS(state,bool){
      state.loginStatus = bool
    }
  },
  actions: {
    changeStatus({commit}){
      commit('SET_LOGINSTATUS',true)
    }
  },
  modules: {
  }
})
