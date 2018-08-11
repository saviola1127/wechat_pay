function getRequest(strParame) {
    var args = new Object();
    var query = location.search.substring(1);

    var pairs = query.split("&"); // Break at ampersand
    for (var i = 0; i < pairs.length; i++) {
        var pos = pairs[i].indexOf('=');
        if (pos == -1) continue;
        var argname = pairs[i].substring(0, pos);
        var value = pairs[i].substring(pos + 1);
        value = decodeURIComponent(value);
        args[argname] = value;
    }
    return args[strParame];
}

function setcode() {
    $("#code").val(getRequest('code'))
}

function convertTime(jsonTime, format) {
    var date = new Date(parseInt(jsonTime.replace("/Date(", "").replace(")/", ""), 10));
    var formatDate = date.format(format);
    return formatDate;
}
Date.prototype.format = function (format) {
    var date = {
        "M+": this.getMonth() + 1,
        "d+": this.getDate(),
        "h+": this.getHours(),
        "m+": this.getMinutes(),
        "s+": this.getSeconds(),
        "q+": Math.floor((this.getMonth() + 3) / 3),
        "S+": this.getMilliseconds()
    };

    if (/(y+)/i.test(format)) {
        format = format.replace(RegExp.$1, (this.getFullYear() + '').substr(4 - RegExp.$1.length));
    }

    for (var k in date) {
        if (new RegExp("(" + k + ")").test(format)) {
            format = format.replace(RegExp.$1, RegExp.$1.length == 1 ? date[k] : ("00" + date[k]).substr(("" + date[k]).length));
        }
    }

    return format;
}
$.ajax({
    type: "get",
    url: "/mp/sportinfo/all",
    dataType: "json",
    success: function(data) {
        var price="",time="";
        $.each(data[0].sportTimeTicketPriceList, function() {
            var formatTime = convertTime('/Date('+this.sportTime+')/', "yyyy年MM月dd日");
            var sportId=this.sportId;
            time+='<a title="price" data-sportId="'+sportId+'" class="J_ping1">'+formatTime+'</a>'
            $(this.ticketPriceList).each(function(){
                price+='<a style="display:none;" onclick="choosePrice(this)" class="J_ping price'+sportId+'">'+$(this)[0].price+'</a>'
            })
        });
        $("#price").html('<p>'+price+'</p>');
        $("#time").html(time);
//$(".pro-color p").find(".price2").show();
        $("#time").on("click","a",function(){
            var sportId=$(this).data("sportid");
            console.log(sportId)
            $(this).addClass("selected1").siblings().removeClass("selected1");
            $("#price a").hide();
            $("#price .price"+sportId+"").show();
        });

        $("#time a").first().trigger("click");
    }
});