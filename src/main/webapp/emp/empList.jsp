<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2019/10/30
  Time: 23:40
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
    <title>员工列表</title>
    <link rel="stylesheet" type="text/css" href="${path}/css/style.css"/>
    <link href="${path}/css/common.css" type="text/css" rel="stylesheet"/>
    <script>
        function funDelete() {
            window.confirm("确认删除");
        }
    </script>
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
                Welcome ${admin.username}
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
                        Salary
                    </td>
                    <td>
                        Age
                    </td>
                    <td>
                        Bir
                    </td>
                    <td>
                        Dept
                    </td>
                    <td>
                        Operation(处理删除的友情提醒)
                    </td>
                </tr>
                <c:forEach items="${pb.list}" var="emp">
                    <tr class="row1">
                        <td>
                                ${emp.id}
                        </td>
                        <td>
                                ${emp.name}
                        </td>
                        <td>
                                ${emp.salary}
                        </td>
                        <td>
                                ${emp.age}
                        </td>
                        <td>
                            <fmt:formatDate value="${emp.birthday}" pattern="yyyy-MM-dd"></fmt:formatDate>
                        </td>
                        <td>
                                ${emp.dept.name}
                        </td>
                        <td>
                            <a onclick="funDelete()" href="${path}/emp/dropEmp?id=${emp.id}">delete emp</a>&nbsp;<a
                                href="${path}/emp/searchEmpById?id=${emp.id}">update emp</a>
                        </td>
                    </tr>
                </c:forEach>

            </table>
            <a href="${path}/emp/showEmpByDept?currentPage=1&rows=4&deptId=${deptId}">首页</a>
            <a href="${path}/emp/showEmpByDept?currentPage=${pb.currentPage-1}&rows=4&deptId=${deptId}">上一页</a>

            <c:forEach begin="1" end="${pb.totalPage}" var="i">
                <c:if test="${pb.currentPage==i }">
                    <a style="color:red"
                       href="${path}/emp/showEmpByDept?currentPage=${i}&rows=4&deptId=${deptId}">${i }</a>
                </c:if>
                <c:if test="${pb.currentPage!=i }">
                    <a href="${path}/emp/showEmpByDept?currentPage=${i}&rows=4&deptId=${deptId}">${i }</a>
                </c:if>
            </c:forEach>

            <a href="${path}/emp/showEmpByDept?currentPage=${pb.currentPage+1}&rows=4&deptId=${deptId}">下一页</a>
            <a href="${path}/emp/showEmpByDept?currentPage=${pb.totalPage}&rows=4&deptId=${deptId}">尾页</a>
            <%--            <div class="pagination">--%>
            <%--                <span class="firstPage">&nbsp;</span> <span class="previousPage">&nbsp;</span>--%>
            <%--                <span class="currentPage">1</span> <a--%>
            <%--                    href="javascript:$.pageSkip(2);">2</a> <a--%>
            <%--                    href="javascript:$.pageSkip(3);">3</a> <span class="pageBreak">...</span>--%>
            <%--                <a class="nextPage" href="javascript: $.pageSkip(2);">&nbsp;</a>--%>
            <%--                <a class="lastPage" href="javascript: $.pageSkip(6);">&nbsp;</a>--%>
            <%--                <span class="pageSkip"> 共6页 到第<input id="pageNumber"--%>
            <%--                                                     name="pageNumber" value="1" maxlength="9"--%>
            <%--                                                     onpaste="return false;">页--%>
            <%--								<button type="submit">&nbsp;</button>--%>
            <%--						</span>(请在全部功能完成后在处理分页)--%>
            <%--            </div>--%>
            <p>
                <input type="button" class="button" value="Add Employee" onclick="location='${path}/emp/addEmp.jsp'"/>
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
