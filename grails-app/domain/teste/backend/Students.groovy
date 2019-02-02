package teste.backend

class Students {

    String regional
    String name
    static hasMany = [answers:Answers]
    static constraints = {
    }
    static mapping = {
        version false
        id column: "id", sqlType: "Integer"
    }
}
