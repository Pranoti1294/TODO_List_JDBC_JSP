<%@page import="com.todo.module.Todo"%>
<%@page import="com.todo.utility.SqlUtil"%>
<%@page import="com.todo.dao.TodoDao"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<%@include file="component/all_css.jsp"%>
</head>
<body style="background-color: #f0f1f2;">
<%@include file="component/navbar.jsp" %>
	
	<div class="container">
		<div class="row p-5">
		
			<div class="col-md-6 offset-md-3">
				<div class="card">
					<div class="card-body">
					<h3 class="text-center text-success">Edit TODO</h3>
						
						<%
						
							int id = Integer.parseInt(request.getParameter("id"));
							TodoDao todoDao = new TodoDao(SqlUtil.getConnection());
							Todo todo = todoDao.editTodo(id);
							
						
						%>
						
					<form action="update" method="post">
						
						<input type="hidden" name="id" value="<%=todo.getId() %>">
						
							  <div class="form-group">
							    <label for="name">TODO</label>
							    <input type="text" class="form-control" id="name" aria-describedby="emailHelp" placeholder="Enter Todo name" name="name" value="<%=todo.getTodoname() %>">
							    
							  </div>
							  <div class="form-group">
							    <label for="description">Description</label>
							    <input type="text" class="form-control" id="description" aria-describedby="emailHelp" placeholder="Enter Todo description" name="description"  value="<%=todo.getTododescription() %>">
							    
							  </div>
							  <div class="form-group">
							      <label for="status">Status</label>
							      <select id="status" class="form-control" name="status">
							      <%
							      
							      if("Pending".equals(todo.getStatus())){
							    	%>
							    	  	<option value="Pending">Pending</option>
							        	<option value="Complete">Complete</option>
							    	  <%
							    	  
							      }else{
							    	  
							    	  %>
							    	  	<option value="Complete">Complete</option>
							    	  	<option value="Pending">Pending</option>	
							    	  
							    	  <% 
							      }
							      
							      %>
							        </select>
							   </div>
							  
							  <div class="text-center" >
							  <button type="submit" class="btn btn-primary">Update</button>
							
							  </div>
						</form>
					</div>
				
				</div>
			</div>
		</div>
	</div>
	
</body>
</html>