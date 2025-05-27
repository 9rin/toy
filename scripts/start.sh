#!/usr/bin/env bash

PROJECT_ROOT="/home/ubuntu/toytweet"
JAR_SOURCE=$(ls $PROJECT_ROOT/build/libs/*.jar 2>/dev/null | head -n 1)

if [ -z "$JAR_SOURCE" ]; then
  echo "$(date +%c) > JAR 파일을 찾을 수 없습니다. build/libs 폴더 확인 필요." >> $PROJECT_ROOT/deploy.log
  exit 1
fi

JAR_TARGET="$PROJECT_ROOT/demo-0.0.1-SNAPSHOT.jar"
APP_LOG="$PROJECT_ROOT/application.log"
ERROR_LOG="$PROJECT_ROOT/error.log"
DEPLOY_LOG="$PROJECT_ROOT/deploy.log"

TIME_NOW=$(date +%c)

echo "$TIME_NOW > JAR 복사 시작: $JAR_SOURCE -> $JAR_TARGET" >> $DEPLOY_LOG
cp $JAR_SOURCE $JAR_TARGET

echo "$TIME_NOW > JAR 실행 시작" >> $DEPLOY_LOG
nohup java -jar -Dspring.config.location=$PROJECT_ROOT/application.yml $JAR_TARGET > $APP_LOG 2> $ERROR_LOG &

CURRENT_PID=$(pgrep -f $JAR_TARGET)
echo "$TIME_NOW > 실행된 프로세스의 아이디는 $CURRENT_PID 입니다." >> $DEPLOY_LOG
