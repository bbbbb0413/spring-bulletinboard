<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8" />
    <title>입력</title>

</head>
<body>
    <!-- form 태그 사용 -->
    <!-- '/sample/update', '/sample/create' 처리 분기 -->
    <form name = "form1" method ="post" action = "/sample/create">
        <div>
            Title <br>
            <input name="boardTitle" id="boardTitle" size="80" placeholder="write title">
        </div>

        <div>
            Content <br>
            <textarea name="boardContent" id="boardContent" rows="10" cols="80" placeholder="write content"></textarea>
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


    <#if type == "UPDATE">
        ${sample.name}<br />
        ${sample.age}<br />
        ${sample.birthday}<br />
        ${sample.address}<br />
    </#if>
</body>
</html>