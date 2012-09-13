package name.huangzhoujin.studygroovy


import groovy.util.GroovyTestCase;
import java.text.*

class JN1015Test extends GroovyTestCase {

	void testCollections01(){
		def list = [5, 6, 7, 8]
		assert list.size == 4
		assert list.size() == 4
		assert list.class == ArrayList //the specific kind of list being used

		assert list[2] == 7 //indexing starts at 0
		assert list.getAt(2) == 7 //equivalent method to []
		assert list.get(2) == 7 //alternative method

		list[2] = 9
		assert list == [
			5,
			6,
			9,
			8, ] //trailing comma OK
		list.putAt(2, 10) //equivalent method to [] when value being changed
		assert list == [5, 6, 10, 8]
		assert list.set(2, 11) == 10 //alternative method that returns old value
		assert list == [5, 6, 11, 8]

		assert [
			'a',
			1,
			'a',
			'a',
			2.5,
			2.5f,
			2.5d,
			'hello',
			7g,
			null,
			9 as byte
		]
		assert [1, 2, 3, 4, 5][-1] == 5 //use negative indices to count from the end
		assert [1, 2, 3, 4, 5][-2] == 4
		assert [1, 2, 3, 4, 5].getAt(-2) == 4 //getAt() available with negative index...
		try{ [1, 2, 3, 4, 5].get(-2); assert 0 } //...but not get()
		catch(e){ assert e instanceof ArrayIndexOutOfBoundsException }

		assert ! [] //an empty list evaluates as false
		assert [1]&& ['a']&& [0]&& [0.0]&& [false]&& [null]
	}

	void testCollections02(){
		def list = [];
		assert list.size() == 0

		list << 5;
		assert list.size() == 1

		list << 7 << 'i' << 11;
		assert list == [5, 7, 'i', 11]

		list << ['m', 'o'];
		assert list == [5, 7, 'i', 11, ['m', 'o']]

		assert ( [1, 2]<< 3 << [4, 5]<< 6 ) == [1, 2, 3, [4, 5], 6]
		assert ([1, 2, 3]<< 4) == ([1, 2, 3].leftShift(4))

	}

	void testCollections03(){
		assert [1, 2]+ 3 + [4, 5]+ 6 == [1, 2, 3, 4, 5, 6]
		assert [1, 2].plus(3).plus([4, 5]).plus(6) == [1, 2, 3, 4, 5, 6]
		//equivalent method for +
		def a= [1, 2, 3];
		a += 4; a += [5, 6]; assert a == [1, 2, 3, 4, 5, 6]
		assert [1, *[222, 333], 456]== [1, 222, 333, 456]
		assert [*[1, 2, 3]]== [1, 2, 3]
		assert [
			1,
			[2, 3, [4, 5], 6],
			7,
			[8, 9]
		].flatten() == [1, 2, 3, 4, 5, 6, 7, 8, 9]

		def list= [1, 2]
		list.add(3) //alternative method name
		list.addAll([5, 4]) //alternative method name
		assert list == [1, 2, 3, 5, 4]

		list= [1, 2]
		list.add(1,3) //add 3 just before index 1
		assert list == [1, 3, 2]
		list.addAll(2,[5, 4]) //add [5,4] just before index 2
		assert list == [1, 3, 5, 4, 2]

		list = [
			'a',
			'b',
			'z',
			'e',
			'u',
			'v',
			'g'
		]
		list[8] = 'x'
		assert list == [
			'a',
			'b',
			'z',
			'e',
			'u',
			'v',
			'g',
			null,
			'x'
		]

		[1, 2, 3].each{ println "Item: $it" }
		['a', 'b', 'c'].eachWithIndex{ it, i -> println "$i: $it" }

		def list1= ['a', 'b', 'c']
		def list2 = new ArrayList( list1 )
		//construct a new list, seeded with the same items as in list1
		assert list2 == list1 // == checks that each corresponding element is the same
		def list3 = list1.clone()
		assert list3 == list1

		assert [1, 2, 3].collect{ it * 2 } == [2, 4, 6]
		//simple call gives single result
		assert [1, 2, 3]*.multiply(2) == [1, 2, 3].collect{ it.multiply(2) }
		//shortcut syntax instead of collect

		def list0= []
		assert [1, 2, 3].collect( list0 ){ it * 2 } == [2, 4, 6]
		//this style of call gives two identical results
		assert list0 == [2, 4, 6]

		///////////////////////////////////////////////////////////////
		assert [1, 2, 3].find{ it > 1 } == 2
		assert [1, 2, 3].findAll{ it > 1 } == [2, 3]
		assert ['a', 'b', 'c', 'd', 'e'].findIndexOf{ it in ['c', 'e', 'g']} == 2
		//find first item that satisfies closure
		assert [1, 2, 3].every{ it < 5 }
		assert ! [1, 2, 3].every{ it < 3 }
		assert [1, 2, 3].any{ it > 2 }
		assert ! [1, 2, 3].any{ it > 3 }

		// sum anything with a plus() method
		assert [1, 2, 3, 4, 5, 6].sum() == 21
		assert ['a', 'b', 'c', 'd', 'e'].sum{
			it=='a'?1: it=='b'?2: it=='c'?3: it=='d'?4: it=='e'?5: 0
		} == 15
		//assert ['a', 'b', 'c', 'd', 'e'].sum{ (char)it - (char)'a' } == 10
		assert ['a', 'b', 'c', 'd', 'e'].sum() == 'abcde'
		assert [['a', 'b'], ['c', 'd']].sum() == ['a', 'b', 'c', 'd']
		// an initial value can be provided
		assert [].sum(1000) == 1000
		assert [1, 2, 3].sum(1000) == 1006

		assert [1, 2, 3].join('-') == '1-2-3'
		assert [1, 2, 3].inject('counting: '){ str, item -> str + item } ==
		'counting: 123'
		assert [1, 2, 3].inject(0){ count, item -> count + item } == 6
	}

