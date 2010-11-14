安装IKAnalyzer
1.将 /digiagent/doc/IKAnalyzer3.2.5Stable_bin.zip解压
2.将IKAnalyzer3.2.5Stable.jar改名为IKAnalyzer.3.2.5.jar
3.使用以下命令将IKAnalyzer安装本地库,注意调整文件路径
	-Dfile=E:\svn\IKAnalyzer3.2.5Stable_bin\IKAnalyzer.3.2.5.jar
mvn install:install-file -DgroupId=org.wltea.analyzer -DartifactId=IKAnalyzer -Dversion=3.2.5 -Dpackaging=jar -Dfile=E:\svn\IKAnalyzer3.2.5Stable_bin\IKAnalyzer.3.2.5.jar