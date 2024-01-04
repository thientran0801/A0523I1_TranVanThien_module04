<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<h2>Convert USO to VND:</h2>
<hr>
<form action="convert" method="post">

    <p><label for="usdId">USD:</label>
        <input type="number" placeholder="USD" name="usd" id="usdId"></p>

    <p> <label for="rateId">Rate:</label>
        <input type="number" placeholder="RATE..." name="rate" id="rateId"></p>
    <input type="submit" value="Convert">
</form>
</body>
</html>