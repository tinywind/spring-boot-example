<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags" %>


<tag:page>
    <div>로그인에 실패했습니다. 아이디와 패스워드를 확인하세요.</div>

    <form method="post" action="/login">
        <input type="text" name = "id"/>
        <input type="password" name="password"/>

        <button type="submit">제출</button>

    </form>


</tag:page>