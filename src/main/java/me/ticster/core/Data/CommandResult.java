package me.ticster.core.Data;

public class CommandResult {
    public enum Status {
        SUCCESS,
        ERROR,
        HELP
    }

    private final Status status;
    private final String message;
    private final Object data;

    public CommandResult(Status status, String message) {
        this(status, message, null);
    }

    public CommandResult(Status status, String message, Object data) {
        this.status = status;
        this.message = message;
        this.data = data;
    }

    public Status getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }

    public Object getData() {
        return data;
    }
}
