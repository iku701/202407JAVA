<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Insert Employee</title>
</head>
<body>
	<%
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");
    %>
    
    <h2>Insert New Employee</h2>
    <form action="empJsonserver1.jsp" method="post">
        <input type="hidden" name="action" value="create" />
        <table>
            <tr>
                <td>Name :</td>
                <td><input type="text" name="ename" required /></td>
            </tr>
            <tr>
                <td>Job :</td>
                <td><input type="text" name="job" required /></td>
            </tr>
            <tr>
                <td>Manager :</td>
                <td><input type="number" name="mgr" required /></td>
            </tr>
            <tr>
                <td>Hire Date :</td>
                <td><input type="date" name="hiredate" required /></td>
            </tr>
            <tr>
                <td>Salary :</td>
                <td><input type="number" name="sal" step="0.01" required /></td>
            </tr>
            <tr>
                <td>Commission :</td>
                <td><input type="number" name="comm" step="0.01" /></td>
            </tr>
            <tr>
                <td>Deptno :</td>
                <td><input type="number" name="deptno" required /></td>
            </tr>
        </table>
        <br/>
        <input type="submit" value="Insert Employee" />
    </form>
</body>
</html>
