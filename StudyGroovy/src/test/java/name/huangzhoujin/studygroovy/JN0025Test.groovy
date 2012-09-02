package name.huangzhoujin.studygroovy;

import groovy.util.GroovyTestCase;
import java.text.*

class JN0025Test extends GroovyTestCase {

	void testStarting01(){
		def g = 7, groovy = 10.2
		//we can separate more than one defined variable by a comma
		print g + ', ' + groovy + '\n' //prints: 7, 10.2
		assert g + ', ' + groovy == '7, 10.2' //we can use assert statement and ==
		//operator to understand examples
	}

	void testStarting02(){
		assert 4 * ( 2 + 3 ) - 6 == 14 //integers only
		assert 2.5 + 7 == 9.5
		assert 7 / 4 == 1.75 //decimal number or division converts expression to decimal
	}

	void testStarting03(){
		assert 2 > 3 == false
		assert 7 <= 9
		assert 7 != 2
		assert true
		assert ! false
		assert 2 > 3 || 7 <= 9
		assert ( 2 > 3 || 4 < 5 ) && 6 != 7
	}

	void testStarting04(){
		def a
		assert a == null
		//variables defined but not given a value have special value null
		def b = 1
		assert b == 1
		b = 2
		assert b == 2 //variables can be re-assigned to
		b = 'cat'
		assert b == 'cat' //they can be re-assigned different types/classes of data
		b = null
		assert b == null //they can be unassigned
	}

	void testStarting05(){
		def abc= 4
		def a23c= 4
		def ab_c= 4
		def _abc= 4

		def ABC= 4
		assert abc == ABC //although their values are the same...
		//assert !abc.is(ABC)
	}

	void testStarting06(){
		assert Byte.MAX_VALUE == 127
		//a class can have attached variables, called 'fields'
		assert Byte.parseByte('34') == 34
		//a class can have attached functions, called 'methods'
		def b= new Byte('34')
		//we can create an 'instance' of a class using the 'new' keyword
		assert b.intValue() == 34
	}

	void testStarting07(){
		assert 4.class == Integer //the common types have both a short name...
		assert 4.class == java.lang.Integer //...and a long name
		assert 4.5.class == BigDecimal
		assert 'hello, world'.class == String
		def a= 7
		assert a.class == Integer
	}

	void testStarting08(){
		assert new DecimalFormat( '#,#00.0#' ).format( 5.6789 ) == '05.68'
	}

	void testStarting09(){
		try{
			'moo'.toLong() //this will generate an exception
			assert false
			//this code should never be reached, so will always fail if executed
		}catch(e){
			assert e instanceof NumberFormatException
		}
	}

	void testStarting10(){
		def list= [1, 2, 3]
		list= [] //empty list
		list= [
			1,
			'b',
			false,
			4.5 ] //mixed types of values OK
		assert list[0] == 1 && list[1] == 'b' && ! list[2] && list[3] == 4.5
		//we can refer to items individually by index

		def map= [1:'a', 2:'b', 3:'c'] //map indicated with colon :
		map= [:] //empty map
		map= ['a': 1, 'b': 'c', 'groovy': 78.9, 12: true] //mixed types of values
		assert map['a'] == 1 && map['b'] == 'c' && map['groovy'] == 78.9 && map[12]
		//we can refer to values individually by key

		//'each' tells the code following it to execute for each item in a list or map:
		//for every item in list, assign to 'it' and execute the following code...
		[2, -17, +987, 0].each{ println it }
		//we can specify a different name for the argument other than the default...
		[2, -17, +987, 0].each{ n -> println n }
		//we can specify two or more arguments, as with this map...
		[ 1: 3, 2: 6, 3: 9, 4: 12 ].each{ k, v->
			assert k * 3 == v
		}
	}

	void testStarting11(){
		assert ('100' as Integer) == 100
		def x = ['97', '98', '99']as Integer[] //convert each item in list to an Integer
		assert x[0] == 97 && x[1] == 98 && x[2] == 99 //access each element individually

		def a= 2
		if( a < 5 ){
			println "a, being $a, is less than 5."
		}else{
			assert false //this line should never execute
		}
	}

	void testStarting12(){
		def i=0
		10.times{ println i++ } //increment i by 1 after printing it

		//another less declarative style of looping...
		while( i > 0 ){
			println i-- //decrement i by after printing it
		}
	}

	void testStarting13(){
		def i=0, j=0
		def f= new File('TheOutput.txt') //create or overwrite this file
		Thread.start{
			while(true){
				i++
				if(i%1000 == 0) f<< 'S' //spawned thread
			}
		}
		while(true){
			j++
			if(j%1000 == 0) f<< 'M' //main thread
		}
	}


}
