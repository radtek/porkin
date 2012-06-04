<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page session="true"%>
<%@ include file="/common/taglibs.jsp"%>
<!doctype html>
<!--[if lt IE 7 ]> <html lang="en" class="no-js ie6"> <![endif]-->
<!--[if IE 7 ]>    <html lang="en" class="no-js ie7"> <![endif]-->
<!--[if IE 8 ]>    <html lang="en" class="no-js ie8"> <![endif]-->
<!--[if IE 9 ]>    <html lang="en" class="no-js ie9"> <![endif]-->
<!--[if (gt IE 9)|!(IE)]><!-->
<html lang="en" class="no-js">
<!--<![endif]-->
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<title>Create Race</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">

<link rel="shortcut icon" href="${ctx}/images/favicon.ico"
	type="image/x-icon">
<link rel="apple-touch-icon" href="${ctx}/images/apple-touch-icon.png">
<link rel="apple-touch-icon" sizes="114x114"
	href="${ctx}/images/apple-touch-icon-retina.png">
<link rel="stylesheet" href="${ctx}/styles/main.css" type="text/css">
<link rel="stylesheet" href="${ctx}/styles/mobile.css" type="text/css">

<meta name="layout" content="main">




</head>
<body>
	<div id="grailsLogo" role="banner">
		<a href="http://grails.org"><img
			src="${ctx}/images/grails_logo.png" alt="Grails" /></a>
	</div>


	<a href="#create-race" class="skip" tabindex="-1">Skip to
		content&hellip;</a>
