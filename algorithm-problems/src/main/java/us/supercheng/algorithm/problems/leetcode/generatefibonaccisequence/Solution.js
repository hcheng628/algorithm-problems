/**
 * @return {Generator<number>}
 */
var fibGenerator = function*() {
    var prev_prev = 0, prev = 1, next;

    for (; ;next = prev_prev + prev, prev_prev = prev, prev = next)
        yield prev_prev
};

/**
 * const gen = fibGenerator();
 * gen.next().value; // 0
 * gen.next().value; // 1
 */
