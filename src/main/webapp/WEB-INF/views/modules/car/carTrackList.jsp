<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>车辆轨迹信息管理</title>
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
		<li class="active"><a href="${ctx}/car/carTrack/">车辆轨迹信息列表</a></li>
		<shiro:hasPermission name="car:carTrack:edit"><li><a href="${ctx}/car/carTrack/form">车辆轨迹信息添加</a></li></shiro:hasPermission>
	</ul>
	<form:form id="searchForm" modelAttribute="carTrack" action="${ctx}/car/carTrack/" method="post" class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<ul class="ul-form">
			<li><label>车辆：</label>
				<form:input path="carId" htmlEscape="false" maxlength="10" class="input-medium"/>
			</li>
			<li><label>经度：</label>
				<form:input path="longitude" htmlEscape="false" maxlength="16" class="input-medium"/>
			</li>
			<li><label>纬度：</label>
				<form:input path="latitude" htmlEscape="false" maxlength="16" class="input-medium"/>
			</li>
			<li><label>创建时间：</label>
				<input name="createDate" type="text" readonly="readonly" maxlength="20" class="input-medium Wdate"
					value="<fmt:formatDate value="${carTrack.createDate}" pattern="yyyy-MM-dd HH:mm:ss"/>"
					onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss',isShowClear:false});"/>
			</li>
			<li class="btns"><input id="btnSubmit" class="btn btn-primary" type="submit" value="查询"/></li>
			<li class="clearfix"></li>
		</ul>
	</form:form>
	<sys:message content="${message}"/>
	<table id="contentTable" class="table table-striped table-bordered table-condensed">
		<thead>
			<tr>
				<th>车辆</th>
				<th>经度</th>
				<th>纬度</th>
				<th>创建时间</th>
				<th>备注</th>
				<shiro:hasPermission name="car:carTrack:edit"><th>操作</th></shiro:hasPermission>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${page.list}" var="carTrack">
			<tr>
				<td><a href="${ctx}/car/carTrack/form?id=${carTrack.id}">
					${carTrack.carId}
				</a></td>
				<td>
					${carTrack.longitude}
				</td>
				<td>
					${carTrack.latitude}
				</td>
				<td>
					<fmt:formatDate value="${carTrack.createDate}" pattern="yyyy-MM-dd HH:mm:ss"/>
				</td>
				<td>
					${carTrack.remarks}
				</td>
				<shiro:hasPermission name="car:carTrack:edit"><td>
    				<a href="${ctx}/car/carTrack/form?id=${carTrack.id}">修改</a>
					<a href="${ctx}/car/carTrack/delete?id=${carTrack.id}" onclick="return confirmx('确认要删除该车辆轨迹信息吗？', this.href)">删除</a>
				</td></shiro:hasPermission>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>