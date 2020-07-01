<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8" />
    <title>입력</title>

</head>
<body>
    <form name = "form1" method ="post" action = "/sample/login">
        <div>
            Id <br>
            <input name="userId" id="userId" size="20" placeholder="write Id">
        </div>

        <div>
            Password <br>
            <input name="userPassword" id="userPassword" type ="password" maxlength="10"></input>
        </div>
        <div class="button">
            <button type = "submit">
                submit
            </button>
        </div>
        <br>
        <div class="button">
            <button type = "button" onclick="location.href ='http://localhost:8080/sample/read-all'">>
                cancel
            </button>
        </div>
    </form>

</body>
</html>