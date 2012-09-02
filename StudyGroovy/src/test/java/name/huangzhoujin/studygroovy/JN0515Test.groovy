package name.huangzhoujin.studygroovy;

import groovy.util.GroovyTestCase;

class JN0515Test extends GroovyTestCase {

	void testInteger01(){
		assert Integer.MAX_VALUE == 2147483647 //at 2 billion, big enough for most uses
		assert Integer.MIN_VALUE == -2147483648
		assert Long.MAX_VALUE == 9223372036854775807
		assert Long.MIN_VALUE == -9223372036854775808
	}

	void testInteger02(){
		[2, -17, +987].each{ assert it }

		//hex using leading 0x (lowercase or uppercase for a,b,c,d,e,f,x)...
		[0xACe, 0X01ff].each{ assert it }

		//octal using leading 0...
		[077, 01].each{ assert it }
	}

	void testInteger03(){
		assert 0x7FFFFFFF.class == Integer
		assert (-0x7FFFFFFF).class == Integer //we must negate using the minus sign
		assert 0x80000000.class == Long
		assert (-0x80000000).class == Integer
		assert (-0x80000001).class == Long
	}

	void testInteger04(){
		assert Short.MAX_VALUE == 32767
		assert Short.MIN_VALUE == -32768
		assert Byte.MAX_VALUE == 127
		assert Byte.MIN_VALUE == -128
		def a= new Byte('34'), b= new Byte('2')
		assert (a+b).class == Integer
	}

	void testInteger05(){
		assert Integer.SIZE == 32
		assert Long.SIZE == 64
		assert Short.SIZE == 16
		assert Byte.SIZE == 8
	}

	void testInteger06(){
		assert 45L as Integer == 45i
		assert 45L as int == 45i //example of using 'int' for Integer
		assert 45L.toInteger() == 45i //alternative syntax
		assert 23L.intValue() == 23i //another alternative syntax

		assert 45i as Long == 45L
		assert 45i as long == 45L
		assert 23i.toLong() == 23L
		assert 45i.longValue() == 45L

		//if converted number too large for target, only lowest order bits returned...
		assert 256i as Byte == 0
		assert 200i as byte == -56 //...and this may result in a negative number
	}

	void testInteger07(){
		assert '42'.toInteger() == 42i
		assert '56'.toLong() == 56L

		try{ 'moo'.toLong(); assert false }
		catch(e){ assert e instanceof NumberFormatException }

		assert new Integer( '45' ) == 45i
		assert new Byte( '45' ) == 45 as byte

		try{ new Integer( 'oink' ); assert false }
		catch(e){ assert e instanceof NumberFormatException }
	}

	void testInteger08(){
		//second character is the base/radix...
		assert Integer.toString( 29, 16 ) == '1d'

		//Long version behaves just like Integer version...
		assert Long.toString( 29L, 16 ) == '1d'

		//if number is negative, so is first character of returned string...
		assert Integer.toString( -29, 16 ) == '-1d'

		//only time result begins with zero is if it is zero...
		assert Integer.toString(0) == '0'

		assert Integer.toString( 29, 16 ).toUpperCase() == '1D'

		//second argument defaults to 10...
		assert Integer.toString( 29 ) == '29'

		//Short version only accepts one parameter, only allowing base 10...
		assert Short.toString( 29 as short ) == '29'
	}

	void testInteger09(){
		assert Integer.toString( 999, Character.MIN_RADIX - 1 ) ==
		Integer.toString( 999, 10 )

		assert Integer.toString( 999, Character.MAX_RADIX + 1 ) ==
		Integer.toString( 999, 10 )

		assert Character.MAX_RADIX == 36
	}

	void testInteger10(){
		assert Integer.toHexString(29) == '1d' //return unsigned base-16 integer
		assert Integer.toHexString(0) == '0'
		assert Integer.toHexString(-17) == 'ffffffef'
		assert Long.toHexString(-17L) == 'ffffffffffffffef'

		//same as toString(,16) when number positive...
		assert Integer.toHexString(29) == Integer.toString(29,16)

		//...but different when number negative
		assert Integer.toHexString(-17) != Integer.toString(-17,16)

		assert Integer.toOctalString(29) == '35'
		assert Integer.toOctalString(0) == '0'
		assert Integer.toOctalString(-17) == '37777777757'
		assert Integer.toBinaryString(29) == '11101'
	}

