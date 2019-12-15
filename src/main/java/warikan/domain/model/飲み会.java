package warikan.domain.model;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

public class 飲み会 {
  private final Set<参加者> _参加者s;
  private final 幹事 _幹事; // FIXME ロジックに使わなかったら消す
  private final Optional<請求金額> _請求金額;
  private final Optional<支払区分比重設定> _支払区分比重設定;

  public 飲み会(幹事 _幹事) {
    if (_幹事 == null) {
      throw new IllegalArgumentException("幹事の存在しない飲み会などないゾ😉");
    }
    this._幹事 = _幹事;
    Set<参加者> 参加者s = new HashSet<>();
    参加者s.add(_幹事.to参加者());
    this._参加者s = 参加者s;
    this._請求金額 = Optional.empty();
    this._支払区分比重設定 = Optional.empty();
  }

  private 飲み会(幹事 _幹事, Set<参加者> _参加者s, Optional<請求金額> _請求金額, Optional<支払区分比重設定> _支払区分比重設定) {
    this._幹事 = _幹事;
    this._参加者s = _参加者s;
    this._請求金額 = _請求金額;
    this._支払区分比重設定 = _支払区分比重設定;
  }

  public 飲み会 参加者を追加する(参加者 参加者) {
    Set<参加者> set = new HashSet<>(this._参加者s);
    set.add(参加者);
    return new 飲み会(this._幹事, set, this._請求金額, Optional.empty());
  }

  public 飲み会 参加者を削除する(参加者 参加者) {
    Set<参加者> set = new HashSet<>(this._参加者s);
    set.remove(参加者);
    return new 飲み会(this._幹事, set, this._請求金額, Optional.empty());
  }

  public 飲み会 請求金額を設定する(請求金額 _請求金額) {
    return new 飲み会(this._幹事, this._参加者s, Optional.of(_請求金額), Optional.empty());
  }

  public Set<参加者支払い金額> 支払金額を計算する() {
    int 比重合計値 = 比重の合計値を求める();
    int 請求金額を比重の合計で割った値 = 請求金額を比重の合計で割る(比重合計値);

    return 割った値と比重から参加者毎の支払い金額を計算する(請求金額を比重の合計で割った値);
    // TODO 差額が生じた場合に幹事に負担させるロジックを実装する
  }

  private int 比重の合計値を求める() {
    return this._参加者s.stream().mapToInt(_参加者 -> _参加者.支払比重の値を求める(this._支払区分比重設定.get())).sum();
  }

  private int 請求金額を比重の合計で割る(int 比重合計値) {
    return this._請求金額.get().値を求める() / 比重合計値;
  }

  private Set<参加者支払い金額> 割った値と比重から参加者毎の支払い金額を計算する(int 請求金額を比重の合計で割った値) {
    return this._参加者s
        .stream()
        .map(_参加者 -> new 参加者支払い金額(_参加者, new 支払金額(支払い金額asInt(請求金額を比重の合計で割った値, _参加者))))
        .collect(Collectors.toSet());
  }

  private int 支払い金額asInt(int 請求金額を比重の合計で割った値, 参加者 _参加者) {
    return _参加者.支払比重の値を求める(this._支払区分比重設定.get()) * 請求金額を比重の合計で割った値;
  }
}
