class OrderedStream:

    def __init__(self, n: int):
        self.ptr = 1
        self.m = {}

    def insert(self, id: int, value: str) -> List[str]:
        ret = []
        self.m[id] = value

        while self.ptr in self.m:
            ret.append(self.m[self.ptr])
            self.ptr += 1

        return ret
