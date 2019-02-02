package teste.backend

class Alternatives {
    String description
    static hasMany = [answers:Answers]
    static constraints = {
    }
    static mapping = {
        version false
        id column: "id", sqlType: "Integer"

    }

}
