<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>订单评价管理</title>
	<meta name="decorator" content="default"/>
	<script type="text/javascript">
		$(document).ready(function() {
			//$("#name").focus();
			$("#inputForm").validate({
				submitHandler: function(form){
					loading('正在提交，请稍等...');
					form.submit();
				},
				errorContainer: "#messageBox",
				errorPlacement: function(error, element) {
					$("#messageBox").text("输入有误，请先更正。");
					if (element.is(":checkbox")||element.is(":radio")||element.parent().is(".input-append")){
						error.appendTo(element.parent().parent());
					} else {
						error.insertAfter(element);
					}
				}
			});
		});
	</script>
</head>
<body>
	<ul class="nav nav-tabs">
		<li><a href="${ctx}/payment/ordersEvaluate/">订单评价列表</a></li>
		<li class="active"><a href="${ctx}/payment/ordersEvaluate/form?id=${ordersEvaluate.id}">订单评价<shiro:hasPermission name="payment:ordersEvaluate:edit">${not empty ordersEvaluate.id?'修改':'添加'}</shiro:hasPermission><shiro:lacksPermission name="payment:ordersEvaluate:edit">查看</shiro:lacksPermission></a></li>
	</ul><br/>
	<form:form id="inputForm" modelAttribute="ordersEvaluate" action="${ctx}/payment/ordersEvaluate/save" method="post" class="form-horizontal">
		<form:hidden path="id"/>
		<sys:message content="${message}"/>		
		<div class="control-group">
			<label class="control-label">评价内容：</label>
			<div class="controls">
				<form:textarea path="content" htmlEscape="false" rows="4" maxlength="64" class="input-xxlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">评价星数：</label>
			<div class="controls">
				<form:input path="starNum" htmlEscape="false" maxlength="4" class="input-xlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">评价类型：</label>
			<div class="controls">
				<form:select path="evaluate" class="input-xlarge ">
					<form:option value="" label=""/>
					<form:options items="${fns:getDictList('orders_evaluate')}" itemLabel="label" itemValue="value" htmlEscape="false"/>
				</form:select>
			</div>
		</div>
		<div class="form-actions">
			<shiro:hasPermission name="payment:ordersEvaluate:edit"><input id="btnSubmit" class="btn btn-primary" type="submit" value="保 存"/>&nbsp;</shiro:hasPermission>
			<input id="btnCancel" class="btn" type="button" value="返 回" onclick="history.go(-1)"/>
		</div>
	</form:form>
</body>
</html>