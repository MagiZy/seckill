<%@page contentType="text/html; charset=UTF-8" %>
<%@include file="common/tag.jsp" %>
<!DOCTYPE html>
<html>
<head>
    <title>秒杀商品列表</title>
    <%@include file="common/head.jsp" %>
</head>
<body background="/resources/img/bg.jpg">
<div style="float:right;" id="github_iframe"></div>
<div class="container">
    <div class="panel panel-default">
        <div class="panel-body">
            <div class="form-group">
                <label>
                    商品编号:${seckill.seckillId}&nbsp;
                    商品名称:${seckill.name}&nbsp;
                    商品数量:${seckill.number}&nbsp;
                    秒杀开始时间:<fmt:formatDate value="${seckill.startTime}" pattern="yyyy-MM-dd"/>&nbsp;
                    秒杀结束时间:<fmt:formatDate value="${seckill.endTime}" pattern="yyyy-MM-dd"/>&nbsp;
                    秒杀创建时间:<fmt:formatDate value="${seckill.createTime}" pattern="yyyy-MM-dd"/>
                </label>
            </div>
            <div class="r1">
                名称:<input type="text" name="seckill-name" id="seckill-name">
            </div>
            <div class="r2">
                数量:<input type="text" name="number" id="number">
            </div>
            <div class="r3">
                秒杀开始时间:<input type="date" name="startTime" id="startTime">
            </div>
            <div class="r4">
                秒杀结束时间:<input type="date" name="endTime" id="endTime">
            </div>
            <button class="btn-default" id="submit">提交</button>
        </div>
    </div>
</div>
<script src="/resources/js/back.js" type="text/javascript"></script>
<!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
<script src="http://apps.bdimg.com/libs/jquery/2.0.0/jquery.min.js"></script>

<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
<script src="http://apps.bdimg.com/libs/bootstrap/3.3.0/js/bootstrap.min.js"></script>
<script>
    $(function () {

        var seckillId =${seckill.seckillId};

        $('#submit').click(function () {
            $.ajax({
                type: "POST",
                dataType: "json",
                data: {
                    name: $('#seckill-name').val(),
                    number: $('#number').val(),
                    startTime:$('#startTime').val(),
                    endTime:$('#endTime').val()
                },
                url: "/seckill/manager/" + seckillId + "/edit.do",
                success: function (result) {
                    alert(result.msg);
                },
                error:function (XMLHttpRequest, textStatus, errorThrown) {
                    alert( XMLHttpRequest.status + $('#startTime').val());
                }
            })
        })
    })
</script>
</body>
</html>