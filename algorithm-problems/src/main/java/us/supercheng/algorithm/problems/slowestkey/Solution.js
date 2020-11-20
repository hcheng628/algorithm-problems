/**
 * @param {number[]} releaseTimes
 * @param {string} keysPressed
 * @return {character}
 */
var slowestKey =
    function(releaseTimes, keysPressed) {
        var m = {},
            len = releaseTimes.length,
            i,
            key,
            max = releaseTimes[0],
            ret = keysPressed[0];

        for (i=1; i<len; i+=1) {
            key = keysPressed[i];
            m[key] = m[key] ? Math.max(m[key], releaseTimes[i] - releaseTimes[i-1]) :
                releaseTimes[i] - releaseTimes[i-1];

            if (m[key] > max) {
                max = m[key];
                ret = key;
            } else if (ret < key && m[key] == max)
                ret = key;
        }

        return ret;
    };