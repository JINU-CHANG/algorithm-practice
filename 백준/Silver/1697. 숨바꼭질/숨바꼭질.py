from collections import deque

def bfs():
    queue = deque()
    queue.append((n, 0))
    visited[n] = True
    while queue:
        c, cnt = queue.popleft()
        if c == k:
            return cnt

        for i in [c-1, c+1, 2*c]:
            if 0 <= i <= 100000 and not visited[i]:
                visited[i] = True
                queue.append((i, cnt+1))

n, k = map(int, input().split())
visited = [False for i in range(100001)]
print([bfs(), n-k][n>k])