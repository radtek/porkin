package name.huangzhoujin.studygroovy;

import groovy.util.GroovyTestCase;
import groovy.time.*

class JN0545Test extends GroovyTestCase {

	public void testDate01(){
		def today= new Date() //represents the date and time when it is created
		println today

		//we can add to and subtract from a date...
		def tomorrow= today + 1,
		dayAfter= today + 2,
		yesterday= today - 1,
		dayBefore= today - 2
		println "\n$dayBefore\n$yesterday\n$today\n$tomorrow\n$dayAfter\n"
		assert today + 7 == today.plus(7) && today - 15 == today.minus(15)

		def d= today.clone()
		d++; assert d == tomorrow
		d= d.next(); assert d == dayAfter //equivalent method
		d--; assert d == tomorrow
		d= d.previous(); assert d == today //equivalent method

		assert tomorrow.after(today)
		assert yesterday.before(today)
		assert tomorrow.compareTo(today) > 0
		assert tomorrow.compareTo(dayAfter) < 0
		assert dayBefore.compareTo(dayBefore) == 0

		def n= today.time //we can convert a Date to a Long
		println n
		today.time = 0 //long 0 is beginning of 1 Jan 1970 GMT
		println today
		def sometimeAgo= new Date(0) //we can construct a date with a Long argument
		assert sometimeAgo == today
	}

	void testDate02(){
		System.setProperty('user.timezone', 'GMT') //we'll look at timezones later

		def c= new GregorianCalendar()
		println c.time //'time' property gives a Date class
		c= Calendar.instance
		assert c.class == GregorianCalendar //another way to create a GregorianCalendar
		println c.time
		assert c.timeInMillis == c.time.time
		//we can get the time in milliseconds after 1 Jan 1970 at 0:00:00am GMT

		println System.currentTimeMillis() //another way to get the current time
		println System.nanoTime()
		//time in nano-seconds: good for measuring elapsed computation times

		c= new GregorianCalendar(2009, Calendar.JULY, 22) //creates 22 July 2009
		c= new GregorianCalendar(2009, Calendar.JULY, 22, 2, 35)
		//creates 22 July 2009 at 2:35am GMT
		c= new GregorianCalendar(2009, Calendar.JULY, 22, 2, 35, 21)
		//creates 22 July 2009 at 2:35:21am GMT

		c.clear() //if we clear the fields, we get...
		assert c.get(Calendar.ERA) == GregorianCalendar.AD &&
		c.get(Calendar.YEAR) == 1970 &&
		c.get(Calendar.MONTH) == 0 &&
		//dates range from 0 to 11, so this is January
		c.get(Calendar.WEEK_OF_MONTH) == 1 && //should be: 0
		c.get(Calendar.DAY_OF_MONTH) == 1 &&
		c.get(Calendar.DATE) == 1 && //same as DAY_OF_MONTH
		c.get(Calendar.DAY_OF_WEEK) == 5 &&
		c.get(Calendar.DAY_OF_WEEK_IN_MONTH) == 1 &&
		c.get(Calendar.AM_PM) == Calendar.AM &&
		c.get(Calendar.HOUR) == 0 &&
		c.get(Calendar.HOUR_OF_DAY) == 0 &&
		c.get(Calendar.MINUTE) == 0 &&
		c.get(Calendar.SECOND) == 0 &&
		c.get(Calendar.MILLISECOND) == 0 &&

		c.get(Calendar.WEEK_OF_YEAR) == 1 &&
		c.get(Calendar.DAY_OF_YEAR) == 1

		def d= new GregorianCalendar()
		d.timeInMillis= 0
		//we can set the 'time', here 1 Jan 1970 at 00:00:00.000 GMT (Gregorian)
		d.time= new Date(0) //alternative syntax
		//assert d == c
	}

