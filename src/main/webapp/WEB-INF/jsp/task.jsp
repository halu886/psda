<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel='stylesheet' type='text/css' href='<c:url value="/plugin/easyUI/themes/default/easyui.css"></c:url>'>
<link rel='stylesheet' type='text/css' href='<c:url value="/plugin/easyUI/themes/icon.css"></c:url>'>
<link rel='stylesheet' type='text/css' href='<c:url value="/plugin/easyUI/demo/demo.css"></c:url>'>
<script type="text/javascript" src='<c:url value="/plugin/easyUI/jquery.min.js"></c:url>'></script>
<script type="text/javascript" src='<c:url value="/plugin/easyUI/jquery.easyui.min.js"></c:url>'></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title> 
<script>
	var url;
	
	<%--$('#dg').datagird('reload');--%>
	
	function newTask(){
		$("#dlg").dialog('open').dialog("setTitle",'添加任务');
		$("#fm").form('clean');
		url='taskController/addTask';
	}
	
	function editTask() {
		var row = $('#dg').datagrid('getSelected');
		if(row){
			$('#dlg').dialog('open').dialog("setTitle","编辑用户");
			$('#fm').form('load',row);
			url="taskServises?id="+row.id;
		}
	}
	
	function saveTask(){
		$('#fm').form('submit',{
			url:'taskController/addTask',
			onSubmit:function(){
				<%--return $(this).form("validate");--%>
				return true;
			},
			success:function(result){
				var result= eval('('+result+')');//待测试
				if(result.errorMsg){
					$.messager.alert("系统提示",result.errroMsg);
					return;
				} else{
					$.messager.alert("系统提示","保存成功");
					$('#dlg').dialog('close');
					$('#dg').datagird("reload");
				}
			}
		})
	} 
	
	<%--function deleteTask() {
		var row=$('#dg').datagrid('getSelected');
		if('row'){
			$.messager.confirm('系统提示','您确定要删除这条记录吗?',fuction(r){
				if(r){
					$.post('useDelete',{delId:row.id},function(result){
						if(result.success){
							$.messager.alter("系统提示","你已经成功删除这条记录");
							$('#dg').datagrid("reload");
						}else{
							$.messager.alert("系统提示",result.errorMsg);
						}
					},'json');
				}
			});
		}
	}--%>
</script>
</head>
<body>
	<table id="dg" title="任务" class="easyui-datagrid"
	pagination="true" rownumbers="true" fitColumns="true" singleSelect="true"  url="taskController/taskList" >
		<thead>
			<tr>
				<th field="projectid" width="50" hidden="true">ID</th>
				<th field="projectname" width="50">Name</th>
				<th field="pprojected" width="50">PId</th>
				<th field="userid" width="50">User</th>
			</tr>
		</thead>
	</table>
	    <div id="toolbar">  
        <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="newTask()">添加用户</a>  
        <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-edit" plain="true" onclick="editTask()">编辑用户</a>  
        <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-remove" plain="true" onclick="deleteTask()">删除用户</a>  
    </div>  
	<div id="dlg" class="easyui-dialog" style="width:400px;height:250px;padding:10px 20px"
	closed="true" bottons="#dlg-buttons">
		<form id="fm" method="post">
			<table cellspacing="10px;">
				<tr>
					<td>任务ID</td>
					<td><input name="projectid" class="easyui-validatebox" required="true"></td>
				</tr>	
				<tr>
					<td>任务Name</td>
					<td><input name="projectname" class="easyui-validatebox" required="true"></td>
				</tr>
				<tr>
					<td>父任务ID</td>
					<td><input name="pprojected" class="easyui-validatebox" required="true"></td>
				</tr>
				<tr>
					<td>UserID</td>
					<td><input name="userid" class="easyui-validatebox" required="true"></td>
				</tr>
			</table> 
		</form>	
		<div id="dlg-buttons">
		<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-ok" onclick="saveTask()">保存</a>
		<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-cancel" onclick="javascript:$('#dlg').dialog('close')">保存</a>		
	</div>
	</div>
</body>
</html>