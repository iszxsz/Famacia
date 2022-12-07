<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="com.mycompany.farmacia.bd.EstoqueBD" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>

<!DOCTYPE html>
<html>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Relatorio</title>
    <link rel="stylesheet" href="css/estoque.css">
    <link rel="stylesheet" href="css/owl.carousel.min.css">
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <link rel="stylesheet" href="css/style.css">
    <link rel="icon" href="imgs/imagem_2022-11-04_004109381-removebg-preview.png">
</head>

<body style="overflow: auto;">
    <sql:setDataSource var= "conn" driver= "com.mysql.jdbc.Driver" url= "jdbc:mysql://drogaspoint.cbl5egq4cigg.us-east-1.rds.amazonaws.com:3306/drogaspoint" user= "admin"  password= "cefet123" />
        <sql:query dataSource="${conn}" var="result" >
            select * from relatorio order by codigo
        </sql:query>
    <nav>
        <a id="return" href="menuVendedor.jsp">
            <?xml version="1.0" ?>
            <!DOCTYPE svg  PUBLIC '-//W3C//DTD SVG 1.1//EN'  'http://www.w3.org/Graphics/SVG/1.1/DTD/svg11.dtd'><svg enable-background="new 0 0 32 32" width="50px" id="seta" version="1.1" viewBox="0 0 32 32" width="32px" xml:space="preserve" xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink"><path clip-rule="evenodd" d="M31.106,15H3.278l8.325-8.293  c0.391-0.391,0.391-1.024,0-1.414c-0.391-0.391-1.024-0.391-1.414,0l-9.9,9.899c-0.385,0.385-0.385,1.029,0,1.414l9.9,9.9  c0.391,0.391,1.024,0.391,1.414,0c0.391-0.391,0.391-1.024,0-1.414L3.278,17h27.828c0.552,0,1-0.448,1-1  C32.106,15.448,31.658,15,31.106,15z" fill="#121313" fill-rule="evenodd" id="Arrow_Back"/><g/><g/><g/><g/><g/><g/></svg>
        </a>
        <p id="titulo">DROGAS POINT</p>
    </nav>
    <div class="content">

        <div class="container">
            <div class="table-responsive">

                <table class="table custom-table">
                    <thead>
                        <tr>

                            <th scope="col">CÃ³digo</th>
                            <th scope="col">Nome</th>
                            <th scope="col">Valor</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:set var="vValor" value="${0.00}"></c:set>
                        <c:set var="clear" value="${param.clear}"></c:set>
                        <c:if test="${!clear.equals('clear')}">
                            <c:forEach var="row" items="${result.rows}">
                                <c:set var="vValor" value="${vValor + row.valor}"></c:set>
                                <tr>
                                    <td><c:out value = "${row.codigo}"/></td>
                                    <td><c:out value = "${row.nome}"/></td>
                                    <td><c:out value = "${row.valor}"/></td>
                                </tr>
                            </c:forEach>
                        </c:if>
                        <c:if test="${clear.equals('clear')}">
                            <h1>Nenhum produto passou no caixa!</h1>
                        </c:if>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
    <div class="total">
        <h1><c:out value = "R$ ${vValor}"/></h1>
        <form action="telaRelatorio.jsp" method="get">
            <input type="text" value="clear" style="display: none;" id="primeiro" name="clear">
            <button type="submit" id="segundo" class="btn btn-primary">Finalizar</button>
        </form>
    </div>
    <script>
        verificarTipoLogin();
        function verificarTipoLogin(){
            if(sessionStorage.getItem("logGerente")){
                let a = document.querySelector("#return");
                a.href = "menuGerente.jsp";
            }
        }
    </script>
</body>

</html>