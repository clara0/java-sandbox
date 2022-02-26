package clara;

public enum RequestType {
    UNKNOWN('z', 0),
    GET('g', 100),
    POST('p', 200),
    DELETE('d', 300),
    INFO('i', 400),
    TRACE('t', 500),
    CANCEL('c', 600);

    private final char id;
    private final int code;

    RequestType(char id, int code) {
        this.id = id;
        this.code = code;
    }

    public static RequestType getRequestType(char id) {
        switch (id) {
            case 'g':
                return GET;
            case 'p':
                return POST;
            case 'd':
                return DELETE;
            case 'i':
                return INFO;
            case 't':
                return TRACE;
            case 'c':
                return CANCEL;
        }
        return UNKNOWN;
    }

    public static RequestType getRequestType(int code) {
        switch (code) {
            case 100:
                return GET;
            case 200:
                return POST;
            case 300:
                return DELETE;
            case 400:
                return INFO;
            case 500:
                return TRACE;
            case 600:
                return CANCEL;
        }
        return UNKNOWN;
    }
}

