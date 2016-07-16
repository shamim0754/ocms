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
### Run App ###
mvn clean tomcat7:deploy
### Browser App ###
http://localhost:8282/ocms/