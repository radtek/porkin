package name.huangzhoujin.studygroovy;

import groovy.util.GroovyTestCase;

class JN1035Test extends GroovyTestCase {

	void testMaps01(){
		def map= ['id':'FX-11', 'name':'Radish', 'no':1234, 99:'Y']
		//keys can be of any type, and mixed together; so can values
		assert map == ['name':'Radish', 'id':'FX-11', 99:'Y', 'no':1234]
		//order of keys irrelevant
		assert map.size() == 4
		assert [1:'a', 2:'b', 1:'c' ] == [1:'c', 2:'b'] //keys unique

		def map2= [
					'id': 'FX-17',
					name: 'Turnip', //string-keys that are valid identifiers need not be quoted
					99: 123, //any data can be a key
					(-97): 987, //keys with complex syntax must be parenthesized
					"tail's": true, //trailing comma OK
				]

		assert map2.id == 'FX-17'
		//we can use field syntax for keys that are valid identifiers
		assert map2['id'] == 'FX-17' //we can always use subscript syntax
		assert map2.getAt('id') == 'FX-17' //some alternative method names
		assert map2.get('id') == 'FX-17'
		assert map2['address'] == null //if key doesn't exist in map
		assert map2.get('address', 'No fixed abode') == 'No fixed abode'
		//default value for non-existent keys

		assert map2.class == null
		//field syntax always refers to value of key, even if it doesn't exist
		//use getClass() instead of class for maps...
		assert map2.getClass() == LinkedHashMap //the kind of Map being used

		assert map2."tail's" == true
		//string-keys that aren't valid identifiers used as field by quoting them
		assert ! map2.'99' && ! map2.'-97' //doesn't work for numbers, though

		map2.name = 'Potato'
		map2[-107] = 'washed, but not peeled'
		map2.putAt('alias', 'Spud')
		//different alternative method names when assigning value
		map2.put('address', 'underground')
		assert map2.name == 'Potato' && map2[-107] == 'washed, but not peeled' &&
		map2.alias == 'Spud' && map2.address == 'underground'
		assert map2 == [ id: 'FX-17', name: 'Potato', alias: 'Spud',
			address: 'underground', 99: 123, (-97): 987,
			(-107): 'washed, but not peeled', "tail's": true ]

		def id= 'address'
		def map3= [id: 11, (id): 22]
		//if we want a variable's value to become the key, we parenthesize it
		assert map3 == [id: 11, address: 22]

		def map4= [:]
		map4[ 1 ]= 'a'
		map4[ 2 ]= 'b'
		map4[ true ]= 'p' //we can use boolean values as a key
		map4[ false ]= 'q'
		map4[ null ]= 'x' //we can also use null as a key
		map4[ 'null' ]= 'z'
		assert map4 == [1:'a', 2:'b', (true):'p', (false):'q', (null):'x', 'null':'z' ]

		def foo = "test"
		map =  [(foo):"bar"]

		println map // will output ["test":"bar"]
		map = [foo:"bar"]
		println map // will output ["foo":"bar"]??

		def p= new StringBuffer()
		[1:'a', 2:'b', 3:'c'].each{ p << it.key +': '+ it.value +'; ' }
		//we supply a closure with either 1 param...
		assert p.toString() == '1: a; 2: b; 3: c; '

		def q= new StringBuffer()
		[1:'a', 2:'b', 3:'c'].each{ k, v-> q << k +': '+ v +'; ' } //...or 2 params
		assert q.toString() == '1: a; 2: b; 3: c; '

		def r= new StringBuffer()
		[1:'a', 2:'b', 3:'c'].eachWithIndex{ it, i->
			//eachIndex() always takes 2 params
			r << it.key +'('+ i +'): '+ it.value +'; '
		}
		assert r.toString() == '1(0): a; 2(1): b; 3(2): c; '

		assert [:].isEmpty()
		assert ! [1:'a', 2:'b'].isEmpty()
		assert [1:'a', 2:'b'].containsKey(2)
		assert ! [1:'a', 2:'b'].containsKey(4)
		assert [1:'a', 2:'b'].containsValue('b')
		assert ! [1:'a', 2:'b'].containsValue('z')

		def m= [1:'a', 2:'b']
		m.clear()
		assert m == [:]

		def defaults= [1:'a', 2:'b', 3:'c', 4:'d'], overrides= [2:'z', 5:'x', 13:'x']
		def result= new HashMap(defaults)
		result.putAll(overrides)
		assert result == [1:'a', 2:'z', 3:'c', 4:'d', 5:'x', 13:'x']
		result.remove(2)
		assert result == [1:'a', 3:'c', 4:'d', 5:'x', 13:'x']
		result.remove(2)
		assert result == [1:'a', 3:'c', 4:'d', 5:'x', 13:'x']

		def m2= [1:'a', 2:'b', 3:'c']

		def es=m2.entrySet()
		es.each{
			assert it.key in [1, 2, 3]
			assert it.value in ['a', 'b', 'c']
			it.value *= 3 //change value in entry set...
		}
		assert m2 == [1:'aaa', 2:'bbb', 3:'ccc'] //...and backing map IS updated

		def ks= m2.keySet()
		assert ks == [1, 2, 3]as Set
		ks.each{ it *= 2 } //change key...
		assert m2 == [1:'aaa', 2:'bbb', 3:'ccc'] //...but backing map NOT updated
		ks.remove( 2 ) //remove key...
		assert m2 == [1:'aaa', 3:'ccc'] //...and backing map IS updated

		def vals= m2.values()
		assert vals.toList() == ['aaa', 'ccc']
		vals.each{ it = it+'z' } //change value...
		assert m2 == [1:'aaa', 3:'ccc'] //...but backing map NOT updated
		vals.remove( 'aaa' ) //remove value...
		assert m2 == [3:'ccc'] //...and backing map IS updated

		vals.clear() //clear values...
		assert m2 == [:] //...and backing map IS updated

		assert es.is( m2.entrySet() ) //same instance always returned
		assert ks.is( m2.keySet() )
		assert vals.is( m2.values() )
	}

