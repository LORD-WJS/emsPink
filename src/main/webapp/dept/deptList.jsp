<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2019/10/30
  Time: 21:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="path" value="${pageContext.request.contextPath}"/>
<html>
<head>
    <meta charset="UTF-8">
    <title>部门列表</title>
    <link rel="stylesheet" type="text/css" href="${path}/css/style.css"/>
</head>
<body>
<div id="wrap">
    <div id="top_content">
        <div id="header">
            <div id="rightheader">
                <p>
                    2009/11/20
                    <br/>
                </p>
            </div>
            <div id="topheader">
                <h1 id="title">
                    <a href="#">main</a>
                </h1>
            </div>
            <div id="navigation">
            </div>
        </div>
        <div id="content">
            <p id="whereami">
            </p>
            <h1>
                Welcome!${admin.realname}
            </h1>
            <table class="table">
                <tr class="table_header">
                    <td>
                        ID
                    </td>
                    <td>
                        Name
                    </td>
                    <td>
                        Operation(删除部门员工一并删除)
                    </td>
                </tr>
                <c:forEach items="${deptList}" var="dept">
                    <tr class="row1">
                        <td>
                                ${dept.id}
                        </td>
                        <td>
                                ${dept.name}
                        </td>
                        <td>
                            <a href="${path}/dept/dropDept?id=${dept.id}">delete </a>&nbsp;<a
                                href="${path}/dept/beforeChange?id=${dept.id}">update</a>&nbsp;<a
                                href="${path}/emp/showEmpByDept?deptId=${dept.id}">show emps</a>
                        </td>
                    </tr>
                </c:forEach>


            </table>
            <p>
                <input type="button" class="button" value="Add Dept" onclick="location='${path}/dept/addDept.jsp'"/>
            </p>
        </div>
    </div>
    <div id="footer">
        <div id="footer_bg">
            ABC@126.com
        </div>
    </div>
</div>
</body>
</html>

