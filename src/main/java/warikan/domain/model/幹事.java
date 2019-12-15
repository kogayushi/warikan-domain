package warikan.domain.model;

import java.time.LocalDateTime;

public class 幹事 {
    private final String name;

    public 幹事(String name) {
        this.name = name;
    }

    public 飲み会 飲み会を作る(支払区分比重設定 _支払区分比重設定, String 名前, LocalDateTime 日時) {
        return new 飲み会(this);
    }

    public 飲み会 参加者を追加する(飲み会 _飲み会, String 参加者の名前, 支払区分 _支払区分) {
        return _飲み会.参加者を追加する(new 参加者(参加者の名前, _支払区分));
    }

    public 飲み会 参加者を削除する(飲み会 _飲み会, 参加者 _参加者) {
        return _飲み会.参加者を削除する(_参加者);
    }

    public 支払区分比重設定 区分ごとの割合を設定する(支払比重 多めのための支払い区分, 支払比重 普通のための支払い区分, 支払比重 少なめのための支払い区分) {
        return new 支払区分比重設定(多めのための支払い区分, 普通のための支払い区分, 少なめのための支払い区分);
    }

    public void 請求金額を設定する(飲み会 _飲み会, 請求金額 _請求金額) {
        _飲み会.請求金額を設定する(_請求金額);
    }

    public 参加者 to参加者() {
        return new 参加者(this.name, 支払区分.普通); // TODO ユースケース未定義のため決め打ちで普通にしたが、コンストラクタで支払い区分を設定できるようにするべきかもしれない。少なめにしてあげたい気もする。
    }
}
