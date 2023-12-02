#!/bin/bash

# Check if both problem num and language are provided
if [ -z "$1" ] || [ -z "$2" ]; then
  echo "Usage: $0 <ProblemNum> <Language>"
  exit 1
fi

problem_num="$1"
language="$2"

# Check if the specified language is valid
case "$language" in
  "java" | "go" | "python" | "javascript" | "bash")
    ;;
  *)
    echo "Invalid language. Supported languages: java, go, python, javascript, bash."
    exit 1
    ;;
esac

# Create a new file for the specified language
new_file="${language}/${problem_num}.${language}"
touch "$new_file"

echo "New solution file created for $problem_num in $language."

# Open the new file in Visual Studio Code
code "$new_file"