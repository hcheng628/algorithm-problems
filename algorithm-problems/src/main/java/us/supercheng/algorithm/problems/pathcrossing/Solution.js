/**
 * @param {string} path
 * @return {boolean}
 */
var isPathCrossing = function(path) {
    var visited = { '0,0': true },
        curr_x = 0,
        curr_y = 0,
        i= 0,
        len = path.length,
        curr,
        key;

    for (; i<len; i+=1) {
        curr = path[i];

        if (curr == 'N')
            curr_y += 1;
        else if (curr == 'S')
            curr_y -= 1;
        else if (curr == 'E')
            curr_x += 1;
        else if (curr == 'W')
            curr_x -= 1;
        else
            throw ('something is wrong');

        key = curr_x + ',' + curr_y;
        if (visited[key])
            return true;
        visited[key] = true;
    }

    return false;
};