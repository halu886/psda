<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<% 
    String context = request.getContextPath();
    request.setAttribute("context",context);
%> 
<html>
<head>
	<meta charset="UTF-8">
	<title>Basic Form - jQuery EasyUI Demo</title>
		<link rel='stylesheet' type='text/css' href='<c:url value="plugin/easyUI/themes/default/easyui.css"/>'>
		<link rel='stylesheet' type='text/css' href='<c:url value="plugin/easyUI/themes/icon.css"/>'>
		<link rel='stylesheet' type='text/css' href='<c:url value="plugin/easyUI/demo/demo.css"/>'>
		<script type="text/javascript" src='<c:url value="plugin/easyUI/jquery.min.js" />'></script>
		<script type="text/javascript" src='<c:url value="plugin/easyUI/jquery.easyui.min.js" />'></script>
</head>
<body>
	<h2>Basic Form</h2>
	<p>Fill the form and submit it.</p>
	<div style="margin:20px 0;"></div>
	<div class="easyui-panel" title="New Topic" style="width:100%;max-width:400px;padding:30px 60px;">
		<form id="ff" method="POST" action="${context}/loginController/login">
			<div style="margin-bottom:20px">
				<input class="easyui-textbox" name="userid" style="width:100%" data-options="label:'ID',required:true">
			</div>
			<div style="margin-bottom:20px">
				<input class="easyui-textbox" name="password" style="width:100%" data-options="label:'PassWord',required:true,validType:'password'">
			</div>
			<div style="text-align:center;padding:5px 0">
<!-- 				<a href="javascript:void(0)" class="easyui-linkbutton" onclick="submitForm()" style="width:80px">Submit</a> -->
<!-- 				<a href="javascript:void(0)" class="easyui-linkbutton" onclick="clearForm()" style="width:80px">Clear</a> -->
				<input class="easyui-linkbutton" type="submit" value="登录" style="width:80px">
		   		<input class="easyui-linkbutton" type="reset" value="重置" onclick="clearForm" style="width:80px">
			</div>
		</form>

	</div>
	<script>
		function clearForm(){
			$('#ff').form('clear');
		}
	</script>
</body>
</html>