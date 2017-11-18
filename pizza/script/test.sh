#! /bin/bash -x

AS_PORT=18080

ENDPOINT=http://127.0.0.1:${AS_PORT}/json/items/post

curl -H "Content-Type: application/json" \
        --data  '{"a":"aaa-string", "b":"bbb-string"}' \
        ${ENDPOINT}
