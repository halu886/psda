package com.jxufe.halu.psda.util;

import java.util.ArrayList;
import java.util.List;

import com.alibaba.fastjson.JSONArray;
import com.jxufe.halu.psda.pojo.Project;

public class TreeUtil{
	private List<Node> rootList = new ArrayList<Node>();
	
	public TreeUtil() {}
	
	public TreeUtil(List<Project> list){
		for (int i = 0; i < list.size(); i++) {
			add(list.get(i));
		}
	}
	
	public void add(Project project) {//���ӽڵ����tree��
		Node nodeProject = new Node(project);
		if(rootList.size()==0){//�ж�tree�Ƿ�Ϊ��
			rootList.add(nodeProject);
			return ;
		}
		boolean done = true;
		for(int i = 0;i < rootList.size()&& done;i++){//�������е���
			/*
			 * �жϸø��ڵ����з�Ϊ���������ӽڵ�
			 */
			Node root = rootList.get(i);
			if(root.getpId().equals(project.getProjectid())){
				nodeProject.setChildren(rootList.get(i));
				done=false;
			}
			done = searchTree(nodeProject, root);
		}
		if(!done) rootList.add(nodeProject);
		return ;

	}
	/*
	 * �����ṹת����JSON��ʽ
	 */
	@SuppressWarnings("unchecked")
	public JSONArray nodeToJSONArray() {
		return new JSONArray((List)rootList);
	}
	/*
	 * ������
	 */
	public boolean searchTree(Node project,Node root){
		if(root==null){
			return false;
		}
		if(root.getId().equals(project.getpId())){ 
			root.getChildren().add(project);
			return true;
			}
		for (int i = 0; root.getChildren().size() > i; i++) {
			if(searchTree(project, root.getChildren().get(i))) return true;
		}
		return false;
	}
}
/*
 * Ҷ�ӽڵ�
 */
class Node{
	private List<Node> children = new ArrayList<Node>();
	private String text;
	private String id ;
	private String pId;
	
	public Node() {}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Node(Project element){
		this.text = element.getProjectname();
		this.id = element.getProjectid();
		this.pId = element.getPprojectid();
	}
	
	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getpId() {
		return pId;
	}

	public void setpId(String pId) {
		this.pId = pId;
	}

	public List<Node> getChildren() {
		return children;
	}
	public void setChildren(Node children) {
		this.children.add(children);
	}
	
}