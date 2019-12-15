package warikan.domain.model;

public class 支払比重 {
    private final int _値;

    public 支払比重(int _値) {
        if (_値 <= 0) {
            throw new IllegalArgumentException("比重の値は必ず1以上である必要があります");
        }
        this._値 = _値;
    }

    public int 値を求める() {
        return this._値;
    }
}
