/**
 * @param {string} time
 * @return {string}
 */
var maximumTime = function(time) {
    var list = [],
        i,
        len;

    for (i=0, len=time.length; i<len; i+=1)
        list.push(time[i]);

    if (list[0] == '?')
        list[0] = list[1] > '3' && list[1] != '?' ? '1' : '2';

    if (list[1] == '?')
        list[1] = list[0] < '2' ? '9' : '3';

    if (list[3] == '?')
        list[3] = '5';

    if (list[4] == '?')
        list[4] = '9'

    return list.join('');
};