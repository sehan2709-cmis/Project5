<%@ page contentType="text/html;charset=UTF-8" language="java"
         isELIgnored="false" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
  <head>
    <title>edit form page</title>
  </head>

  <body>
  <h1>게시물 수정</h1>
  <form:form modelAttribute="u" method="POST" action="../editok">
    <form:hidden path="seq"/>
    <table id="edit">
      <tr><td>title:</td><td><form:input path="title"/></td></tr>
      <tr><td>writer:</td><td><form:input path="writer"/></td></tr>
      <tr><td>content:</td><td><form:textarea cols="50" rows="5" path="content"/></td></tr>
    </table>

    <input type="submit" value="edit"/>
    <input type="button" value="cancel" onclick="history.back()"/>
  </form:form>
  </body>
</html>
