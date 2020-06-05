<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8" />
    <title>입력</title>

</head>
<body>
    <!-- form 태그 사용 -->
    <!-- '/sample/update', '/sample/create' 처리 분기 -->
    <form name = "form1" method ="post" action = "/sample/sign-up/create">
        <div>
            Id <br>
            <input name="userId" id="userId" size="20" placeholder="write Id">
        </div>

        <div>
            Password <br>
            <input name="userPassword" id="userPassword" type ="password" maxlength="10"></input>
        </div>
        <div>
            Name <br>
            <input name="userName" id="userName" size="20" placeholder="write Name">
        </div>
        <div>
            Email <br>
            <input name="userEmail" id="userEmail" size="20" placeholder="write Email"></input>
        </div>

        <br>
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