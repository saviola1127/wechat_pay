$(function() {
    $(".clickwn").click(function() {
        $(".flick-menu-mask").show();
        $(".spec-menu").show();
    })

    $(".tclck").click(function() {
        $(".flick-menu-mask").hide();
        $(".spec-menu").hide();
    })

    /* $("#cool").focus(function(){
         var oi = $('#cool').val();

         $('.amount').html(oi)
     });*/

    $('#cool').bind('input propertychange', function() {
        /* alert(this.value);*/
        $('.amount').html(this.value)

    }).bind('input input', function() {

    });

    // $('#time a').click(function () {
    //     var cook = $(this).index();
    //     $('#time a').eq(cook).addClass('selected1').siblings().removeClass('selected1');
    // })

    //加减面板
    $(function() {
        //加号
        $(".jia").click(function() {

            var $parent = $(this).parent(".num");
            var $num = window.Number($(".inputBorder", $parent).val());
            $(".inputBorder", $parent).val($num + 1);

            $('.amount').html($num + 1)

        });

        //减号
        $(".jian").click(function() {
            var $parent = $(this).parent(".num");
            var $num = window.Number($(".inputBorder", $parent).val());
            if($num > 2) {
                $(".inputBorder", $parent).val($num - 1);
                $('.amount').html($num - 1)

            } else {
                $(".inputBorder", $parent).val(1);
                $('.amount').html($num)

            }
        });

    })

})