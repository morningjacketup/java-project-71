package hexlet.code;

public final class Difference {
    private final String statusName;
    private final Object oldValue;
    private final Object newValue;

    public Difference(String status, Object oldVal, Object newVal) {
        this.statusName = status;
        this.oldValue = oldVal;
        this.newValue = newVal;
    }

    public String getStatus() {
        return statusName;
    }

    public Object getOldValue() {
        return oldValue;
    }

    public Object getNewValue() {
        return newValue;
    }
}
