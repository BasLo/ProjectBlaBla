<%@ page contentType="text/html;charset=UTF-8" %>
<body>
<div>
    <form name="f" action="${"/login"}" method="post">
        <fieldset>
            <legend>Please Login</legend>
            <label for="j_username">Username</label>
            <input id="j_username" name="j_username"/>
            <label for="j_password">Password</label>
            <input type="password" id="j_password" name="j_password"/>
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
            <div class="form-actions">
                <button class="btn">Log in</button>
            </div>
        </fieldset>
    </form>
</div>
</body>
