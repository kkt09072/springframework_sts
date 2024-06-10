<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri = "http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<title><spring:message code="label.title" /></title>
<script>
    function init(){
        alert('<spring:message code="label.selectLang" />');
    }
</script>
</head>
<body onload="init()">
    <form method="post" action="login">
        <table>
            <tr>
                <td>
                    <label>
                        <strong><spring:message code="label.firstName" /></strong>
                    </label>
                </td>
                <td><input name="firstName" /></td>
            </tr>
            <tr>
                <td>
                    <label>
                        <strong><spring:message code="label.lastName" /></strong>
                    </label>
                </td>
                <td><input name="lastName" /></td>
            </tr>
            <tr>
                <spring:message code="label.submit" var="labelSubmit" />
                <td colspan="2">
                    <input type="submit" value="${labelSubmit}" />
                </td>
            </tr>
        </table>
    </form>
</body>
</html>