	void testInteger11(){
		[
			{ Integer.parseInt("2147483648", 10) },
			//number too large
			{ Integer.parseInt("99", 8) },
			//digit 9 not octal
			{ Integer.parseInt("Kona", 10) },
			//digits not decimal
			{ Integer.parseInt("1111", Character.MIN_RADIX - 1 ) },
			//radix too small
			{ Integer.parseInt("1111", Character.MAX_RADIX + 1 ) },
			//radix too large
			{ Integer.parseInt( '@#$%' ) },
			//invalid number
			{ Integer.parseInt( '' ) }, //invalid number
		].each{ c->
			try{ c(); assert false }
			catch(e){assert e instanceof NumberFormatException}
		}
	}

	void testInteger12(){
		assert Integer.valueOf( '12af', 16 ) == 0x12af
		//same as: Integer.parseInt( '12af', 16 )

		assert Long.valueOf( '123' ) == 123
		//same as: Long.parseInt( '123' )

		assert Short.valueOf( 027 as short ) == 027
	}

	void testInteger13(){
		assert Integer.decode('0xff') == 0xFF
		assert Integer.decode('#FF') == 0xFF
		assert Long.decode('#FF') == 0xFFL //long, short, and byte also can be decoded
		assert Short.decode('#FF') == 0xFF as short
		assert Byte.decode('#F') == 0xF as byte
		assert Integer.decode('-077') == -077
		assert Integer.decode('2345') == 2345

		try{ Integer.decode('7 @8'); assert false }
		catch(e){ assert e instanceof NumberFormatException }
	}

	void testInteger14(){
		assert Integer.signum(45i) == 1
		assert Integer.signum(0i) == 0
		assert Integer.signum(-43i) == -1
		assert Long.signum(-43L) == -1
	}

	void testInteger15(){
		assert 45i.compareTo( 47L ) < 0
		assert (45 as byte).compareTo( 43 as short ) > 0
		assert 45.compareTo( 45 ) == 0
	}

	void testInteger16(){
		assert 34 + 33 == 67    && 34.plus( 33 ) == 67
		assert 34L - 21L == 13L && 34L.minus( 21L ) == 13L
		assert 3 * 31 == 93     && 3.multiply( 31 ) == 93
		assert 23 % 3 == 2      && 23.mod( 3 ) == 2
		assert 3**2 == 9        && 3.power( 2 ) == 9

		assert 22.intdiv(5) == 4
		assert (-22).intdiv(5) == -4
		assert (-34).abs() == 34
		assert (-34L).abs() == 34L

		def a= 7
		assert a++ == 7 && a == 8 && a-- == 8 && a == 7 &&
		++a == 8 && a == 8 && --a == 7 && a == 7

		def b = 7, c = 7 //These operators use methods next() and previous()
		assert ( ++b ) == ( c = c.next() )
		assert b == c
		assert ( --b ) == ( c = c.previous() )
		assert b == c
		assert ( b++ ) == { def z = c; c = c.next(); z }()
		assert b == c

		def b1= Integer.MAX_VALUE
		assert ++b1 == Integer.MIN_VALUE && --b1 == Integer.MAX_VALUE

		assert 3*(4+5) != 3*4+5 //parenthesized expressions always have highest precedence

		assert -3**2 == -(3**2) //power has next highest precedence
		assert ( 2*3**2 == 2*(3**2) ) && ( 2*3**2 != (2*3)**2 )

		assert -3+2 != -(3+2) //unary operators have next highest precedence
		assert -~234 ==  -(~234) //unary operators group right-to-left

		//multiplication and modulo have next highest precedence
		assert 3*4%5 == (3*4)%5 //multiplication and modulo have equal precedence
		assert 3%4*5 == (3%4)*5

		//addition and subtraction have equal precedence, lower than mult/etc
		assert 4+5-6 == 3
		assert 5+3*4 == 5+(3*4)

		assert (23i+45L).class == Long

		assert 256*256*256*256 == 0

		//we can fix this problem by using a long at the beginning of the calculation...
		assert 256L*256*256*256 == 4294967296L

		assert 14 > 7          && 14.compareTo(7) > 0
		assert 14 >= 8         && 14.compareTo(8) >= 0
		assert -4 < 3          && (-4).compareTo(3) < 0
		assert -14 <= -9       && (-14).compareTo(-9) <= 0
	}

