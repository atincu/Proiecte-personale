<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<html>
<body>
	<h1>HOMEPAGE</h1>
	<h2>
		 Logged in as <sec:authentication property="name"/> <sec:authentication property="authorities"/>
	</h2>
	<a href ="logout">Logout</a>

	<sec:authorize access="hasRole('ROLE_ADMIN')">
		Asta vede adminul
	</sec:authorize>	
	<sec:authorize access="hasRole('ROLE_USER')">
		Asta vede userul
	</sec:authorize>
</body>
</html>