<!doctype html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>后台系统管理</title>
	<meta name="renderer" content="webkit|ie-comp|ie-stand">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width,user-scalable=yes, minimum-scale=0.4, initial-scale=0.8" />
    <meta http-equiv="Cache-Control" content="no-siteapp" />
    <link rel="stylesheet" href="//cdn.junn.top/layui/2.4.3/css/layui.css">
    <link rel="stylesheet" href="./css/xadmin.css">
    <script type="text/javascript" src="//cdn.junn.top/jquery/3.3.1/jquery.min.js"></script>
    <script src="//cdn.junn.top/layui/2.4.3/layui.js" charset="utf-8"></script>
    <script type="text/javascript" src="./js/xadmin.js"></script>
</head>
<body class="login-bg">
    
    <div class="login">
        <div class="message">管理登录</div>
        <div id="darkbannerwrap"></div>
        
        <form method="post" class="layui-form" >
            <input name="username" placeholder="用户名"  type="text" lay-verify="required" class="layui-input" >
            <hr class="hr15">
            <input name="password" lay-verify="required" placeholder="密码"  type="password" class="layui-input">
            <hr class="hr15">
            <input value="登录" lay-submit lay-filter="login" style="width:100%;" type="submit">
            <hr class="hr20" >
        </form>
    </div>

    <script>
        $(function  () {
            layui.use('form', function(){
              var form = layui.form;
              //监听提交
              form.on('submit(login)', function(data){
                  $.post("/api/user/login", data.field).then(function(res) {
                      if (res.msg) {
                          layer.msg(res.msg);
                      } else {
                          location.href = "/"
                      }
                  })
                return false;
              });
            });
        })

        
    </script>

    
    <!-- 底部结束 -->
    
</body>
</html>