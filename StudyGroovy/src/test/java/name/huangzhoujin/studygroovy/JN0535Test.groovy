package name.huangzhoujin.studygroovy;

import groovy.util.GroovyTestCase;

class JN0535Test extends GroovyTestCase {

	public void testFloats01(){
		assert 1.200065d.class == Double
		assert 1.234f.class == Float
		assert (-1.23E23D).class == Double
		assert (1.167g).class == BigDecimal

		assert Float.MIN_VALUE == 1.4E-45f
		assert Float.MAX_VALUE == 3.4028235E38f
		assert Double.MIN_VALUE == 4.9E-324d
		assert Double.MAX_VALUE == 1.7976931348623157E308d

		assert (1f / 0f) == Double.POSITIVE_INFINITY
		assert (-1f / 0f) == Double.NEGATIVE_INFINITY
		assert Double.POSITIVE_INFINITY == Float.POSITIVE_INFINITY

		assert 0.0f != -(0.0f)
		//positive and negative zeroes not equal, when negative is written -(0.0f)
		assert 0.0f == -0.0f

		assert Double.MAX_VALUE * Double.MAX_VALUE == Double.POSITIVE_INFINITY
		assert Double.MIN_VALUE * Double.MIN_VALUE == 0.0d
		assert -Double.MAX_VALUE * Double.MAX_VALUE == Double.NEGATIVE_INFINITY
		assert -Double.MAX_VALUE * -Double.MAX_VALUE == Double.POSITIVE_INFINITY

		assert Float.TYPE == float
		assert Double.TYPE == double

		assert 45.76f as int == 45i  //truncated
		assert 45.76d as int == 45i
		assert 45.76f.toInteger() == 45i //method name
		assert 45.76f.toLong() == 45L
		assert 200.8f as byte == -56 as byte //sign reversed after truncation
		assert 45.76f.toBigInteger() == 45

		assert 789g as Float == 789f
		assert 45i.toFloat() == 45f //method name
		assert 789g.toFloat() == 789f
		assert 789g.floatValue() == 789f //alternative method name
		assert 45i as double == 45d
		assert 6789g.toDouble() == 6789d //method name
		assert 6789g.doubleValue() == 6789d //alternative method name

		assert new BigInteger( '1' + '0'*40 ).floatValue() == Float.POSITIVE_INFINITY
		//one with 40 zeroes after it
		assert new BigInteger( '1234567890' * 3 ).floatValue() == 1.2345679e29f

		assert 89.980 as float == 89.98f
		assert 1.432157168 as float == 1.4321572f //rounded
		assert 78.9g.toFloat() == 78.9f
		assert 456.789g.floatValue() == 456.789f
		assert 6.789g.toDouble() == 6.789d
		assert 2345.6789g.doubleValue() == 2345.6789d
		assert new BigDecimal( '-' + '1' *45 ).floatValue() == Float.NEGATIVE_INFINITY
		assert new BigDecimal( '0.' + '0'*45 + '1' ).floatValue() == 0.0f
		assert new BigDecimal( '0.' + '1234567890' *3 ).floatValue() == 0.12345679f

		assert 23.45e37d as float == 23.45e37f
		assert new Float( 23.45e37d ) == 23.45e37f
		assert new Float( 23.45e67d ) == Float.POSITIVE_INFINITY
		assert 123.45e12f as double //conversion inexact

		[
			'77',
			'1.23e-23',
			'4.56',
			'-1.7E1',
			'98.7e2',
			'-0.27e-30'
		].each{
			assert it.toFloat()
			assert new Float(it)
			assert it.toDouble()
			assert new Double(it)
		}
		assert new Float( '   1.23e-23    ' ) //leading and trailing whitespace removed
		try{ new Float( null ); assert 0 }
		catch(e){ assert e instanceof NullPointerException }
		[
			'NaN',
			'-NaN',
			'Infinity',
			'-Infinity',
			'+Infinity'
		].each{ assert new Float(it) }

		assert new Float( '  -0Xabc.defP7' )
		//we can have hexadecimal mantissa, with P indicating exponent
		assert new Float( '  0xABC.DEFp17  ' )
		//part after P must be base-10, not more hex
		assert new Float( '0X.defP-3f  \n' )
		//any whitespace OK (spaces, tabs, newlines, carriage returns, etc)
		try{ new Float( '  @0X6azQ/3d' ); assert 0 }
		catch(e){ assert e instanceof NumberFormatException }
		//because the string doesn't contain a parsable number in the form of a Float
		assert Float.valueOf( '0xABp17' )
		//alternate means of contructing float from string representation
		assert Float.parseFloat( '0xABp17' )
		//another alternate means of contructing float from string
		assert new Double( '0x12bc.89aP7d  ' )
	}

