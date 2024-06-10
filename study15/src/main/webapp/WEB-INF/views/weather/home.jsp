<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri = "http://java.sun.com/jsp/jstl/functions"%>
<c:set var="path2" value="${pageContext.servletContext.contextPath }" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>날씨 예보</title>
	<script>
	function sendLocation() {
	    if (navigator.geolocation) {
	        navigator.geolocation.getCurrentPosition(function(position) {
	            var grid = dfs_xy_conv("toXY", position.coords.latitude, position.coords.longitude);
	            document.getElementById('nx').value = grid.x;
	            document.getElementById('ny').value = grid.y;
	            
	            const now = new Date();
	            const year = now.getFullYear();
	            const month = ('0' + (now.getMonth() + 1)).slice(-2);
	            const day = ('0' + now.getDate()).slice(-2);
	            const dateStr = year + month + day;
	            
	            document.getElementById('baseDate').value = dateStr;
	        }, function(error) {
	            console.error("Error Code = " + error.code + " - " + error.message);
	        });
	    } else {
	        alert("Geolocation is not supported by this browser.");
	        return false;
	    }
	}
	
	function dfs_xy_conv(code, v1, v2) {
	    var RE = 6371.00877;
	    var GRID = 5.0;
	    var SLAT1 = 30.0;
	    var SLAT2 = 60.0;
	    var OLON = 126.0;
	    var OLAT = 38.0;
	    var XO = 43;
	    var YO = 136;
	    
	    var DEGRAD = Math.PI / 180.0;
	    var RADDEG = 180.0 / Math.PI;
	
	    var re = RE / GRID;
	    var slat1 = SLAT1 * DEGRAD;
	    var slat2 = SLAT2 * DEGRAD;
	    var olon = OLON * DEGRAD;
	    var olat = OLAT * DEGRAD;
	
	    var sn = Math.tan(Math.PI * 0.25 + slat2 * 0.5) / Math.tan(Math.PI * 0.25 + slat1 * 0.5);
	    sn = Math.log(Math.cos(slat1) / Math.cos(slat2)) / Math.log(sn);
	    var sf = Math.tan(Math.PI * 0.25 + slat1 * 0.5);
	    sf = Math.pow(sf, sn) * Math.cos(slat1) / sn;
	    var ro = Math.tan(Math.PI * 0.25 + olat * 0.5);
	    ro = re * sf / Math.pow(ro, sn);
	    var rs = {};
	    if (code == "toXY") {
	        rs['lat'] = v1;
	        rs['lng'] = v2;
	        var ra = Math.tan(Math.PI * 0.25 + (v1) * DEGRAD * 0.5);
	        ra = re * sf / Math.pow(ra, sn);
	        var theta = v2 * DEGRAD - olon;
	        if (theta > Math.PI) theta -= 2.0 * Math.PI;
	        if (theta < -Math.PI) theta += 2.0 * Math.PI;
	        theta *= sn;
	        rs['x'] = Math.floor(ra * Math.sin(theta) + XO + 0.5);
	        rs['y'] = Math.floor(ro - ra * Math.cos(theta) + YO + 0.5);
	    }
	    return rs;
	}
	</script>
</head>
<body>
    <h1>Send Current Date and Location</h1>
    <hr>
    <form id="locationForm" action="${path2}/weather/result" method="post">
        <input type="hidden" id="nx" name="nx">
        <input type="hidden" id="ny" name="ny">
        <input type="hidden" id="baseDate" name="baseDate">
        <button type="submit">Send Location</button>
    </form>
    <script>
    sendLocation();
    </script>
</body>
</html>