	void testInteger17(){
		def a = 4, b = 4, c = 5
		assert a == b && a.equals(b)
		assert a != c  && ! a.equals(c)
		assert (4 <=> 7) == -1 && 4.compareTo(7) == -1
		assert (4 <=> 4) == 0  && 4.compareTo(4) == 0
		assert (4 <=> 2) == 1  && 4.compareTo(2) == 1
	}

	void testInteger18(){
		assert Integer.highestOneBit( 45 ) == 32
		assert Integer.highestOneBit( 27 ) == 16
		assert Integer.highestOneBit( 0 ) == 0
		assert Integer.highestOneBit( -1 ) == -128*256*256*256
		//assert Long.highestOneBit( -1L ) == -128*256*256*256 * 256*256*256*256

		assert Integer.lowestOneBit( 45i ) == 1 //match lowest order 1-bit in argument
		assert Integer.lowestOneBit( 46i ) == 2
		assert Integer.lowestOneBit( 48i ) == 16

		[ 0:32, 1:31, 2:30, 4:29 ].each{ k, v->
			assert Integer.numberOfLeadingZeros( k ) == v
			//returns the number of zero-bits preceding the highest-order 1-bit
			assert Long.numberOfLeadingZeros( k as long ) == v + 32
		}

		[ 0:32, 45:0, 46:1, 48:4 ].each{ k, v->
			assert Integer.numberOfTrailingZeros( k ) == v
			//returns the number of 0-bits following the lowest-order 1-bit
		}

		//returns the number of 1-bits in the binary representation...
		assert Integer.bitCount( 7 ) == 3
		assert Integer.bitCount( -1 ) == 32
	}

	void testInteger19(){
		def x= 0x33333333i
		assert ~x == -x - 1
		assert 0xB4F<<4 == 0xB4F0      && 0xB4F.leftShift( 4 ) == 0xB4F0

		//shift 4 bits to the right, dropping off digits...
		assert 0xD23C>>4 == 0xD23      && 0xD23C.rightShift( 4 ) == 0xD23

		//sign-extension performed when right-shifting...
		assert -0xFFF>>4 == -0x100     && (-0xFFF).rightShift( 4 ) == -0x100

		//...unless triple >>> used
		assert -0xFFF>>>4 == 0xFFFFF00 && (-0xFFF).rightShiftUnsigned(4) == 0xFFFFF00
		[0xABC, -0x98765].each{
			it << 8  == it >> -8
		}

		assert Integer.rotateLeft( 0x456789AB, 4 ) == 0x56789AB4
		//we use multiples of 4 only to show what's happening easier

		assert Integer.rotateLeft( 0x456789AB, 12 ) ==
		Integer.rotateRight( 0x456789AB, Integer.SIZE - 12 )
		//rotating left and right are inverse operations

		assert Integer.rotateLeft( 0x456789AB, 32 ) == 0x456789AB //no change here

		assert Long.rotateRight( 0x0123456789ABCDEF, 40 ) == 0x6789ABCDEF012345

		assert (0x33 & 0x11) == 0x11 && 0x33.and(0x11) == 0x11
		assert (0x33 | 0x11) == 0x33 && 0x33.or(0x11) == 0x33
		assert (0x33 ^ 0x11) == 0x22 && 0x33.xor(0x11) == 0x22

		assert Integer.toString( 123456, 2 ) == '11110001001000000'

		assert Integer.toString( Integer.reverse( 123456 ), 2 ) ==
		'10010001111000000000000000' //reverse bits

		assert Integer.reverseBytes( 0x157ACE42 ) == 0x42CE7A15 //also works for bytes
	}

