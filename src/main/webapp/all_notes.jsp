<%@page import="com.entities.Note"%>
<%@page import="java.util.List"%>
<%@page import="org.hibernate.Query"%>
<%@page import="com.helper.FactoryProvider"%>
<%@page import="org.hibernate.Session"%>
<%@page import="org.hibernate.SessionFactory"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>All notes: Note take</title>

  <%@include file="all_css_js.jsp"%>
</head>
<body>
<div class="container">
 <%@include file="navbar.jsp" %>
 <br>
 <h1 class="text-uppercase">All notes</h1>
 <div class="row">
 <div class="col-12">
 
 
 </div>
 <%
 Session s=FactoryProvider.getFactory().openSession();
Query q= s.createQuery("from Note");
 List<Note> list1=q.list();
 for(Note note:list1)
 {
	 %>
	 
<div class="card mt-3" >
<img class="card-img-top m-4 mx-auto" style="max-width: 100px" alt="" src="img/notepad.png">
  <div class="card-body px-5">
    <h5 class="card-title"><%=note.getTitle() %></h5>
    <h6 class="card-subtitle mb-2 text-muted"></h6>
    <p class="card-text"><%= note.getContent() %></p>
    <p><b><%=note.getAddedDate() %></b></p>
    <div class="container text-center m-2">
    <a href="DeleteServlet?note_id=<%=note.getId() %>" class="btn btn-danger">Delete</a>
    <a href="edit.jsp?note_id=<%=note.getId() %> " class="btn btn-primary">Update</a>
   </div>
  </div>
</div>
	 
	 <%

 }
 
 s.close();
%> 
 
 </div>
 
 
 
  

 </div>
</body>
</html>