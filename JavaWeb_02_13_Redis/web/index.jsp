<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
	<head>
		<title>省份列表</title>
		<script src="js/jquery-3.3.1.min.js"></script>
		<script>
			$(function () {
			    // 发送ajax请求，加载所有省份信息
				$.get("provinceServlet", {}, function (data) {
				    // 1.获取select
					var province = $("#province");
					// 2.遍历json数组
					$(data).each(function () {
						// 3.创建option
						var option = "<option name='" + this.id + "'>" + this.name + "</option>";
						// 4.select追加option
                        province.append(option);
                    });
                });
            })
		</script>
	</head>
	<body>
		<select id="province">
			<option>---请选择省份---</option>
		</select>
	</body>
</html>