	void testInteger20(){
		assert ! 0; assert 1; assert 2; assert -1; assert -2
		assert ( ! 1 && 0 ) != ( ! (1 && 0) )
		// the unary ! has the same, high, precedence as the other unary operators
		assert ( 1 || 0 && 0 ) != ( (1 || 0) && 0 ) // && has higher precedence than ||

		def x = 0
		0 && x++
		assert x == 0
		//x++ wasn't performed because falsity of (0 && x++) was known when 0 evaluated

		1 || x++
		assert x == 0
		//x++ wasn't performed because truth of (1 || x++) was known when 1 evaluated
	}

	void testInteger21(){
		def x= 1? 7: -5
		assert x == 7
	}

	void testInteger22(){
		def x, y = (x = 3) && 1
		assert (x == 3) && y

		def i = 2, j = (i=3) * i
		//in the multiplication, lefthand (i=3) evaluated before righthand i
		assert j == 9

		def a = 7
		a += 2 //short for a = a + 2
		assert a == 9
		a += (a = 3) //expands to a = a + (a = 3) before any part is evaluated
		assert a == 12

		assert 45i as BigInteger == 45g
		assert 45L.toBigInteger() == 45g
		assert 45g as Integer == 45i
		assert 45g.intValue() == 45i //alternate syntax
		assert 45g as Long == 45L
		assert 45g.longValue() == 45L

		assert 256g as Byte == 0
		//if converted number too large for target, only lowest order bits returned
		assert 200g as byte == -56 //...and this may result in a negative number

		assert BigInteger.valueOf( 45L ) == 45g
		//works for longs only (not for ints, shorts, or bytes)
		assert BigInteger.ZERO == 0g
		assert BigInteger.ONE == 1g
		assert BigInteger.TWO == 2g
		assert BigInteger.TEN == 10g

		assert new BigInteger( [1, 2, 3]as byte[] ) == 1g*256*256 + 2*256 + 3
		//big-endian 2's complement representation
		try{new BigInteger( []as byte[] ); assert 0}
		catch(e){assert e instanceof NumberFormatException} //empty array not allowed

		assert new BigInteger( -1, [1, 2]as byte[] ) == -258g
		//we pass in sign as a separate argument

		assert new BigInteger( 1, [1, 2]as byte[] ) == 258g

		assert new BigInteger( 0, [0, 0]as byte[] ) == 0g

		assert new BigInteger( 1, []as byte[] ) == 0 //empty array allowable

		try{ new BigInteger( 2, [1, 2, 3]as byte[] ); assert 0 }
		catch(e){ assert e instanceof NumberFormatException}

		def ba= (1g*256*256 + 2*256 + 3).toByteArray()
		//big-endian 2's complement representation
		assert ba.size() == 3 && ba[ 0 ] == 1 && ba[ 1 ] == 2 && ba[ 2 ] == 3

		def bb= 255g.toByteArray()
		assert bb.size() == 2 && bb[ 0 ] == 0 && bb[ 1 ] == -1
		//always includes at least one sign bit

		def bc= (-(2g*256 + 3)).toByteArray()
		assert bc.size() == 2 && bc[ 0 ] == -3 && bc[ 1 ] == -3

		assert '27'.toBigInteger() == 27g
		assert new BigInteger("27", 10) == 27g
		assert new BigInteger("27") == 27g //default radix is 10
		assert new BigInteger("110", 2) == 6g
		assert new BigInteger("-1F", 16) == -31g
		[
			{ new BigInteger(" 27", 10) },
			//no whitespace allowed in string
			{ new BigInteger("Z", Character.MAX_RADIX + 1 ) },
			//radix out of range
			{ new BigInteger("0", Character.MIN_RADIX - 1 ) }, //radix out of range
		].each{
			try{ it(); assert 0 }catch(e){ assert e instanceof NumberFormatException }
		}

		assert 6g.toString(2) == '110'
		assert (-31g).toString(16) == '-1f'
		assert 27g.toString() == '27' //default radix is 10
		assert 27g.toString( Character.MAX_RADIX + 1 ) == '27'

		//assert new BigInteger( 20, new Random() ).toString( 2 ).size() == 20
		//20 is max bit length, must be >= 0
		assert new BigInteger( 20, new Random() ) >= 0

		assert 34g.plus( 33g ) == 34g + 33g
		assert 34g.add( 33g ) == 34g + 33g //alternative name for plus
		assert 34g.minus( 21g ) == 34g - 21g
		assert 34g.subtract( 21g ) == 34g - 21g //alternative name for minus
		assert 3g.multiply( 31g ) == 3g * 31g
		assert 7g.negate() == -7g //unary operation/method
		assert (-7g).negate() == 7g

		assert (45L + 123g).class == BigInteger
		assert (23 - 123g).class == BigInteger
		assert ( 3g * 31 ).class == BigInteger
		assert ( 3 * 31g ).class == BigInteger
		assert 3g.multiply( 31 ).class == BigInteger
		assert 3.multiply( 31g ).class == BigInteger

		assert 256L*256*256*256 * 256*256*256*256 == 0
		//the first 256 is a Long, so each intermediate and final product also Long,
		//and calc overflowed

		assert 256g*256*256*256 * 256*256*256*256 == 18446744073709551616


	}

