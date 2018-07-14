package redirector

class BootStrap {

    def init = { servletContext ->
        if (Person.count() == 0) {
            new Person(key: 123, firstName: 'John', lastName: 'Doe', email: 'john.doe@johndoe.me', optin: 1).save()
            new Person(key: 124, firstName: 'Jane', lastName: 'Doe', email: 'jane.doe@janedoe.me', optin: 1).save()
            new Person(key: 125, firstName: 'Richard', lastName: 'Roe', email: 'jich.roe@richroe.me', optin: 0).save()
           
        }
    }
    def destroy = {
    }
}
