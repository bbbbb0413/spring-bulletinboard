<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8" />
    <title>단건 조회</title>
</head>
<body>
<form name = "form1">
    <div>
        boardId : <label>${board.boardId} </label>
    </div>
    <div>
        <input name="boardTitle" id="boardTitle" size="80" placeholder=${board.boardTitle} readonly>
    </div>

    <div>
        <textarea name="boardContent" id="boardContent" rows="10" cols="80" placeholder=${board.boardContent} readonly></textarea>
    </div>
    <div>
        Makedate : <label>${board.boardMakeDate} </label>
    </div>
    <div>
        Fixdate : <label>${board.boardFixDate} </label>
    </div>
    <div>
        Count : <label>${board.boardCount} </label>
    </div>
    <br>
    <div class="button">
        <button type = "button" onclick="location.href = 'http://localhost:8080/sample/write?type=UPDATE&board_id=${board.boardId}'">
            update
        </button>

    </div>
</form>
    <form>
    <div class="button">
        <button type = "button" onclick="location.href ='http://localhost:8080/sample/read-all'">>
            back
        </button>
    </div>
    </form>
<#--Reply form 수정해야함.-->
<#--    <form name = "form2" method ="post" action = "/sample/create">-->
<#--        <div>-->
<#--            writer <br>-->
<#--            <input name="replyWriter" id="replyWriter" size="20" placeholder="write writer">-->
<#--        </div>-->

<#--        <div>-->
<#--            Content <br>-->
<#--            <textarea name="ReplyContent" id="ReplyContent" rows="5" cols="40" placeholder="write content"></textarea>-->
<#--        </div>-->
<#--        <br>-->
<#--        <div class="button">-->
<#--            <button type = "submit">-->
<#--                submit-->
<#--            </button>-->
<#--        </div>-->
<#--        <br>-->
<#--        <div class="button">-->
<#--            <button type = "button" onclick="location.href ='http://localhost:8080/sample/read-all'">>-->
<#--                cancel-->
<#--            </button>-->
<#--        </div>-->
<#--    </form>-->

<#--reply 목록 조회 출력하는 부분, 변경해야함-->
<table border ="1" width = "600px">
<#list board.replies as row>
    <tr>
        <th>id</th>
        <th>writer</th>
        <th>content</th>
        <th>makedate</th>
    </tr>
    <tr>
        <td>${row.replyId}</td>
        <td>${row.replyWriter}</td>
        <td>${row.replyContent}</td>
        <td>${row.replyMakeDate}</td>
    </tr>
</#list>
</table>
</body>
</html>