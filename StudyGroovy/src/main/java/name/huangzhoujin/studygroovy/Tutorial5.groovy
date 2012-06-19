package name.huangzhoujin.studygroovy

class Tutorial5 {

	static main(args) {
		def names = [
			"Graham James Edward Miller",
			"Andrew Gregory Macintyre",
			"No MiddleName"
		]
		
		def printClosure = {
			def matcher = (it =~ /(.*?)(?: .*)* (.*)/);  // notice the non-matching group in the middle
			if (matcher.matches())
				println(matcher[0][2]+", "+matcher[0][1]);
		}
		names.each(printClosure);
		
		def popesArray = [
			"Pope Anastasius I 399-401",
			"Pope Innocent I 401-417",
			"Pope Zosimus 417-418",
			"Pope Boniface I 418-422",
			"Pope Celestine I 422-432",
			"Pope Sixtus III 432-440",
			"Pope Leo I the Great 440-461",
			"Pope Hilarius 461-468",
			"Pope Simplicius 468-483",
			"Pope Felix III 483-492",
			"Pope Gelasius I 492-496",
			"Pope Anastasius II 496-498",
			"Pope Symmachus 498-514"
		]
		
		println "-----------------------------------------------"
		
		def myClosure = {
			def myMatcher = (it =~ /Pope (.*?)(?: .*)? ([0-9]+)-([0-9]+)/);
			if (myMatcher.matches())
				println(myMatcher[0][1]+": "+myMatcher[0][2]+" to "+myMatcher[0][3]);
		}
		popesArray.each(myClosure);
	
	}

}
