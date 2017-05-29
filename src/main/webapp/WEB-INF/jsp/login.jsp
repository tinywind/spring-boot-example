<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags" %>


<tag:page>
    <c:if test="${fail != null && fail}">
        <div>로그인에 실패했습니다. 아이디와 패스워드를 확인하세요.</div>
    </c:if>

    <form id="login-form" method="post" action="/login">
        <input type="text" name="id"/>
        <input type="password" name="password"/>

        <input type="checkbox" id="save-login"/>
        <label for="save-login">
            자동로그인
        </label>

        <button type="button" onclick="submitForm()">로그인</button>
    </form>

    <script type="text/javascript">

        /**
         * 1. 로그인할 때
         *  - 자동로그인이 Enable이면, id/password 정보를 local storage 에 저장한다.
         *  - 자동로그인 disable이면, local storage 에 저장된 id/password 정보를 삭제한다.
         * 2. 페이지 로딩시
         *  - local storage에 id/password 정보가 있다면, 자동로그인 체크박스에 체크하고 id/password input 박스에 정보를 기입한다.
         * */
        var loginId = localStorage.getItem('login-id');
        $('[name=id]').val(loginId);
        $('[name=password]').val(localStorage.getItem('login-password'));

         if (loginId != null) {
            $('#save-login').prop('checked', true);
        }

        function submitForm() {
            if ($('#save-login').is(':checked')) {
                localStorage.setItem('login-id', $('[name=id]').val());
                localStorage.setItem('login-password', $('[name=password]').val());
                // localStorage.getItem('foo');
            } else {
                localStorage.removeItem('login-id');
                localStorage.removeItem('login-password');
            }

            $('#login-form').submit();
        }

    </script>

</tag:page>