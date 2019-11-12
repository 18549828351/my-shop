
    function demo () {
                var abc= document.getElementById('bbb').value;

                var inObj ={
                    name :abc,
                    age: '15'
                };
                var outObj = comTrxSubSendPostJson(inObj);
                alert(outObj.cronstr);

    };

    function comTrxSubSendPostJson(inTrxObj, showErrDlg) {

        var qurl = "sendMsg.do";
        var inTrxStr = JSON.stringify(inTrxObj);
        var outTrxObj = null;
        jQuery.ajax({
            type:"post",
            url:qurl,
            timeout:300000, // TODO 5min
            // contentType: "application/json",
            // dataType:'JSON',
            data:{
                strInMsg:inTrxStr
            },
            async:false, // false代表等待ajax执行完毕后才执行alert("ajax执行完毕")语句;
            beforeSend:function () {
                // $("#loadingImgDiv").show();
            },
            complete:function () {// ajaxStop改为ajaxComplete也是一样的
                // $("#loadingImgDiv").hide();
            },
            success:function (data) {
                //outTrxObj =  JSON.parse(data);
                outTrxObj=data;
            },
            error : function(xhr, stat, e){
                console.error(xhr);
            }
        });
        return outTrxObj;
    }