	void testCollections04(){
		def list= [9, 4, 2, 10, 5]
		assert list.max() == 10
		assert list.min() == 2
		assert Collections.max( list ) == 10
		assert Collections.min( list ) == 2
		assert ['x', 'y', 'a', 'z'].min() == 'a'

		//we can also compare single characters
		def list2= [
			'abc',
			'z',
			'xyzuvw',
			'Hello',
			'321'
		]
		assert list2.max{ it.size() } == 'xyzuvw'
		//we can use a closure to spec the sorting behaviour
		assert list2.min{ it.size() } == 'z'

		////////////////////////////////////////////////////////////
		def mc= [compare:{a,b-> a.equals(b)? 0: a<b? -1: 1}] as Comparator
		//this syntax to be explained in a later tutorial
		list= [
			7,
			4,
			9,
			-6,
			-1,
			11,
			2,
			3,
			-9,
			5,
			-13
		]
		assert list.max( mc ) == 11
		assert list.min( mc ) == -13
		assert Collections.max( list, mc ) == 11
		assert Collections.min( list, mc ) == -13

		def mc2= [
					compare: {a,b->
						a.equals(b)? 0: Math.abs(a)<Math.abs(b)? -1: 1 }
				] as Comparator
		//we should always ensure a.equals(b) returns 0, whatever else we do,
		//to avoid inconsistent behaviour in many contexts

		assert list.max( mc2 ) == -13
		assert list.min( mc2 ) == -1
		assert list.max{a,b-> a.equals(b)? 0: Math.abs(a)<Math.abs(b)? -1: 1 } == -13
		assert list.min{a,b-> a.equals(b)? 0: Math.abs(a)<Math.abs(b)? -1: 1 } == -1
	}

