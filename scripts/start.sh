#!/usr/bin/env bash

PROJECT_ROOT="/home/ubuntu/toytweet"
JAR_PATH="$PROJECT_ROOT/demo-0.0.1-SNAPSHOT.jar"

APP_LOG="$PROJECT_ROOT/application.log"
ERROR_LOG="$PROJECT_ROOT/error.log"
DEPLOY_LOG="$PROJECT_ROOT/deploy.log"

TIME_NOW=$(date +%c)

echo "$TIME_NOW > JAR 실행 시작" >> $DEPLOY_LOG
nohup java -jar -Dspring.config.location=$PROJECT_ROOT/application.yml $JAR_PATH > $APP_LOG 2> $ERROR_LOG &

CURRENT_PID=$(pgrep -f $JAR_PATH)
echo "$TIME_NOW > 실행된 프로세스의 아이디는 $CURRENT_PID 입니다." >> $DEPLOY_LOG
