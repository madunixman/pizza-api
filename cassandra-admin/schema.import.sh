#! /bin/bash -x

cd $(dirname $0)
source cassandra-env.sh

${CASSANDRA_HOME}/bin/cqlsh -e "drop schema ${KEYSPACE}"
${CASSANDRA_HOME}/bin/cqlsh -e "source 'data/schema.${KEYSPACE}.cql'"
