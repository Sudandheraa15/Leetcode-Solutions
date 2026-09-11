class Solution {
    public int timeRequiredToBuy(int[] tickets, int k) {
        Queue <Integer> q=new LinkedList<>(); 
        for(int i=0;i<tickets.length;i++){
           q.offer(i);
        }
        int time=0;
        while(!q.isEmpty()){
            
            int ind=q.poll();
            tickets[ind]--;
             time++;
            if(ind==k && tickets[ind]==0){
               return time;
            }
            if(tickets[ind] >0){
                 q.offer(ind);
            }

        }
       return time;
    }
}