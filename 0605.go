func canPlaceFlowers(flowerbed []int, n int) bool {
	plantable := 0
	for i := 0; i < len(flowerbed); i++ {
		flower := flowerbed[i]
		if flower == 1 {
			i++
			continue
		} else if i < len(flowerbed)-1 {
			nextFlower := flowerbed[i+1]
			if nextFlower == 0 {
				plantable++
				if plantable == n {
					return true
				}
				i++
			}
		} else {
			plantable++
		}
	}
	return n <= plantable
}