	void testCollections05(){
		assert ['a', 'b', 'c', 'b', 'b']- 'c' == ['a', 'b', 'b', 'b']
		//remove 'c', and return resulting list
		assert ['a', 'b', 'c', 'b', 'b']- 'b' == ['a', 'c']
		//remove all 'b', and return resulting list
		assert ['a', 'b', 'c', 'b', 'b']- ['b', 'c']== ['a']
		//remove all 'b' and 'c', and return resulting list
		assert ['a', 'b', 'c', 'b', 'b'].minus('b') == ['a', 'c']
		//equivalent method name for -
		assert ['a', 'b', 'c', 'b', 'b'].minus( ['b', 'c']) == ['a']
		def list= [1, 2, 3, 4, 3, 2, 1]
		list -= 3
		assert list == [
			1,
			2,
			4,
			2,
			1] //use -= to remove 3, permanently
		assert ( list -= [2, 4]) == [
			1,
			1] //remove 2's and 4's, permanently
		list= [1, 2, 3, 4, 5, 6, 2, 2, 1]
		assert list.remove(2) == 3 		//remove the third element, and return it
		assert list == [1, 2, 4, 5, 6, 2, 2, 1]

		list= ['a', 'b', 'c', 'b', 'b']
		assert list.remove('c') //remove 'c', and return true because element removed
		assert list.remove('b')
		//remove first 'b', and return true because element removed
		assert ! list.remove('z') //return false because no elements removed
		assert list == ['a', 'b', 'b']

		list= ['a', 2, 'c', 4]
		list.clear()
		assert list == []

		def stack= [1, 2, 4, 6]
		stack << 7
		assert stack == [1, 2, 4, 6, 7]
		assert stack.pop() == 7
		assert stack == [1, 2, 4, 6]

		assert 'a' in ['a', 'b', 'c']
		assert ['a', 'b', 'c'].contains('a')
		assert [1, 3, 4].containsAll([1, 4])

		assert [].isEmpty()
		assert [1, 2, 3, 3, 3, 3, 4, 5].count(3) == 4

		assert [1, 2, 4, 6, 8, 10, 12].intersect([1, 3, 6, 9, 12]) == [1, 6, 12]

		assert [1, 2, 3].disjoint( [4, 6, 9])
		assert ! [1, 2, 3].disjoint( [2, 4, 6])
		assert Collections.disjoint( [1, 2, 3], [4, 6, 9]) //alternative method name
	}

	void testCollections06(){
		assert [6, 3, 9, 2, 7, 1, 5].sort() == [1, 2, 3, 5, 6, 7, 9]

		def list= [
			'abc',
			'z',
			'xyzuvw',
			'Hello',
			'321'
		]
		assert list.sort{ it.size() } == [
			'z',
			'abc',
			'321',
			'Hello',
			'xyzuvw'
		]

		def list2= [
			7,
			4,
			-6,
			-1,
			11,
			2,
			3,
			-9,
			5,
			-13
		]
		assert list2.sort{a,b-> a.equals(b)? 0: Math.abs(a)<Math.abs(b)? -1: 1 } ==
		[
			-1,
			2,
			3,
			4,
			5,
			-6,
			7,
			-9,
			11,
			-13
		]
		def mc= [
					compare: {a,b->
						a.equals(b)? 0: Math.abs(a)<Math.abs(b)? -1: 1 }
				] as Comparator
		assert list2.sort(mc) == [
			-1,
			2,
			3,
			4,
			5,
			-6,
			7,
			-9,
			11,
			-13
		]

		def list3= [6, -3, 9, 2, -7, 1, 5]
		Collections.sort(list3)
		assert list3 == [-7, -3, 1, 2, 5, 6, 9]
		Collections.sort(list3, mc)
		assert list3 == [1, 2, -3, 5, 6, -7, 9]

		assert [1, 2, 3]* 3 == [1, 2, 3, 1, 2, 3, 1, 2, 3]
		assert [1, 2, 3].multiply(2) == [1, 2, 3, 1, 2, 3]
		assert Collections.nCopies( 3, 'b' ) == ['b', 'b', 'b']
		//nCopies works differently
		assert Collections.nCopies( 2, [1, 2]) == [
			[1, 2],
			[1, 2]] //not [1,2,1,2]
		assert ['a', 'b', 'c', 'd', 'c', 'd'].indexOf('c') == 2 //index returned
		assert ['a', 'b', 'c', 'd', 'c', 'd'].indexOf('z') == -1
		//index -1 means value not in list
		assert ['a', 'b', 'c', 'd', 'c', 'd'].lastIndexOf('c') == 4

		list= [];
		list2= [];
		[1, 2, 3, 4, 5].each{ list << it*2 }
		assert list == [2, 4, 6, 8, 10]
		[1, 2, 3, 4, 5].eachWithIndex{item, index-> list2 << item * index }
		//closure supplied must have 2 params
		assert list2 == [0, 2, 6, 12, 20]
	}

