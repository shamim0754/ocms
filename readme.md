# README #



### Installation Step ###
1. Install jdk 7 or 8 [see guide](https://java.com/en/download/help/windows_manual_download.xml)
	* Setup environment variables:
	 JAVA_HOME & attach JAVA_HOME to PATH Variable [see guide](http://www.javatpoint.com/how-to-set-path-in-java)
2. Install maven [see guide](http://www.mkyong.com/maven/how-to-install-maven-in-windows/)
3. download tomcat,extract it & run by clicking startup.bat of bin directory 
[dowanload link](https://tomcat.apache.org/download-80.cgi)
2. Dowaload Oracle 11g express & Install [dowanload link](http://www.oracle.com/technetwork/database/database-technologies/express-edition/downloads/index.html)

### App Setting ###
1.create a oracle user

`create user ocms identified by delta321`
`grant create session to ocms`

Add tomcat user $TOMCAT_HOME/conf/tomcat-users.xml
```xml
<role rolename="manager-gui"/>
  <role rolename="manager"/>
  <role rolename="manager-script"/>
  <user username="maven" password="maven" roles="manager,manager-script"/> 
  <user username="admin" password="delta321" roles="manager-gui,manager,manager-script"/>
```
Change http server port 8080 to 8282 since oracle express use 8080 $TOMCAT_HOME/conf/servers.xml
```xml
<Connector port="8282" protocol="HTTP/1.1"
               connectionTimeout="20000"
               redirectPort="8443" />
```

Add server at servers section in $MAVEN_HOME/conf/settings.xml
```xml
 	<server>
      <id>tomcat</id>
      <username>maven</username>
      <password>maven</password>
    </server>
``` 
###Oracle JDBC ###
We need to install oracle jdbc into maven local repository so that we can use it as a dependency since there is no maven central repository for oracle like mysql

`mvn install:install-file -Dfile=C:\oraclexe\app\oracle\product\11.2.0\server\jdbc\lib\ojdbc6.jar -DgroupId=com.oracle 
-DartifactId=ojdbc6 -Dversion=11.2.0 -Dpackaging=jar`

-Dfile = specify your jdbc location

### Run App ###
mvn clean tomcat7:deploy
### Browser App ###
http://localhost:8282/ocms/