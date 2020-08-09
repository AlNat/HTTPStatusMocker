<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@include file="static/styles.jsp" %>

    <title>HTTP Mocker</title>
</head>
<body>

<div id="layout">
    <h1 class="title">HTTP Status Mocker</h1>

    <div class="wrapper">
        <div class="content">
            This is a simple HTTP Request\Response status code mocker.
        </div>
        <div class="content">
            You can pass any HTTP Status Code as argument and get it.
            All HTTP statuses can be reached at <a target="_blank" rel="noopener noreferrer" href="https://en.wikipedia.org/wiki/List_of_HTTP_status_codes">Wiki</a>.
        </div>
        <div class="content">
            Just request with expected status, e.g. <a target="_blank" rel="noopener noreferrer" href="./201">/201</a> and get the passed status in response.
        </div>
        <div class="content">
            In addition you can add `delay` parameter to request to wait seconds, like <a target="_blank" rel="noopener noreferrer" href="./201?delay=10">10 seconds</a>.
        </div>
    </div>

    <div class="footer">
        Created by <a target="_blank" rel="noopener noreferrer" href="https://github.com/AlNat">AlNat</a>
    </div>

</div>

</body>
</html>
