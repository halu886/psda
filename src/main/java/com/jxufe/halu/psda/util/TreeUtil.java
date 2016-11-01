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
	
	public void add(Project project) {//将子节点加入tree中
		Node nodeProject = new Node(project);
		if(rootList.size()==0){//判断tree是否为空
			rootList.add(nodeProject);
			return ;
		}
		boolean done = true;
		for(int i = 0;i < rootList.size()&& done;i++){//遍历所有的树
			/*
			 * 判断该根节点是有否为这个任务的子节点
			 */
			Node root = rootList.get(i);
			if(root.getElement().getPprojectid().equals(project.getProjectid())){
				nodeProject.setChildren(rootList.get(i));
				done=false;
			}
			done = searchTree(nodeProject, root);
		}
		if(!done) rootList.add(nodeProject);
		return ;

	}
	/*
	 * 将树结构转化成JSON格式
	 */
	@SuppressWarnings("unchecked")
	public JSONArray nodeToJSONArray() {
		return new JSONArray((List)rootList);
	}
	/*
	 * 遍历树
	 */
	public boolean searchTree(Node project,Node root){
		if(root==null){
			return false;
		}
		if(root.getElement().getProjectid().equals(project.getElement().getPprojectid())){ 
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
 * 叶子节点
 */
class Node{
	private Project element;
	private List<Node> children = new ArrayList<Node>();
	private String text;
	
	public Node() {}
	
	public Node(Project element){
		this.element = element;
		this.text = element.getProjectname();
	}
	
	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Project getElement() {
		return element;
	}
	public void setElement(Project element) {
		this.element = element;
	}
	public List<Node> getChildren() {
		return children;
	}
	public void setChildren(Node children) {
		this.children.add(children);
	}
	
}