	//	public void testFloats02(){
	//		assert new BigDecimal(0.25d) == 0.25
	//		//exact conversion because 0.25 has an exact binary representation
	//
	//		assert new BigDecimal(0.1d) ==	0.1000000000000000055511151231257827021181583404541015625
	//
	//		(0.1d).toBigDecimal() == new BigDecimal(0.1d) //alternative method name
	//
	//		assert new BigDecimal(0.1f) == 0.1000000000000000055511151231257827021181583404541015625
	//		//inexact conversion as 0.1 has a recurring decimal part in binary
	//
	//		assert (0.1f as BigDecimal) == 0.1000000000000000055511151231257827021181583404541015625
	//
	//		//assert new BigDecimal(0.1d, new java.math.MathContext(25) ) ==
	//		//0.1000000000000000055511151 //rounds to 25 places as specified
	//	}

	public void testFloats03(){
		assert BigDecimal.valueOf( 0.25d ) == 0.25
		assert BigDecimal.valueOf( 0.1d ) == 0.1
		//always exact, because converts double to a string first
		assert new BigDecimal( Double.toString( 0.1d ) ) == 0.1
		//explicitly convert double to string, then to BigDecimal
		assert BigDecimal.valueOf( -23.456e-17d ) == -2.3456E-16
		assert BigDecimal.valueOf( -23.456e-17f ) == -2.3455999317674643E-16
		//result inexact because float converted to double first

		try{ BigDecimal.valueOf( Double.POSITIVE_INFINITY ); assert 0 }
		catch(e){ assert e instanceof NumberFormatException }

		try{ BigDecimal.valueOf( Double.NaN ); assert 0 }
		catch(e){ assert e instanceof NumberFormatException }

		assert Float.toString( 3.0e6f ) == '3000000.0' //no leading zeros
		assert Float.toString( 3.0e0f ) == '3.0' //at least one digit after the point
		assert Float.toString( 3.0e-3f ) == '0.0030'
		assert Float.toString( 3.0e7f ) == '3.0E7'
		//exponent used if it would be > 6 or < -3
		assert Float.toString( 3.0e-4f ) == '3.0E-4' //mantissa >= 1 and < 10

		[        0.0f: '0x0.0p0',
					(-0.0f): '0x0.0p0', //no negative sign in hex string rep'n of -0.0f
					1.0f: '0x1.0p0', //most returned strings begin with '0x1.' or '-0x1.'
					2.0f: '0x1.0p1',
					3.0f: '0x1.8p1',
					5.0f: '0x1.4p2',
					(-1.0f): '-0x1.0p0',
					0.5f: '0x1.0p-1',
					0.25f: '0x1.0p-2',
					(Float.MAX_VALUE): '0x1.fffffep127',
					(Float.MIN_VALUE): '0x0.000002p-126',
					//low values beginning with '0x0.' are called 'subnormal'
					(Float.NEGATIVE_INFINITY): '-Infinity',
					(Float.NaN): 'NaN',
				].each{ k, v->
					assert Float.toHexString(k) == v
				}
		assert String.format('%d', 45) == '45'
		assert String.format('%5d,%1$5o', 46L) == '   46,   56'
		//octal format; each minimum 5 chars wide; use an argument twice
		assert String.format('%-4d,%<-5x', 47g) == '47  ,2f   '
		//hex format without leading '0x'; left-justified with '-';
		//shortcut ('<') for using argument again
		assert String.format('%2d,%<1X', 123) == '123,7B'
		//hex in uppercase with capital 'X'
		assert String.format('%04d', 34) == '0034' //zero-pad
		assert String.format('%,5d', 12345) == '12,345' //use grouping-separators
		assert String.format('%+3d,%2$ 3d', 123L, 456g) == '+123, 456'
		//always use plus sign; always use a leading space
		assert String.format('%(3d', -789 as short) == '(789)' //parens for negative
		assert String.format('%(3o,%2$(3x,%3$(3X', 123g, 456g, -789g) == '173,1c8,(315)'
		//neg octal/hex only for BigInteger

		//Floating-Point ('f', 'a', 'e', 'g')
		assert String.format('e = %f', Math.E) == 'e = 2.718282'
		//default 'f' format is 7.6
		assert String.format('e=%+6.4f', Math.E) == 'e=+2.7183'
		//precision is digits after decimal point
		assert String.format('$ %(,6.2f', -6217.58) == '$ (6,217.58)'
		//'(' flag gives parens, ',' uses separators
		assert String.format('%a, %A', 2.7182818f, Math.PI) ==
		'0x1.5bf0a8p1, 0X1.921FB54442D18P1' //'a' for hex
		assert String.format('%+010.4a', 23.25d) == '+0x001.7400p4'
		//'+' flag always includes sign; '0' flag zero-fills
		assert String.format('%e, %10.4e', Math.E, 12345.6789) ==
		'2.718282e+00, 1.2346e+04' //'e' for scientific format
		assert String.format('%(10.5E', -0.0000271) == '(2.71000E-05)'
		assert String.format('%g, %10.4G', Math.E, 12345.6789) == '2.71828,  1.235E+04'
	}

