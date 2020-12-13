## run application 

java -XX:StartFlightRecording:filename=recording.jfr,duration=10s -jar target/flightrecorder-0.0.1-SNAPSHOT.jar

spring boot 使用jfr 功能，必须按照FlightRecorderApplication main method 中的实现，需要将FlightRecorderApplicationStartup 加入到ApplicationStartup 中

不然不能获得jfr 的信息

## jdk mission control 

open the record.jfr file with jmc

## run DBB
```
env -u JDK_JAVA_OPTIONS java -XX:NativeMemoryTracking=summary \                  
src/main/java/org/excavator/boot/flightrecorder/DBB.java 20 100     
```