<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main"/>
		<title>Persons</title>
	</head>
	<body>
        <!--<g:each in="${persons}" var="person" status="i">
            <h3>${i+1}. ${person.key}: ${person.lastName}, ${person.firstName}</h3>

            <br/>
        </g:each>-->
        
        <form>
            <p><label for="firstName">First Name:</label><g:textField name="firstName" id="firstName" value="" /></p>
            <p><label for="lastName">Last Name: </label><g:textField name="lastName" id="lastName" value="" /></p>
            <p><label for="email">Email:</label><g:textField name="email" id="email" value="" /></p>
            <p><label for="optin">Opt In:</label>
            <g:radio name="optin" id="yes" value="yes"/><label>Yes</label>
            <g:radio name="optin" id="no" value="no"/><label>No</label></p>
            <g:submitButton name="submit" value="Submit" />
            <g:submitButton name="cancel" value="Cancel" />
        </form>


          <script type="text/javascript">
          window.onload = function urlParams() {
            var url_string = window.location.href;
            var url = new URL(url_string);
            var firstName = url.searchParams.get("firstName");
            document.getElementById("firstName").value = firstName.toString();
            var lastName = url.searchParams.get("lastName");
            document.getElementById("lastName").value = lastName.toString();
            var email = url.searchParams.get("email");
            document.getElementById("email").value = email.toString();
            var optin = url.searchParams.get("optin");
            if (optin == "1") {
              document.getElementById("yes").checked = true;
            }
            else if (optin == "2") {
              document.getElementById("no").checked = true;
            }
          }
          </script>
	</body>
</html>