package format;

public class SSymbolEntity {
    public enum type {
        Label,
        Constant,
        Variable
    }

    private String symbolName;
    private type type;
    private String address;
    private String value;

    public String getSymbolName() {
        return symbolName;
    }
    public void setSymbolName(String symbolName) {
        this.symbolName = symbolName;
    }

    public SSymbolEntity.type getType() {
        return type;
    }

    public void setType(SSymbolEntity.type type) {
        this.type = type;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getValue() {
        return value;
    }
    public void setValue(String value) {
        this.value = value;
    }
}
