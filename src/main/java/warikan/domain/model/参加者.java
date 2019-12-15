package warikan.domain.model;

import java.util.Objects;

public class 参加者 {
  private final String _名前;
  private final 支払区分 _支払区分;

  public 参加者(String _参加者の名前, 支払区分 _支払区分) {
    this._名前 = _参加者の名前;
    this._支払区分 = _支払区分;
  }

  public int 支払比重の値を求める(支払区分比重設定 _支払区分比重設定) {
    return _支払区分比重設定.支払比重を求める(this._支払区分).値を求める();
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof 参加者)) return false;
    参加者 参加者 = (参加者) o;
    return _名前.equals(参加者._名前) && _支払区分 == 参加者._支払区分;
  }

  @Override
  public int hashCode() {
    return Objects.hash(_名前, _支払区分);
  }
}
