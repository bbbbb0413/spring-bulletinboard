<#ftl encoding="utf-8">
<!DOCTYPE html>
<html lang="ko" xmlns:c="http://java.sun.com/jsp/jstl/core">

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta charset="UTF-8" />
    <title>전체 조회</title>

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

        <#list boardList as row>
            <tr>
                <td>${row.boardId}</td>
                <td>${row.boardContent}</td>
                <td>${row.boardCount}</td>
                <td>${row.boardMakeDate}</td>
                <td>${row.boardFixDate}</td>
                <td><a href="http://localhost:8080/sample/read-one?board_id=${row.boardId}">${row.boardTitle}</a></td>
            </tr>

        </#list>
    </table>
    <button type = "button" onclick="location.href ='http://localhost:8080/sample/write?type=CREATE'">
        Post
    </button>
    <button type = "button" onclick="location.href ='http://localhost:8080/sample/sign-up?type=CREATE'">
        sign up
    </button>

    <#list startpage..endpage as curpage>
        <a href = "http://localhost:8080/sample/read-all?curpage=${curpage}">${curpage}</a>
    </#list>
</body>
</html>