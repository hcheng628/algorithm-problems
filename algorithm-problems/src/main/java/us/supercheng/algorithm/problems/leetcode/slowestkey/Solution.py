class Solution:
    def slowestKey(self, releaseTimes: List[int], keysPressed: str) -> str:
        m = {}
        max_val = releaseTimes[0]
        ret = keysPressed[0]

        for i in range(1, len(releaseTimes)):
            key = keysPressed[i]
            m[key] = max(releaseTimes[i] - releaseTimes[i-1], m[key]) if key in m \
                else releaseTimes[i] - releaseTimes[i-1]

            if m[key] > max_val:
                max_val = m[key]
                ret = key
            elif m[key] == max_val and ord(ret) < ord(key):
                ret = key

        return ret
