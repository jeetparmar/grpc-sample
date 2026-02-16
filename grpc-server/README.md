# grpc-server

Spring Boot gRPC server example using Protocol Buffers.

## Stack

- Java 25
- Maven Wrapper (`./mvnw`)
- Spring Boot 4
- grpc-spring-boot-starter
- Protobuf + gRPC Java codegen

## Project layout

- `src/main/proto/greet.proto`: gRPC contract
- `src/main/java/com/grps/service/GreetingService.java`: service implementation
- `src/main/resources/application.yml`: gRPC server config

## Service

- gRPC server port: `9090`
- Service: `greet.GreetService`
- RPC: `greet(GreetRequest) returns (GreetResponse)`

Example request:

```json
{
  "name": "Alice"
}
```

Example response:

```json
{
  "message": "Hello Alice 👋 from gRPC"
}
```

## Run

```bash
./mvnw spring-boot:run
```

Or build and run the jar:

```bash
./mvnw clean package
java -jar target/grpc-server-0.0.1-SNAPSHOT.jar
```

## Test with grpcurl

List services:

```bash
grpcurl -plaintext localhost:9090 list
```

Call the greet RPC:

```bash
grpcurl -plaintext \
  -d '{"name":"Alice"}' \
  localhost:9090 greet.GreetService/greet
```

## Test

```bash
./mvnw test
```
