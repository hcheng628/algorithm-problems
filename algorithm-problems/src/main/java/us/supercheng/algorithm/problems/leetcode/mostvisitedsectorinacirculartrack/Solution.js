/**
 * @param {number} n
 * @param {number[]} rounds
 * @return {number[]}
 */
var mostVisited = function(n, rounds) {
        var visited = Array(n+1).fill(0),
            ret = [],
            max = 0,
            len = rounds.length,
            i;

        for (i=0; i<len-1; i+=1)
            travel(visited, rounds[i], rounds[i+1], n);
        visited[rounds[len-1]] +=1;

        for (i=0; i<=n; i+=1)
            if (visited[i] > max)
                max = visited[i];

        for (i=1; i<=n; i+=1)
            if (visited[i] == max)
                ret.push(i);

        return ret;
    },
    travel = function(visited, from, to, N) {
        if (from <= to)
            for (; from<to; from+=1)
                visited[from] +=1;
        else {
            for (;from<=N; from+=1)
                visited[from] +=1;
            for (from=1; from<to; from+=1)
                visited[from] +=1;
        }
    };