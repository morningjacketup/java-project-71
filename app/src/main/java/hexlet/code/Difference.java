package hexlet.code;

public final class Difference {
    public static final String ADDED = "added";
    public static final String DELETED = "deleted";
    public static final String CHANGED = "changed";
    public static final String UNCHANGED = "unchanged";
    private final String statusName;
    private final Object oldValue;
    private final Object newValue;

    public Difference(String status, Object oldVal, Object newVal) {
        this.statusName = status;
        this.oldValue = oldVal;
        this.newValue = newVal;
    }

    public String getStatusName() {
        return statusName;
    }

    public Object getOldValue() {
        return oldValue;
    }

    public Object getNewValue() {
        return newValue;
    }
}
