<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>通信线路节点管理</title>
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
		<li class="active"><a href="${ctx}/node/node/">通信线路节点列表</a></li>
		<shiro:hasPermission name="node:node:edit"><li><a href="${ctx}/node/node/form">通信线路节点添加</a></li></shiro:hasPermission>
	</ul>
	<form:form id="searchForm" modelAttribute="node" action="${ctx}/node/node/" method="post" class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<ul class="ul-form">
			<li><label>结点名称：</label>
				<form:input path="name" htmlEscape="false" maxlength="32" class="input-medium"/>
			</li>
			<li><label>状态：</label>
				<form:select path="status" class="input-medium">
					<form:option value="" label=""/>
					<form:options items="${fns:getDictList('node_status')}" itemLabel="label" itemValue="value" htmlEscape="false"/>
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
				<th>结点名称</th>
				<th>顺序号</th>
				<th>经度</th>
				<th>状态</th>
				<th>纬度</th>
				<shiro:hasPermission name="node:node:edit"><th>操作</th></shiro:hasPermission>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${page.list}" var="node">
			<tr>
				<td><a href="${ctx}/node/node/form?id=${node.id}">
					${node.name}
				</a></td>
				<td>
					${node.sort}
				</td>
				<td>
					${node.longitude}
				</td>
				<td>
					${fns:getDictLabel(node.status, 'node_status', '')}
				</td>
				<td>
					${node.latitude}
				</td>
				<shiro:hasPermission name="node:node:edit"><td>
    				<a href="${ctx}/node/node/form?id=${node.id}">修改</a>
					<a href="${ctx}/node/node/delete?id=${node.id}" onclick="return confirmx('确认要删除该通信线路节点吗？', this.href)">删除</a>
				</td></shiro:hasPermission>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>