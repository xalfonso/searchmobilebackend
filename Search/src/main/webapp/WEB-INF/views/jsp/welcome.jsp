<%@page session="false"%>
<%--<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>--%>
<%@include file="/WEB-INF/views/jsp/comun/directivas.jsp"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <title>Spring MVC 4 + Ajax Hello World</title>

        <%@include file="/WEB-INF/views/jsp/comun/intoHead.jsp" %>

    </head>
    <body>
        <%@include file="/WEB-INF/views/jsp/comun/menu.jsp"%>
        <section>
            <div class="container">

                <div class="content">
                    <h1>Search Form</h1>
                    <br>

                    <div id="feedback"></div>

                    <form class="form-horizontal" id="search-form">
                        <div class="form-group form-group-lg">
                            <label class="col-sm-2 control-label">Username</label>
                            <div class="col-sm-10">
                                <input type=text class="form-control" id="username" value="${id}">
                            </div>
                        </div>
                        <div class="form-group form-group-lg">
                            <label class="col-sm-2 control-label">Email</label>
                            <div class="col-sm-10">
                                <input type="text" class="form-control" id="email">
                            </div>
                        </div>

                        <div class="form-group">
                            <div class="col-sm-offset-2 col-sm-10">
                                <button type="submit" id="bth-search"
                                        class="btn btn-primary btn-lg">Search</button>
                            </div>
                        </div>
                    </form>

                </div>

            </div>
        </section>
        <!--<div class="container">-->
        <footer>
            <p>
                &copy; <a href="http://www.mkyong.com">Sitio Web</a> 2015
            </p>
            <ul class="pull-right">
                <li>link1</li>
                <li>link2</li>
                <li>link3</li>
            </ul>
        </footer>
        <!--</div>-->

        <script>
            jQuery(document).ready(function ($) {

                $("#search-form").submit(function (event) {

                    // Disble the search button
                    enableSearchButton(false);

                    // Prevent the form from submitting via the browser.
                    event.preventDefault();

                    searchViaAjax();

                });

            });

            function searchViaAjax() {

                var search = {}
                search["username"] = $("#username").val();
                search["email"] = $("#email").val();

                $.ajax({
                    type: "POST",
                    contentType: "application/json",
                    url: "${home}search/api/getSearchResult",
                    data: JSON.stringify(search),
                    dataType: 'json',
                    timeout: 100000,
                    success: function (data) {
                        console.log("SUCCESS: ", data);
                        display(data);
                    },
                    error: function (e) {
                        console.log("ERROR: ", e);
                        display(e);
                    },
                    done: function (e) {
                        console.log("DONE");
                        enableSearchButton(true);
                    }
                });

            }

            function enableSearchButton(flag) {
                $("#btn-search").prop("disabled", flag);
            }

            function display(data) {
                var json = "<h4>Ajax Response</h4><pre>"
                        + JSON.stringify(data, null, 4) + "</pre>";
                $('#feedback').html(json);
            }
        </script>

    </body>
</html>