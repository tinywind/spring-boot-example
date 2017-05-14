<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags" %>


<tag:page>
    <c:if test="${message != null}">
        <div>
            ${message}
        </div>

    </c:if>

    <form id="join-form" method="post" action="/join">
        <input type="text" name = "id"/>
        <input type="password" name="password"/>
        <input type="password" name="passwordConfirm"/>

        <button id="submit-button" type="button">제출</button>

    </form>

    <script type="text/javascript">
        $('#submit-button').click(function () {
            var form = $('#join-form'); //#은 아이디를 뜻한다/

            var inputId = form.find('[name=id]');
            var inputPassword = form.find('[name=password]');
            var inputPasswordConfirm = form.find('[name=passwordConfirm]');

            if(inputId.val() == ""){
                alert("아이디가 비어있습니다");
                return;
            }
            if(inputPassword.val() == ""){
                alert("패스워드가 비어있습니다");
                return;
            }
            if(inputPassword.val() != inputPasswordConfirm.val()){
                alert("패스워드와 패스워드 확인가 같지 않습니다");
                return;
            }

            form.submit();


        })


    </script>
</tag:page>