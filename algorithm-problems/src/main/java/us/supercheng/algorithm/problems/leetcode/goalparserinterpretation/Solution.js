/**
 * @param {string} command
 * @return {string}
 */
var interpret = function(command) {
    var l = [],
        i,
        len,
        c;

    for (i=0, len=command.length; i<len; i+=1) {
        c = command[i];

        if (c == 'G')
            l.push(c);
        else {
            if (command[i+1] == ')') {
                l.push('o');
                i += 1;
            } else {
                l.push('al');
                i += 3;
            }
        }
    }

    return l.join('');
};