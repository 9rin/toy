#!/usr/bin/env bash

PROJECT_ROOT="/home/ubuntu/toytweet"
JAR_PATH="$PROJECT_ROOT/demo-0.0.1-SNAPSHOT.jar"
DEPLOY_LOG="$PROJECT_ROOT/deploy.log"

echo "$(date +%c) > JAR 직접 실행 (포그라운드 모드)" >> $DEPLOY_LOG

# ✅ 백그라운드 실행 없이 직접 실행
java -jar -Dspring.config.location=$PROJECT_ROOT/application.yml $JAR_PATH
