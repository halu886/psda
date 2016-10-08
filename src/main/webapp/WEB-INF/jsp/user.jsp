<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<script type="text/javascript" src="plugin/easyUI/jquery.min.js"></script>
<script type="text/javascript" src="plugin/easyUI/jquery.easyui.min.js"></script>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<table id="dg" title="任务" class="easyui-datagrid"
	pagination="true" rownumbers="true" fitColumns="true" singleSelect="true">
		<thead>
			<tr>
				<th field="id" width="50" hidden="true">ID</th>
				<th field="name" width="50">Name</th>
				<th field="pId" width="50">PId</th>
				<th field="use" width="50">User</th>
			</tr>
		</thead>
	</table>
	    <div id="toolbar">  
        <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="newUser()">添加用户</a>  
        <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-edit" plain="true" onclick="editUser()">编辑用户</a>  
        <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-remove" plain="true" onclick="deleteUser()">删除用户</a>  
    </div>  
	<div id="dlg" class="easyui-dialog" style="width:400px;height:250px;padding:10px 20px"
	closed="true" bottons="#dlg-buttons">
		<form id="fm" method="post">
			<table cellspacing="10px;">
				<tr></tr>
					<td>任务ID</td>
					<td><input name="name" class="easyui-validatebox" required="true"></td>
			</table>
		</form>
	
		
	</div>
</body>
</html>