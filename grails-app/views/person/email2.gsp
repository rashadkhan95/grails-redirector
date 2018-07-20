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
        
        <p>Hello Jane, </p>
        <p>Click on the link below to go to the form.</p>
        
        
        <p>Jane Doe: <g:link controller="person" action="goToJane">http://localhost:8080/process/optin?key=124</g:link></p>
        
        
    </body>
</html>
