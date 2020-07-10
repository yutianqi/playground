class Solution(object):
    def partitionLabels(self, S):
        """
        :type S: str
        :rtype: List[int]
        """
        table = {c: i for i, c in enumerate(S)}
        
        
        print(table)
        
        
        start = 0
        maxIdx = 0
        res = []
        for i, c in enumerate(S):
            maxIdx = max(table[c], maxIdx)
            if maxIdx == i:
                res.append(maxIdx - start + 1)
                start = i + 1
        return res  
        
        
        
def main():
    solution = Solution()
    ret = solution.partitionLabels("ababcbacadefegdehijhklij")
    print(ret)


if "__main__" == __name__:
    main()