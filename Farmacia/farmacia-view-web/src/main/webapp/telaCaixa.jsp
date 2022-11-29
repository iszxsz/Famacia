<%-- 
    Document   : telaCaixa
    Created on : 8 de nov de 2022, 12:22:19
    Author     : Aluno
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page language="java" import="com.mycompany.farmacia.*"%>
<!DOCTYPE html>
<html>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Caixa</title>
    <link rel="stylesheet" href="../css/estoque.css">
    <link rel="stylesheet" href="../css/owl.carousel.min.css">
    <link rel="stylesheet" href="../css/bootstrap.min.css">
    <link rel="stylesheet" href="../css/style.css">
    <link rel="icon" href="../imgs/imagem_2022-11-04_004109381-removebg-preview.png">
</head>

<body>
    <nav>
        <a href="menuVendedor.html">
            <?xml version="1.0" ?>
            <!DOCTYPE svg  PUBLIC '-//W3C//DTD SVG 1.1//EN'  'http://www.w3.org/Graphics/SVG/1.1/DTD/svg11.dtd'><svg enable-background="new 0 0 32 32" width="50px" id="seta" version="1.1" viewBox="0 0 32 32" width="32px" xml:space="preserve" xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink"><path clip-rule="evenodd" d="M31.106,15H3.278l8.325-8.293  c0.391-0.391,0.391-1.024,0-1.414c-0.391-0.391-1.024-0.391-1.414,0l-9.9,9.899c-0.385,0.385-0.385,1.029,0,1.414l9.9,9.9  c0.391,0.391,1.024,0.391,1.414,0c0.391-0.391,0.391-1.024,0-1.414L3.278,17h27.828c0.552,0,1-0.448,1-1  C32.106,15.448,31.658,15,31.106,15z" fill="#121313" fill-rule="evenodd" id="Arrow_Back"/><g/><g/><g/><g/><g/><g/></svg>
        </a>
        <p id="titulo">DROGAS POINT</p>
    </nav>
    <div class="gigante">
        <div class="nota">
            <input type="text" placeholder="Pesquisar..." style="margin-top: 40px; margin-left: 30px; width: 145px; margin-bottom: .375rem">
            <?xml version="1.0" ?>
            <!DOCTYPE svg  PUBLIC '-//W3C//DTD SVG 1.1//EN'  'http://www.w3.org/Graphics/SVG/1.1/DTD/svg11.dtd'><svg height="30px" id="Layer_1" style="enable-background:new 0 0 512 512; cursor: pointer" version="1.1" viewBox="0 0 512 512" xml:space="preserve" xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink"><path d="M448.3,424.7L335,311.3c20.8-26,33.3-59.1,33.3-95.1c0-84.1-68.1-152.2-152-152.2c-84,0-152,68.2-152,152.2  s68.1,152.2,152,152.2c36.2,0,69.4-12.7,95.5-33.8L425,448L448.3,424.7z M120.1,312.6c-25.7-25.7-39.8-59.9-39.8-96.3  s14.2-70.6,39.8-96.3S180,80,216.3,80c36.3,0,70.5,14.2,96.2,39.9s39.8,59.9,39.8,96.3s-14.2,70.6-39.8,96.3  c-25.7,25.7-59.9,39.9-96.2,39.9C180,352.5,145.8,338.3,120.1,312.6z"/></svg>
            <br>
            <h1>NOTA FISCAL:</h1>
            <button type="button" id="primeiro" class="btn btn-danger">Cancelar</button>
            <button type="button" id="segundo" class="btn btn-primary">Finalizar</button>
        </div>
        <div class=" content ">

            <div class="container ">
                <div class="table-responsive ">

                    <table class="table custom-table ">
                        <thead>
                            <tr>

                                <th scope="col ">Código</th>
                                <th scope="col ">Quantidade</th>
                                <th scope="col ">Nome</th>
                                <th scope="col ">Rótulo</th>
                                <th scope="col ">Preço</th>
                            </tr>
                        </thead>
                        <tbody>
                            <tr scope="row ">



                                <td>
                                    #0001
                                </td>
                                <td>2</td>
                                <td>
                                    Álcool em gel
                                </td>
                                <td>9569</td>
                                <td>R$49,99</td>

                            </tr>

                            <tr>

                                <td>#0002</td>
                                <td>1</td>
                                <td>
                                    Dipirona
                                </td>
                                <td>181</td>
                                <td>R$37,50</td>
                            </tr>
                            <tr>

                                <td>#0003</td>
                                <td>2</td>
                                <td>
                                    Água
                                </td>
                                <td>23623</td>
                                <td>R$2,50</td>
                            </tr>
                            <tr>

                                <td>#0004</td>
                                <td>1</td>
                                <td>
                                    Colírio
                                </td>
                                <td>54154814</td>
                                <td>R$8,90</td>
                            </tr>

                        </tbody>
                    </table>
                </div>


            </div>

        </div>
    </div>
</body>

</html>
