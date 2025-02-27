#include <queue>
#include <string>
using namespace std;

class Solution {
public:
    string predictPartyVictory(string senate) {
        int n = senate.size();
        queue<int> radiant, dire;

        // Step 1: Initialize queues with indices of 'R' and 'D' senators
        for (int i = 0; i < n; i++) {
            if (senate[i] == 'R') {
                radiant.push(i);
            } else {
                dire.push(i);
            }
        }

        // Step 2: Simulate the voting process
        while (!radiant.empty() && !dire.empty()) {
            int rIndex = radiant.front(); // Front of Radiant queue
            int dIndex = dire.front();    // Front of Dire queue

            // Compare indices to determine who bans whom
            if (rIndex < dIndex) {
                // Radiant senator bans Dire senator
                radiant.pop();
                dire.pop();
                radiant.push(rIndex + n); // Re-enqueue Radiant senator for the next round
            } else {
                // Dire senator bans Radiant senator
                dire.pop();
                radiant.pop();
                dire.push(dIndex + n); // Re-enqueue Dire senator for the next round
            }
        }

        // Step 3: Determine the winner
        if (radiant.empty()) {
            return "Dire";
        } else {
            return "Radiant";
        }
    }
};

/**
 * Explanation of the Code:
 * 1. We use two queues to store the indices of 'R' and 'D' senators.
 * 2. In each round, the senator with the smaller index bans the other senator.
 * 3. The senator who performed the ban is re-enqueued with their index incremented by `n` to simulate the next round.
 * 4. The process continues until one of the queues is empty.
 * 5. The party with remaining senators in their queue wins.
 */