from collections import deque

class Solution:
    def predictPartyVictory(self, senate: str) -> str:
        n = len(senate)
        r_queue = deque(
            i for i, sen in enumerate(senate) if sen == 'R'
        )
        d_queue = deque(
            i for i, sen in enumerate(senate) if sen == 'D'
        )

        while r_queue and d_queue:
            r_turn, d_turn = r_queue.popleft(), d_queue.popleft()
            
            if r_turn < d_turn:
                r_queue.append(r_turn + n)
            else:
                d_queue.append(d_turn + n)
        
        return 'Radiant' if r_queue else 'Dire'