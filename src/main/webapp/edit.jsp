<%@page import="com.entities.Note"%>
<%@page import="org.hibernate.Transaction"%>
<%@page import="com.helper.FactoryProvider"%>
<%@page import="org.hibernate.Session"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@include file="all_css_js.jsp"%>
</head>
<body>
  <div class="container">
   <%@include file="navbar.jsp" %>
   <h1>Edit your note</h1>
   <br>
   <%
   int noteid=Integer.parseInt(request.getParameter("note_id").trim());
   Session s=FactoryProvider.getFactory().openSession();
   Transaction tx=s.beginTransaction();
   Note note=s.get(Note.class, noteid);
   	
   %>
    <form action="UpdateServlet" method="post">
  <input value="<%=note.getId() %>" name="noteId" type="hidden">
  <div class="mb-3">
 
    <label for="title" class="form-label">Note title</label>
    <input required type="text"  class="form-control" id="title" name="title" placeholder="Enter here"    aria-describedby="emailHelp" value="<%=note.getTitle()%>"/>
    <div id="emailHelp" class="form-text">We'll never share your email with anyone else.</div>
  </div>
  <div class="mb-3">
    <label for="content" class="form-label">NoteContent</label>
 <textarea id="content" placeholder="Enter your content here" name="content" class="form-control" style="height:300px;"> <%=note.getContent() %></textarea>
  </div>
  <div class="container text-center">
  <button type="submit" class="btn btn-success">Save your note</button>
</div>
</form>
   </div>
</body>
</html>