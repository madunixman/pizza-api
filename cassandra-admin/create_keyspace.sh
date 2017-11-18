#! /bin/bash -x

cd $(dirname $0)
source cassandra-env.sh

${CASSANDRA_HOME}/bin/cqlsh -e  "create keyspace ${KEYSPACE} with replication = {'class':'SimpleStrategy','replication_factor':1};"
