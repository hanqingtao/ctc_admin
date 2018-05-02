<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>通信站管理</title>
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
		<li class="active"><a href="${ctx}/station/station/">通信站列表</a></li>
		<shiro:hasPermission name="station:station:edit"><li><a href="${ctx}/station/station/form">通信站添加</a></li></shiro:hasPermission>
	</ul>
	<form:form id="searchForm" modelAttribute="station" action="${ctx}/station/station/" method="post" class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<ul class="ul-form">
			<li><label>名称：</label>
				<form:input path="name" htmlEscape="false" maxlength="32" class="input-medium"/>
			</li>
			<li><label>联系电话：</label>
				<form:input path="phone" htmlEscape="false" maxlength="32" class="input-medium"/>
			</li>
			<li><label>联系人：</label>
				<form:input path="contact" htmlEscape="false" maxlength="32" class="input-medium"/>
			</li>
			<li class="btns"><input id="btnSubmit" class="btn btn-primary" type="submit" value="查询"/></li>
			<li class="clearfix"></li>
		</ul>
	</form:form>
	<sys:message content="${message}"/>
	<table id="contentTable" class="table table-striped table-bordered table-condensed">
		<thead>
			<tr>
				<th>名称</th>
				<th>联系电话</th>
				<th>联系人</th>
				<th>备注信息</th>
				<th>修改时间</th>
				<shiro:hasPermission name="station:station:edit"><th>操作</th></shiro:hasPermission>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${page.list}" var="station">
			<tr>
				<td><a href="${ctx}/station/station/form?id=${station.id}">
					${station.name}
				</a></td>
				<td>
					${station.phone}
				</td>
				<td>
					${station.contact}
				</td>
				<td>
					${station.remarks}
				</td>
				<td>
					<fmt:formatDate value="${station.updateDate}" pattern="yyyy-MM-dd HH:mm:ss"/>
				</td>
				<shiro:hasPermission name="station:station:edit"><td>
    				<a href="${ctx}/station/station/form?id=${station.id}">修改</a>
					<a href="${ctx}/station/station/delete?id=${station.id}" onclick="return confirmx('确认要删除该通信站吗？', this.href)">删除</a>
				</td></shiro:hasPermission>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>