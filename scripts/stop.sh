#!/usr/bin/env bash
PROJECT_ROOT="/home/ubuntu/toytweet"
JAR_FILE="$PROJECT_ROOT/demo-0.0.1-SNAPSHOT.jar"

DEPLOY_LOG="$PROJECT_ROOT/deploy.log"

TIME_NOW=$(date +%c)# 현재 구동 중인 애플리케이션 PID 확인
CURRENT_PID=$(pgrep -f $JAR_FILE)# 프로세스가 켜져 있으면 종료
if [ -z $CURRENT_PID ]; then
  echo "$TIME_NOW > 현재 실행 중인 애플리케이션이 없습니다." >> $DEPLOY_LOG
else
  echo "$TIME_NOW > 실행 중인 $CURRENT_PID 애플리케이션 종료" >> $DEPLOY_LOG
  kill -15 $CURRENT_PID
fi