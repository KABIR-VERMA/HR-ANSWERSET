class State:
    def __init__(self, xx, yy, gg, ss):
        self.x = xx
        self.y = yy
        self.gold = gg
        self.steps = ss

def valid(xx, yy, n, m):
    if(xx < 0 or xx >= n or yy < 0 or yy >= m):
        return False
    return True
        
def minMoves(maze, x, y):
    n = len(maze)
    m = len(maze[0])
    goal = 0
    for i in range(n):
        for j in range(m):
            if(maze[i][j] == 2):
                maze[i][j] = 2 + goal
                goal += 1
    
    visited = [[[False for i in range(1 << goal)] for j in range(m)] for k in range(n)]
    d = deque()
    d.append(State(0, 0, 0, 0))
    dx = [1, -1, 0, 0]
    dy = [0, 0, 1, -1]
    while(len(d) != 0):
        ns = d.popleft()
        if(ns.x == x and ns.y == y and bin(ns.gold).count("1") == goal):
            return ns.steps
        else:
            for i in range(4):
                nx = ns.x + dx[i]
                ny = ns.y + dy[i]
                nt = ns.gold
                if(not valid(nx, ny, n, m) or maze[nx][ny] == 1):
                    continue
                if(maze[nx][ny] != 0):
                    pos = maze[nx][ny] - 2
                    nt = nt | (1 << pos)
                if(visited[nx][ny][nt]):
                    continue
                visited[nx][ny][nt] = True
                d.append(State(nx, ny, nt, ns.steps + 1))
        
    return -1
