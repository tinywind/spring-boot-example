<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags" %>


<%--@elvariable id="bindingResult" type="org.springframework.validation.BindingResult"--%>
<%--@elvariable id="post" type="com.gogokwon.model.Post"--%>

<tag:page>
    <style>
        .bind-error{
            color: red !important;
        }
    </style>

    <%--<form action="/post" method="post" enctype="multipart/form-data">--%>
    <form:form modelAttribute="post" action="/post" method="post" enctype="multipart/form-data">
        <form:hidden path="id"/>

        <div class="md-form">
            <form:input path="title" class="form-control"/>
            <label for="title" class="${bindingResult == null || bindingResult.getFieldErrorCount("title") == 0 ? '':'bind-error'}">Title</label>
        </div>

        <div class="md-form">
            <%--<input type="text" name="subtitle" id="subtitle" class="form-control">--%>
                <form:input path="subtitle" class="form-control"/>
                <label for="subtitle" class="">Subtitle</label>
        </div>

        <!--Textarea with icon prefix-->
        <div class="md-form">
            <i class="fa fa-pencil prefix"></i>
            <%--<textarea type="text" name="content" id="content" class="md-textarea"></textarea>--%>
            <form:textarea path="content" class="md-textarea"/>
            <label for="content">Content</label>
        </div>

        <div class="file-field input-field">
            <div class="btn">
                <span>File</span>
                <input type="file" name="file">
            </div>
            <div class="file-path-wrapper">
                <input class="file-path validate" type="text" value="${u.filename(post.fileUrl)}">
            </div>
        </div>
        <div>
            <button type="submit" class="btn btn-outline-secondary btn-rounded waves-effect">Submit</button>
            <button type="button" class="btn btn-outline-secondary btn-rounded waves-effect" onclick="location.history.back()">Cancel</button>
        </div>

    </form:form>

    <script type="text/javascript">

        <c:if test="${bindingResult.hasErrors()}">
        alert("${bindingResult.allErrors.get(bindingResult.errorCount - 1).defaultMessage.replaceAll('"','\\"')}");
        </c:if>

        $('[name=title]').keydown(function()
        {
           $('[for=title]').removeClass('bind-error');
        });

    </script>
</tag:page>