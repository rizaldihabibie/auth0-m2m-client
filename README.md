# auth0-m2m-client
auth0-m2m-client is swing application as client of springboot-server-auth2-authorization.<br/>
Application flow :
1. User must login to get access token from auth0. User needs to provide client id, client secret and audience.
2. Application request access_token from auth0. This access token will be included when application make a request to server
3. If request success, app will make a service call to http://bot.whatismyipaddress.com to get app host public IP
4. Application open main page
5. If user click Submit Button, app will submit detected public IP to server
6. Application will show server response in main page.

## How to build JAR file
### Using Netbeans IDE 11
1. Import project to IDE
2. Right click on project folder root
3. Choose Run Maven -> Goals...
4. In field Goals, fill with `clean compile assembly:single`
5. Click OK
### Using terminal
1. Open the terminal
2. go to project root directory
3. run this comman <br/>
`mvn clean compile assembly:single`
## How to run JAR file
Use this command to run application using default setting (server must be run on localhost:8080)<br/>
`java -jar ReportClientApp-1.0-SNAPSHOT-jar-with-dependencies.jar'`<br/>
If server run on another host and port, use this command <br/>
`java -jar ReportClientApp-1.0-SNAPSHOT-jar-with-dependencies.jar 'http://HOST:PORT'`

## How to run via Docker
1. If jar and Dockerfile is in the same directory, use this command to build Docker image <br/>
`docker build -t IMAGE_NAME .`
2. If jar and Dockerfile is not in ther same directory, use this command <br/>
`docker build -t IMAGE_NAME-f /path/to/Dockerfile .`
4. Run container <br />
`docker run --name demo-server --rm -d IMAGE_NAME http://SERVER_HOST:SERVER_PORT`
<br/>
