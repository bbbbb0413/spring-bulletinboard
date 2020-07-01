<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8" />
    <title>입력</title>

</head>
<body>
    <!-- form 태그 사용 -->
    <!-- '/sample/update', '/sample/create' 처리 분기 -->
    <#if type == "CREATE">
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
    </#if>

    <#if type == "UPDATE">
        <form name = "form2" method ="post" action = "/sample/update">
            <div>
                <input type="hidden" name="boardId" id="boardId" value=${board.boardId}> </input>
                <input type="hidden" name="boardCount" id="boardCount" value=${board.boardCount}> </input>
                <input type="hidden" name="boardMakeDate" id="boardMakeDate" value=${board.boardMakeDate}> </input>
                <input type="hidden" name="boardFixDate" id="boardFixDate" value=${board.boardFixDate}> </input>
            </div>

            <div>
                Title <br>
                <input name="boardTitle" id="boardTitle" size="80" placeholder=${board.boardTitle}>
            </div>

            <div>
                Content <br>
                <textarea name="boardContent" id="boardContent" rows="10" cols="80" placeholder=${board.boardContent}></textarea>
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
    </#if>
</body>
</html>