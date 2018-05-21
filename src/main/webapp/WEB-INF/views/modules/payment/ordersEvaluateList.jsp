<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>订单评价管理</title>
	<meta name="decorator" content="default"/>
	<script type="text/javascript">
		$(document).ready(function() {
			
		});
		function page(n,s){
			$("#pageNo").val(n);
			$("#pageSize").val(s);
			$("#searchForm").submit();
        	return false;
        }
	</script>
</head>
<body>
	<ul class="nav nav-tabs">
		<li class="active"><a href="${ctx}/payment/ordersEvaluate/">订单评价列表</a></li>
		<shiro:hasPermission name="payment:ordersEvaluate:edit"><li><a href="${ctx}/payment/ordersEvaluate/form">订单评价添加</a></li></shiro:hasPermission>
	</ul>
	<form:form id="searchForm" modelAttribute="ordersEvaluate" action="${ctx}/payment/ordersEvaluate/" method="post" class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<ul class="ul-form">
			<li><label>创建时间：</label>
				<input name="beginCreateDate" type="text" readonly="readonly" maxlength="20" class="input-medium Wdate"
					value="<fmt:formatDate value="${ordersEvaluate.beginCreateDate}" pattern="yyyy-MM-dd HH:mm:ss"/>"
					onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss',isShowClear:false});"/> - 
				<input name="endCreateDate" type="text" readonly="readonly" maxlength="20" class="input-medium Wdate"
					value="<fmt:formatDate value="${ordersEvaluate.endCreateDate}" pattern="yyyy-MM-dd HH:mm:ss"/>"
					onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss',isShowClear:false});"/>
			</li>
			<li><label>评价类型：</label>
				<form:select path="evaluate" class="input-medium">
					<form:option value="" label=""/>
					<form:options items="${fns:getDictList('orders_evaluate')}" itemLabel="label" itemValue="value" htmlEscape="false"/>
				</form:select>
			</li>
			<li class="btns"><input id="btnSubmit" class="btn btn-primary" type="submit" value="查询"/></li>
			<li class="clearfix"></li>
		</ul>
	</form:form>
	<sys:message content="${message}"/>
	<table id="contentTable" class="table table-striped table-bordered table-condensed">
		<thead>
			<tr>
				<th>评价星数</th>
				<th>创建时间</th>
				<th>评价类型</th>
				<shiro:hasPermission name="payment:ordersEvaluate:edit"><th>操作</th></shiro:hasPermission>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${page.list}" var="ordersEvaluate">
			<tr>
				<td><a href="${ctx}/payment/ordersEvaluate/form?id=${ordersEvaluate.id}">
					${ordersEvaluate.starNum}
				</a></td>
				<td>
					<fmt:formatDate value="${ordersEvaluate.createDate}" pattern="yyyy-MM-dd HH:mm:ss"/>
				</td>
				<td>
					${fns:getDictLabel(ordersEvaluate.evaluate, 'orders_evaluate', '')}
				</td>
				<shiro:hasPermission name="payment:ordersEvaluate:edit"><td>
    				<a href="${ctx}/payment/ordersEvaluate/form?id=${ordersEvaluate.id}">修改</a>
					<a href="${ctx}/payment/ordersEvaluate/delete?id=${ordersEvaluate.id}" onclick="return confirmx('确认要删除该订单评价吗？', this.href)">删除</a>
				</td></shiro:hasPermission>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>