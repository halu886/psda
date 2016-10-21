<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<html>
<head>
<link rel='stylesheet' type='text/css' href='plugin/easyUI/themes/default/easyui.css'>
<link rel='stylesheet' type='text/css' href='plugin/easyUI/themes/icon.css'>
<link rel='stylesheet' type='text/css' href='plugin/easyUI/demo/demo.css'>
<script type="text/javascript" src="plugin/easyUI/jquery.min.js"></script>
<script type="text/javascript" src="plugin/easyUI/jquery.easyui.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script>
	var url;
	
	$('#dg').datagrid('reload');
	
	function newProject(){
		url="projectController/addProject";
		$('#dlg').dialog('open').dialog("setTitle",'添加任务');
		$('#fm').form('reset');
	}
	
	function editProject() {
		var row = $('#dg').datagrid('getSelected');
		if(row){
			$('#dlg').dialog('open').dialog("setTitle","编辑用户");
			$('#fm').form('load',row);
			url="projectController/editProject?id="+row.id;
		}
	}
	
	function saveProject(){
		$('#fm').form('submit',{
			url:url,
			onSubmit:function(){
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
					$('#dg').datagird('reload');
				}
			}
		})
	} 
	
	function deleteProject() {
		var row=$('#dg').datagrid('getSelected');
		if(row){
			$.messager.confirm("系统提示","您确定要删除这条记录吗?",function(r){
				if(r){
					$.post('projectController/projectDelete',row,function(result){
						if(result.success){
							$.messager.alter("系统提示","你已经成功删除这条记录");
							$('#dg').datagrid("reload");
						}else{
							$.messager.alert("系统提示",result.errorMsg);
						}
					});
				}
			});
		}
	}
</script>
</head>
<body>
	<table id="dg" title="任务" class="easyui-datagrid"
	pagination="true" rownumbers="true" fitColumns="true" singleSelect="true"  url="projectController/projectList" >
		<thead>
			<tr>
				<th field="groupid" width="50" hidden="true">ID</th>
				<th field="departid" width="50">deparID</th>
				<th field="classid" width="50">classID</th>
				<th field="pprojectid" width="50">PProjectID</th>
			</tr>
		</thead>
	</table>
	    <div id="toolbar">  
        <a href="javascript:void(0);" class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="newProject()">添加用户</a>  
        <a href="javascript:void(0);" class="easyui-linkbutton" iconCls="icon-edit" plain="true" onclick="editProject()">编辑用户</a>  
        <a href="javascript:void(0);" class="easyui-linkbutton" iconCls="icon-remove" plain="true" onclick="deleteProject()">删除用户</a>  
    </div>  
	<div id="dlg" class="easyui-dialog" style="width:400px;height:250px;padding:10px 20px"
	closed="true" bottons="#dlg-buttons">
		<form id="fm" method="post">
			<table cellspacing="10px;">
				<tr>
					<td>ID</td>
					<td><input name="projectid" class="easyui-validatebox" required="true"></td>
				</tr>	
				<tr>
					<td>deparID</td>
					<td><input name="projectname" class="easyui-validatebox" required="true"></td>
				</tr>
				<tr>
					<td>groupID</td>
					<td><input name="pprojected" class="easyui-validatebox" required="true"></td>
				</tr>
				<tr>
					<td>PProjectID</td>
					<td><input name="userid" class="easyui-validatebox" required="true"></td>
				</tr>
			</table> 
		</form>	
		<div id="dlg-buttons">
		<a href="javascript:void(0);" class="easyui-linkbutton" iconCls="icon-ok" onclick="saveProject()">保存</a>
		<a href="javascript:void(0);" class="easyui-linkbutton" iconCls="icon-cancel" onclick="javascript:$('#dlg').dialog('close')">取消</a>		
	</div>
	</div>
</body>
</html>