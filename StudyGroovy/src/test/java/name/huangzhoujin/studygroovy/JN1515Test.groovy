package name.huangzhoujin.studygroovy;

import groovy.util.GroovyTestCase;

class JN1515Test extends GroovyTestCase {

	void testCharacters01(){
		assert Character.SIZE == 16 && Character.SIZE == Short.SIZE //16 bits in size
		assert Character.MIN_VALUE as int == 0x0000
		assert Character.MAX_VALUE as int == 0xFFFF
		assert Character.TYPE == char //often, we can write 'char' instead

		def categories= [
			'LOWERCASE_LETTER',
			//unicode category "Ll": a lowercase letter that has an uppercase variant
			'UPPERCASE_LETTER',
			//Lu: an uppercase letter that has a lowercase variant
			'TITLECASE_LETTER',
			//Lt: a letter beginning a word with only the first letter capitalized
			'MODIFIER_LETTER',
			//Lm: a special character that is used like a letter
			'OTHER_LETTER',
			//Lo: a letter or ideograph not having lowercase and uppercase variants

			'NON_SPACING_MARK',
			//Mn: a combining character that doesnt take up space (eg accents, umlauts)
			'COMBINING_SPACING_MARK',
			//Mc: a combining character that takes up space (eg vowel signs in the East)
			'ENCLOSING_MARK',
			//Me: an enclosing character (eg circle, square, keycap)

			'SPACE_SEPARATOR',
			//Zs: an invisible whitespace character that takes up space
			'LINE_SEPARATOR',
			//Zl: line separator character 0x2028
			'PARAGRAPH_SEPARATOR',
			//Zp: paragraph separator character 0x2029

			'MATH_SYMBOL',
			//Sm: any mathematical symbol
			'CURRENCY_SYMBOL',
			//Sc: any currency sign
			'MODIFIER_SYMBOL',
			//Sk: a combining character that's also a full character on its own
			'OTHER_SYMBOL',
			//So: various other symbols (eg dingbats, box-drawing)

			'DECIMAL_DIGIT_NUMBER',
			//Nd: a digit zero through nine in any script except ideographic scripts
			'LETTER_NUMBER',
			//Nl: a number that looks like a letter (eg Roman numerals)
			'OTHER_NUMBER',
			//No: a superscript or subscript digit, or number that's not a digit 0..9
			//                                     (excluding from ideographic scripts)

			'DASH_PUNCTUATION',
			//Pd: any kind of hyphen or dash
			'START_PUNCTUATION',
			//Ps: any kind of opening bracket
			'END_PUNCTUATION',
			//Pe: any kind of closing bracket
			'INITIAL_QUOTE_PUNCTUATION',
			//Pi: any kind of opening quote
			'FINAL_QUOTE_PUNCTUATION',
			//Pf: any kind of closing quote
			'CONNECTOR_PUNCTUATION',
			//Pc: a punctuation character that connects words (eg underscore)
			'OTHER_PUNCTUATION',
			//Po: any other kind of punctuation character

			'FORMAT',
			//Cf: invisible formatting indicator
			'CONTROL',
			//Cc: 65 ISO control characters (0x00..0x1F and 0x7F..0x9F)
			'PRIVATE_USE',
			//Co: any code point reserved for private non-unicode use
			'SURROGATE',
			//Cs: one half of a surrogate pair
			'UNASSIGNED', //Cn: any code point to which no character has been assigned
		]

		def stats= (0x0000..0xFFFF).groupBy{ Character.getType(it) }
		stats.entrySet().sort{ it.value.size }.reverse().each{ cat->
			def keyName= Character.fields.
			find{ it.get() == cat.key && it.name in categories }.name
			println "$keyName: $cat.value.size"
		}

		assert Character.MIN_HIGH_SURROGATE == 0xD800 &&
		Character.MIN_SURROGATE == 0xD800
		assert Character.MAX_HIGH_SURROGATE == 0xDBFF
		assert Character.MIN_LOW_SURROGATE == 0xDC00
		assert Character.MAX_LOW_SURROGATE == 0xDFFF &&
		Character.MAX_SURROGATE == 0xDFFF
		assert Character.isSurrogatePair( Character.MIN_HIGH_SURROGATE,
		Character.MIN_LOW_SURROGATE )
		assert Character.isHighSurrogate( Character.MIN_HIGH_SURROGATE )
		assert Character.isLowSurrogate( Character.MIN_LOW_SURROGATE )

		assert Character.MIN_CODE_POINT == 0x0000
		assert Character.MIN_SUPPLEMENTARY_CODE_POINT == 0x10000 //an integer
		assert Character.MAX_CODE_POINT == 0x10FFFF
		assert Character.isValidCodePoint( Character.MIN_CODE_POINT )
		assert ! Character.isValidCodePoint( Character.MAX_CODE_POINT + 1 )
		assert Character.isSupplementaryCodePoint(
		Character.MIN_SUPPLEMENTARY_CODE_POINT )
		assert ! Character.isSupplementaryCodePoint(
		Character.MIN_SUPPLEMENTARY_CODE_POINT - 1 )

		assert Character.charCount(0xFFFF) == 1
		//number of Characters needed to represent a certain integer as Unicode
		assert Character.charCount(0x10FFFF) == 2

		assert Character.isDefined(0xFFFD)
		assert ! Character.isDefined(0xFFFF) //doesn't include unassigned characters
		assert Character.isDefined(0x10000)

		def minLowSurr= Character.MIN_LOW_SURROGATE,
		maxLowSurr= Character.MAX_LOW_SURROGATE,
		minHighSurr= Character.MIN_HIGH_SURROGATE,
		maxHighSurr= Character.MAX_HIGH_SURROGATE
		assert Character.toChars(0xFFFF).collect{ it as int }.toList() == [0xFFFF]
		//convert integer into array of Characters
		assert Character.toChars(0x10000).collect{ it as int }.toList() ==
		[
			minHighSurr as int,
			minLowSurr as int
		]
		assert Character.toChars(0x10FFFF).collect{ it as int }.toList() ==
		[
			maxHighSurr as int,
			maxLowSurr as int
		]

		def charArray= new char[6] //an array that can only contain Characters
		assert Character.toChars(0x10000, charArray, 2) == 2 &&
		charArray.collect{ it as int }.toList() ==
		[
			0,
			0,
			minHighSurr as int,
			minLowSurr as int,
			0,
			0
		]
		charArray= new char[4]
		assert Character.toChars(0xFFFF, charArray, 1) == 1 &&
		charArray.collect{ it as int }.toList() == [0, 0xFFFF, 0, 0]

		assert Character.toCodePoint(minHighSurr, minLowSurr) == 0x10000
		//converts surrogate pair to integer representation

	}

