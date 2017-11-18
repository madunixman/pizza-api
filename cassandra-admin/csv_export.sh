#! /bin/bash -x

cd $(dirname $0)
source cassandra-env.sh

${CASSANDRA_HOME}/bin/cqlsh -e "COPY restaurants.restaurant TO 'restaurant.csv';"
