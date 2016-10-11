        
        <spring:url var="home" value="/" scope="request" />
        <spring:url value="/resources/admin/js/userController.js" var="adminJs"/>
        <spring:url value="/resources/core/js/angular.min.js" var="angularJs"/>
        <spring:url value="/resources/core/css/bootstrap.min.css" var="bootstrapCss" />
        <spring:url value="/resources/core/js/bootstrap.min.js" var="bootstrapJs" />
        <spring:url value="/resources/core/js/jquery.1.10.2.min.js" var="jqueryJs" />
        <spring:url value="/resources/core/css/comunCss.css" var="comunCss" />
        <script src="${jqueryJs}"></script>
        <script src="${bootstrapJs}"></script>
        <script src="${angularJs}"></script>
        <script src="${adminJs}"></script>
        <link href="${bootstrapCss}" rel="stylesheet" />
        <link href="${comunCss}" rel="stylesheet" />