	public void testFloats04(){
		assert 3.4f.plus( 3.3f ) == 3.4f + 3.3f
		assert 3.4f.minus( 2.1f ) == 3.4f - 2.1f
		assert 3.0f.multiply( 3.1f ) == 3.0f * 3.1f
		assert 3.0f.multiply( 3f ) == 3.0f * 3f
		assert 3.0.multiply( 3f ) == 3.0 * 3f
		//assert 7.7f.negate() == -7.7f //unary operation/method
		//assert (-7.7f).negate() == -(-7.7f)
		assert +(7.7f) == 7.7f

		try{ 3.4f.multiply(null); assert false }
		catch(e){ assert e instanceof NullPointerException }

		assert (23.4f + 7.998d).class == Double
		assert (23.4f - 123.45g).class == Double
		assert (7.998d * 123.45g).class == Double
		//assert (23.4f - i=789).class == Double

		assert 2.4f.div( 1.6f ) == ( 2.4f / 1.6f )
		assert ( 2.5f / 1i ).class == Double
		//produces double result if either operand is float or double
		assert ( 2.5f / 1.25 ).class == Double

		def a= 34.56f % 5
		assert a == 34.56f.mod(5) && a < 5.0f && a >= 0.0f

		def b= 34.56f % 5.1f
		assert b == 34.56f.mod(5.1f) && b < 5.0f && b >= 0.0f

		def c= -34.56f % 5.1f
		assert c == (-34.56f).mod(5.1f) && c <= 0.0f && c > -5.0f

		////////////////////////////////////////////////////////
		def Infinity=Double.POSITIVE_INFINITY, NaN=Double.NaN, Zero=0.0d
		assert Math.IEEEremainder( 33d, 10d ) == 3d
		//give remainder after rounding to nearest value
		assert Math.IEEEremainder( 37d, 10d ) == -3d
		assert Math.IEEEremainder( -33d, 10d ) == -3d
		assert Math.IEEEremainder( -37d, 10d ) == 3d
		assert Math.IEEEremainder( 35d, 10d ) == -5d
		//when two values equally near, use even number
		assert Math.IEEEremainder( 45d, 10d ) == 5d
		assert Math.IEEEremainder( Zero, 10d ) == Zero
		assert Math.IEEEremainder( -Zero, 10d ) == -Zero
		assert Math.IEEEremainder( Infinity, 10d ) == NaN
		assert Math.IEEEremainder( 35d, Zero ) == NaN
		assert Math.IEEEremainder( 35d, Infinity ) == 35d

		assert (-23.4f).abs() == 23.4f
		assert (-23.414d).abs() == 23.414d

		assert 14.49f.round() == 14i
		assert 14.5f.round() == 15i
		assert (-14.5f).round() == -14i
		assert 14.555d.round() == 15L

		assert 4.5f**3 == 91.125d //double returned
		assert 4.5f.power(3) == 4.5f**3 //using equivalent method instead
		//assert 1.1.power(1000000000) == Double.POSITIVE_INFINITY

		//def Infinity=Double.POSITIVE_INFINITY, NaN=Double.NaN, Zero=0.0d
		assert NaN.isNaN()
		assert Double.isNaN( NaN )
		assert Infinity.isInfinite()
		assert (-Infinity).isInfinite()
		assert Double.isInfinite( Infinity )
		assert Double.isInfinite( -Infinity )
		assert Float.isInfinite( Float.NEGATIVE_INFINITY )

		assert 345f.equals( 3.45e2f ) && 345f == 3.45e2f
		//equals() and == behave the same in all cases
		assert ! 34.5f.equals( 13.4f ) && 34.5f != 13.4f //equivalent

		assert Float.NaN.equals( Float.NaN ) && Float.NaN == Float.NaN

		assert 0.0f == -0.0f && 0.0f.equals( -0.0f )
		//-0.0f is evaluated as positive zero
		assert 0.0f != -(0.0f) && ! 0.0f.equals( -(0.0f) )
		//negative zero must be written -(0.0f)

		assert 345d.equals( 3.45e2d ) && 345d == 3.45e2d

		assert Float.POSITIVE_INFINITY.equals( Float.POSITIVE_INFINITY ) &&
		Float.POSITIVE_INFINITY == Float.POSITIVE_INFINITY
		assert ! Float.POSITIVE_INFINITY.equals( Float.NEGATIVE_INFINITY ) &&
		! ( Float.POSITIVE_INFINITY == Float.NEGATIVE_INFINITY )

		assert (2.50f <=> 2.5f) == 0 && 2.50f.compareTo(2.5f) == 0
		assert (-3.45f <=> 1.23f) == -1 && (-3.45f).compareTo(1.23f)  == -1
		assert (1.23d <=> -0.12d) == 1 && 1.23d.compareTo(-0.12d) == 1
		assert (-1.23d < -0.12d) && (-1.23d).compareTo(-0.12d) < 0

		assert (Float.NaN > Float.POSITIVE_INFINITY) &&
		Float.NaN.compareTo(Float.POSITIVE_INFINITY) > 0
		assert (0.0f <=> -0.0f) == 0
		assert (Float.NaN <=> Float.NaN) == 0 && Float.NaN.compareTo(Float.NaN) == 0
		assert Float.compare( 3.4f, 7.9f ) == -1
		assert Double.compare( 3.4d, -7.9d ) == 1

	}

