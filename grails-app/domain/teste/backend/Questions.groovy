package teste.backend

class Questions {

    String description
    static hasMany = [answers:Answers]
    static constraints = {
    }
    static mapping = {
        version false
        id column: "id", sqlType: "Integer"
    }
}
