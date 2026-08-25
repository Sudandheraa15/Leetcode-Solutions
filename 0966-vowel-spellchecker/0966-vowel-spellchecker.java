class Solution { 
    public String[] spellchecker(String[] wordlist, String[] queries) { 
        Set<String> exact = new HashSet<>(); 
        Map<String, String> caseMap = new HashMap<>(); 
        Map<String, String> vowelMap = new HashMap<>(); 
        for (String word : wordlist) { 
            exact.add(word); 
            String lower = word.toLowerCase(); 
            if (!caseMap.containsKey(lower)) {
                caseMap.put(lower, word);
            } 
            String pattern = vowelPattern(lower); 
            if (!vowelMap.containsKey(pattern)) {
                vowelMap.put(pattern, word);
            }
        } 
        String[] answer = new String[queries.length]; 
        for (int i = 0; i < queries.length; i++) { 
            String query = queries[i]; 
            if (exact.contains(query)) {
                answer[i] = query;
                continue;
            } 
            String lower = query.toLowerCase();

            if (caseMap.containsKey(lower)) {
                answer[i] = caseMap.get(lower);
                continue;
            }
            String pattern = vowelPattern(lower);

            if (vowelMap.containsKey(pattern)) {
                answer[i] = vowelMap.get(pattern);
                continue;
            }
            answer[i] = "";
        }
        return answer;
    }
    private String vowelPattern(String word) {

        StringBuilder sb = new StringBuilder();

        for (char c : word.toCharArray()) {

            if (isVowel(c)) {
                sb.append('*');
            } else {
                sb.append(c);
            }
        } 
        return sb.toString();
    } 
    private boolean isVowel(char c) { 
        return c == 'a' || c == 'e' || c == 'i' ||
               c == 'o' || c == 'u';
    }
}