	public void testFloats05(){
		def a= 12.315d
		a++
		assert a == 13.315d
		--a
		assert a == 12.315d

		assert (1.23d? true: false)
		assert ! (0.0f? true: false)

		assert Float.floatToIntBits( 0.0f ) == 0
		assert Float.floatToIntBits( 15.15f ) == 0x41726666
		assert Float.floatToIntBits( Float.NaN ) == 0x7fc00000
		assert Float.floatToIntBits( Float.POSITIVE_INFINITY ) == 0x7f800000
		assert Float.floatToIntBits( Float.NEGATIVE_INFINITY ) == (0xff800000 as int)
		assert Double.doubleToLongBits( 15.15d ) == 0x402e4ccccccccccd

		assert Float.intBitsToFloat( 0x7fc00000 ) == Float.NaN
		assert Float.intBitsToFloat( 0x7f800000 ) == Float.POSITIVE_INFINITY
		assert Float.intBitsToFloat( 0xff800000 as int ) == Float.NEGATIVE_INFINITY
		assert Float.intBitsToFloat( 0 ) == 0.0f
		assert Float.intBitsToFloat( 0x41726666 ) == 15.15f
		assert Double.longBitsToDouble( 0x402e4ccccccccccd ) == 15.15d
		assert Float.intBitsToFloat( Float.floatToIntBits( 15.15f ) ) == 15.15f

		assert Float.MAX_VALUE == Float.intBitsToFloat(0x7f7fffff)
		assert Float.MIN_NORMAL == Float.intBitsToFloat(0x00800000)
		//the smallest positive nonzero normal value
		assert Float.MIN_VALUE == Float.intBitsToFloat(0x1)
		//the smallest positive nonzero value, including subnormal values
		assert Float.MAX_EXPONENT == Math.getExponent(Float.MAX_VALUE)
		assert Float.MIN_EXPONENT == Math.getExponent(Float.MIN_NORMAL)
		assert Float.MIN_EXPONENT == Math.getExponent(Float.MIN_VALUE) + 1

		assert Math.sin( 0.0 ) == 0.0
		assert Math.sin( 0.5 * Math.PI ) == 1.0
		assert Math.sin( Math.PI ) < 1e-15 //almost 0.0, but not quite
		assert Math.sin( 1.5 * Math.PI ) == -1.0
		assert Math.sin( 2 * Math.PI ) > -1e-15 //almost 0.0
		assert Math.sin( -0.5 * Math.PI ) == -1.0
		assert Math.sin( -Math.PI ) > -1e-15 //almost 0.0
		assert Math.sin( -1.5 * Math.PI ) == 1.0
		assert Math.sin( -2 * Math.PI ) < 1e-15 //almost 0.0
		assert Math.sin( Double.POSITIVE_INFINITY ) == Double.NaN
		assert Math.sin( Double.NEGATIVE_INFINITY ) == Double.NaN

		assert Math.cos( Double.POSITIVE_INFINITY ) == Double.NaN
		assert Math.tan( Double.NEGATIVE_INFINITY ) == Double.NaN
		assert Math.asin( 0.0 ) == 0.0
		assert Math.asin( 1.0 ) == 0.5 * Math.PI
		assert Math.asin( 1.001 ) == Double.NaN
		assert Math.acos( -1.0 ) == Math.PI
		assert Math.acos( -1.001 ) == Double.NaN
		assert Math.atan( 0.0 ) == 0.0

		def Infinity= Double.POSITIVE_INFINITY, NaN= Double.NaN, Zero= 0.0d

		[ (Infinity): Infinity,
					10000: 4,
					10: 1,
					1: 0,
					0.1: -1,
					0.00001: -5,
					0.0: -Infinity,
					(-0.001): NaN,
				].each{ k, v -> assert Math.log10(k) == v } //returns base-10 logarithm

		[ (Infinity): Infinity,
					(Math.E): 1,
					1: 0,
					0.0: -Infinity,
					(-0.001): NaN,
				].each{ k, v -> assert Math.log(k) == v } //returns natural logarithm

		assert Math.exp( Infinity ) == Infinity //returns Math.E raised to a power
		assert Math.exp( -Infinity ) == 0.0

		assert Math.ulp( 123.456d ) == Math.ulp( -123.456d )
		assert Math.ulp( 0.123456789d ) != Math.ulp( 0.123456789f )
		//if Float, a different scale is used

		assert Math.ulp( Double.POSITIVE_INFINITY ) == Double.POSITIVE_INFINITY
		assert Math.ulp( Double.NEGATIVE_INFINITY ) == Double.POSITIVE_INFINITY
		assert Math.ulp( 0.0d ) == Double.MIN_VALUE
		assert Math.ulp( Double.MIN_VALUE ) == Double.MIN_VALUE
		assert Double.MAX_VALUE > Math.ulp( Double.MAX_VALUE )


		/////////////////////////////////////////////////
		[     [1d, 1d]: 0.25d * Math.PI,
			[1d, -1d]: 0.75d * Math.PI,
			[-1d, 1d]: -0.25d * Math.PI,
			[-1d, -1d]: -0.75d * Math.PI,

			[0d, 1d]: 0d,
			[-(0d), 1d]: -(0d),
			[0d, -1d]: Math.PI,
			[-(0d), -1d]: -Math.PI, // -(0d) gives huge difference in result to 0d
			[1d, 0d]: 0.5d * Math.PI,
			[1d, -(0d)]: 0.5d * Math.PI,
			[-1d, 0d]: -0.5d * Math.PI,
			[-1d, -(0d)]: -0.5d * Math.PI,

			[Double.NaN, 1d]: Double.NaN, //NaN returned if either argument is NaN

			[1d, Infinity]: 0d,
			[1d, -Infinity]: Math.PI,
			[-1d, Infinity]: -(0d),
			[-1d, -Infinity]: -Math.PI,
			[Infinity, 1d]: 0.5d * Math.PI,
			[Infinity, -1d]: 0.5d * Math.PI,
			[-Infinity, 1d]: -0.5d * Math.PI,
			[-Infinity, -1d]: -0.5d * Math.PI,
			[Infinity, Infinity]: 0.25d * Math.PI,
			[Infinity, -Infinity]: 0.75d * Math.PI,
			[-Infinity, Infinity]: -0.25d * Math.PI,
			[-Infinity, -Infinity]: -0.75d * Math.PI,
		].each{k,v->
			if( Math.atan2( k[0], k[1] ) != v )
				println "( ${k[0]}, ${k[1]} ): ${Math.atan2(k[0],k[1])};  $v"
		}

		def assertClose= {it1,it2,ulp->
			assert it1 > it2 - ulp*Math.ulp(it2) && it1 < it2 + ulp*Math.ulp(it2)
		}
		//def Infinity=Double.POSITIVE_INFINITY, Zero=0d, NaN=Double.NaN,
		def E=Math.E
		assertClose Math.sinh( 2d ), 0.5d*(E**2d - E**-2d), 2.5d
		//sinh() result will be with 2.5 ulp of exact value
		assert Math.sinh( Infinity ) == Infinity
		assert Math.sinh( -Infinity ) == -Infinity
		assert Math.sinh( Zero ) == Zero
		assert Math.sinh( -Zero ) == -Zero
		assertClose Math.cosh( 2d ), 0.5d*(E**2d + E**-2d), 2.5d
		assert Math.cosh( Infinity ) == Infinity
		assert Math.cosh( -Infinity ) == Infinity
		assert Math.cosh( Zero ) == 1d
		assert Math.cosh( -Zero ) == 1d
		assertClose Math.tanh( 2d ), Math.sinh( 2d )/Math.cosh( 2d ), 2.5d
		assert Math.tanh( Infinity ) == 1d
		assert Math.tanh( -Infinity ) == -1d
		assert Math.tanh( Zero ) == Zero
		assert Math.tanh( -Zero ) == -Zero

		assert Math.toDegrees( Math.PI ) == 180.0
		assert Math.toRadians( 90.0 ) == 0.5 * Math.PI
	}

