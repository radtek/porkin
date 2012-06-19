package name.huangzhoujin.studygroovy

class Tutorial2 {

	
	static main(args) {
		def square = { it * it }
		println square(9)
		def result = [ 1, 2, 3, 4 ].collect(square)
		println result
		def printMapClosure = { key, value -> println key + "=" + value }
		[ "Yue" : "Wu", "Mark" : "Williams", "sudha" : "Kumari" ].each(printMapClosure)
		
		def fullString = ""
		def orderParts = ["BUY", 200, "Hot Dogs", "1"]
		orderParts.each {
		  fullString += it + " "
		}
		println fullString
		
		def myMap = ["China": 1 , "India" : 2, "USA" : 3]
		
		result = 0
		myMap.keySet().each( { result+= myMap[it] } )
		println result
		
		def  stringDate = "2005-07-04"
		def dateArray = stringDate.split("-")	// split() uses regEx's, so you need to escape chars such as a "." -> "\\."
		def year = dateArray[0].toInteger()
		year = year + 1
		def newDate = year + "-" + dateArray[1] + "-" + dateArray[2]
		println newDate
		
		
	}

}

