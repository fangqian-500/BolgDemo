const { defineConfig } = require('@vue/cli-service')
module.exports = defineConfig({
  transpileDependencies: true,
  lintOnSave: false,
  // publicPath: '/api',
    devServer: {
        proxy: {
            // detail: https://cli.vuejs.org/config/#devserver-proxy
            '/api': {
                ws: true,
                target: `http://127.0.0.1:8090/blog`,
                // secure: false,
                changeOrigin: true,
                pathRewrite: {'^/api': ''}
            }
        }
    }

})

