<%-- 
    Document   : telaRelatorio
    Created on : 8 de nov de 2022, 12:22:35
    Author     : Aluno
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page language="java" import="com.mycompany.farmacia.*"%>
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

<body>
    <sql:setDataSource var= "conexao" driver= "com.mysql.jdbc.Driver" url= "jdbc:mysql://drogaspoint.cbl5egq4cigg.us-east-1.rds.amazonaws.com:3306/drogaspoint" user= "admin"  password= "cefet123" />
        <sql:query dataSource="${conexao}" var="result" >
            select * from relatorio
        </sql:query>
    <nav>
        <a href="menuVendedor.jsp">
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

                            <th scope="col">Data</th>
                            <th scope="col">Código</th>
                            <th scope="col">Quantidade</th>
                            <th scope="col">Nome</th>
                            <th scope="col">Valor</th>
                        </tr>
                    </thead>
                    <tbody>
                        <tr scope="row">



                            <td>
                                10/03/2023
                            </td>
                            <td>#0001</td>
                            <td>
                                4x
                            </td>
                            <td>Álcool em gel</td>
                            <td>R$49,99</td>

                        </tr>

                        <tr>

                            <td>29/03/2023</td>
                            <td>#0002</td>
                            <td>
                                9x
                            </td>
                            <td>Dipirona</td>
                            <td>R$37,50</td>
                        </tr>
                        <tr>

                            <td>17/02/2023</td>
                            <td>#0003</td>
                            <td>
                                24x
                            </td>
                            <td>Água</td>
                            <td>R$2,50</td>
                        </tr>
                        <tr>

                            <td>14/01/2023</td>
                            <td>#0004</td>
                            <td>
                                12x
                            </td>
                            <td>Colírio</td>
                            <td>R$8,90</td>
                        </tr>
                        <c:forEach var="row" items="${result.rows}">
                            <tr>
                                <td><c:out value = "${row.codigo}"/></td>
                                <td><c:out value = "${row.quantidade}"/></td>
                                <td><c:out value = "${row.nome}"/></td>
                                <td><c:out value = "R$ ${row.receita}"/></td>
                                <td><c:out value = "R$ ${row.receita}"/></td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>


        </div>

    </div>
    <div class="total">
        <h1>TOTAL: R$704,26</h1>
    </div>
</body>

</html>
