<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<html>

<head>
    <meta name="_csrf" content="${_csrf.token}"/>
    <meta name="_csrf_header" content="${_csrf.headerName}"/>
    <meta charset="utf-8">
    <script type="text/javascript" src="<c:url value="/resources/js/jquery-3.0.0.min.js"/>"></script>

</head>
<body>

<tiles:insertAttribute name="navigation_bar"/>
<div></div>
<div id="header">
    <tiles:insertAttribute name="header"/>
</div>
<div></div>
<div id="page">
    <tiles:insertAttribute name="content"/>
</div>
<div></div>
<div id="footer_wrapper">
    <tiles:insertAttribute name="footer"/>
</div>

</body>
</html>