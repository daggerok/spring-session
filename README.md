This is a simple spring-session demo project

1. download sources of example:

    ```$ git clone https://github.com/daggerok/spring-session-demo.git```

2. install and run redis-server:

    see http://redis.io/topics/quickstart

3. build and run application:

    ```
    $ gradle clean build bootRun # if you have gradle
    $ ./gradlew clean build bootRun # if you have no gradle
    ```

4. now you can get session uid:

    go to http://localhost:8080/session/get

5. do same a few times and you will have same uid
6. to remove existed sessions from redis folow next commands:

    ```
    $ $REDIS_HOME/src/redis-cli
    > FLUSHALL
    ```

7. now you can refresh opened page to get new session uid
8. if you want to see all sessions, use select-all query in redis-cli:

    ```> keys *```

have fun with spring-session :)