	void testMaps02(){
		def m1= [1:'a', 3:'c', 5:'e'], m2= [1:'a', 5:'e']
		assert m1.entrySet().containsAll(m2.entrySet())
		//true if m1 contains all of m2's mappings
		def m3= [1:'g', 5:'z', 3:'x']
		m1.keySet().equals(m3.keySet()) //true if maps contain mappings for same keys

		def m= [1:'a', 2:'b', 3:'c', 4:'d', 5:'e']
		m.keySet().retainAll( [2, 3, 4]as Set )
		assert m == [2:'b', 3:'c', 4:'d']
		m.values().removeAll( ['c', 'd', 'e']as Set )
		assert m == [2:'b']

	}

	void testMaps03(){
		def m= [1:'a', 2:'b', 3:'c', 4:'d', 5:'e']
		//assert [86: m, 99: 'end'].clone()[86].is( m ) //clone() makes a shallow copy

		def c= []
		def d= [
			'a',
			'bb',
			'ccc',
			'dddd',
			'eeeee'
		]
		assert m.collect{ it.value * it.key } == d
		assert m.collect(c){ it.value * it.key } == d
		assert c == d

		assert m.findAll{ it.key == 2 || it.value == 'e' } == [2:'b', 5:'e']
		def me= m.find{ it.key % 2 == 0 }
		assert [me.key, me.value]in [[2, 'b'], [4, 'd']]

		//assert m.toMapString() == '[1:"a", 2:"b", 3:"c", 4:"d", 5:"e"]'

		def sm= m.subMap( [2, 3, 4])
		sm[3]= 'z'
		assert sm == [2:'b', 3:'z', 4:'d']
		assert m == [1:'a', 2:'b', 3:'c', 4:'d', 5:'e'] //backing map is not modified

		assert m.every{ it.value.size() == 1 }
		assert m.any{ it.key % 4 == 0 }

		def family = [dad:"John" , mom:"Jane", son:"John"]
		def val = "John"

		assert family.find{it.value == "John"}?.key == "dad"
		//or
		assert family.find{it.value == val}?.key == "dad"

		def retVal = []
		family.findAll{it.value == val}.each{retVal << it?.key}

		assert retVal == ["dad", "son"]

		assert family.findAll{it.value == val} == ["son":"John", "dad":"John"]
		//or
		def returnValue = family.findAll{it.value == val}
		assert returnValue == ["son":"John", "dad":"John"]

		assert ['a', 7, 'b', [2, 3]].groupBy{ it.class } == [
			(String.class): ['a', 'b'],
			(Integer.class): [7],
			(ArrayList.class): [[2, 3]]]

		assert [
			[name:'Clark', city:'London'],
			[name:'Sharma', city:'London'],
			[name:'Maradona', city:'LA'],
			[name:'Zhang', city:'HK'],
			[name:'Ali', city: 'HK'],
			[name:'Liu', city:'HK'],
		].groupBy{ it.city } == [
			London: [
				[name:'Clark', city:'London'],
				[name:'Sharma', city:'London']
			],
			LA: [
				[name:'Maradona', city:'LA']
			],
			HK: [
				[name:'Zhang', city:'HK'],
				[name:'Ali', city: 'HK'],
				[name:'Liu', city:'HK']
			],
		]

		assert ('The quick brown fox jumps over the lazy dog'.toList()*.
		toLowerCase() - ' ').
		findAll{ it in 'aeiou'.toList() }.
		//emulate SQL's WHERE clause with findAll() method
		groupBy{ it }.
		//emulate GROUP BY clause with groupBy() method
		findAll{ it.value.size() > 1 }.
		//emulate HAVING clause with findAll() method after the groupBy() one
		entrySet().sort{ it.key }.reverse().
		//emulate ORDER BY clause with sort() and reverse() methods
		collect{ "$it.key:${it.value.size()}" }.join(', ') == 'u:2, o:4, e:3'
	}