	public void testFloats06(){
		def  assertClose= {it1,it2,ulp->
			assert it1 > it2 - ulp*Math.ulp(it2) && it1 < it2 + ulp*Math.ulp(it2)
		}
		def Infinity=Double.POSITIVE_INFINITY, NaN=Double.NaN, Zero= 0d, E= Math.E

		assertClose Math.expm1( 123.4d ), E**123.4d - 1, 31
		assertClose Math.expm1( 23.4d ), E**23.4d - 1, 10
		assertClose Math.expm1( 3.4d ), E**3.4d - 1, 3
		assert Math.expm1( Infinity ) == Infinity
		assert Math.expm1( -Infinity ) == -1d
		assert Math.expm1( Zero ) == Zero
		assert Math.expm1( -Zero ) == -Zero

		assert Math.log1p( 123.4d ) == Math.log(1d + 123.4d)
		assert Math.log1p( 23.4d ) == Math.log(1d + 23.4d)
		assert Math.log1p( 3.4d ) == Math.log(1d + 3.4d)
		assert Math.log1p( -1.1d ) == NaN
		assert Math.log1p( Infinity ) == Infinity
		assert Math.log1p( -1d ) == -Infinity
		assert Math.log1p( Zero ) == Zero
		assert Math.log1p( -Zero ) == -Zero

		assert Math.scalb(5, 3) == 5 * 2**3
		assert Math.scalb(NaN, 3) == NaN
		assert Math.scalb(Infinity, 3) == Infinity //same sign
		assert Math.scalb(Zero, 3) == Zero //same sign

		def ten= Math.sqrt( 10 ) * Math.sqrt( 10 )
		def error= 1e-14
		assert ten > 10 - error && ten < 10 + error

		assert Math.sqrt( -0.001 ) == Double.NaN
		assert Math.sqrt( 0 ) == 0
		assert Math.sqrt( Double.POSITIVE_INFINITY ) == Double.POSITIVE_INFINITY

		//def ten= Math.cbrt( 10 ) * Math.cbrt( 10 ) * Math.cbrt( 10 )
		//def error= 1e-14
		assert ten > 10 - error && ten < 10 + error

		assert Math.cbrt( -123.456 ) == -Math.cbrt( 123.456 )
		assert Math.cbrt( 0 ) == 0
		assert Math.cbrt( Double.POSITIVE_INFINITY ) == Double.POSITIVE_INFINITY
		assert Math.cbrt( Double.NEGATIVE_INFINITY ) == Double.NEGATIVE_INFINITY

		assert Math.ceil( 6.77 ) == 7 &&      Math.floor( 6.77 ) == 6
		assert Math.ceil( -34.43 ) == -34 &&  Math.floor( -34.43 ) == -35
		assert Math.ceil( 0.73 ) == 1.0 &&    Math.floor( 0.73 ) == 0.0
		//assert Math.ceil( -0.73 ) == -0.0d && Math.floor( -0.73 ) == -1.0
		//sign required for -0.0d
		assert Math.ceil( 13.0 ) == 13.0 &&   Math.floor( 13.0 ) == 13.0
		assert Math.ceil( 0.0 ) == 0.0 &&     Math.floor( 0.0 ) == 0.0
		assert Math.ceil( 23.45 ) == -Math.floor( -23.45 )

		[                       7.45: 7,
					7.5: 8,
					(-3.95): -4,
					(-3.5): -3,
					(Double.NaN): 0,
					(Double.NEGATIVE_INFINITY): Long.MIN_VALUE,
					(Long.MIN_VALUE as Double): Long.MIN_VALUE,
					(Double.POSITIVE_INFINITY): Long.MAX_VALUE,
					(Long.MAX_VALUE as Double): Long.MAX_VALUE,
				].each{ k, v -> assert Math.round( k ) == v }

		assert Math.max( 7i, 9i ) == 9i //returns the same class as its arguments
		assert Math.min( 23L, 19L ) == 19L
		assert Math.min( 1.7f, 0.3f ) == 0.3f
		assert Math.min( -6.7d, 1.3d ) == -6.7d
		assert Math.min( 7i, 9L ) == 7L //converts result to most precise type of argument
		assert Math.min( 1L, 3.3f ) == 1f
		assert Math.min( -6.7f, 1.3d ) == -6.699999809265137d

		[   7.49d: 7.0d,
					7.5d: 8.0d,
					8.5d: 8d,
					(-7.5d): -8d,
					7d: 7d,
					0d: 0d,
					(Double.POSITIVE_INFINITY): Double.POSITIVE_INFINITY,
				].each{ k, v-> assert Math.rint( k ) == v }
		//round to nearest integer (or even integer)

		assert Math.abs( -23i ) == 23i
		assert Math.abs( 234L ) == 234L
		assert Math.abs( 0i ) == 0i
		assert Math.abs( Integer.MIN_VALUE ) == Integer.MIN_VALUE
		//WARNING: this result not intuitive
		assert Math.abs( Long.MIN_VALUE ) == Long.MIN_VALUE

		assert Math.abs( -23.45f ) == 23.45f
		assert Math.abs( -123.4d ) == 123.4d
		assert Math.abs( 0.0f ) == 0.0f
		assert Math.abs( -0.0f ) == 0.0f
		assert Math.abs( Float.NEGATIVE_INFINITY ) == Float.POSITIVE_INFINITY

		[
			-23.45f,
			781.23f,
			Float.NEGATIVE_INFINITY
		].each{
			assert Math.abs(it) ==
			Float.intBitsToFloat(0x7fffffff & Float.floatToIntBits(it))
			assert Math.abs(it) ==
			Float.intBitsToFloat((Float.floatToIntBits(it)<<1)>>>1)
		} //there's related assertions for doubles


	}

