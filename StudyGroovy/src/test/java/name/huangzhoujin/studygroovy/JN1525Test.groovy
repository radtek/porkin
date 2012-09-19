package name.huangzhoujin.studygroovy;

import groovy.util.GroovyTestCase;

class JN1525Test extends GroovyTestCase {
	
	void testString01(){
		assert 'hello, world' == "hello, world"
		assert "Hello, Groovy's world" == 'Hello, Groovy\'s world'
			//backslash escapes the quote
		assert 'Say "Hello" to the world' == "Say \"Hello\" to the world"
		
		assert '\b' == '\010' //backspace
		assert '\t' == '\011' //horizontal tab
		assert '\n' == '\012' //linefeed
		assert '\f' == '\014' //form feed
		assert '\r' == '\015' //carriage return
		assert '\\' == '\\' //use backslash to escape the backslash
		
		def i= 1, list= []
		3.times{ list<< "${i++}" }
		assert list.join() == '123'

	}
	
	void testString02(){
		def o= new Object()
		assert String.valueOf( o ) == o.toString() //this works for any object in Groovy
		assert String.valueOf( true ) == true.toString() //boolean value
		assert String.valueOf( 'd' as char ) == ('d' as char).toString() //character
		assert String.valueOf( 7.5d ) == 7.5d.toString() //double
		assert String.valueOf( 8.4f ) == 8.4f.toString() //float
		assert String.valueOf( 13i ) == 13i.toString() //integer
		assert String.valueOf( 14L ) == 14L.toString() //long
		assert String.valueOf( ['a', 'b', 'c'] ) == ['a', 'b', 'c'].toString()
			//list, etc, etc, etc
		
		def s= 'abcdefg'
		assert s.length() == 7 && s.size() == 7
		assert s.substring(2,5) == 'cde' && s.substring(2) == 'cdefg'
		assert s.subSequence(2,5) == 'cde'
		
		assert 'he she\t it'.tokenize() == ['he', 'she', 'it']
		//tokens for split are ' \t\n\r\f'
		assert 'he she\t it'.tokenize() ==
		new StringTokenizer('he she\t it').collect{ it }

		assert 'he,she;it,;they'.tokenize(',;') == ['he', 'she', 'it', 'they']
		//supply our own tokens
		assert new StringTokenizer('he,she;it,;they', ',;').collect{ it } ==
		'he,she;it,;they'.tokenize(',;')

		assert new StringTokenizer('he,she,;it', ',;', true).collect{ it } ==
		[
			'he',
			',',
			'she',
			',',
			';',
			'it'
		]
		//long form provides extra option to return the tokens with the split-up data
		
		assert 'abcde'.find{ it > 'b' } == 'c' //first one found
		assert 'abcde'.findAll{ it > 'b' } == ['c', 'd', 'e'] //all found
		assert 'abcde'.findIndexOf{ it > 'c' } == 3 //first one found
		
		assert 'abcde'.every{ it < 'g' } && ! 'abcde'.every{ it < 'c' }
		assert 'abcde'.any{ it > 'c' } && ! 'abcde'.any{ it > 'g' }
		
		assert 'morning'.replace('n','t') == 'mortitg' &&
			   'boo'.replace('o', 'at') == 'batat' &&
			   'book'.replace('oo','ie') == 'biek'
		
		assert 'EggS'.toLowerCase() == 'eggs' && 'EggS'.toUpperCase() == 'EGGS'
		assert '   Bacon   '.trim() == 'Bacon'
		assert 'noodles'.startsWith('nood') && 'noodles'.endsWith('dles')
		assert 'corn soup'.startsWith('rn', 2) //2 is offset
		
		assert 'abc'.concat('def') == 'abcdef'
		assert 'abcdefg'.contains('def')
		assert ''.isEmpty() && ! 'abc'.isEmpty()
		
		assert 'morning'.indexOf('n') == 3
		assert 'morning'.indexOf('n', 4) == 5 //ignore first 4 characters
		assert 'morning'.indexOf('ni') == 3
		assert 'morning'.indexOf('ni', 4) == -1 //not found
		assert 'morning'.lastIndexOf('n') == 5
		assert 'morning'.lastIndexOf('n', 4) == 3 //only search first 4 characters
		assert 'morning'.lastIndexOf('ni') == 3
		assert 'morning'.lastIndexOf('ni', 4) == 3
			//only search first 4 characters for first char of search string
	}
	
	

}
