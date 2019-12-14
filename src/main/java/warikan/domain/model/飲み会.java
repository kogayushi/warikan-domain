package warikan.domain.model;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

public class 飲み会 {
  private final Set<参加者> _参加者s;
  private final 幹事 _幹事; // FIXME ロジックに使わなかったら消す
  private final Optional<請求金額> _請求金額;

  public 飲み会(幹事 _幹事) {
    if (_幹事 == null) {
      throw new IllegalArgumentException("幹事の存在しない飲み会などないゾ😉");
    }
    this._幹事 = _幹事;
    Set<参加者> 参加者s = new HashSet<>();
    参加者s.add(_幹事.to参加者());
    this._参加者s = 参加者s;
    this._請求金額 = Optional.empty();
  }

  public 飲み会(幹事 _幹事, Set<参加者> _参加者s, Optional<請求金額> _請求金額) {
    this._幹事 = _幹事;
    this._参加者s = _参加者s;
    this._請求金額 = _請求金額;
  }

  public 飲み会 参加者を追加する(参加者 参加者) {
    Set<参加者> set = new HashSet<>(this._参加者s);
    set.add(参加者);
    return new 飲み会(this._幹事, set, this._請求金額);
  }

  public 飲み会 参加者を削除する(参加者 参加者) {
    Set<参加者> set = new HashSet<>(this._参加者s);
    set.remove(参加者);
    return new 飲み会(this._幹事, set, this._請求金額);
  }

  public 飲み会 請求金額を設定する(請求金額 _請求金額) {
    return new 飲み会(this._幹事, this._参加者s, Optional.of(_請求金額));
  }

  public Set<参加者支払い金額> 支払金額を計算する() {
    // ここに支払い金額計算ロジックを書く
    return null;
  }
}
