<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Document</title>
</head>
<body>
    <h2>Bem vindo a aplicação !!</h2>

    <!-- Repare que não usamos o "req.setAttribute("usuarioLogado", usuario)" para recuprar essa informação
    e mostrar na página. Isso acontece porque a expression language é capaz de buscar variáveis no escopo
    do RESQUEST e também no escopo da SESSION, caso ela não ache no escopo do REQUEST ela procura no
    escopo da SESSION -->

    <c:if test="${not empty usuarioLogado}">
        Você está logado como ${usuarioLogado.email}
    </c:if>
    <form action="novaEmpresa" method="POST">
        Nome: <input type="text" name="nome" /><br />
        <input type="submit" value="Enviar" />
    </form>

    <form action="login" method="post">
        Email: <input type="text" name="email" /><br />
        Senha: <input type="password" name="senha" /><br />
        <input type="submit" value="Login" />
    </form>

    <form action="logout" method="post">
        <button type="submit">Deslogar</button>
    </form>

</body>
</html>