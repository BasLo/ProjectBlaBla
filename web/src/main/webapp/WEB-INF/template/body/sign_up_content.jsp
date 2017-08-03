<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form name="f" action="${"/signUp"}" method="post" >
    <fieldset>
        <legend>Your information</legend>

        <label for="username">Username</label>
        <input id="username" name="username"/>

        <label for="password">Password</label>
        <input type="password" id="password" name="password"/>

        <label for="matchingPassword">Confirm password</label>
        <input type="password" id="matchingPassword" name="matchingPassword"/>

        <label for="email" >Email</label>
        <input type="email" id="email" name="email"/>

        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>

        <div class="form-actions">
            <button class="btn">Register</button>
        </div>
    </fieldset>
</form>
</body>
</html>