	void testInteger23(){
		def a= 7g
		assert a++ == 7g && a == 8g && a-- == 8g && a == 7g &&
		++a == 8g && a == 8g && --a == 7g && a == 7g

		assert 7g.divide( 4g ) == 1g
		assert 7g.remainder( 4g ) == 3g
		def a1= 7g.divideAndRemainder( 4g )
		assert a1[0] == 1g //quotient, same result as divide()
		assert a1[1] == 3g //remainder, same result as remainder()

		assert 7g.divide( -4g ) == -1g
		assert 7g.remainder( -4g ) == 3g
		assert (-7g).divide( 4g ) == -1g
		assert (-7g).remainder( 4g ) == -3g
		//division of a negative yields a negative (or zero) remainder
		assert (-7g).divide( -4g ) == 1g
		assert (-7g).remainder( -4g ) == -3g
	}

	void testInteger24(){
		assert 22g.intdiv(5g) == 4g
		assert (-22g).intdiv(5g) == -4g

		assert 7g.abs() == 7g //absolute value
		assert (-7g).abs() == 7g

		assert 28g.gcd(35g) == 7g
		//greatest common divisor of absolute value of each number

		assert (-28g).gcd(35g) == 7g
		assert 28g.gcd(-35g) == 7g
		assert (-28g).gcd(-35g) == 7g
		assert 0g.gcd(9g) == 9g
		assert 0g.gcd(0g) == 0g

		assert 4g**3 == 64g //raising to the power
		//assert (4g**3).class == Integer
		//raising to the power converts a BigInteger to an integer

		assert 4g.power(3) == 64g //using method
		assert 4g.pow(3) == 64g
		//pow() is different to, and sometimes slower than, power()
		assert (-4g).power(3) == -64g
		assert 4g.power(0) == 1g //exponent must be integer >=0

		assert 7g % 4g == 3g && 7g.mod( 4g ) == 3g
		//modulo arithmetic, using operator or method
		assert 8g % 4g == 0g
		assert -7g % 4g == 1g
		//result of mod is between 0 and (modulus - 1) inclusive
		try{ 7g % -4g; assert 0 }catch(e){ assert e instanceof ArithmeticException }
		//mod value must be positive

		assert 4g.modPow( 3g, 9g ) == 1
		//calculates as ((4**3) mod 9), result always zero or positive
		assert 4g.modPow( -2g, 9g ) == 4
		//negative exponents allowed, but mod value must be positive

		assert 4g.modInverse( 3g ) == 1 //calculates as ((4**-1) mod 3)
		//mod must be positive, and value must have a multiplicative inverse mod m
		//(ie, be relatively prime to m)

		assert 7g.max(5g) == 7g //maximum and minimum
		assert 4g.min(5g) == 4g
		def a=5g, b=5g, c=a.min(b)
		assert [a, b].any{ c.is(it) }
		//either a or b may be returned if they're both equal

		assert (-45g <=> -43g) && ( (-45g).compareTo( -43g ) == -1 )
		//comparing two BigIntegers
		assert 14g >= 8g         && 14g.compareTo(8g) >= 0

		assert 45g.signum() == 1 //return sign as -1,0, or 1
		assert 0g.signum() == 0
		assert (-43g).signum() == -1
	}

