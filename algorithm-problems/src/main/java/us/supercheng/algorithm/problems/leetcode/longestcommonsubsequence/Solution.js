/**
 * @param {string} text1
 * @param {string} text2
 * @return {number}
 */
var longestCommonSubsequence = function(text1, text2) {
    var dp = [],
        len1 = text1.length,
        len2 = text2.length,
        i,
        j;

    for (i=0; i<=len1; i+=1) {
        dp.push([]);
        for (j=0; j<=len2; j+=1)
            dp[i].push(0);
    }

    for (i=1; i<=len1; i+=1)
        for (j=1; j<=len2; j+=1)
            if (text1[i - 1] == text2[j - 1])
                dp[i][j] = dp[i - 1][j - 1] + 1;
            else
                dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);

    return dp[len1][len2];
};