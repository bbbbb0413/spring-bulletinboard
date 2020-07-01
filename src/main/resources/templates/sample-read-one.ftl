<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8" />
    <title>단건 조회</title>
</head>
<body>
<table border ="1" width = "600px">
    <tr>
        <th>id</th>
        <th>content</th>
        <th>count</th>
        <th>makedate</th>
        <th>fixdate</th>
        <th>title</th>
    </tr>
    <tr>
        <td>${board.boardId}</td>
        <td>${board.boardContent}</td>
        <td>${board.boardCount}</td>
        <td>${board.boardMakeDate}</td>
        <td>${board.boardFixDate}</td>
        <td>${board.boardTitle}</td>
    </tr>
    <form>
    <div class="button">
        <button type = "button" onclick="location.href ='http://localhost:8080/sample/read-all?curpage=0'">>
            back
        </button>
    </div>
    </form>

</body>
</html>