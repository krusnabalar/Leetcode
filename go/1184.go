package leetcode

func distanceBetweenBusStops(distance []int, start int, destination int) int {
	distance_clockwise := 0
	for current := start; current != destination; current = (current + 1) % len(distance) {
		distance_clockwise += distance[current]
	}
	distance_counter_clockwise := 0
	for current := destination; current != start; current = (current + 1) % len(distance) {
		distance_counter_clockwise += distance[current]
	}

	if distance_clockwise < distance_counter_clockwise {
		return distance_clockwise
	} else {
		return distance_counter_clockwise
	}
}
