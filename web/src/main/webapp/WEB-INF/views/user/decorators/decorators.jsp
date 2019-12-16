<%--
  Created by IntelliJ IDEA.
  User: HauKute
  Date: 5/5/2019
  Time: 5:46 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="decorator" uri="http://www.opensymphony.com/sitemesh/decorator" %>
<!DOCTYPE html>
<html lang="">
<head>
    <title>Spring MVC Project</title>
    <%@ include file="/WEB-INF/views/user/decorators/header.jsp" %>
    <decorator:head />
</head>
<body id="page-top">
    <%@ include file="/WEB-INF/views/user/decorators/top_title.jsp" %>
    <div id="wrapper">
        <%@ include file="/WEB-INF/views/user/decorators/navigation.jsp" %>
        <div id="content-wrapper">
            <div class="container-fluid">
                <decorator:body />
            </div>

            <footer class="sticky-footer">
                <div class="container my-auto">
                    <div class="copyright text-center my-auto">
                        <span>Copyright © Your Website 2018</span>
                    </div>
                </div>
            </footer>
        </div>
    </div>
    <%@ include file="/WEB-INF/views/user/decorators/footer.jsp" %>
</body>
</html>
