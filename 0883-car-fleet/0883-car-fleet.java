class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        float[] time = new float[target];
        for (int i = 0; i < speed.length; i++)
            time[position[i]] = (float)(target-position[i])/speed[i];
        int cnt = 0;
        float max = 0;
        for (int i = time.length - 1; i >= 0; i--) {
            if (time[i] > max) {
                cnt++;
                max = time[i];
            }
        }
        return cnt;
    }
}