	void testDate03(){
		def c1= new GregorianCalendar(1995, Calendar.SEPTEMBER, 5, 19, 35, 30, 750)

		//dates...
		assert String.format('%tY/%<tm/%<td', c1) == '1995/09/05'
		//println(String.format("test"+'%tA%<te %<tB%<ty', c1));
		//assert String.format('%tA%<te %<tB%<ty', c1) == 'ÐÇÆÚ¶þ5 ¾ÅÔÂ95'
		//assert String.format('century:%tC, month:%<tb, day:%<te', c1) ==
		//	'century:19, month:Sep, day:5'
		//		assert String.format('month:%th, day of year:%<tj, day of week:%<ta', c1) ==
		//			'month:Sep, day of year:248, day of week:Tue' //'h' same as 'b'
		//
		//		//times...
		//		assert String.format('%tH:%<tM:%<tS.%<tL', c1) == '19:35:30.750'
		//		assert String.format('%tI%<tp, %<tl%<tp, nanoseconds:%<tN', c1) ==
		//			'07pm, 7pm, nanoseconds:750000000'
		//		assert String.format('%ts', c1) == '810300930'
		//			//seconds since start of 1-Jan-1970 GMT
		//		assert String.format('%tQ', c1) == '810300930750'
		//			//milliseconds since start of 1-Jan-1970 GMT
		//		assert String.format('%tk',
		//					new GregorianCalendar(1995, Calendar.SEPTEMBER, 5, 6, 35)) == '6'

		//shortcut formats...
		assert String.format('%tF', c1) == '1995-09-05' //date as '%tm/%td/%ty'
		assert String.format('%tD', c1) == '09/05/95' //date as '%tY-%tm-%td'
		assert String.format('%tT', c1) == '19:35:30' //time as '%tH:%tM:%tS'
		assert String.format('%tR', c1) == '19:35' //time as '%tH:%tM'
		//assert String.format('%tr', c1) == '07:35:30 PM' //time as '%tI:%tM:%tS %Tp'

		//additionally...
		assert String.format('%tF', new Date(0)) == '1970-01-01'
		//we can supply a Date instead of a Calendar
		assert String.format('%tF', 0L) == '1970-01-01' //we can also supply a long

		assert String.format('...%15tF...', 0L) == '...     1970-01-01...' //width 15
		assert String.format('...%-15tF...', 0L) == '...1970-01-01     ...'
		// '-' flag to left-justify
	}

	void testDate04(){
		System.setProperty('user.timezone', 'GMT')

		def c= new GregorianCalendar()
		c.set( Calendar.ERA, GregorianCalendar.AD )
		c.set( Calendar.YEAR, 1949 )
		c.set( Calendar.MONTH, Calendar.OCTOBER )
		c.set( Calendar.DATE, 31 )
		//assert String.format('%tF %<ta', c) == '1949-10-31 Mon'

		//properties for calculating WEEK_OF_YEAR and WEEK_OF_MONTH fields...
		c.firstDayOfWeek = Calendar.SUNDAY //Sunday in most countries, Monday in others
		c.minimalDaysInFirstWeek = 1

		assert c.get(Calendar.ERA) == GregorianCalendar.AD &&
		c.get(Calendar.YEAR) == 1949 &&
		c.get(Calendar.MONTH) == 9 && //dates range from 0 to 11, so October
		c.get(Calendar.MONTH) == Calendar.OCTOBER && //alternatively
		c.get(Calendar.DAY_OF_MONTH) == 31 &&
		c.get(Calendar.WEEK_OF_YEAR) == 45 && //range from 1 to 53
		c.get(Calendar.WEEK_OF_MONTH) == 6 && //range from 1 to 6
		c.get(Calendar.DAY_OF_YEAR) == 304 &&
		c.get(Calendar.DAY_OF_WEEK) == 2 && //Monday
		c.get(Calendar.DAY_OF_WEEK_IN_MONTH) == 5

		//changing the month uses the same year and day of month...
		c.set(Calendar.MONTH, Calendar.AUGUST )
		c.time //cause other fields to update themselves
		//assert String.format('%tF %<ta', c) == '1949-08-31 Wed'

		c.set(Calendar.MONTH, Calendar.APRIL )
		//...but may cause adjustment to roll into following month
		c.time
		//assert String.format('%tF %<ta', c) == '1949-05-01 Sun'

		c.set(Calendar.DATE, 31 )
		c.set(Calendar.MONTH, Calendar.FEBRUARY )
		c.set(Calendar.MONTH, Calendar.SEPTEMBER )

		//rolling into following month only occurs when other fields update themselves,
		//call this method to trigger it...
		c.time

		//assert String.format('%tF %<ta', c) == '1949-10-01 Sat'
		//...so Feb-28 DIDN'T roll into Mar-03

		//changing the day of month uses the same month and year...
		c.set( Calendar.DATE, 1 ); c.time
		//assert String.format('%tF %<ta', c) == '1949-10-01 Sat'

		//changing the day of year adjusts the month, day, and other date fields...
		c.set(Calendar.DAY_OF_YEAR, c.get(Calendar.DAY_OF_YEAR) + 2 ); c.time
		//assert String.format('%tF %<ta', c) == '1949-10-03 Mon'

		//changing the week of year keeps the same day of week, but adjusts
		//the other date fields...
		c.set(Calendar.WEEK_OF_YEAR, c.get(Calendar.WEEK_OF_YEAR) + 3 ); c.time
		//assert String.format('%tF %<ta', c) == '1949-10-24 Mon'

		//changing the week of month keeps both the same month and day of week...
		c.set(Calendar.WEEK_OF_MONTH, c.get(Calendar.WEEK_OF_MONTH) - 2 ); c.time
		//assert String.format('%tF %<ta', c) == '1949-10-10 Mon'

		//changing the day of week in month also keeps both the
		//same month and day of week...
		c.set(Calendar.DAY_OF_WEEK_IN_MONTH, c.get(Calendar.DAY_OF_WEEK_IN_MONTH) - 1 )
		c.time
		//assert String.format('%tF %<ta', c) == '1949-10-03 Mon'

		//changing the day of week keeps the same week in year...
		c.set( Calendar.DAY_OF_WEEK, Calendar.SATURDAY ); c.time
		//assert String.format('%tF %<ta', c) == '1949-10-08 Sat'
		c.set( Calendar.DAY_OF_WEEK, Calendar.SUNDAY ); c.time
		//assert String.format('%tF %<ta', c) == '1949-10-02 Sun'
	}

