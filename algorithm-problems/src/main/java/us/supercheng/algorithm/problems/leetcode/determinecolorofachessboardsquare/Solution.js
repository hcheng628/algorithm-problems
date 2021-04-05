/**
 * @param {string} coordinates
 * @return {boolean}
 */
var squareIsWhite = function(coordinates) {
    var col = coordinates.charCodeAt(0) - 'a'.charCodeAt(0),
        row = coordinates.charCodeAt(1) - '1'.charCodeAt(0);
    return !(col % 2 == row % 2);
};