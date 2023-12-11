#!/bin/bash

# Function to extract problem numbers from file names in a folder
get_problem_numbers() {
    find "$1" -type f -name "*.$2" -exec basename {} .$2 \; | grep -E '^[0-9]+$' | sed 's/^0*//'
}

# Get unique problem numbers from each language folder
java_problems=$(get_problem_numbers "java" "java")
go_problems=$(get_problem_numbers "go" "go")
python_problems=$(get_problem_numbers "python" "py")

# Create a superset of unique problems
superset=$(echo -e "$java_problems\n$go_problems\n$python_problems" | sort -n | uniq)

# Initialize README with description
echo "## LeetCode" > README.md
echo "The combined efforts of 3 dudes solving algorithms" >> README.md
echo "" >> README.md

# Input the table header
echo "| Question | Java | Go | Python |" >> README.md
echo "| - | - | - | - |" >> README.md

# Iterate through the superset and generate table rows
for problem in $superset; do
    java_status="X"
    go_status="X"
    python_status="X"

    [[ $java_problems =~ (^|[[:space:]])$problem($|[[:space:]]) ]] && java_status="O"
    [[ $go_problems =~ (^|[[:space:]])$problem($|[[:space:]]) ]] && go_status="O"
    [[ $python_problems =~ (^|[[:space:]])$problem($|[[:space:]]) ]] && python_status="O"

    echo "| $problem | $java_status | $go_status | $python_status |" >> README.md
done

# Add the last row indicating the number of problems solved in each language
java_count=$(echo "$java_problems" | wc -l)
go_count=$(echo "$go_problems" | wc -l)
python_count=$(echo "$python_problems" | wc -l)
echo "| **Total** | $java_count | $go_count | $python_count |" >> README.md
