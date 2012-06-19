package name.huangzhoujin.studygroovy

class Tutorial4 {

	static main(args) {
		def result =  ("potatoe" ==~ /potatoe/)
		println result

		result = ("potato" ==~ /potatoe?/)
		println result

		result = ("motato" ==~ /potatoe?/)
		println result

		def theRegularExpression = /Wisniew?ski/
		checkSpelling("Wisniewski", theRegularExpression)
		checkSpelling("Wisnieski", theRegularExpression)
		checkSpelling("Wisniewewski", theRegularExpression)
		
		println "-------------------------------------------------------------"
		theRegularExpression = /Wisn(ie|ei)w?ski/
		checkSpelling("Wisniewski", theRegularExpression)
		checkSpelling("Wisnieski", theRegularExpression)
		checkSpelling("Wisniewewski", theRegularExpression)
	}


	static checkSpelling(spellingAttempt, spellingRegularExpression) {
		if (spellingAttempt ==~ spellingRegularExpression) {
			println("Congratulations, you spelled it correctly.")
		} else {
			println("Sorry, try again.")
		}
	}
}
