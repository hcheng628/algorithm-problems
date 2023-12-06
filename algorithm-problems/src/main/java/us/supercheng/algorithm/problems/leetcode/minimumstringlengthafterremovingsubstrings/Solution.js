/**
 * @param {string} s
 * @return {number}
 */
var minLength = function(s) {
	if (!s || (typeof s) !== 'string' || s.length < 1)
		return 0;

	let i = 0,
		len = s.length,
		stack = [];

	for (; i < len; i += 1)
		if (stack.length > 0 && ((s[i] === 'B' && stack[stack.length - 1] === 'A') || (s[i] === 'D' && stack[stack.length - 1] === 'C')))
			stack.pop();
		else
			stack.push(s[i]);

	return stack.length;
};
