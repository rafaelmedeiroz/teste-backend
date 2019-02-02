package teste.backend

import grails.gorm.transactions.Transactional

@Transactional
class AverageService {

    Double nationalAverage() {
        Long totalAnswers = Answers.count
        Long keepStudents = Answers.countByAlternatives Alternatives.load(Answers.ANSWER_YES_ID)

        Double nationalAverage = keepStudents / totalAnswers * 100 as Double
        nationalAverage.round(4)
    }

    List<RegionalAverage> regionalAverages() {
        def criteria = Answers.createCriteria()
        def allStudents = criteria.list {
            createAlias 'student', 's'

            projections {
                groupProperty 's.regional'
                count 's.id'
            }
        }

        criteria = Answers.createCriteria()
        def students = criteria.list {
            createAlias 'student', 's'

            alternatives {
                eq 'id', Answers.ANSWER_YES_ID
            }

            projections {
                groupProperty 's.regional'
                count 's.id'
            }
        }

        final int REGIONAL = 0
        final int STUDENTS = 1

        students.collect {
            String regional = it[REGIONAL] as String
            long keepStudents = it[STUDENTS] as long
            def found = allStudents.find { r -> r[REGIONAL] == regional }
            long regionalStudents = found[STUDENTS] as long
            Double average = keepStudents / regionalStudents * 100 as double

            new RegionalAverage(regional: regional, average: average.round(4))
        }
    }
}
