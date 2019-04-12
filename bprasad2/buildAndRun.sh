#!/bin/sh
mvn clean package && docker build -t finalProject/bprasad2 .
docker rm -f bprasad2 || true && docker run -d -p 8080:8080 -p 4848:4848 --name bprasad2 finalProject/bprasad2