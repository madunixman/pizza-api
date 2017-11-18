#! /bin/bash -x

AS_PORT=18080

cd $(dirname $0)
cd .. 

mvn clean
mvn jetty:run -Djetty.http.port=${AS_PORT}
