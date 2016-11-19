<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<% 
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<base href="<%=	basePath%>">
<link rel='stylesheet' type='text/css' href='<c:url value="plugin/easyUI/themes/default/easyui.css"/>'>
<link rel='stylesheet' type='text/css' href='<c:url value="plugin/easyUI/themes/icon.css"/>'>
<link rel='stylesheet' type='text/css' href='<c:url value="plugin/easyUI/demo/demo.css"/>'>
<script type="text/javascript" src='<c:url value="plugin/easyUI/jquery.min.js" />'></script>
<script type="text/javascript" src='<c:url value="plugin/easyUI/jquery.easyui.min.js" />'></script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>任务管理主页面</title>
</head>
<body>
<div id="cc" class="easyui-layout" style="width:100%;height:600px;">
    <div data-options="region:'north',title:'North Title',split:true" style="height:0%;"></div>
    <div data-options="region:'south',title:'South Title',split:true" style="height:20%;"></div>
    <div data-options="region:'east',title:'East',split:true" style="width:20%;"></div>
    <div data-options="region:'west',title:'West',split:true" style="width:20%;">
    	<div id="accordion" class="easyui-accordion" style="width:100%;height: 100%">
    		<div title="任务管理" data-options="iconCls:'icon-save'" style="padding:10px;overflow:auto;">
				<!--未完成任务-->
    			<ul id="unDoProject"  class="easyui-tree" ></ul>
    			<!-- 已完成任务 -->
<!--     			<ul id="doProject"></ul>  -->
    		</div>
    		<div title="部门管理" data-options="iconCls:'icon-save',selected:true" style="overflow:auto;padding:10px;">
    		</div>
    		<div title="设置" data-options="iconCls:'icon-save'" style="overflow:auto;padding:10px;">
    		</div>
    	</div>
    </div>  
    <div data-options="region:'center',title:'center title'" style="padding:1%;background:#eee;"></div>
</div>
<script type="text/javascript">
// 	$('#unDoProject').tree({
<%-- 		url:"<%= basePath%>projectController/projectTree", --%>
// 		data:'${projectTree}'
// 	});
	$.ajax({
		url:'projectController/projectTree',
		type:'POST',
		success: function(response){
			alert("ok");
			$('#unDoProject').tree({data:response});
		},
		error : function() {
            alert("erroe");
        }
	});
</script>
		
</body>
</html>