## 文字列の圧縮

### 概要
アルファベットのみで構成される文字列を圧縮する。

## 課題 1. 文字列圧縮
同じの文字が続く場合、"文字+連続する文字数"に置き換え、文字数を短くして圧縮する StringsCompressor クラスを作成しなさい

### Javaコード
``` java
String text = encode("AAAAABBBBBBBBBBCDDDDDDDDDEEFFFFFG");
System.out.println(text);
```

### 結果
``` console
A5B10CD9E2F5G
```

## 課題 1. 文字列圧縮
課題 1 で圧縮した文字列を展開する StringsExpander クラスを作成しなさい

### Javaコード
``` java
String text = decode("A5B10CD9E2F5G");
System.out.println(text);
```

### 結果
``` console
AAAAABBBBBBBBBBCDDDDDDDDDEEFFFFFG
```
