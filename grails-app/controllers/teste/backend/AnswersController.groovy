package teste.backend

class AnswersController {
	static responseFormats = ['json', 'xml']
    AverageService averageService

    def index() {
        List<RegionalAverage> regionalAverage = averageService.regionalAverages()
        Double national = averageService.nationalAverage()

        return [regionalAverageList: regionalAverage, national: national]
    }
}
