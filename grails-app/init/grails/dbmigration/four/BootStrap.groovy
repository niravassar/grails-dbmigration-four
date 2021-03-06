package grails.dbmigration.four


import grails.util.Environment

class BootStrap {

    def init = { servletContext ->

        if ( Environment.current == Environment.DEVELOPMENT ) {
            initPersons()
        }
    }

    def destroy = {
    }

    static void initPersons() {
        [
            [name: 'Nirav', age: 39],
            [name: 'Jeff', age: 45],
            [name: 'Sergio', age: 34]
        ].each { Map m ->
            Person.findByName(m.name) ?: new Person(m).save()
        }
    }
}
