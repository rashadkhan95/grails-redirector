package redirector

import grails.validation.ValidationException
//import static org.springframework.http.HttpStatus.*

class PersonController {

    PersonService personService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond personService.list(params), model:[personCount: personService.count()]
        
    }
    
    def showPersons(){
        def persons = Person.list()
        [persons:persons]
    }
    
    def email() {
        def john = Person.findByKey(123)
        [john:john]
        
        //render(view: "/views/index", model: john)
        //return [personView: john]
    }
    
    def list() {
        [persons: Person.list(params)]
    }

    def goToForm(){
        def john = Person.findByKey(123)
        [john:john]
        redirect(url: "http://localhost:8080/opt/in?firstName=${john.firstName}&lastName=${john.lastName}&email=${john.email}&optin=${john.optin}")}
    
    def goToJane(){
        def jane = Person.findByKey(124)
        [jane:jane]
        redirect(url: "http://localhost:8080/opt/in?firstName=${jane.firstName}&lastName=${jane.lastName}&email=${jane.email}&optin=${jane.optin}")}
    
    def goToRich(){
        def rich = Person.findByKey(125)
        [rich:rich]
        redirect(url: "http://localhost:8080/opt/in?firstName=${rich.firstName}&lastName=${rich.lastName}&email=${rich.email}&optin=${rich.optin}")}
    
    
    

    def show(Long id) {
        respond personService.get(id)
    }

    def create() {
        respond new Person(params)
    }

    def save(Person person) {
        if (person == null) {
            notFound()
            return
        }

        try {
            personService.save(person)
        } catch (ValidationException e) {
            respond person.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'person.label', default: 'Person'), person.id])
                redirect person
            }
            '*' { respond person, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond personService.get(id)
    }

    def update(Person person) {
        if (person == null) {
            notFound()
            return
        }

        try {
            personService.save(person)
        } catch (ValidationException e) {
            respond person.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'person.label', default: 'Person'), person.id])
                redirect person
            }
            '*'{ respond person, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        personService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'person.label', default: 'Person'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'person.label', default: 'Person'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
