/** EasyWeb spa v3.1.2 date:2019-06-05 License By http://easyweb.vip */

layui.config({
    version: true,   // 更新组件缓存，设为true不缓存，也可以设一个固定值
    base: 'assets/module/'
}).extend({
    formSelects: 'formSelects/formSelects-v4',
    treetable: 'treetable-lay/treetable',
    dropdown: 'dropdown/dropdown',
    notice: 'notice/notice',
    step: 'step-lay/step',
    dtree: 'dtree/dtree',
    citypicker: 'city-picker/city-picker',
    tableSelect: 'tableSelect/tableSelect',
    cropper: 'cropper/cropper',
    zTree: 'zTree/zTree'
}).use(['config', 'layer', 'element', 'index', 'admin', 'laytpl'], function () {
    var $ = layui.jquery;
    var layer = layui.layer;
    var element = layui.element;
    var config = layui.config;
    var index = layui.index;
    var admin = layui.admin;
    var laytpl = layui.laytpl;

    // 检查是否登录
    if (!config.getToken()) {
        // return location.replace('components/login/login.html');
    }

    // 获取用户信息
    admin.req('userInfo.json', {}, function (res) {
        if (200 == res.code) {
            config.putUser(res.user);
            admin.renderPerm();  // 移除没有权限的元素
            $('#huName').text(res.user.nickName);
        } else {
            layer.msg('获取用户失败', {icon: 2});
        }
    }, 'get');

    // 加载侧边栏
    admin.req('menus.json?v=307', {}, function (res) {
        laytpl(sideNav.innerHTML).render(res, function (html) {
            $('.layui-layout-admin .layui-side .layui-nav').html(html);
            element.render('nav');
        });
        index.regRouter(res);  // 注册路由
        index.loadHome({  // 加载主页
            url: '#/stuIndex/stuIndex',
            name: '<i class="layui-icon layui-icon-home"></i>'
        });
    }, 'get');

    // 移除loading动画
    setTimeout(function () {
        admin.removeLoading();
    }, 300);

    // 提示
    if (!config.pageTabs) {
        layer.confirm('系统默认关闭多标签功能，你可以在设置界面开启', {
            skin: 'layui-layer-admin',
            area: '280px',
            title: '温馨提示',
            shade: 0,
            btn: ['打开设置', '知道了']
        }, function (i) {
            layer.close(i);
            $('a[ew-event="theme"]').trigger('click');
        });
    }

});