	void testDate05(){
		System.setProperty('user.timezone', 'GMT')
		def c= new GregorianCalendar( 1949, Calendar.OCTOBER, 2 )

		c.set( Calendar.AM_PM, Calendar.AM )
		c.set( Calendar.HOUR, 6 ) //set the AM_PM and HOUR fields...
		c.set( Calendar.MINUTE, 30 )
		c.set( Calendar.SECOND, 15 ); c.time
		assert String.format('%tF %<tT', c) == '1949-10-02 06:30:15'
		assert c.get( Calendar.HOUR_OF_DAY ) == 6
		//...and the HOUR_OF_DAY field is updated...

		c.set( Calendar.HOUR_OF_DAY, 19 ); c.time
		assert String.format('%tF %<tT', c) == '1949-10-02 19:30:15'
		assert c.get( Calendar.HOUR ) == 7 && c.get( Calendar.AM_PM ) == Calendar.PM
		//...and vice versa

		c.set( Calendar.AM_PM, Calendar.AM ); c.time
		assert String.format('%tF %<tT', c) == '1949-10-02 07:30:15' &&
		c.get( Calendar.AM_PM ) == Calendar.AM

		c.set( Calendar.HOUR, 18 ); c.time
		//if we set the HOUR with a 24-hr value, it self-adjusts
		assert c.get( Calendar.HOUR ) == 6 && c.get( Calendar.AM_PM ) == Calendar.PM

		//there's no 24:00, only 00:00 which is 'am', on the following day...
		c= new GregorianCalendar(1950, Calendar.JANUARY, 26, 23, 59)
		//assert String.format('%tF %<tT %<tp', c) == '1950-01-26 23:59:00 pm'
		c.add( Calendar.MINUTE, 1 )
		//assert String.format('%tF %<tT %<tp', c) == '1950-01-27 00:00:00 am'

		//12:00 noon is 'pm'...
		c= new GregorianCalendar(1950, Calendar.JANUARY, 27, 12, 00)
		//assert String.format('%tF %<tT %<tp', c) == '1950-01-27 12:00:00 pm'
	}

