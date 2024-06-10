<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri = "http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1/jquery.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/latest/js/bootstrap.min.js"></script>
	<link href="https://maxcdn.bootstrapcdn.com/bootstrap/latest/css/bootstrap.min.css" rel="stylesheet">
	<style>
	    body {
	        background: #f8f8f8;
	        padding: 60px 0;
	    }
	    
	    #login-form > div {
	        margin: 15px 0;
	    }
	
	</style>
</head>
<body>
	<div class="container">
	    <div class="col-md-6 col-md-offset-3 col-sm-8 col-sm-offset-2">
	        <div class="panel panel-success">
	            <div class="panel-heading">
	                <div class="panel-title">환영합니다!</div>
	            </div>
	            <div class="panel-body">
	                <form id="login-form" method="post" action="/loginProcess.do">
	                    <div>
	                        <input type="text"  name="id"	class="form-control" name="아이디 입력" placeholder="Username" autofocus>
	                    </div>
	                    <div>
	                        <button type="submit" class="form-control btn btn-primary">로그인</button>
	                    </div>
	                </form>
	            </div>
	        </div>
	    </div>
	</div>
</body>
</html>