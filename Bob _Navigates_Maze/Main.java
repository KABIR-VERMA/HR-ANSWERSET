class Result {

    /*
     * Complete the 'minMoves' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. 2D_INTEGER_ARRAY maze
     *  2. INTEGER x
     *  3. INTEGER y
     */
    static class State{
        int x,y,steps,gold;
        State(int xx,int yy,int tt,int ss){
            x= xx;
            y = yy;
            gold = tt;
            steps=ss;
        }
    }

    public static int minMoves(List<List<Integer>> maze, int x, int y) {
    // Write your code here
        int[] dx = {-1,0,1,0};
        int[] dy = {0,1,0,-1};
        int goal = 0;
        for(int i=0;i<maze.size();i++)
        {
            for(int j=0;j<maze.size();j++)
            {
                if(maze.get(i).get(j)==2){
                    maze.get(i).set(j,2+goal);
                    goal++;
                } 
            }
        }
        boolean[][][] vis = new boolean[maze.size()][maze.size()][(1<<(goal))];
        Queue<State> Q= new  LinkedList<State>();
        Q.add(new State(0,0,0,0));
        vis[0][0][0]=true;
        while(!Q.isEmpty()){
            State now = Q.remove();
            if(now.x==x && now.y==y && Integer.bitCount(now.gold)==goal)
            {
                return now.steps;
            }
            for(int i=0;i<4;i++){
                int nx = now.x+dx[i] , ny = now.y+dy[i] , nt = now.gold;
                if(nx<0 || ny<0 || nx>=maze.size() || ny>=maze.size() || maze.get(nx).get(ny)==1)
                {
                    continue;
                }
                if(maze.get(nx).get(ny)!=0)
                {
                    int pos = maze.get(nx).get(ny)-2;
                    nt = nt|(1<<pos);
                }
                if(vis[nx][ny][nt])
                {
                    continue;
                }
                vis[nx][ny][nt] = true;
                Q.add(new State(nx, ny, nt, now.steps+1));
            }
        }
        return -1;
    }

}

