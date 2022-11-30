<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="com.mycompany.farmacia.servico.ManterProduto" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>

<!DOCTYPE html>
<html>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Estoque</title>
    <link rel="stylesheet" href="css/estoque.css">
    <link rel="stylesheet" href="css/owl.carousel.min.css">
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <link rel="stylesheet" href="css/style.css">
    <link rel="icon" href="imgs/imagem_2022-11-04_004109381-removebg-preview.png">
</head>

<body>
    <sql:setDataSource var= "conn" driver= "com.mysql.jdbc.Driver" url= "jdbc:mysql://drogaspoint.cbl5egq4cigg.us-east-1.rds.amazonaws.com:3306/drogaspoint" user= "admin"  password= "cefet123" />
        <sql:query dataSource="${conn}" var="result" >
            select * from estoque
        </sql:query>
    <nav>
        <a href="menuVendedor.jsp">
            <?xml version="1.0" ?>
            <!DOCTYPE svg  PUBLIC '-//W3C//DTD SVG 1.1//EN'  'http://www.w3.org/Graphics/SVG/1.1/DTD/svg11.dtd'><svg enable-background="new 0 0 32 32" width="50px" id="seta" version="1.1" viewBox="0 0 32 32" width="32px" xml:space="preserve" xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink"><path clip-rule="evenodd" d="M31.106,15H3.278l8.325-8.293  c0.391-0.391,0.391-1.024,0-1.414c-0.391-0.391-1.024-0.391-1.414,0l-9.9,9.899c-0.385,0.385-0.385,1.029,0,1.414l9.9,9.9  c0.391,0.391,1.024,0.391,1.414,0c0.391-0.391,0.391-1.024,0-1.414L3.278,17h27.828c0.552,0,1-0.448,1-1  C32.106,15.448,31.658,15,31.106,15z" fill="#121313" fill-rule="evenodd" id="Arrow_Back"/><g/><g/><g/><g/><g/><g/></svg>
        </a>
        <p id="titulo">DROGAS POINT</p>
    </nav>
    <div class="gigante">
        <div class="botoues">
            <button type="button" id="addproduto" class="btn btn-danger" data-toggle="modal" data-target="#exampleModalCenter" style="width: 190px;">Adicionar Produto</button>
        </div>
        <div class="content">
            <div id="myModal" class="modal">

                <!-- Modal content -->
                <div class="modal-content">
                    <div class="modal-header">
                        <h2 id="titulomodal">Adicionar Produto</h2>
                        <span class="close">&times;</span>                  
                    </div>
                    <div class="modal-body">
                        <form action="" method="post">
                            <label for="POST-name">Nome:</label>
                            <input id="POST-name" type="text" name="name"> <br>
                            <label for="POST-name">Rótulo:</label>
                            <input id="POST-name" type="text" name="name"> <br>
                            <label for="POST-name">Quantidade:</label>
                            <input id="POST-name" type="text" name="name"> <br>
                            <label for="POST-name">Preço:</label>
                            <input id="POST-name" type="text" name="name"> <br>
                            <label for="POST-name">Validade:</label>
                            <input id="POST-name" type="text" name="name"><br>
                            <label for="POST-name">Precisa de Bula:</label>
                            <input type="radio" id="sim" name="bula" value="sim">
                            <label for="html">Sim</label>
                            <input type="radio" id="nao" name="bula" value="nao">
                            <label for="css">Não</label><br>
                          </form>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="butaco" onclick="document.getElementById('myModal').style.display='none'">Adicionar</button>
                        <button type="button" class="butaco2" onclick="document.getElementById('myModal').style.display='none'" class="cancelbtn">Cancelar</button>
                    </div>
                </div>
    
            </div>

            <div class="container">
                <div class="table-responsive">

                    <table class="table custom-table">
                        <thead>
                            <tr>

                                <th scope="col">Código</th>
                                <th scope="col">Quantidade</th>
                                <th scope="col">Nome</th>
                                <th scope="col">Receita</th>
                                <th scope="col">Valor</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach var="row" items="${p.rows}">
                            <tr>
                                <td><c:out value = "${row.produto.getCodigo()}"/></td>
                                <td><c:out value = "${row.produto.getNome()}"/></td>
                                <td><c:out value = "${row.produto.getReceita()}"/></td>
                                <td><c:out value = "${row.produto.getValor()}"/></td>
                                
                            </tr>
                        </c:forEach>

                        </tbody>
                    </table>
                </div>


            </div>

        </div>
    </div>
    <script>
        // Get the modal
        var modal = document.getElementById("myModal");

        // Get the button that opens the modal
        var btn = document.getElementById("addproduto");

        // Get the <span> element that closes the modal
        var span = document.getElementsByClassName("close")[0];

        // When the user clicks the button, open the modal 
        btn.onclick = function() {
            modal.style.display = "block";
        };

        // When the user clicks on <span> (x), close the modal
        span.onclick = function() {
            modal.style.display = "none";
        };

        // When the user clicks anywhere outside of the modal, close it
        window.onclick = function(event) {
            if (event.target == modal) {
                modal.style.display = "none";
            }
        };
    </script>
    

</body>

</html>