	void testCollections07(){
		def list, list2, list3
		list= [1, 2, list, 4]
		list2= [1, 2, list2, 4]
		assert list.equals(list2)
		list3= [1, 2, list, 4]
		assert ! list.equals(list3)

		assert 5..8 == [
			5,
			6,
			7,
			8] //includes both values
		assert 5..<8 == [
			5,
			6,
			7] //excludes specified top value
		assert ('a'..'d') == ['a', 'b', 'c', 'd']

		def n=0
		(1..10).each{ n += it }
		assert n == 55

		assert [*3..5]== [3, 4, 5]
		assert [1, *3..5, 7, *9..<12]== [1, 3, 4, 5, 7, 9, 10, 11]

		assert ('a'..'g')[ 3..5 ] == ['d', 'e', 'f']
		assert ('a'..'g').getAt( 3..5 ) == [
			'd',
			'e',
			'f'] //equivalent method name
		assert ('a'..'g')[1, 3, 5, 6] == ['b', 'd', 'f', 'g']
		assert ('a'..'g')[1, *3..5] == ['b', 'd', 'e', 'f']
		assert ('a'..'g')[1, 3..5] == ['b', 'd', 'e', 'f']
		//range in subscript flattened automatically
		assert ('a'..'g')[-5..-2] == ['c', 'd', 'e', 'f']
		assert ('a'..'g').getAt( [1, *3..5]) == ['b', 'd', 'e', 'f']
		//equivalent method name
		assert ('a'..'g').getAt( [1, 3..5]) == ['b', 'd', 'e', 'f']

		list=[1, 2, 3, 4, 5];
		def sl= list.subList(2,4)
		sl[0]= 9 //if we change the sublist...
		assert list == [
			1,
			2,
			9,
			4,
			5] //...backing list changes...
		list[3]= 11
		assert sl == [9, 11] //...and vice versa
		assert ['a', 'b', 'c', 'd', 'e'][1..3].indexOf('c') == 1

	}

	void testCollections08(){
		def list = [
			'a',
			'b',
			'c',
			'd',
			'e',
			'f',
			'g'
		]
		list[2..3] = 'z'
		assert list == [
			'a',
			'b',
			'z',
			'e',
			'f',
			'g'] //swap two entries for one
		list[4..4]= ['u', 'v']
		assert list == [
			'a',
			'b',
			'z',
			'e',
			'u',
			'v',
			'g'] //swap one entry for two
		list= [
			'a',
			'b',
			'z',
			'e',
			'u',
			'v',
			'g'
		]
		list[0..1]= []
		assert list == [
			'z',
			'e',
			'u',
			'v',
			'g'] //remove entries from index range
		list[1..1]= []
		assert list == [
			'z',
			'u',
			'v',
			'g'] //remove entry at index
		list = [
			'a',
			'b',
			'c',
			'd',
			'e',
			'f',
			'g'
		]
		list.putAt(2..3, 'z')
		assert list == ['a', 'b', 'z', 'e', 'f', 'g']
		list.putAt(4..4, ['u', 'v'])
		assert list == [
			'a',
			'b',
			'z',
			'e',
			'u',
			'v',
			'g'
		]
		list.putAt(1..<3, [])
		assert list == ['a', 'e', 'u', 'v', 'g']
		list.putAt( 0..<0, 'm' ) //
		assert list == ['m', 'a', 'e', 'u', 'v', 'g']
		list.removeRange(1,3) //another method to do similar, means: list[1..<3]= []
		list[1..2].clear()
		assert list == ['m', 'g']
	}

