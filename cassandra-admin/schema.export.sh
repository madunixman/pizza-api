#! /bin/bash -x

cd $(dirname $0)
source cassandra-env.sh

${CASSANDRA_HOME}/bin/cqlsh -e "DESC KEYSPACE ${KEYSPACE}" > data/schema.${KEYSPACE}.cql
