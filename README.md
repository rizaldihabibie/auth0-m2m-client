# auth0-m2m-client
auth0-m2m-client is swing application as client of springboot-server-auth2-authorization.<br/>
Application flow :
1. User must login to get access token from auth0. User needs to provide client id, client secret and audience.
2. Application request access_token from auth0. This access token will be included when application make a request to server
3. If request success, app will make a service call to http://bot.whatismyipaddress.com to get app host public IP
4. Application open main page
5. If user click Submit Button, app will submit detected public IP to server
6. Application will show server response in main page.

## How to run JAR file
Use this command to run application using default setting (server must be run on localhost:8080)<br/>
`java -jar ReportClientApp-1.0-SNAPSHOT-jar-with-dependencies.jar'`<br/>
If server run on another host and port, use this command <br/>
`java -jar ReportClientApp-1.0-SNAPSHOT-jar-with-dependencies.jar 'http://HOST:PORT'`
