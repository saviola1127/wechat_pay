<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
    <title>支付选择画面</title>
    <meta name="keywords" content="关键字,关键字">
    <meta name="description" content="">
    <style type="text/css">
        *{margin: 0;padding: 0;}
        body{font-size:12px;font-family:"微软雅黑";color:#666;}
    </style>
</head>
<body>
<div style="margin:40px auto;width:400px;">
    <a href="javascript:wechat();">微信支付</a><br/><br/><br/>
    <a href="javascript:ali();">支付宝支付</a>
</div>
<script type="text/javascript" src="http://apps.bdimg.com/libs/jquery/2.1.4/jquery.min.js"></script>
<script type="text/javascript">
    function wechat(){
        var redirect_uri = "https://ticket.feisea.cn/mp/payment/payment.htm?hotelId=14501";
        var href = "https://open.weixin.qq.com/connect/oauth2/authorize?redirect_uri=" + encodeURIComponent(redirect_uri);
        href += "&appid=wxa29362d013ba8ba0&response_type=code&scope=snsapi_base";
        window.location.href = href;
    }
    function ali(){

    }
</script>
</body>
</html>