	void testCollections09(){
		assert [1, 2, 3].reverse() == [3, 2, 1]

		def list= ['a', 'b', 'c', 'd', 'e']
		Collections.reverse( list )
		assert list == ['e', 'd', 'c', 'b', 'a']
		use(Collections){ list.reverse() }
		//alternative syntax for null-returning Collections.reverse(List)
		assert list == ['a', 'b', 'c', 'd', 'e']

		def list2= []
		[1, 2, 3, 4, 5].reverseEach{ list2 << it*2 }
		//same as, but more efficient than: [...].reverse().each{...}
		assert list2 == [10, 8, 6, 4, 2]

		assert [1, 2, 3, 4, 5, 6][3..1] == [4, 3, 2]
		//use backwards range to reverse returned sublist

		def list3 = [1, 2, -3, 5, 6, -7, 9]
		def rmc= Collections.reverseOrder()
		Collections.sort(list3, rmc)
		assert list3 == [9, 6, 5, 2, 1, -3, -7]

		def list4 = [1, 2, -3, 5, 6, -7, 9]
		def mc= [
					compare: {a,b->
						a.equals(b)? 0: Math.abs(a)<Math.abs(b)? -1: 1}
				] as Comparator
		def rmc2= Collections.reverseOrder( mc )
		Collections.sort(list4, rmc2)
		assert list4 == [9, -7, 6, 5, -3, 2, 1]

		assert Collections.binarySearch([
			2,
			5,
			6,
			7,
			9,
			11,
			13,
			26,
			31,
			33
		], 26) == 7
		//list must already be sorted
		assert Collections.binarySearch([
			2,
			5,
			6,
			7,
			9,
			11,
			13,
			31,
			33
		], 26) == -8
		//if key not there, give negative of one plus the index before which key
		//would be if it was there

		mc= [
					compare: {a,b->
						a.equals(b)? 0: Math.abs(a)<Math.abs(b)? -1: 1 }
				] as Comparator
		assert Collections.binarySearch([
			2,
			-5,
			-6,
			7,
			9,
			-11,
			13,
			26,
			31,
			-33
		], 26, mc) == 7

		list= [
			'a',
			'b',
			'c',
			'b',
			'b',
			'e',
			'e'
		]
		assert list.removeAll( ['b', 'z'])
		//remove 'b' and 'z', return true because list changed
		assert list == ['a', 'c', 'e', 'e']
		assert ! list.removeAll( ['b', 'z'])
		//return false because list didn't change
		assert list == ['a', 'c', 'e', 'e']
		assert list.retainAll( ['a', 'e'])
		//retain only 'a' and 'e', return true because list changed
		assert list == ['a', 'e', 'e']
		assert ! list.retainAll( ['a', 'e'])
		//retain only 'a' and 'e', return true because list didn't change
		assert list == ['a', 'e', 'e']
	}

