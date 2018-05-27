<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
    <body>
        <ul>
            <c:forEach var="empresa" items="${empresas}">
                <li>${empresa.id} : ${empresa.nome}</li><br>
            </c:forEach>
        </ul>
    </body>
</html>