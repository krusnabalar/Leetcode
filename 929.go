func numUniqueEmails(emails []string) int {
	set := make(map[string]struct{})
	for _, email := range emails {
		split := strings.Split(email, "@")
		local := strings.Split(split[0], "+")
		noDots := strings.ReplaceAll(local[0], ".", "")
		set[noDots+"@"+split[1]] = struct{}{}
	}

	return len(set)
}