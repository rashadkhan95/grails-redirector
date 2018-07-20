<!DOCTYPE html>
<html>
	<head>
		<title>Persons</title>
	</head>
	<body>
        <g:each in="${persons}" var="person" status="i">
            <h3>${i+1}. ${person.key}: ${person.lastName}, ${person.firstName}</h3>

            <br/>
        </g:each>
        
        
	</body>
</html>