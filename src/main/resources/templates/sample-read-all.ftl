<#ftl encoding="utf-8">

<!DOCTYPE html>
<html lang="ko" xmlns:c="http://java.sun.com/jsp/jstl/core">

<head>
    <meta charset="UTF-8" />
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">


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
        <a href = "http://localhost:8080/sample/read-all?curpage=${curpage}">${curpage+1}</a>
    </#list>

    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js" integrity="sha384-OgVRvuATP1z7JjHLkuOU7Xw704+h835Lr+6QL9UvYjZE3Ipu6Tp75j7Bh/kR0JKI" crossorigin="anonymous"></script>
</body>
</html>