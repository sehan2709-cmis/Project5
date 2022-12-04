<%@ page contentType="text/html;charset=UTF-8" language="java"
         isELIgnored="false" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
  <head>
    <title>List / Main Page(?)</title>
  </head>

  <body>
    <h1>LIST</h1>
    <table id="list" width="90%" border="1">
      <tr>
        <th>id</th>
        <th>title</th>
        <th>writer</th>
        <th>content</th>
        <th>regdate</th>
        <th>edit</th>
        <th>delete</th>
      </tr>

      <c:forEach items="${list}" var="u">
        <tr>
          <td>${u.seq}</td>
          <td>${u.title}</td>
          <td>${u.writer}</td>
          <td>${u.content}</td>
          <td>${u.regdate}</td>
          <td><a href="editform/${u.seq}">edit</a></td>
          <td><a href="javascript:delete_ok('${u.seq}')">delete</a></td>
        </tr>
      </c:forEach>
    </table><br/>
    <button type="button" onclick="location.href='add'">add post</button>

    <script>
      function delete_ok(ID){
        var a = confirm("would you like to delete this post?");
        if(a) location.href = "deleteok/" + ID;
      }
    </script>
  </body>
</html>
