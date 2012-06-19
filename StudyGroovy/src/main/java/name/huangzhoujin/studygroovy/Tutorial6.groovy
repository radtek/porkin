package name.huangzhoujin.studygroovy

import groovy.sql.Sql

class Tutorial6 {

	static main(args) {
		def piEstimate = 3
		println("Pi is about ${piEstimate}")
		println("Pi is closer to ${355/113}")

		def sql = Sql.newInstance( 'jdbc:mysql://localhost/register', 'register','a123456b', 'com.mysql.jdbc.Driver' )
		sql.eachRow('select * from t_reg_area order by area_id' ){ println "$it.area_id -- ${it.area_name} --" }
	}
}
