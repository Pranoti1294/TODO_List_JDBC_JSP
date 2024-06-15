
<%@page import="com.todo.module.Todo"%>
<%@page import="java.util.List"%>
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
<body>
	<%@include file="component/navbar.jsp" %>
	
	<h1 class="text-center text-success">TODO-APP</h1>
	
	<%
		if(session.getAttribute("smsg")!=null){
			%>
				<div class="alert alert-success" role="alert">
				  <%= (String)session.getAttribute("smsg") %>
				</div>
			<%
			session.removeAttribute("smsg");
		}
	
	%>
	
	<div class="container">
		<table class="table table-striped" border="1px">
		  <thead class="bg-success text-white">
		    <tr>
		      <th scope="col">ID</th>
		      <th scope="col">TODO</th>
		      <th scope="col">Description</th>
		      <th scope="col">Status</th>
		      <th scope="col">Action</th>
		    </tr>
		  </thead>
		  <tbody>
		  
		  <%
		  
		  	TodoDao dao = new TodoDao(SqlUtil.getConnection());
		  	List<Todo> todo = dao.getTodoList();
		  	
		  	for(Todo t : todo){
		  		%>
		  		
				  	<tr>
				      <th scope="row"><%=t.getId() %></th>
				      <td><%=t.getTodoname() %></td>
				      <td><%=t.getTododescription() %></td>
				      <td><%=t.getStatus() %></td>
				      <td>
				      	<a href="edit.jsp?id=<%=t.getId() %>" class="btn btn-sm btn-success">Edit</a>
				      	<a href="delete?id=<%=t.getId() %>" class="btn btn-sm btn-danger">Delete</a>
				      </td>
				    </tr>
		  		
		  		<%
		  	}
		  	
		  
		  %>
		    
		   
		  </tbody>
		</table>
	
	</div>
	
</body>
</html>