	void testCharacters02(){
		def minLowSurr= Character.MIN_LOW_SURROGATE,
		minHighSurr= Character.MIN_HIGH_SURROGATE

		def ca1= [
			'a',
			'b',
			'c',
			minHighSurr,
			minLowSurr,
			'e',
			'f',
			'g'] as char[]
		def ca2= [
			'a',
			'b',
			'c',
			0xFFFF,
			'e',
			'f',
			'g'] as char[]
		assert Character.codePointAt(ca1, 3) == 0x10000
		//beginning at index 3, look at as many chars as needed
		assert Character.codePointAt(ca2, 3) == 0xFFFF
		assert Character.codePointAt(ca1, 3, 4) == minHighSurr
		//extra parameter limits sequence of chars to index <4
		assert Character.codePointAt(ca2, 3, 4) == 0xFFFF
		assert Character.codePointBefore(ca1, 4) == minHighSurr
		assert Character.codePointBefore(ca1, 5) == 0x10000
		//if low surrogate, look back more for high one, and use both
		assert Character.codePointBefore(ca1, 5, 4) == minLowSurr
		//extra param limits lookback to index >=4
		assert Character.codePointCount(ca1, 1, 5) == 4
		//number of code points in a subarray given by offset 1 and count 5
		assert Character.codePointCount(ca1, 1, 4) == 3
		//lone high surr counted as 1 code point
		assert Character.offsetByCodePoints(ca1, 0, 6, 1, 3) == 5
		//index of ca1[0..<6] that's offset by 3 code points

		//versions of these methods exist for strings...
		def s1= 'abc'+ minHighSurr + minLowSurr +'efg'
		def s2= 'abcdefg'
		assert Character.codePointAt(s1, 3) == 0x10000
		//if high surrogate, add on low surrogate
		assert Character.codePointAt(s1, 4) == minLowSurr
		//if low surrogate, use it only
		//int temp = 'e' as int
		//assert Character.codePointAt(s1, 5) == temp
		//temp =  'd' as int
		//assert Character.codePointAt(s2, 3) == temp
		//enquire code point in string
		assert Character.codePointBefore(s1, 4) == minHighSurr
		assert Character.codePointBefore(s1, 5) == 0x10000
		//if low surrogate, look back more for high one, and use both
		assert Character.codePointCount(s1, 1, 5) == 3
		//number of code points in a substring with indexes >=1 and <5
		assert Character.offsetByCodePoints(s1, 1, 3) == 5
		//index from 1 that's offset by 3 code points
	}

