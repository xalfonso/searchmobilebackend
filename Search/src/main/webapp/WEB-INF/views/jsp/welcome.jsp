<%@page session="false"%>
<%@include file="/WEB-INF/views/jsp/comun/directivas.jsp"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <title>Spring MVC 4 + Ajax Hello World</title>
        <%@include file="/WEB-INF/views/jsp/comun/intoHead.jsp" %>
    </head>
    <body>
        <%@include file="/WEB-INF/views/jsp/comun/layersBegin.jspf"%>

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

<%@include file="/WEB-INF/views/jsp/comun/layersEnd.jspf" %>
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