<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<form action="save" method="post">
    <fieldset>
        <legend>Sandwich Condiments</legend>
        <label><input type="checkbox" name="condiments" value="Lettuce">Lettuce</label>
        <label><input type="checkbox" name="condiments" value="Tomato">Tomato</label>
        <label><input type="checkbox" name="condiments" value="Mustard">Mustard</label>
        <label><input type="checkbox" name="condiments" value="Sprouts">Sprouts</label>
        <hr>
        <input type="submit" value="Save">
    </fieldset>
</form>
</body>
</html>