<%@ page import="java.util.List" %>
<%@ page import="model.SmallToDo" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>ToDO</title>
</head>
<body>
Your ToDoList

<%
    List<SmallToDo> toDoList = (List<SmallToDo>) request.getAttribute("todoList");
    for (SmallToDo toDoIttem : toDoList) {
%>

<p>
    <%=toDoIttem.getId()%>
    <%=toDoIttem.getComment()%>
    <%= toDoIttem.isDone()%>
</p>

<%
    }
%>
</body>
</html>