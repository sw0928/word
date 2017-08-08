/**
 * Created by shenjiabo on 16/7/18.
 */
var webpack = require('webpack');
var commonsPlugin = new webpack.optimize.CommonsChunkPlugin('common.js');

module.exports = {
    //插件项
    plugins: [commonsPlugin],
    //页面入口文件配置
    entry: {
        index : './index.js'
    },
    //入口文件输出配置
    output: {
        path: './build',
        filename: '[name].js'
    },
    module: {
        //加载器配置
        loaders: [{
            test: /\.js$/,
            loader: 'babel',
            exclude: /node_modules/,
            query: {
                presets: ['es2015', 'react'],
                compact : true
            }
        }, {
            test: /\.jsx$/,
            loader: 'babel!jsx-loader?harmony'
        },{
            test: /\.css$/,
            loader: "style!css"
        },],
        plugins: [commonsPlugin]
    },
    //其它解决方案配置
    resolve: {
        //查找module的话从这里开始查找
        root: './../../', //绝对路径
        //自动扩展文件后缀名，意味着我们require模块可以省略不写后缀名
        extensions: ['', '.js', '.json', '.scss'],
        //模块别名定义，方便后续直接引用别名，无须多写长长的地址
        alias: {

        }
    }
};