<%--
  Created by IntelliJ IDEA.
  User: HauKute
  Date: 3/31/2019
  Time: 9:48 AM
  To change this template use File | Settings | File Templates.
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
    <body>
        <form name="f" action="<c:url value='j_spring_security_check'/>" method="post">
            <div class="form-group">
                <div class="form-label-group">
                    <input type="text" id="inputUserName" class="form-control" placeholder="UserNa,e" required="required" autofocus="autofocus" name="j_username">
                    <label for="inputUserName">UserName</label>
                </div>
            </div>

            <div class="form-group">
                <div class="form-label-group">
                    <input type="password" id="inputPassword" class="form-control" placeholder="UserNa,e" required="required" autofocus="autofocus" name="j_password">
                    <label for="inputPassword">Password</label>
                </div>
            </div>
            <div class="text-center">
                <input name="submit" type="submit">
                <input name="reset" type="reset">
            </div>
        </form>
    </body>
</html>
