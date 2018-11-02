layui.extend({
    table2: '/js/table' // {/}的意思即代表采用自有路径，即不跟随 base 路径
}).use(['table2', 'layer'], function () {
    var layer = layui.layer //弹层
        , table = layui.table2 //表格
    //执行一个 table 实例
    table.render($.extend({
        elem: '#dataTable'
        , height: 'auto'
        , title: ''
        , page: true //开启分页
        , toolbar: 'default' //开启工具栏，此处显示默认图标，可以自定义模板，详见文档
        , url: '/api/roles' //数据接口
        , request: {
            pageName: 'page' //页码的参数名称，默认：page
            , limitName: 'size' //每页数据量的参数名，默认：limit
        }
        , parseData: function (res) { //res 即为原始返回的数据
            return {
                "code": 0, //解析接口状态
                "msg": res.message, //解析提示文本
                "count": res.page.totalElements, //解析数据长度
                "data": res._embedded.roles //解析数据列表
            };
        }, cols: [[ //表头
            {type: 'checkbox', fixed: 'left'}
            , {field: 'name', title: '角色名', sort: true}
            , {field: 'remark', title: '备注'}
            , {fixed: 'right', width: 165, align: 'center', toolbar: '#barDemo'}
        ]]
    }, window.OPTIONS));

    //监听头工具栏事件
    table.on('toolbar(table)', function (obj) {
        var checkStatus = table.checkStatus(obj.config.id)
        var data = checkStatus.data //获取选中的数据
        switch (obj.event) {
            case 'add':
                x_admin_show('添加', window.CREAT_PAGE)
                break;
            case 'update':
                if (data.length === 0) {
                    layer.msg('请选择一行');
                } else if (data.length > 1) {
                    layer.msg('只能同时编辑一个');
                } else {
                    modifyData(data[0])
                }
                break;
            case 'delete':
                if (data.length === 0) {
                    layer.msg('请选择一行');
                } else {
                    deleteData(data[0], null, function () {
                        table.reload(obj.config.id, {})
                    })
                }
                break;
        }
    })

    //监听行工具事件
    table.on('tool(table)', function (obj) {
        var data = obj.data //获得当前行数据
        var layEvent = obj.event //获得 lay-event 对应的值
        if (layEvent === 'del') {
            deleteData(data, obj.del)
        } else if (layEvent === 'edit') {
            modifyData(data)
        }
    })

    function deleteData(data, cb, ok) {
        layer.confirm('真的删除行么', function (index) {
            if (cb) cb()
            //向服务端发送删除指令
            $.ajax({
                type: "DELETE",
                url: data._links.self.href
            }).then(function () {
                if (ok) ok()
            })
            layer.close(index)
        })
    }

    function modifyData(data) {
        x_admin_show('编辑', window.CREAT_PAGE + '?self=' + encodeURI(data._links.self.href))
    }
})