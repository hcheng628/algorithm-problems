class Solution:
    def interpret(self, command: str) -> str:
        l = []
        idx = 0

        while idx < len(command):
            if command[idx] == "G":
                l.append("G")
                idx += 1
            else:
                if command[idx + 1] == ")":
                    l.append("o")
                    idx += 2
                else:
                    l.append("al")
                    idx +=4

        return "".join(l)


        def interpret2(self, command: str) -> str:
            return command.replace("()", "o").replace("(al)", "al")
