class MovingAverage {
    int size;
    int[] runningWindow;
    int count = 0, index = 0, sum = 0;

    public MovingAverage(int size) {
        this.size = size;
        runningWindow = new int[size];
    }

    public double next(int val) {
        count++;
        count = Math.min(count, this.size);
        index = (index + 1) % this.size;
        sum = sum - this.runningWindow[index] + val;
        this.runningWindow[index] = val;
        return (sum * 1.0 / count);
    }
}

/**
 * Your MovingAverage object will be instantiated and called as such:
 * MovingAverage obj = new MovingAverage(size);
 * double param_1 = obj.next(val);
 */