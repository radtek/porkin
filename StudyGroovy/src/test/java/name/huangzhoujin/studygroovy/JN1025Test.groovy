package name.huangzhoujin.studygroovy

import groovy.util.GroovyTestCase;
import java.text.*

class JN1025Test extends GroovyTestCase{

	void testArrays01(){
		def a= new Object[4] //we must specify the size of the fixed-size array
		assert a.size() == 4
		assert a.length == 4 //field alternative to size()
		a.each{ assert it == null } //default value is null
		assert a instanceof Object[]
		assert a.class == Object[]

		a[0]= 'a'
		a[1]= 2 //elements can be any value
		a.putAt(2, 'c') //alternative method name syntax
		a[3]= false
		assert a[0] == 'a' && a[1] == 2 && a.getAt(2) == 'c' && a.getAt(3) == false
		//either subscript or method name
		assert a[-4] == 'a' && a[-3] == 2 && a[-2] == 'c' && a[-1] == false
		//subscripts can be negative

		try{ a[4]; assert 0 }
		catch(e){ assert e instanceof ArrayIndexOutOfBoundsException }
		try{ a[-5]; assert 0 }
		catch(e){ assert e instanceof ArrayIndexOutOfBoundsException }

		assert a[1..2] == [
			2,
			'c'] //we can use the same subscripting as for lists
		assert a[2..2] == ['c']
		assert a[0, 2..3] == ['a', 'c', false]

		assert a.toList() == ['a', 2, 'c', false]
		assert a as List == ['a', 2, 'c', false]
		println a.toArrayString();
		assert a.toArrayString() == '[a, 2, c, false]'

		assert new Object[ 0x100000003 ].size() == 3
		//index coerced to integer, positive or negative
		try{ new Object[ 0x80000000 ]; assert 0 }
		catch(e){ assert e instanceof NegativeArraySizeException }

		
	}
}