	void testCollections10(){
		def list= ['a', 7, 'b', 9, 7, 7, 2.4, 7]
		Collections.replaceAll( list, 7, 55)
		assert list == [
			'a',
			55,
			'b',
			9,
			55,
			55,
			2.4,
			55
		]

		list= ['a', 7, 'b', 9, 7, 7, 2.4, 7]
		use(Collections){ list.replaceAll(7, 55) } //alternative syntax
		assert list == [
			'a',
			55,
			'b',
			9,
			55,
			55,
			2.4,
			55
		]

		list= ['a', 2, null, 4, 'zyx', 2.5]
		use(Collections){ list.fill( 'g' ) } //or: Collections.fill( list, 'g' )
		assert list == ['g', 'g', 'g', 'g', 'g', 'g']

		list= ['a', 'e', 'i', 'o', 'u', 'z']
		use(Collections){ list.swap(2, 4) } //or: Collections.swap(list, 2, 4)
		assert list == ['a', 'e', 'u', 'o', 'i', 'z']

		assert Collections.frequency([
			'a',
			'b',
			'a',
			'c',
			'a',
			'a',
			'd',
			'e'
		], 'a') == 4
		use(Collections){
			assert [
				'a',
				'b',
				'a',
				'c',
				'a',
				'a',
				'd',
				'e'
			].frequency('a') == 4
		}

		list= ['a', 'b', 'c', 'd', 'e']
		Collections.rotate(list, 3)
		assert list == ['c', 'd', 'e', 'a', 'b']
		use(Collections){ list.rotate(-2) }
		assert list == ['e', 'a', 'b', 'c', 'd']

		list= [1, 2, 3, 4, 5]
		Collections.shuffle(list, new Random())
		//we can supply our own random number generator...
		assert list != [1, 2, 3, 4, 5]

		list= [1, 2, 3, 4, 5]
		Collections.shuffle(list) //...or use the default one
		assert list != [1, 2, 3, 4, 5]

		assert [3, 5, 5, 5, 2].unique() == [3, 5, 2]
		def mc= [ compare:
					{a,b->
						a.equals(b) || a.equals(-b)? 0: Math.abs(a)<Math.abs(b)? -1: 1 }
				] as Comparator

		assert [3, 5, 5, -5, 2, -7].unique(mc) == [3, 5, 2, -7]
		//remove subsequent items comparator considers equal
		assert [3, 5, 5, -5, 2, -7].unique{a, b->
			a == b || a == -b? 0: Math.abs(a)<Math.abs(b)? -1: 1
		} == [3, 5, 2, -7]

		list= [1, 2, 3]
		Collections.copy( list, [9, 8, 7])
		assert list == [
			9,
			8,
			7] //overwrites original data
		Collections.copy( list, [11, 12]) //source list shorter...
		assert list == [
			11,
			12,
			7] //...which leaves remaining entries unchanged
		try{ Collections.copy( list, [21, 22, 23, 24]); assert 0 } //source list too long
		catch(e){ assert e instanceof IndexOutOfBoundsException }

		list= [
			1,
			8,
			8,
			2,
			3,
			7,
			6,
			4,
			6,
			6,
			2,
			3,
			7,
			5
		]
		assert Collections.indexOfSubList( list, [2, 3, 7]) == 3
		assert Collections.lastIndexOfSubList( list, [2, 3, 7]) == 10
		assert Collections.indexOfSubList( list, [9, 9, 13]) == -1

		def s1= [1, 2, 3, 3, 3, 4]as Set,
		s2= [4, 3, 2, 1]as Set,
		s3= new HashSet( [1, 4, 2, 4, 3, 4])
		//assert s1.class == HashSet && s2.class == HashSet
		//the specific kind of set being used
		assert s1 == s2
		assert s1 == s3
		assert s2 == s3
		assert s1.asList() && s1.toList()
		//a choice of two methods to convert a set to a list
		assert ( ([]as Set) << null << null << null ) == [null]as Set
	}

	void testCollections11(){
		def s= [1, 2]as Set
		assert s.add(3)
		assert ! s.add(2)
		assert s.addAll( [5, 4])
		assert ! s.addAll( [5, 4])
		assert s == [1, 2, 3, 5, 4]as Set

		def list = [
			1,
			2,
			7,
			2,
			2,
			4,
			7,
			11,
			5,
			2,
			5
		]
		def uniques= []as Set, dups= []as Set
		list.each{ uniques.add(it) || dups.add(it) }
		uniques.removeAll(dups)
		assert uniques == [1, 4, 11]as Set && dups == [2, 5, 7]as Set

		def s1=[1, 2, 3, 4, 5, 6], s2=[4, 5, 6, 7, 8, 9]
		def diff = (s1 as Set) + s2
		def tmp = s1 as Set
		tmp.retainAll(s2)
		diff.removeAll(tmp)
		assert diff == [1, 2, 3, 7, 8, 9]as Set

		list= [3, 2, 3, 3, 1, 7, 5]
		assert new TreeSet(list) == new TreeSet([1, 1, 1, 2, 5, 7, 3, 1])
		assert new TreeSet(list).toList() == list.unique().sort()

		assert new TreeSet(list).first() == list.unique().min()
		assert new TreeSet(list).last() == list.unique().max()

		def c= [ compare:
					{a,b->
						a.equals(b)? 0: Math.abs(a)<Math.abs(b)? -1: 1 }
				] as Comparator
		def ts= new TreeSet( c )
		ts<< 3 << -7 << 9 << -2 << -4
		assert ts == new TreeSet( [-2, 3, -4, -7, 9])
		assert ts.comparator() == c //retrieve the comparator
	}

