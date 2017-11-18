#! /bin/bash -x

cd $(dirname $0)
source cassandra-env.sh

pgrep -u ${LOGNAME} -f cassandra | xargs kill -9
