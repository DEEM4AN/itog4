class Counter implements AutoCloseable {
    private int count;
    private boolean closed;

    public Counter() {
        count = 0;
        closed = false;
    }

    public void add() {
        if (closed) {
            throw new IllegalStateException("Counter is closed");
        }
        count++;
    }

    @Override
    public void close() {
        closed = true;
        if (count == 0) {
            throw new IllegalStateException("Counter has not been used properly");
        }
    }

    public int getCount() {
        return count;
    }
}