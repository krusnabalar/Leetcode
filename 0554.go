func leastBricks(wall [][]int) int {

	lines := make(map[int]int, len(wall[0]))
	res := len(wall)

	for _, row := range wall {
		currLine := 0
		for i := 0; i < len(row)-1; i++ {
			currLine += row[i]
			lines[currLine] += 1
			if len(wall)-lines[currLine] < res {
				res = len(wall) - lines[currLine]
			}
		}
	}

	return res

}