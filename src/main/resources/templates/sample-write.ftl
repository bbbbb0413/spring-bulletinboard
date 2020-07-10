<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8" />
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

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
                    update
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

    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js" integrity="sha384-OgVRvuATP1z7JjHLkuOU7Xw704+h835Lr+6QL9UvYjZE3Ipu6Tp75j7Bh/kR0JKI" crossorigin="anonymous"></script>

</body>
</html>