package Excessoes;

public class erroDeCoonsumo extends RuntimeException {
    private String message;

    public erroDeCoonsumo(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return this.message;
    }
}
