spring-session [![build](https://travis-ci.org/daggerok/spring-session.svg?branch=master)](https://travis-ci.org/daggerok/spring-session)
==============

1. download sources of example:

`$ git clone https://github.com/daggerok/spring-session-demo.git`

2. install and run redis-server (see http://redis.io/topics/quickstart):

```bash
docker-compose up -d
```

3. build and run application:

```bash
$ gradle clean build bootRun # if you have gradle
```

4. now you can get session uid:

```bash
open http://localhost:8080/session/get
```

5. do same a few times and you will have same uid
6. to remove existed sessions from redis folow next commands:

```
$ $REDIS_HOME/src/redis-cli
> FLUSHALL
```

7. now you can refresh opened page to get new session uid
8. if you want to see all sessions, use select-all query in redis-cli:

`> keys *`

have fun with spring-session :)
