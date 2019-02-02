package teste.backend

class Answers {
    static final Long ANSWER_YES_ID = 37l

    static constraints = {
    }
    static belongsTo = [student:Students, questions:Questions, alternatives:Alternatives]
    static mapping = {
        version false
        id column: "id", sqlType: "Integer"
        student column: "student_id", sqlType: "Integer"
        questions column: "question_id", sqlType: "Integer"
        alternatives column: "alternative_id", sqlType: "Integer"
    }
}
