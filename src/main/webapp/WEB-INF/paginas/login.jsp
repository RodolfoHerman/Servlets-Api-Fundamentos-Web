<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
    <body>
        <c:choose>
            <c:when test="${not empty usuarioLogado}">
                Você está logado como : ${usuarioLogado.email}
                <br>
            </c:when>    
            <c:otherwise>
                Usuario ou senha invalido
                <br>
            </c:otherwise>
        </c:choose>
    </body>
</html>