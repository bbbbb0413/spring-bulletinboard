<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8" />
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

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
            board update
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
    <form name = "form2" method ="post" action = "/reply/create">
        <div>
            <input type = "hidden" name="board" id= "board" value=${board.boardId}>
        </div>
        <div>
            writer <br>
            <input name="replyWriter" id="replyWriter" size="20" placeholder="write writer">
        </div>

        <div>
            Content <br>
            <textarea name="ReplyContent" id="ReplyContent" rows="5" cols="40" placeholder="write content"></textarea>
        </div>
        <br>
        <div class="button">
            <button type = "submit">
                reply create
            </button>
        </div>
        <br>
    </form>

<#--reply 목록 조회 출력하는 부분, 변경해야함-->
<table border ="1" width = "600px">
    <tr>
        <th>id</th>
        <th>writer</th>
        <th>content</th>
        <th>makedate</th>
        <th>fixdate</th>
        <th>update</th>
        <th>delete</th>
    </tr>
    <#list board.replies as row>
    <tr>
        <td>${row.replyId}</td>
        <td>${row.replyWriter}</td>
        <td>${row.replyContent}</td>
        <td>${row.replyMakeDate}</td>
        <td>${row.replyFixDate}</td>
        <td>
            <form name="reply_update" method="post" action = "/reply/update?reply_id=${row.replyId}">
                <input type="hidden" name="replyId" id="replyId" value=${row.replyId}> </input>
                <input type="hidden" name="replyWriter" id="replyWriter" value=${row.replyWriter}> </input>
                <input type="hidden" name="replyMakeDate" id="replyMakeDate" value=${row.replyMakeDate}> </input>
                <input type="hidden" name="replyFixDate" id="replyFixDate" value=${row.replyFixDate}> </input>
                <div>
                    <textarea name = "replyContent" id = "replyContent" rows="5" cols="20" placeholder=${row.replyContent}></textarea>
                </div>
                <div class="button">
                    <button type = "submit">
                        update
                    </button>
                </div>
            </form>
        </td>
        <td><button type="button" onclick="location.href = 'http://localhost:8080/reply/delete?reply_id=${row.replyId}'">delete</button></td>
    </tr>
</#list>
</table>
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js" integrity="sha384-OgVRvuATP1z7JjHLkuOU7Xw704+h835Lr+6QL9UvYjZE3Ipu6Tp75j7Bh/kR0JKI" crossorigin="anonymous"></script>


</body>
</html>