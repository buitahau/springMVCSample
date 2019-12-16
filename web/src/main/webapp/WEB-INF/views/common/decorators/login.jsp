<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="decorator" uri="http://www.opensymphony.com/sitemesh/decorator" %>
<!DOCTYPE html>
<html lang="">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Spring MVC Project</title>
    <!-- Bootstrap core CSS-->
    <link href="<c:url value="/resources/static/vendor/bootstrap/css/bootstrap.min.css"/>" rel="stylesheet">
    <!-- Custom fonts for this template-->
    <link href="<c:url value="/resources/static/vendor/fontawesome-free/css/all.min.css"/>" rel="stylesheet">
    <!-- Custom styles for this template-->
    <link href="<c:url value="/resources/static/css/sb-admin.css"/>" rel="stylesheet">
</head>

<body class="bg-dark">
<div class="container">
    <div class="card card-login mx-auto mt-5">
        <div class="card-header">Login</div>
        <div class="card-body">
        <decorator:body />
        </div>
    </div>
</div>

<!-- Bootstrap core JavaScript-->
<script src="<c:url value="/resources/static/vendor/jquery/jquery.min.js"/>"></script>
<script src="<c:url value="/resources/static/vendor/bootstrap/js/bootstrap.bundle.min.js"/>"></script>

<!-- Core plugin JavaScript-->
<script src="<c:url value="/resources/static/vendor/jquery-easing/jquery.easing.min.js"/>"></script>

</body>
</html>
