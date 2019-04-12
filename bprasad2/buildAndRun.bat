@echo off
call mvn clean package
call docker build -t finalProject/bprasad2 .
call docker rm -f bprasad2
call docker run -d -p 8080:8080 -p 4848:4848 --name bprasad2 finalProject/bprasad2