<!--
  To change this license header, choose License Headers in Project Properties.
  To change this template file, choose Tools | Templates
  and open the template in the editor.
-->

<%@ page contentType="text/html;charset=UTF-8" %>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Email</title>
    </head>
    <body>
        
        <p>Hello John, </p>
        <p>Click on the link below to go to the form.</p>
        
        <p>John Doe: <g:link controller="person" action="goToForm">http://localhost:8090/process/optin?key=123</g:link></p>
        
        
    </body>
</html>
