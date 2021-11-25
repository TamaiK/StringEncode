import myclass.StringsCompressor;
import myclass.StringsExpander;

public class App {

    private static final String MESSAGE_FORMAT_FOR_ENCODE_TEXT = "エンコード前：%s";
    private static final String MESSAGE_FORMAT_FOR_ENCODE_RESULT = "エンコード後：%s";

    private static final String MESSAGE_FORMAT_FOR_DECODE_TEXT = "デコード前：%s";
    private static final String MESSAGE_FORMAT_FOR_DECODE_RESULT = "デコード後：%s";

    public static final String MESSAGE_FOR_BLANK = "";

    public static void main(String[] args) throws Exception {

        String encodeString = "AAAAABBBBBBBBBBCDDDDDDDDDEEFFFFFG";
        String text = encode(encodeString);
        println(MESSAGE_FORMAT_FOR_ENCODE_TEXT, encodeString);
        println(MESSAGE_FORMAT_FOR_ENCODE_RESULT, text);

        println(MESSAGE_FOR_BLANK, text);

        String decodeString = "A5B10CD9E2F5G";
        text = decode(decodeString);
        println(MESSAGE_FORMAT_FOR_DECODE_TEXT, decodeString);
        println(MESSAGE_FORMAT_FOR_DECODE_RESULT, text);
    }

    private static String encode(String encodeString) {
        return StringsCompressor.encode(encodeString);
    }

    private static String decode(String decodeString) {
        return StringsExpander.decode(decodeString);
    }

    // 汎用関数

    private static void println(String str, Object... args) {
        System.out.println(String.format(str, args));
    }
}