	void testMaps04(){
		def dogLetters= ('The quick brown fox jumps over the lazy dog'.toList()*.
				toLowerCase() - ' '),
		jugLetters= ('Pack my box with five dozen liquor jugs'.toList()*.
				toLowerCase() - ' ')
		assert dogLetters.groupBy{ it }.
		findAll{   it.value.size() > jugLetters.groupBy{ it }[ it.key ].size()   }.
		entrySet().sort{it.key}.collect{ "$it.key:${it.value.size()}" }.join(', ') ==
		'e:3, h:2, o:4, r:2, t:2'

		def map1= new HashMap() //uses initial capacity of 16 and load factor of 0.75
		def map2= new HashMap(25) //uses load factor of 0.75
		def map3= new HashMap(25, 0.8f)
		def map4= [:] //the shortcut syntax

		def set1= new HashSet() //uses initial capacity of 16 and load factor of 0.75
		def set2= new HashSet(25) //uses load factor of 0.75
		def set3= new HashSet(25, 0.8f)
		def set4= Collections.newSetFromMap( [:] )
		//we can supply our own empty map for the implementation

		def map= [3:'c', 2:'d' ,1:'e', 5:'a', 4:'b'], tm= new TreeMap(map)
		assert tm.firstKey() == map.keySet().min() && tm.firstKey() == 1
		assert tm.lastKey() == map.keySet().max() && tm.lastKey() == 5
		assert tm.findIndexOf{ it.key==4 } == 3

		def c= [ compare:
					{a,b->
						a.equals(b)? 0: Math.abs(a)<Math.abs(b)? -1: 1 }
				] as Comparator

		tm= new TreeMap( c )
		tm[3]= 'a'; tm[-7]= 'b'; tm[9]= 'c'; tm[-2]= 'd'; tm[-4]= 'e'
		assert tm == new TreeMap( [(-2):'d', 3:'a', (-4):'e', (-7):'b', 9:'c'] )
		assert tm.comparator() == c //retrieve the comparator

		def tm2= new TreeMap( tm ) //use same map entries and comparator
		assert tm2.comparator() == c

		def tm3= new TreeMap( tm as HashMap )
		//special syntax to use same map entries but default comparator only
		assert tm3.comparator() == null
	}
}
