class Solution:
    def countMatches(self, items: List[List[str]], ruleKey: str, ruleValue: str) -> int:
        ret = 0
        rule_idx = 0

        if ruleKey == 'color':
            rule_idx = 1
        elif ruleKey == 'name':
            rule_idx = 2

        for item in items:
            if item[rule_idx] == ruleValue:
                ret += 1

        return ret