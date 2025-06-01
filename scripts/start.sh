#!/usr/bin/env bash

PROJECT_ROOT="/home/ubuntu/toytweet"
JAR_PATH="$PROJECT_ROOT/demo-0.0.1-SNAPSHOT.jar"

APP_LOG="$PROJECT_ROOT/application.log"
ERROR_LOG="$PROJECT_ROOT/error.log"
DEPLOY_LOG="$PROJECT_ROOT/deploy.log"

TIME_NOW=$(date +%c)

# ✅ 이전 프로세스 종료
CURRENT_PID=$(pgrep -f $JAR_PATH)

if [ -n "$CURRENT_PID" ]; then
    echo "$TIME_NOW > 실행 중인 애플리케이션을 종료합니다. (PID: $CURRENT_PID)" >> $DEPLOY_LOG
    kill -9 $CURRENT_PID
    sleep 2
fi

# ✅ 새로운 JAR 실행
echo "$TIME_NOW > JAR 실행 시작" >> $DEPLOY_LOG
nohup java -jar -Dspring.config.location=$PROJECT_ROOT/application.yml $JAR_PATH > $APP_LOG 2> $ERROR_LOG &

NEW_PID=$(pgrep -f $JAR_PATH)
echo "$TIME_NOW > 새로 실행된 프로세스의 아이디는 $NEW_PID 입니다." >> $DEPLOY_LOG