	void testCollections12(){
		def ss= new TreeSet(['a', 'b', 'c', 'd', 'e'])

		def hs= ss.headSet('c')
		assert hs == new TreeSet(['a', 'b'])
		//return all elements < specified element
		hs.remove('a')
		assert ss == new TreeSet(['b', 'c', 'd', 'e'])
		//headset is simply a view of the data in ss

		def ts= ss.tailSet('c')
		assert ts == new TreeSet(['c', 'd', 'e'])
		//return all elements >= specified element
		ts.remove('d')
		assert ss == new TreeSet(['b', 'c', 'e'])
		//tailset is also a view of data in ss

		def bs= ss.subSet('b','e')
		assert bs == new TreeSet(['b', 'c'])
		//return all elements >= but < specified element
		bs.remove('c')
		assert ss == new TreeSet(['b', 'e'])
		//subset is simply a view of the data in ss

		ss << 'a' << 'd'
		assert hs == new TreeSet(['a', 'b'])
		//if backing sorted set changes, so do range-views
		assert ts == new TreeSet(['d', 'e'])
		assert bs == new TreeSet(['b', 'd'])

		def dic= new TreeSet(
				[
					'aardvark',
					'banana',
					'egghead',
					'encephalograph',
					'flotsam',
					'jamboree']
				)
		assert dic.subSet('banana', 'flotsam').size() == 3
		//incl 'banana' but excl 'flotsam'
		assert dic.subSet('banana', 'flotsam\0').size() == 4 //incl both
		assert dic.subSet('banana\0', 'flotsam').size() == 2 //excl both
		dic.subSet('e', 'f').clear()
		assert dic == new TreeSet(
		[
			'aardvark',
			'banana',
			'flotsam',
			'jamboree']
		)//clear all words beginning with 'e'
		
		def imList= ['a', 'b', 'c'].asImmutable()
		try{ imList<< 'd'; assert 0 }
		catch(e){ assert e instanceof UnsupportedOperationException }
		
		imList= Collections.unmodifiableList( ['a', 'b', 'c'] ) //alternative way
		try{ imList<< 'd'; assert 0 }
		catch(e){ assert e instanceof UnsupportedOperationException }
		
		def imSet= (['a', 'b', 'c'] as Set).asImmutable()
		try{ imSet<< 'd'; assert 0 }
		catch(e){ assert e instanceof UnsupportedOperationException }
		
		imSet= Collections.unmodifiableSet( ['a', 'b', 'c'] as Set ) //alternative way
		try{ imSet<< 'd'; assert 0 }
		catch(e){ assert e instanceof UnsupportedOperationException }
		
		def imSortedSet= ( new TreeSet(['a', 'b', 'c']) ).asImmutable()
		try{ imSortedSet<< 'd'; assert 0 }
		catch(e){ assert e instanceof UnsupportedOperationException }
		
		imSortedSet= Collections.unmodifiableSortedSet( new TreeSet(['a', 'b', 'c']) )
																//alternative way
		try{ imSortedSet<< 'd'; assert 0 }
		catch(e){ assert e instanceof UnsupportedOperationException }
		
		def list= Collections.emptyList()
		assert list == []
		try{ list<< 'a'; assert 0 }
		catch(e){ assert e instanceof UnsupportedOperationException }
		list= Collections.EMPTY_LIST
		assert list == []
		try{ list<< 'a'; assert 0 }
		catch(e){ assert e instanceof UnsupportedOperationException }
		
		def set= Collections.emptySet()
		assert set == [] as Set
		try{ set<< 'a'; assert 0 }
		catch(e){ assert e instanceof UnsupportedOperationException }
		set= Collections.EMPTY_SET
		assert set == [] as Set
		try{ set<< 'a'; assert 0 }
		catch(e){ assert e instanceof UnsupportedOperationException }
		
		def singList= Collections.singletonList('a')
		assert singList == ['a']
		try{ singList<< 'b'; assert 0 }
		catch(e){ assert e instanceof UnsupportedOperationException }
		
		def singSet = Collections.singleton('a')
		assert singSet == ['a'] as Set
		try{ singSet<< 'b'; assert 0 }
		catch(e){ assert e instanceof UnsupportedOperationException }

	}


}
