#!/bin/bash
jarFile=urule-console.jar
if [ ! -z "$(ps -ef|grep $jarFile|grep java)" ] ; then
  ps -ef|grep $jarFile|grep 'java'|awk '{print $2}'|xargs kill -9
fi
profile=215
if [ ! -z "$1" ] ; then
    profile=$1
fi
echo $profile
nohup java -jar -Dspring.profiles.active=$profile urule-console.jar > run.log 2>&1 &
