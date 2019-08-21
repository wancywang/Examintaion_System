/** EasyWeb spa v3.1.2 date:2019-06-05 License By http://easyweb.vip */

layui.define(function (exports) {
    var config = {
        version: '312',  // 版本号，模块js和页面加版本号防止缓存
        base_server: 'json/', // 接口地址，实际项目请换成http形式的地址
        tableName: 'easyweb-spa',  // 存储表名
        pageTabs: false,   // 是否开启多标签
        openTabCtxMenu: true,   // 是否开启Tab右键菜单
        maxTabNum: 20,  // 最多打开多少个tab
        viewPath: 'components', // 视图位置
        viewSuffix: '.html',  // 视图后缀
        defaultTheme: 'theme-admin',  // 默认主题
        reqPutToPost: true,  // req请求put方法变成post
        cacheTab: true,  // 是否记忆Tab
        // 获取缓存的token
        getToken: function () {
            var cacheData = layui.data(config.tableName);
            if (cacheData) {
                return cacheData.token;
            }
        },
        // 清除token
        removeToken: function () {
            layui.data(config.tableName, {
                key: 'token',
                remove: true
            });
        },
        // 缓存token
        putToken: function (token) {
            layui.data(config.tableName, {
                key: 'token',
                value: token
            });
        },
        // 当前登录的用户
        getUser: function () {
            var cacheData = layui.data(config.tableName);
            if (cacheData) {
                return cacheData.login_user;
            }
        },
        // 缓存user
        putUser: function (user) {
            layui.data(config.tableName, {
                key: 'login_user',
                value: user
            });
        },
        // 获取用户所有权限
        getUserAuths: function () {
            var auths = [];
            /* var authorities = config.getUser().authorities;
             for (var i = 0; i < authorities.length; i++) {
                auths.push(authorities[i].authority);
            } */
            return auths;
        },
        // ajax请求的header
        getAjaxHeaders: function (requestUrl) {
            var headers = [];
            /* var token = config.getToken();
            if (token) {
                headers.push({
                    name: 'Authorization',
                    value: 'Bearer ' + token.access_token
                });
            } */
            return headers;
        },
        // ajax请求结束后的处理，返回false阻止代码执行
        ajaxSuccessBefore: function (res, requestUrl) {
            if (res.code == 401) {
                config.removeToken();
                layer.msg('登录过期', {icon: 2, time: 1500}, function () {
                    location.reload();
                });
                return false;
            } else if (res.code == 403) {
                layer.msg('没有访问权限', {icon: 2});
            } else if (res.code == 404) {
                layer.msg('404访问不存在', {icon: 2});
            }
            return true;
        },
        // 路由不存在处理
        routerNotFound: function (r) {
            // location.replace('#/template/error/error-404');
            layer.alert('路由' + location.hash + '不存在', {
                title: '提示',
                skin: 'layui-layer-admin',
                btn: [],
                offset: '30px',
                anim: 6,
                shadeClose: true
            });
        }
    };

    // 更新组件缓存
    layui.config({
        version: config.version
    });

    exports('config', config);
});
