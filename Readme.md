
# Project Setup and Usage

## Build the Project

To build the Maven project with Java version 1.8, run the following command:

```bash
mvn clean install -Djava.version=1.8
```
Set Environment Variable
Before running the gRPC commands, set the root path for the gRPC Java destination:

```bash
export GRPC_JAVA_DEST_ROOT_PATH="./"
```
# gRPC Commands

## Login to the gRPC Service
To log in to the gRPC service, use the following command. Replace the login_id and username with your actual credentials:

```bash
grpcurl --plaintext -d '{"login_id": "12", "username": "dea"}' localhost:9090 helper.AuthHelperService.Login
```
## Validate the Token
After logging in, you can validate the token using the command below. Replace the token value with the actual token received from the login response:

```bash
grpcurl --plaintext -d '{"token": "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJsb2dpblR5cGUiOiJsb2dpbiIsImxvZ2luSWQiOjEyLCJyblN0ciI6IkFKN0xvWkpVY1lHT3ltamZSSklReTNOeXRaMzZEbE1xIn0.UBEQGSF4_yLtad1iw31Se2atuAWXbQ_1t_7uJ5PvR1A"}' localhost:9090 helper.AuthHelperService.Validate
```

## Logout
```bash
grpcurl --plaintext -d '{"token": "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJsb2dpblR5cGUiOiJsb2dpbiIsImxvZ2luSWQiOjEyLCJyblN0ciI6IkFKN0xvWkpVY1lHT3ltamZSSklReTNOeXRaMzZEbE1xIn0.UBEQGSF4_yLtad1iw31Se2atuAWXbQ_1t_7uJ5PvR1A"}' localhost:9090 helper.AuthHelperService.Logout
```

## Notes

Ensure that your gRPC server is running on localhost:9090 before executing the commands.
The --plaintext flag is used to indicate that the connection is not encrypted. If your server requires TLS, you will need to adjust the command accordingly.

### Instructions for Use

- Copy the above script and paste it into your project's README file.
- Adjust any specific details (like the token or service names) as necessary for your application.
- Ensure that the commands are formatted correctly in your Markdown file for better readability. 

This structured format will help users understand how to build the project and interact with the gRPC service effectively.