	void testCharacter03(){
		def directionalities= [:]
		Character.fields.each{
			if( it.name =~ /^DIRECTIONALITY_/ ) directionalities[ it.get() ]= it.name
		}

		def stats= (0x0000..0xFFFF).groupBy{ Character.getDirectionality(it) }
		//will also work for supplementary chars
		stats.entrySet().sort{ it.value.size }.reverse().each{ dir->
			def keyName=  Character.fields.
					find{ it.get() == dir.key && it.name in directionalities.values() }.name
			println "$keyName: $dir.value.size"
		}

		(0x0000..0xFFFF).groupBy{ Character.UnicodeBlock.of( it as char ) }.
		entrySet().sort{it.value.size}.reverse().
		each{ println "$it.key: $it.value.size" } //this uses basic plane only

		//this one uses supplementary characters also...
		(0x0000..0x10FFFF).groupBy{ Character.UnicodeBlock.of( it as int ) }.
		entrySet().sort{it.value.size}.reverse().
		each{ println "$it.key: $it.value.size" }

		try{ Character.UnicodeBlock.of( 0x110000 ); assert 0 }
		catch(e){ assert e instanceof IllegalArgumentException }

		assert Character.MIN_RADIX == 2
		//the minimum and maximum radixes available for conversion to/from strings
		assert Character.MAX_RADIX == 36 //0 to 9, and A to Z
		assert Character.forDigit(12, 16) == 'c'
		//character representation for a digit in a certain radix
		assert Character.digit('c' as char, 16) == 12
		//digit of a character rep'n in a certain radix
		
		[
			'BASIC LATIN',
			'basic latin',
			'BasicLatin',
			'baSiclaTin',
			'BaSiC LaTiN',
			'BASIC_LATIN',
			'BaSiC_LaTiN'
		].
		each{ assert Character.UnicodeBlock.forName(it).toString() == 'BASIC_LATIN' }
		
		assert 'a'.class == String
		def c1= 'a' as char, c2= (char)'b' //constructing
		def c3= new Character(c2), c4= c2.charValue() //cloning
		[c1, c2, c3, c4].each{ assert it.class == Character }
		assert c2 == c3 && c1 != c2
		assert c1 < c2 && c1.compareTo(c2) == -1
			//comparing works just the same as for numbers
		assert c2.toString().class == String
		
		
	}
	
	void testCharacter04(){
		def categories= [
					'digit': { Character.isDigit(it) },
					'letter': { Character.isLetter(it) },
					'letter or digit': { Character.isLetterOrDigit(it) },
					'identifier ignorable': { Character.isIdentifierIgnorable(it) },
					//an ignorable character in a Java or Unicode identifier
					'ISO control': { Character.isISOControl(it) }, //an ISO control character
					'Java identifier part': { Character.isJavaIdentifierPart(it) },
					//be part of a Java identifier as other than the first character
					'Java identifier start': { Character.isJavaIdentifierStart(it) },
					//permissible as the first character in a Java identifier
					'Unicode identifier part': { Character.isUnicodeIdentifierPart(it) },
					//be part of a Unicode identifier other than first character
					'Unicode identifier start': { Character.isUnicodeIdentifierStart(it) },
					//permissible as first character in a Unicode identifier
					'lower case': { Character.isLowerCase(it) },
					'upper case': { Character.isUpperCase(it) },
					'title case': { Character.isTitleCase(it) },
					'space char': { Character.isSpaceChar(it) }, //a Unicode space character
					'whitespace': { Character.isWhitespace(it) }, //white space according to Java
					'mirrored': { Character.isMirrored(it) },
					//mirrored according to the Unicode spec
				]
		def stats= [:]
		categories.keySet().each{ stats[it]= 0 }
		(0x0000..0xFFFF).each{ch->
			//also works with supplementaries (0x0000..0x10FFFF)
			categories.each{cat->
				if( cat.value(ch) ) stats[ cat.key ] += 1
			}
		}
		stats.entrySet().sort{ it.value }.reverse().each{ println "$it.key: $it.value" }
	}
	
	void testCharacter05(){
		assert 'a' as char == 97 && 'd' as char == 100
		assert ('a' as char) + 7 == 104 && 7 + ('a' as char) == 104
		//either first or second arg
		assert ('a' as char) + ('d' as char) == 197 //two chars
		assert ('a' as char).plus(7) == ('a' as char) + 7 //alternative method name
		assert ('a' as char) - 27 == 70 && ('a' as char).minus(27) == 70
		assert ('a' as char) * ('d' as char) == 9700 &&
		('a' as char).multiply('d' as char) == 9700
		assert 450 / ('d' as char) == 4.5 && 450.div('d' as char) == 4.5
		assert 420.intdiv('d' as char) == 4

		assert ('a' as char) > 90 && ('a' as char).compareTo(90) == 1
		assert 90 < ('a' as char) && 90.compareTo('a' as char) == -1
		assert ('a' as char) == ('a' as char) &&
		('a' as char).compareTo('a' as char) == 0

		def c= 'p' as char
		assert c++ == 'p' as char && c == 'q' as char &&
		c-- == 'q' as char && c == 'p' as char &&
		++c == 'q' as char && c == 'q' as char &&
		--c == 'p' as char && c == 'p' as char
		assert c.next() == 'q' && c.previous() == 'o' && c == 'p'

		assert Character.getNumericValue('6' as char) == 6
		assert Character.reverseBytes(0x37ae as char) == 0xae37 as char

		assert Character.toUpperCase('a' as char) == 'A' as char
		assert Character.toLowerCase('D' as char) == 'd' as char
		assert Character.toTitleCase('a' as char) == 'A' as char
	}

}
