#!/bin/bash
REDIS_HOST="${REDIS_HOST:-localhost}"
REDIS_PORT="${REDIS_PORT:-6379}"
echo REDIS_HOST: $REDIS_HOST
echo REDIS_PORT: $REDIS_PORT
java -jar /app/todo-manager.jar --spring.redis.host=${REDIS_HOST} --spring.redis.port=${REDIS_PORT}
