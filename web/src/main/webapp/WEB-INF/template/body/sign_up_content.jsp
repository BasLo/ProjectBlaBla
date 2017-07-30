<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form name="f" action="${"/sing_up"}" method="post">
    <fieldset>
        <legend>Your information</legend>
        <label for="username">Username</label>
        <input id="username" name="username"/>
        <label for="password">Password</label>
        <input type="password" id="password" name="password"/>
        <label for="confirm_password">Confirm password</label>
        <input type="password" id="confirm_password" name="confirm_password"/>
        <label for="email" >Email</label>
        <input type="email" id="email" name="email"/>
        <div class="form-actions">
            <button class="btn">Log in</button>
        </div>
    </fieldset>
</form>
</body>
</html>
