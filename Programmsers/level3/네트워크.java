class Solution {
    boolean[] visit;
    int answer = 0;
    
    void dfs(int v, int[][] computers){
        visit[v] = true;
        
        for(int i=0;i<computers[v].length;i++){
            if(!visit[i] && computers[v][i]==1){
                dfs(i,computers);
            }
        }
    }
    
    public int solution(int n, int[][] computers) {
        visit = new boolean[n];
        
        for(int i=0;i<n;i++){
            if(!visit[i]){
                dfs(i,computers);
                answer++;
            }
        }
        return answer;
    }
}
