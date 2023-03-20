class Solution:
    def distMoney(self, money: int, children: int) -> int:
        if children > money:
            return -1
        elif children * 8 == money:
            return children
        elif children * 8 < money:
            return children - 1

        ret = 0
        while money - 8 >= children - 1:
            ret += 1
            money -= 8
            children -= 1

        return ret - 1 if money == 4 and children == 1 else ret