	void testDate06(){
		use(Extras){
			[ {
					new TimeDuration( 12, 30, 0, 0 )
				}:   '12 hrs, 30 mins', {
					new TimeDuration( 4, 12, 30, 0, 0 )
				}:'4 days, 12 hrs, 30 mins', {
					new Duration( 4, 12, 30, 0, 500 )
				}:  '4 days, 12 hrs, 30 mins, 0.500 secs', {
					new DatumDependentDuration( 7, 6, 0, 12, 30, 0, 0 )
				}:
				'7 yrs, 6 mths, 12 hrs, 30 mins',
			].each{
				assert it.key().toString() == it.value
			}
		}

		def convertToMilliseconds= { yr, mth, day, hr, min, sec, mil->
			mil + 1000g*( sec + 60g*( min + 60g*( hr + 24g*(
					day + 30g*( mth + 12g*yr )
					))))
		}

		assert new TimeDuration( 12, 30, 0, 0 ).toMilliseconds() ==
		convertToMilliseconds( 0, 0, 0, 12, 30, 0, 0 )
		//ignores 61-second leap minutes
		assert new Duration( 114, 12, 30, 0, 0 ).toMilliseconds() ==
		convertToMilliseconds( 0, 0, 114, 12, 30, 0, 0 )
		//ignores 25-hour daylight-saving days
		assert new DatumDependentDuration( 5, 1, 14, 12, 30, 0, 0 ).toMilliseconds() !=
		convertToMilliseconds( 5, 1, 14, 12, 30, 0, 0 )
		//considers 31-day months and leap-years

		use( [
			Extras,
			groovy.time.TimeCategory]
		){
			assert 10.years.class == DatumDependentDuration

			assert 10.years.toString() ==
			new DatumDependentDuration( 10, 0, 0, 0, 0, 0, 0 ).toString()
			assert 4.months.toString() ==
			new DatumDependentDuration( 0, 4, 0, 0, 0, 0, 0 ).toString()
			assert 7.weeks.toString() == new Duration( 49, 0, 0, 0, 0 ).toString()
			assert 5.days.toString() == new Duration( 5, 0, 0, 0, 0 ).toString()
			assert 12.hours.toString() == new TimeDuration( 12, 0, 0, 0 ).toString()
			assert 15.minutes.toString() == new TimeDuration( 0, 15, 0, 0).toString()
			assert 13.seconds.toString() == new TimeDuration( 0, 0, 13, 0 ).toString()
			assert 750.milliseconds.toString() ==
			new TimeDuration( 0, 0, 0, 750 ).toString()

			assert 1.day.toString() == new Duration( 1, 0, 0, 0, 0 ).toString()
			//we can use the singular name for any of these...
			assert 25.minute.toString() == new TimeDuration( 0, 25, 0, 0 ).toString()
			//...even when not grammatical in English
		}

		use( [
			Extras,
			groovy.time.TimeCategory]
		){

			assert (10.years + 4.months).class == DatumDependentDuration
			assert (10.years + 4.months).toString() ==
			new DatumDependentDuration( 10, 4, 0, 0, 0, 0, 0 ).toString()
			assert (10.years.plus(4.months) ).toString() ==
			(10.years + 4.months).toString() //alternative method name
			assert (4.months + 10.years).toString() == (10.years + 4.months).toString()
			//all duration operations are commutative

			assert (10.years + 4.weeks).class == DatumDependentDuration
			assert (5.days + 7.weeks).class == Duration
			assert (5.days + 17.hours).class == TimeDuration
			assert (10.minutes + 5.seconds).class == TimeDuration

			//adding a DatumDependentDuration and a TimeDuration gives a
			//specially-defined TimeDatumDependentDuration...
			assert (10.years + 12.hours).toString() ==
			new TimeDatumDependentDuration( 10, 0, 0, 12, 0, 0, 0 ).toString()
			assert (10.years + 12.hours).class == TimeDatumDependentDuration

			assert ( 10.years + new TimeDatumDependentDuration( 0, 0, 0, 12, 0, 0, 0 )
			).class == TimeDatumDependentDuration
			assert ( 10.days + new TimeDatumDependentDuration( 0, 0, 0, 12, 0, 0, 0 )
			).class == TimeDatumDependentDuration
			assert ( 10.minutes + new TimeDatumDependentDuration( 0, 0, 0, 12, 0, 0, 0 )
			).class == TimeDatumDependentDuration
			assert ( new TimeDatumDependentDuration( 0, 0, 0, 12, 0, 0, 0 ) +
			new TimeDatumDependentDuration( 0, 0, 0, 0, 10, 0, 0 )
			).class == TimeDatumDependentDuration

			//subtracting durations...
			assert (10.years - 4.months).class == DatumDependentDuration
			assert (10.years - 4.months).toString() ==
			new DatumDependentDuration( 10, -4, 0, 0, 0, 0, 0 ).toString()
			assert (10.years.minus(4.months) ).toString() ==
			(10.years - 4.months).toString() //alternative method name

			assert (10.years - 12.hours).class == DatumDependentDuration
			assert (5.days - 7.weeks).class == Duration
			assert (5.days - 17.hours).class == TimeDuration
			assert (10.minutes - 5.seconds).class == TimeDuration
			assert (10.years - 4.weeks).class == DatumDependentDuration
		}

		use( [
			Extras,
			groovy.time.TimeCategory]
		){

			assert (10.years + 4.months).class == DatumDependentDuration
			assert (10.years + 4.months).toString() ==
			new DatumDependentDuration( 10, 4, 0, 0, 0, 0, 0 ).toString()
			assert (10.years.plus(4.months) ).toString() ==
			(10.years + 4.months).toString() //alternative method name
			assert (4.months + 10.years).toString() == (10.years + 4.months).toString()
			//all duration operations are commutative

			assert (10.years + 4.weeks).class == DatumDependentDuration
			assert (5.days + 7.weeks).class == Duration
			assert (5.days + 17.hours).class == TimeDuration
			assert (10.minutes + 5.seconds).class == TimeDuration

			//adding a DatumDependentDuration and a TimeDuration gives a
			//specially-defined TimeDatumDependentDuration...
			assert (10.years + 12.hours).toString() ==
			new TimeDatumDependentDuration( 10, 0, 0, 12, 0, 0, 0 ).toString()
			assert (10.years + 12.hours).class == TimeDatumDependentDuration

			assert ( 10.years + new TimeDatumDependentDuration( 0, 0, 0, 12, 0, 0, 0 )
			).class == TimeDatumDependentDuration
			assert ( 10.days + new TimeDatumDependentDuration( 0, 0, 0, 12, 0, 0, 0 )
			).class == TimeDatumDependentDuration
			assert ( 10.minutes + new TimeDatumDependentDuration( 0, 0, 0, 12, 0, 0, 0 )
			).class == TimeDatumDependentDuration
			assert ( new TimeDatumDependentDuration( 0, 0, 0, 12, 0, 0, 0 ) +
			new TimeDatumDependentDuration( 0, 0, 0, 0, 10, 0, 0 )
			).class == TimeDatumDependentDuration

			//subtracting durations...
			assert (10.years - 4.months).class == DatumDependentDuration
			assert (10.years - 4.months).toString() ==
			new DatumDependentDuration( 10, -4, 0, 0, 0, 0, 0 ).toString()
			assert (10.years.minus(4.months) ).toString() ==
			(10.years - 4.months).toString() //alternative method name

			assert (10.years - 12.hours).class == DatumDependentDuration
			assert (5.days - 7.weeks).class == Duration
			assert (5.days - 17.hours).class == TimeDuration
			assert (10.minutes - 5.seconds).class == TimeDuration
			assert (10.years - 4.weeks).class == DatumDependentDuration
		}
	}

	void testDate07(){
		TimeZone.availableIDs.toList().groupBy{ TimeZone.getTimeZone(it).rawOffset }.
		entrySet().sort{it.key}.reverse().each{
			println String.format('%6.2f hrs: %2d',
			it.key / (60*60*1000), it.value.size())
			it.value.each{
				def tz= TimeZone.getTimeZone(it)
				println "${' '*8}$tz.displayName ($tz.ID): " +
				"${tz.DSTSavings / (60*60*1000)}, ${tz.useDaylightTime()}"
			}
		}

		
	}

}
