# jms2-test
Testing some of the JMS 2.0 features


## To start in Open Liberty

`mvn clean install -Dliberty`

## To start in Wildfly

`mvn clean install -Dwildfly`

Both will start the server in the foreground (as part of the maven build)

### To test
Then hit this URL (GET) to create a message on the queue

`wget localhost:8080/jms2-test/api`

That should print out in the log:

`JMS: [Hello world]`