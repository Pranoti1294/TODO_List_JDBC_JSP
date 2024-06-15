package com.todo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.todo.module.Todo;

public class TodoDao {
	private Connection connection;

	public TodoDao(Connection connection) {
		super();
		this.connection = connection;
	}
	
	public boolean addTodo(String name, String description, String status) {
		boolean flag = false;
		try {
			
			String qryString = "insert into todo(name,description,status) values(?,?,?)";
			PreparedStatement pst = connection.prepareStatement(qryString);
			pst.setString(1, name);
			pst.setString(2, description);
			pst.setString(3, status);
			
			int result = pst.executeUpdate();
			
			if(result == 1) {
				flag = true;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return flag;
	}
	
	public Todo editTodo(int id) {
		
		Todo todo = null;
		
		
		try {
			
			String qryString = "select * from todo where id=?";
			PreparedStatement pst = connection.prepareStatement(qryString);
			pst.setInt(1, id);
			
			ResultSet resultSet = pst.executeQuery();
			
			while (resultSet.next()) {
				todo = new Todo();
				todo.setId(resultSet.getInt(1));
				todo.setTodoname(resultSet.getString("name"));
				todo.setTododescription(resultSet.getString("description"));
				todo.setStatus(resultSet.getString("status"));
				
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return todo;
	}
	
	
	public List<Todo> getTodoList(){
		List<Todo> todoliList = new ArrayList<>();
		Todo todo;
		try {
			
			String qryString = "select * from todo";
			PreparedStatement pst = connection.prepareStatement(qryString);
			
			ResultSet resultSet = pst.executeQuery();
			
			while(resultSet.next()){
				
				todo = new Todo();
				todo.setId(resultSet.getInt(1));
				todo.setTodoname(resultSet.getString("name"));
				todo.setTododescription(resultSet.getString("description"));
				todo.setStatus(resultSet.getString("status"));
				
				todoliList.add(todo);
			}	
			
		} catch (Exception e) {
			
		}
		
		return todoliList; 
	}
	
	public boolean updateTodo(Todo todo) {
		boolean flag = false;
		try {
			
			String qryString = "update todo set name=?,description=?,status=? where id=?";
			PreparedStatement pst = connection.prepareStatement(qryString);
			pst.setString(1, todo.getTodoname());
			pst.setString(2, todo.getTododescription());
			pst.setString(3, todo.getStatus());
			pst.setInt(4, todo.getId());
			
			int result = pst.executeUpdate();
			
			if(result == 1) {
				flag = true;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return flag;
	}
	
	
	public boolean deleteTodo(int id) {
		boolean flag = false;
		try {
			
			String qryString = "delete from todo where id=?";
			PreparedStatement pst = connection.prepareStatement(qryString);
			pst.setInt(1, id);
			int result = pst.executeUpdate();
			
			if(result == 1) {
				flag = true;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return flag;
	}
	
	
}
