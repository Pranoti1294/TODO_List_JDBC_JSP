package com.todo.module;

public class Todo {
	private int id;
	private String todoname;
	private String tododescription;
	private String status;
	
	public Todo() {}
	
	public Todo(int id, String todoname, String tododescription, String status) {
		super();
		this.id = id;
		this.todoname = todoname;
		this.tododescription = tododescription;
		this.status = status;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTodoname() {
		return todoname;
	}
	public void setTodoname(String todoname) {
		this.todoname = todoname;
	}
	public String getTododescription() {
		return tododescription;
	}
	public void setTododescription(String tododescription) {
		this.tododescription = tododescription;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	@Override
	public String toString() {
		return "Entity [id=" + id + ", todoname=" + todoname + ", tododescription=" + tododescription + ", status="
				+ status + "]";
	}
	
}
