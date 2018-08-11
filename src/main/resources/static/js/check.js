// 验证中文名称
function isChinaName(name) {
    var pattern = /^[\u4E00-\u9FA5]{1,6}$/;
    return pattern.test(name);
}

// 验证手机号
function isPhoneNo(phone) {
    var pattern = /^1[34578]\d{9}$/;
    return pattern.test(phone);
}

//验证邮箱
function isMailadd(mail) {
    var pattern=/^[0-9a-zA-Z]+(?:[\_\.\-][a-z0-9\-]+)*@[a-zA-Z0-9]+(?:[-.][a-zA-Z0-9]+)*\.[a-zA-Z]+$/i;
    return pattern.test(mail);
}
// 验证函数
function formValidate() {
    var str = '';

    // 判断名称
    if($.trim($('#name').val()).length == 0) {
        str += '姓名没有输入\n';
        $('#name').focus();
    } else {
        if(isChinaName($.trim($('#name').val())) == false) {
            str += '姓名不合法\n';
            $('#name').focus();
        }
    }

    // 判断手机号码
    if ($.trim($('#phone').val()).length == 0) {
        str += '手机号没有输入\n';
        $('#phone').focus();
    } else {
        if(isPhoneNo($.trim($('#phone').val()) == false)) {
            str += '手机号码不正确\n';
            $('#phone').focus();
        }
    }

    if($.trim($('#email').val()).length == 0) {
        str += '邮箱地址没有输入\n';
        $('#email').focus();
    } else {
        if(isMailadd($.trim($('#email').val())) == false) {
            str += '邮箱地址不正确；\n';
            $('#email').focus();
        }
    }

    // 如果没有错误则提交
    if(str != '') {
        alert(str);
        return false;
    } else {
        addInfo();
    }
}

$('#directorder_spec').on('click', function() {
    formValidate();
});
function addInfo() {
    var sport_name = $("#sport_name").html();
    var sport_time = $(".selected1").html();
    var user_price = parseInt($(".selected").html());
    var ticket_number = parseInt($("#cool").val());
    var ought_amount = user_price * ticket_number;
    var user_name = $("#name").val();
    var mobile_phone = $("#phone").val();
    var user_email = $("#email").val();
    var code = $("#code").val();
    $.ajax({
        url: '/mp/payment/payment',

        //<!-- url  :请求地址 -->
        type: 'post',
        //<!--type ：请求类型:post/get -->
        data: {　　　　　　　　　　　 //<!--data ：发送给服务器的数据 -->
            // uUsername : u,　　　　　　  <!-- 使用自己声明的对象 -->
            sport_name: sport_name, //赛事名称
            sport_time: sport_time, //赛事时间
            user_price: user_price, //价格
            ticket_number: ticket_number, //数量
            ought_amount: ought_amount, //应付金额
            user_name: user_name, //姓名
            mobile_phone: mobile_phone, //手机号码
            user_email: user_email,　　 //用户邮箱
            code: code //mp code
        },
        dataType: 'json', //<!--dataType:服务器返回的数据类型 text/xml/script/html/json/jsonp -->
        success: function(data) {　　　 //<!--回调函数 -->
            location.href="http://ticket.feisea.cn/mp/payment/wechat_pay?appId="+data.start.appId+"&timestamp="+data.start.timestamp
                +"&nonceStr="+data.start.nonceStr+"&signature="+data.start.signature+"&signType="+data.pay.signType+"&packageStr="+data.pay.packageStr+"&paySign="+data.pay.paySign;
        },
        fail:function(data) {
            alert("系统错误")
            //  alert(data);
        }

    });
}