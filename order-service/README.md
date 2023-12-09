### Some important commands

1. Start zookeeper-server command  
.\bin\windows\zookeeper-server-start.bat .\config\server.properties

2. Start kafka-serve command  
   .\bin\windows\kafka-server-start.bat .\config\server.properties

3. Start kafka-console-consumer command  
   .\bin\windows\kafka-console-consumer.bat --topic order-topic --from-beginning --bootstrap-server localhost:9092

[follow this link for more details](https://kafka.apache.org/quickstart)