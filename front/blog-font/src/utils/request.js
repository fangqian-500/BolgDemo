
import axios from 'axios';
import cookie from "js-cookie";


//自定义配置来封装一个Axios请求
const service = axios.create({
    timeout: 1000,
    baseURL: '/api'
})

//拦截器处理，(在发送前需要做的处理)在请求或响应被then或catch处理前拦截他们
//请求拦截器
service.interceptors.request.use(config=>{
    //在发送请求之前做的事情
    // console.log("config = ",config)
    //cookie中取出token，附带给请求头
    if (cookie.get('token')!=null){
        cookie.remove('token')
        //让每个请求携带token
        // config.headers['Authorization'] = 'Bearer ' + cookie.get('token')
    }
    //post 请求参数json化
    if(config.method =='post'){
       typeof config.data === 'object'? JSON.stringify(config.data):config.data
    }
    return config
    },
    error => {
    //对请求错误做些什么
        return Promise.reject(error)
});


//响应拦截器
service.interceptors.response.use(response=>{
    //对响应数据做点什么
    //如果响应码为401,则token过期，跳转
    console.log('response = ',response)
    if (response.status =='401'){
        //直接跳转登录页面
        this.router.push('login')
    }
    return response;
    },
    error=>{
    //对响应错误做点什么
        return Promise.reject(error)
})

export default service

