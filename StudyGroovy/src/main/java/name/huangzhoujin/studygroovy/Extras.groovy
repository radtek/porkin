package name.huangzhoujin.studygroovy

import groovy.time.*

class Extras {

	static toString(BaseDuration it){
		def list= []
		if(it.years != 0) list<< "$it.years yrs"
		if(it.months != 0) list<< "$it.months mths"
		if(it.days != 0) list<< "$it.days days"
		if(it.hours != 0) list<< "$it.hours hrs"
		if(it.minutes != 0) list<< "$it.minutes mins"
		if(it.seconds != 0 || it.millis != 0) list<< "$it.seconds.$it.millis secs"
		list.join(', ')
	}
}
