 <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
 <%@include file="all_css_js.jsp"%>
</head>
<body>
  <div class="container">
 <%@include file="navbar.jsp" %>
   <br>
   <h1>Please fill your note detail</h1>
   <br>
   <!-- this is add forms -->
   <form action="SaveNoteServlet" method="post">
  <div class="mb-3">
    <label for="title" class="form-label">Note title</label>
    <input required type="text"  class="form-control" id="title" name="title" placeholder="Enter here"    aria-describedby="emailHelp">
    <div id="emailHelp" class="form-text">We'll never share your email with anyone else.</div>
  </div>
  <div class="mb-3">
    <label for="content" class="form-label">NoteContent</label>
 <textarea id="content" placeholder="Enter your content here" name="content" class="form-control"></textarea>
  </div>
  <div class="container text-center">
  <button type="submit" class="btn btn-primary">Add</button>
</div>
</form>
   
   </div>
</body>
</html>