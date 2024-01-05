<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Calculator</h1>
<hr>
<form action="cal" method="post">
    <fieldset>
        <legend>Calculator</legend>
        <input type="number" name="number1" required>
        <input type="number" name="number2" required>
        <br>
        <br>
        <button type="submit" name="operator" value="+">Addition (+)</button>
        <button type="submit" name="operator" value="-">Subtraction (-)</button>
        <button type="submit" name="operator" value="*">Multiplication (x)</button>
        <button type="submit" name="operator" value="/">Disvision (/)</button>
        <br>
        <p style="color:red;">Result: ${result}</p>
    </fieldset>
</form>
</body>
</html>
