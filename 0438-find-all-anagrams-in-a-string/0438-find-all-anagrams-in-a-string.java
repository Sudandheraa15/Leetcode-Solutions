class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        int[] n=new int[26];
        int[] m=new int[26];
        ArrayList<Integer> l=new ArrayList<>();
        for(char c:p.toCharArray()){
            n[c-'a']++;
        }
        int k=p.length();
        for(int i=0;i<s.length();i++){
            m[s.charAt(i)-'a']++;
            if(i>=k){
                m[s.charAt(i-k)-'a']--;
            }
            if(java.util.Arrays.equals(n,m)){
             l.add(i-k+1);    
            }
        }
        return l;
    }
}