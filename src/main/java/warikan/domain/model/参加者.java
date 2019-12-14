package warikan.domain.model;

public class 参加者 {
  private final String _名前;
  private final 支払区分 _支払区分;

  public 参加者(String _参加者の名前, 支払区分 _支払区分) {
    this._名前 = _参加者の名前;
    this._支払区分 = _支払区分;
  }

  // FIXME equalsとかちゃんと実装してね
}