	void testInteger25(){
		100.times{
			def primes= [17g, 19g, 23g, 29g, 31g]
			//bitlength is 5, so primes from 16 to 31 incl
			assert new BigInteger( 5, 50, new Random() ) in primes
			//5 is bit-length, 50 is certainty (must be integer)
		}

		def pp= BigInteger.probablePrime( 20, new Random() )
		//if we don't want to specify certainty
		//20 is bit-length; there's <1.0e-30 chance the number isn't prime

		def pn= pp.nextProbablePrime()
		//this is probably next prime, but definitely no primes skipped over
		( (pp+1)..<pn ).each{
			assert ! it.isProbablePrime(50)
			//we can test for primality to specific certainty (here, 50).
			//True if probably prime, false if definitely composite
		}
		assert 10g.nextProbablePrime() == 11
		assert 0g.nextProbablePrime() == 2

		assert 0x33g.testBit(1)
		//true if bit is 1, indexing beginning at 0 from righthand side
		assert ! 0x33g.testBit(2)
		(2..100).each{
			assert (-0x3g).testBit(it)
			//negative BigIntegers have virtual infinite sign-extension
		}

		def binRepr={n->
			(15..0).inject(''){flo,it->
				flo<< (n.testBit(it)? 1: 0)
			}
		}
		assert 0x33g.toString(2) == '110011'
		assert binRepr(0x33g) as String == '0000000000110011'
		assert (-0x33g).toString(2) == '-110011' //not what we want to see
		assert binRepr(-0x33g) as String == '1111111111001101'
		//notice the negative sign bit extended virtually

		assert 0x33g.setBit(6) == 0x73g //0x33g is binary 110011
		assert 0x33g.clearBit(4) == 0x23g
		assert 0x33g.flipBit(1) == 0x31g
		assert 0x33g.flipBit(2) == 0x37g

		assert 0x1g.getLowestSetBit() == 0
		//index of the rightmost one bit in this BigInteger
		assert 0x2g.getLowestSetBit() == 1
		assert 0x8g.getLowestSetBit() == 3
		assert 0x33g.bitLength() == 6
		//number of bits in minimal representation of number
		assert (-0x33g).bitLength() == 6 //exclude sign bit
		assert 0x33g.bitCount() == 4 //number of bits that differ from sign bit
		assert (-0x33g).bitCount() == 3

		assert (-0x33g).clearBit(9) == -0x233g

		assert 0xB4Fg.shiftLeft( 4 ) == 0xB4F0g  //shift 4 bits to the left
		assert 0xD23Cg.shiftRight( 4 ) == 0xD23g
		//shift 4 bits to the right, dropping off digits
		assert (-0xFFFg).shiftRight( 4 ) == -0x100g
		//sign-extension performed when right-shifting
		[0xABCg, -0x98765g].each{
			it.shiftLeft( 8 ) == it.shiftRight( -8 )
		}

		assert 123g.not() == -124g //in 2's-complement, negate and add 1
		assert -0xFFg.not() == 0x100g

		assert ( (0x33g & 0x11g) == 0x11g)  && 0x33g.and(0x11g) == 0x11g
		assert ( (0x33g | 0x11g) == 0x33g)  && 0x33g.or(0x11g) == 0x33g
		assert ( (0x33g ^ 0x11g) == 0x22g)  && 0x33g.xor(0x11g) == 0x22g
		assert 0x33g.andNot(0x11g) == 0x22g && (0x33g & (~ 0x11g)) == 0x22g

		assert (-1g & -1g) == -1g

		//or returns a negative number if either operand is negative...
		assert (1g | -1g) == -1g

		//xor returns a negative number if exactly one operand is negative...
		assert (1g ^ -1g) == -2g
		assert (-1g ^ -2g) == 1g

		assert 11g.and(-2g) == 10g //01011 and 11110 is 01010, ie, 10g
	}
}
