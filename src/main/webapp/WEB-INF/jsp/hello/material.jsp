<%--@elvariable id="name" type="java.lang.String"--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Hello Millky</title>
    <!--Import Google Icon Font-->
    <link href="http://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
    <!-- Compiled and minified CSS -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.98.1/css/materialize.min.css">

</head>

<body>

<a href="/application.yml">application_yml</a>
<ul id="slide-out" class="side-nav">
    <li><div class="userView">
        <div class="background">
            <img src="images/office.jpg">
        </div>
        <a href="#!user"><img class="circle" src="images/yuna.jpg"></a>
        <a href="#!name"><span class="white-text name">John Doe</span></a>
        <a href="#!email"><span class="white-text email">jdandturk@gmail.com</span></a>
    </div></li>
    <li><a href="#!"><i class="material-icons">cloud</i>First Link With Icon</a></li>
    <li><a href="#!">Second Link</a></li>
    <li><div class="divider"></div></li>
    <li><a class="subheader">Subheader</a></li>
    <li><a class="waves-effect" href="#!">Third Link With Waves</a></li>
</ul>
<a href="#" data-activates="slide-out" class="button-collapse"><i class="material-icons">menu</i></a>


<div class="slider">
    <ul class="slides">
        <li>
            <img src="http://lorempixel.com/580/250/nature/1"> <!-- random image -->
            <div class="caption center-align">
                <h3>This is our big Tagline!</h3>
                <h5 class="light grey-text text-lighten-3">Here's our small slogan.</h5>
            </div>
        </li>
        <li>
            <img src="http://lorempixel.com/580/250/nature/2"> <!-- random image -->
            <div class="caption left-align">
                <h3>Left Aligned Caption</h3>
                <h5 class="light grey-text text-lighten-3">Here's our small slogan.</h5>
            </div>
        </li>
        <li>
            <img src="http://lorempixel.com/580/250/nature/3"> <!-- random image -->
            <div class="caption right-align">
                <h3>Right Aligned Caption</h3>
                <h5 class="light grey-text text-lighten-3">Here's our small slogan.</h5>
            </div>
        </li>
        <li>
            <img src="http://lorempixel.com/580/250/nature/4"> <!-- random image -->
            <div class="caption center-align">
                <h3>This is our big Tagline!</h3>
                <h5 class="light grey-text text-lighten-3">Here's our small slogan.</h5>
            </div>
        </li>
    </ul>
</div>

<div class="row">
    <form class="col s12">
        <div class="row">
            <div class="input-field col s6">
                <input placeholder="Placeholder" id="first_name" type="text" class="validate">
                <label for="first_name">First Name</label>
            </div>
            <div class="input-field col s6">
                <input id="last_name" type="text" class="validate">
                <label for="last_name">Last Name</label>
            </div>
        </div>
        <div class="row">
            <div class="input-field col s12">
                <input disabled value="I am not editable" id="disabled" type="text" class="validate">
                <label for="disabled">Disabled</label>
            </div>
        </div>
        <div class="row">
            <div class="input-field col s12">
                <input id="password" type="password" class="validate">
                <label for="password">Password</label>
            </div>
        </div>
        <div class="row">
            <div class="input-field col s12">
                <input id="email" type="email" class="validate">
                <label for="email">Email</label>
            </div>
        </div>
        <div class="row">
            <div class="col s12">
                This is an inline input field:
                <div class="input-field inline">
                    <input id="email2" type="email" class="validate">
                    <label for="email2" data-error="wrong" data-success="right">Email</label>
                </div>
            </div>
        </div>
    </form>
</div>


<!-- Dropdown Trigger -->
<a class='dropdown-button btn' href='#' data-activates='dropdown1'>dROP!</a>

<!-- Dropdown Structure -->
<ul id='dropdown1' class='dropdown-content'>
    <li><a href="#!">one</a></li>
    <li><a href="#!">two</a></li>
    <li class="divider"></li>
    <li><a href="#!">three</a></li>
    <li><a href="#!"><i class="material-icons">view_module</i>four</a></li>
    <li><a href="#!"><i class="material-icons">cloud</i>five</a></li>
</ul>
<!-- Element Showed -->
<a id="menu" class="waves-effect waves-light btn btn-floating" ><i class="material-icons">menu</i></a>

<!-- Tap Target Structure -->
<div class="tap-target" data-activates="menu">
    <div class="tap-target-content">
        <h5>Title</h5>
        <p>A bunch of text</p>
    </div>
</div>


<ul class="pagination">
    <li class="disabled"><a href="#!"><i class="material-icons">chevron_left</i></a></li>
    <li class="active"><a href="#!">1</a></li>
    <li class="waves-effect"><a href="#!">2</a></li>
    <li class="waves-effect"><a href="#!">3</a></li>
    <li class="waves-effect"><a href="#!">4</a></li>
    <li class="waves-effect"><a href="#!">5</a></li>
    <li class="waves-effect"><a href="#!"><i class="material-icons">chevron_right</i></a></li>
</ul>

<!--Import jQuery before materialize.js-->
<script type="text/javascript" src="https://code.jquery.com/jquery-2.1.1.min.js"></script>
<!-- Compiled and minified JavaScript -->
<script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.98.1/js/materialize.min.js"></script>


</body>
</html>