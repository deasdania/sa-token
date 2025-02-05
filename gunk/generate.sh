#!/bin/bash

# Install gunk tools dependencies
echo "Installing Gunk tool dependencies..."
go install $(go list -tags tools -f '{{ join .Imports "\n" }}' tools.go)
if [ $? -ne 0 ]; then
  echo -e "${RED}Error: Failed to install Gunk tool dependencies.${NC}"
  exit 1
fi

RED='\033[0;31m'
GREEN='\033[0;32m'
NC='\033[0m'

if [ -z "$GRPC_JAVA_DEST_ROOT_PATH" ]; then
  echo -e "${RED}Error: GRPC_JAVA_DEST_ROOT_PATH environment variable is not set.${NC}"
  exit 1
fi

# remove the trailing slash
GRPC_JAVA_DEST_ROOT_PATH=$(echo "$GRPC_JAVA_DEST_ROOT_PATH" | sed 's:/*$::')
GRPC_JAVA_DEST_PATH=$GRPC_JAVA_DEST_ROOT_PATH/src
echo "Formatting Gunk files..."
gunk format ./...
echo -e "${GREEN}Gunk files formatted successfully.${NC}"

echo "Generating gRPC code..."
gunk generate ./...
echo -e "${GREEN}gRPC code generated successfully.${NC}"

GRPC_JAVA_SOURCE_DIR="./src"
if [ ! -d "$GRPC_JAVA_SOURCE_DIR" ]; then
  echo -e "${RED}Error: Java source directory not found at $GRPC_JAVA_SOURCE_DIR.${NC}"
  exit 1
fi


# Define the source and destination paths
GRPC_JAVA_SOURCE_DIR="src/main/java/com/example/gunk/v1/helper"  # Source directory for generated files
GRPC_JAVA_DEST_PATH="../src/main/java/com/example/gunk/v1/helper"              # Destination directory

# Create the destination directory if it doesn't exist
echo "Moving Java files to $GRPC_JAVA_DEST_PATH"
mkdir -p "$GRPC_JAVA_DEST_PATH"

# Move the generated files using rsync
rsync -a --delete --remove-source-files "$GRPC_JAVA_SOURCE_DIR/" "$GRPC_JAVA_DEST_PATH/"

# Clean up empty directories in the source path
find "$GRPC_JAVA_SOURCE_DIR" -type d -empty -delete

# Check if rsync was successful and print an appropriate message
# if [ $? -eq 0 ]; then
#   echo -e "\033[32mJava files successfully moved to $GRPC_JAVA_DEST_PATH/\033[0m"
# else
#   echo -e "\033[31mError: Failed to move Java files.\033[0m"
#   exit 1
# fi