<!-- 	<div class="nav" role="navigation"> -->
<!-- 		<ul> -->
<!-- 			<li><a class="home" href="/racetrack/">Home</a></li> -->
<!-- 			<li><a href="/racetrack/race/list" class="list">Race List</a></li> -->
<!-- 		</ul> -->
<!-- 	</div> -->

	<div id="create-race" class="content scaffold-create" role="main">
		<h1>欢迎使用网上报名系统</h1>


		<form action="/racetrack/race/save" method="post">
			<fieldset class="form">




				<div class="fieldcontain  required">
					<label for="name"> Name <span class="required-indicator">*</span>

					</label> <input type="text" name="name" required="" value="" id="name" />
				</div>

				<div class="fieldcontain  required">
					<label for="startDateTime"> Start Date Time <span
						class="required-indicator">*</span>
					</label> <input type="hidden" name="startDateTime" value="date.struct" />

					<select name="startDateTime_day" id="startDateTime_day"><option
							value="1">1</option>
						<option value="2">2</option>
						<option value="3">3</option>
						<option value="4" selected="selected">4</option>
						<option value="5">5</option>
						<option value="6">6</option>
						<option value="7">7</option>
						<option value="8">8</option>
						<option value="9">9</option>

						<option value="10">10</option>
						<option value="11">11</option>
						<option value="12">12</option>
						<option value="13">13</option>
						<option value="14">14</option>
						<option value="15">15</option>
						<option value="16">16</option>
						<option value="17">17</option>
						<option value="18">18</option>

						<option value="19">19</option>
						<option value="20">20</option>
						<option value="21">21</option>
						<option value="22">22</option>
						<option value="23">23</option>
						<option value="24">24</option>
						<option value="25">25</option>
						<option value="26">26</option>
						<option value="27">27</option>

						<option value="28">28</option>
						<option value="29">29</option>
						<option value="30">30</option>
						<option value="31">31</option>
					</select> <select name="startDateTime_month" id="startDateTime_month"><option
							value="1">一月</option>
						<option value="2">二月</option>
						<option value="3">三月</option>
						<option value="4">四月</option>

						<option value="5">五月</option>
						<option value="6" selected="selected">六月</option>
						<option value="7">七月</option>
						<option value="8">八月</option>
						<option value="9">九月</option>
						<option value="10">十月</option>
						<option value="11">十一月</option>
						<option value="12">十二月</option>
					</select> <select name="startDateTime_year" id="startDateTime_year"><option
							value="1912">1912</option>
						<option value="1913">1913</option>
						<option value="1914">1914</option>
						<option value="1915">1915</option>
						<option value="1916">1916</option>
						<option value="1917">1917</option>
						<option value="1918">1918</option>
						<option value="1919">1919</option>
						<option value="1920">1920</option>

						<option value="1921">1921</option>
						<option value="1922">1922</option>
						<option value="1923">1923</option>
						<option value="1924">1924</option>
						<option value="1925">1925</option>
						<option value="1926">1926</option>
						<option value="1927">1927</option>
						<option value="1928">1928</option>
						<option value="1929">1929</option>

						<option value="1930">1930</option>
						<option value="1931">1931</option>
						<option value="1932">1932</option>
						<option value="1933">1933</option>
						<option value="1934">1934</option>
						<option value="1935">1935</option>
						<option value="1936">1936</option>
						<option value="1937">1937</option>
						<option value="1938">1938</option>

						<option value="1939">1939</option>
						<option value="1940">1940</option>
						<option value="1941">1941</option>
						<option value="1942">1942</option>
						<option value="1943">1943</option>
						<option value="1944">1944</option>
						<option value="1945">1945</option>
						<option value="1946">1946</option>
						<option value="1947">1947</option>

						<option value="1948">1948</option>
						<option value="1949">1949</option>
						<option value="1950">1950</option>
						<option value="1951">1951</option>
						<option value="1952">1952</option>
						<option value="1953">1953</option>
						<option value="1954">1954</option>
						<option value="1955">1955</option>
						<option value="1956">1956</option>

						<option value="1957">1957</option>
						<option value="1958">1958</option>
						<option value="1959">1959</option>
						<option value="1960">1960</option>
						<option value="1961">1961</option>
						<option value="1962">1962</option>
						<option value="1963">1963</option>
						<option value="1964">1964</option>
						<option value="1965">1965</option>

						<option value="1966">1966</option>
						<option value="1967">1967</option>
						<option value="1968">1968</option>
						<option value="1969">1969</option>
						<option value="1970">1970</option>
						<option value="1971">1971</option>
						<option value="1972">1972</option>
						<option value="1973">1973</option>
						<option value="1974">1974</option>

						<option value="1975">1975</option>
						<option value="1976">1976</option>
						<option value="1977">1977</option>
						<option value="1978">1978</option>
						<option value="1979">1979</option>
						<option value="1980">1980</option>
						<option value="1981">1981</option>
						<option value="1982">1982</option>
						<option value="1983">1983</option>

						<option value="1984">1984</option>
						<option value="1985">1985</option>
						<option value="1986">1986</option>
						<option value="1987">1987</option>
						<option value="1988">1988</option>
						<option value="1989">1989</option>
						<option value="1990">1990</option>
						<option value="1991">1991</option>
						<option value="1992">1992</option>

						<option value="1993">1993</option>
						<option value="1994">1994</option>
						<option value="1995">1995</option>
						<option value="1996">1996</option>
						<option value="1997">1997</option>
						<option value="1998">1998</option>
						<option value="1999">1999</option>
						<option value="2000">2000</option>
						<option value="2001">2001</option>

						<option value="2002">2002</option>
						<option value="2003">2003</option>
						<option value="2004">2004</option>
						<option value="2005">2005</option>
						<option value="2006">2006</option>
						<option value="2007">2007</option>
						<option value="2008">2008</option>
						<option value="2009">2009</option>
						<option value="2010">2010</option>

						<option value="2011">2011</option>
						<option value="2012" selected="selected">2012</option>
						<option value="2013">2013</option>
						<option value="2014">2014</option>
						<option value="2015">2015</option>
						<option value="2016">2016</option>
						<option value="2017">2017</option>
						<option value="2018">2018</option>
						<option value="2019">2019</option>

						<option value="2020">2020</option>
						<option value="2021">2021</option>
						<option value="2022">2022</option>
						<option value="2023">2023</option>
						<option value="2024">2024</option>
						<option value="2025">2025</option>
						<option value="2026">2026</option>
						<option value="2027">2027</option>
						<option value="2028">2028</option>

						<option value="2029">2029</option>
						<option value="2030">2030</option>
						<option value="2031">2031</option>
						<option value="2032">2032</option>
						<option value="2033">2033</option>
						<option value="2034">2034</option>
						<option value="2035">2035</option>
						<option value="2036">2036</option>
						<option value="2037">2037</option>

						<option value="2038">2038</option>
						<option value="2039">2039</option>
						<option value="2040">2040</option>
						<option value="2041">2041</option>
						<option value="2042">2042</option>
						<option value="2043">2043</option>
						<option value="2044">2044</option>
						<option value="2045">2045</option>
						<option value="2046">2046</option>

						<option value="2047">2047</option>
						<option value="2048">2048</option>
						<option value="2049">2049</option>
						<option value="2050">2050</option>
						<option value="2051">2051</option>
						<option value="2052">2052</option>
						<option value="2053">2053</option>
						<option value="2054">2054</option>
						<option value="2055">2055</option>

						<option value="2056">2056</option>
						<option value="2057">2057</option>
						<option value="2058">2058</option>
						<option value="2059">2059</option>
						<option value="2060">2060</option>
						<option value="2061">2061</option>
						<option value="2062">2062</option>
						<option value="2063">2063</option>
						<option value="2064">2064</option>

						<option value="2065">2065</option>
						<option value="2066">2066</option>
						<option value="2067">2067</option>
						<option value="2068">2068</option>
						<option value="2069">2069</option>
						<option value="2070">2070</option>
						<option value="2071">2071</option>
						<option value="2072">2072</option>
						<option value="2073">2073</option>

						<option value="2074">2074</option>
						<option value="2075">2075</option>
						<option value="2076">2076</option>
						<option value="2077">2077</option>
						<option value="2078">2078</option>
						<option value="2079">2079</option>
						<option value="2080">2080</option>
						<option value="2081">2081</option>
						<option value="2082">2082</option>

						<option value="2083">2083</option>
						<option value="2084">2084</option>
						<option value="2085">2085</option>
						<option value="2086">2086</option>
						<option value="2087">2087</option>
						<option value="2088">2088</option>
						<option value="2089">2089</option>
						<option value="2090">2090</option>
						<option value="2091">2091</option>

						<option value="2092">2092</option>
						<option value="2093">2093</option>
						<option value="2094">2094</option>
						<option value="2095">2095</option>
						<option value="2096">2096</option>
						<option value="2097">2097</option>
						<option value="2098">2098</option>
						<option value="2099">2099</option>
						<option value="2100">2100</option>

						<option value="2101">2101</option>
						<option value="2102">2102</option>
						<option value="2103">2103</option>
						<option value="2104">2104</option>
						<option value="2105">2105</option>
						<option value="2106">2106</option>
						<option value="2107">2107</option>
						<option value="2108">2108</option>
						<option value="2109">2109</option>

						<option value="2110">2110</option>
						<option value="2111">2111</option>
						<option value="2112">2112</option>
					</select>

				</div>

				<div class="fieldcontain  required">
					<label for="city"> City <span class="required-indicator">*</span>

					</label> <input type="text" name="city" required="" value="" id="city" />
				</div>

				<div class="fieldcontain  required">
					<label for="state"> State <span class="required-indicator">*</span>
					</label> <select name="state" required="" id="state">

						<option value="GA">GA</option>
						<option value="NC">NC</option>
						<option value="SC">SC</option>
						<option value="VA">VA</option>
					</select>
				</div>

				<div class="fieldcontain  required">
					<label for="distance"> Distance <span
						class="required-indicator">*</span>

					</label> <input type="number" name="distance" step="any" min="3.0"
						max="100.0" required="" value="" id="distance" />
				</div>

				<div class="fieldcontain  required">
					<label for="cost"> Cost <span class="required-indicator">*</span>
					</label> <input type="number" name="cost" step="any" min="0.0" max="999.99"
						required="" value="" id="cost" />

				</div>

				<div class="fieldcontain  required">
					<label for="maxRunners"> Max Runners <span
						class="required-indicator">*</span>
					</label> <input type="number" name="maxRunners" required="" value="10000"
						id="maxRunners" />
				</div>

				<div class="fieldcontain  ">
					<label for="registrations"> Registrations </label>

					<ul class="one-to-many">

						<li class="add"><a
							href="/racetrack/registration/create?race.id=">Add
								Registration</a></li>
					</ul>

				</div>


			</fieldset>

			<!-- <fieldset class="buttons">
				<input type="submit" name="create" class="save" value="Create"
					id="create" />
			</fieldset> -->
		</form>
	</div>

	<div class="footer" role="contentinfo"></div>
	<div id="spinner" class="spinner" style="display: none;">Loading&hellip;</div>

	<script src="${ctx}/scripts/application.js" type="text/javascript"></script>

</body>
</html>