	public void testFloats07(){
		def Infinity= Double.POSITIVE_INFINITY, NaN= Double.NaN
		[
					[3d, 0d]: 1d,
					[3d, -(0d)]: 1d,
					[3d, 1d]: 3d,
					[3d, Infinity]: Infinity,
					[-3d, Infinity]: Infinity,
					[0.3d, -Infinity]: Infinity,
					[-0.3d, -Infinity]: Infinity,
					[3d, -Infinity]: 0d,
					[-3d, -Infinity]: 0d,
					[0.3d, Infinity]: 0d,
					[-0.3d, Infinity]: 0d,
					[1d, Infinity]: Double.NaN,
					[0d, 1d]: 0d,
					[Infinity, -1d]: 0d,
					[0d, -1d]: Infinity,
					[Infinity, 1d]: Infinity,
					[-(0d), 2d]: 0d, //exponent >0 but not finite odd integer
					[-Infinity, -2d]: 0d, //exponent <0 but not finite odd integer
					[-(0d), 3d]: -(0d), //exponent is positive finite odd integer
					[-Infinity, -3d]: -(0d), //exponent is negative finite odd integer
					[-(0d), -2d]: Infinity, //exponent <0 but not finite odd integer
					[-Infinity, 2d]: Infinity, //exponent >0 but not finite odd integer
					[-(0d), -3d]: -Infinity, //exponent is negative finite odd integer
					[-Infinity, 3d]: -Infinity, //exponent is positive finite odd integer
					[-3d, 4i]: {-> def a= Math.abs(-3d); a*a*a*a }(),
					//exponent is finite even integer
					[-3d, 5i]: {-> def a= Math.abs(-3d); -a*a*a*a*a }(),
					//exponent is finite odd integer
					[-3d, 2.5]: NaN, //exponent is finite and not an integer
					[NaN, 0d]: 1d //exception to the NaN ripple rule
				].each{k, v->
					assert Math.pow( k[0], k[1] ) == v
				}

		assert Math.random() >= 0d //this method uses new Random() when first called
		assert Math.random() < 1d

		assert Math.signum( 17.75d ) == 1d
		assert Math.signum( 17.75f ) == 1f
		assert Math.signum( -19.5d ) == -1d
		assert Math.signum( 0d ) == 0d
		assert Math.signum( -(0d) ) == -(0d)

		assert Math.copySign( 34.4f, -2.1f ) == -34.4f
		assert Math.copySign( -1234.4d, 2.23d ) == 1234.4d

		//def Infinity=Double.POSITIVE_INFINITY, NaN=Double.NaN
		assert Math.hypot( 9d, 16d ) == Math.sqrt( 9d**2 + 16d**2 )
		assert Math.hypot( Infinity, 234d ) == Infinity
		assert Math.hypot( NaN, 234d ) == NaN
		assert Math.hypot( Infinity, NaN ) == Infinity

		//def Infinity=Double.POSITIVE_INFINITY, Zero=0d, NaN=Double.NaN, E=Math.E
		assert Math.getExponent(2.345e31d) <= Double.MAX_EXPONENT
		assert Math.getExponent(2.345e31d) >= Double.MIN_EXPONENT
		assert Math.getExponent( NaN ) == Double.MAX_EXPONENT + 1
		assert Math.getExponent( Infinity ) == Double.MAX_EXPONENT + 1

		//assert Math.getExponent( Zero ) == Double.MIN_EXPONENT - 1
		//this is also the value of subnormal exponents

		assert Math.getExponent(12.3e4f) <= Float.MAX_EXPONENT &&
		Math.getExponent(12.3e4f) >= Float.MIN_EXPONENT

		//def Infinity=Double.POSITIVE_INFINITY, NaN=Double.NaN, 
		def Zero= 0d
		assert Math.nextAfter( 12.34d, 999d ) == 12.34d + Math.ulp( 12.34d )
		assert Math.nextAfter( 12.34d, -999d ) == 12.34d - Math.ulp( 12.34d )
		assert Math.nextAfter( 12.34f, 999f ) == 12.34f + Math.ulp( 12.34f )
		assert Math.nextAfter( 12.34d, 12.34d ) == 12.34d
		//if numbers equal, return second one
		assert Math.nextAfter( Zero, -Zero ) == -Zero
		//numbers are 'equal', and second one returned
		assert Math.nextAfter( Double.MIN_VALUE, -12d ) == Zero
		assert Math.nextAfter( -Double.MIN_VALUE, 12d ) == -Zero
		assert Math.nextAfter( Double.MAX_VALUE, Infinity ) == Infinity
		assert Math.nextAfter( -Double.MAX_VALUE, -Infinity ) == -Infinity
		assert Math.nextAfter( Infinity, 12d ) == Double.MAX_VALUE
		assert Math.nextAfter( -Infinity, 12d ) == -Double.MAX_VALUE
		assert Math.nextAfter( Zero, Infinity ) == Double.MIN_VALUE
		assert Math.nextAfter( Infinity, Infinity ) == Infinity
		assert Math.nextUp( 12.34d ) == Math.nextAfter( 12.34d, Infinity )
		//shortcut method for both doubles and floats

	}


}
