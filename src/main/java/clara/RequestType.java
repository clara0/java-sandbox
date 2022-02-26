package clara;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

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

    private static final Map<Character, RequestType> charIdMap;
    private static final Map<Integer, RequestType> codeMap;

    static {
        Map<Character, RequestType> tempCharMap = new HashMap<>();
        tempCharMap.put(GET.id, GET);
        tempCharMap.put(POST.id, POST);
        tempCharMap.put(DELETE.id, DELETE);
        tempCharMap.put(INFO.id, INFO);
        tempCharMap.put(TRACE.id, TRACE);
        tempCharMap.put(CANCEL.id, CANCEL);
        charIdMap = tempCharMap;

        Map<Integer, RequestType> tempCodeMap = new HashMap<>();
        tempCodeMap.put(GET.code, GET);
        tempCodeMap.put(POST.code, POST);
        tempCodeMap.put(DELETE.code, DELETE);
        tempCodeMap.put(INFO.code, INFO);
        tempCodeMap.put(TRACE.code, TRACE);
        tempCodeMap.put(CANCEL.code, CANCEL);
        codeMap = tempCodeMap;
    }

    public static RequestType fromCharId(char id) {
        RequestType requestType = charIdMap.get(id);
        return requestType == null ? UNKNOWN : requestType;
    }

    public static RequestType fromCode(int code) {
        RequestType requestType = codeMap.get(code);
        return requestType == null ? UNKNOWN : requestType;
    }

    public static RequestType fromName(String name) {
        try {
            return RequestType.valueOf(name.toUpperCase(Locale.ROOT));
        } catch (IllegalArgumentException | NullPointerException e) {
            return UNKNOWN;
        }
    }
}

