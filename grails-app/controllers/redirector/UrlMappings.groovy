package redirector

class UrlMappings {

    static mappings = {
        "/$controller/$action?/$id?(.$format)?"{
            constraints {
                // apply constraints here
            }
        }

        //"/"(view:"/index")
        "/"(view:"/person/email")
        "500"(view:'/error')
        "404"(view:'/notFound')
        "/opt/in"(view:'/opt/in')
        "/email2"(view:'/person/email2')
        "/email3"(view:'/person/email3')
    }
}
