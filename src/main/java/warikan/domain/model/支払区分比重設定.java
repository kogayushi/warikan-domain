package warikan.domain.model;

import java.util.EnumMap;
import java.util.Map;

public class 支払区分比重設定 {

  private final Map<支払区分, 支払比重> value;

  public 支払区分比重設定(支払比重 多めのための支払い区分, 支払比重 普通のための支払い区分, 支払比重 少なめのための支払い区分) {
    Map<支払区分, 支払比重> map = new EnumMap(支払区分.class);
    map.put(支払区分.多め, 多めのための支払い区分);
    map.put(支払区分.普通, 普通のための支払い区分);
    map.put(支払区分.少なめ, 少なめのための支払い区分);
    this.value = map;
  }

  public 支払比重 支払比重を求める(支払区分 _支払区分) {
    return this.value.get(_支払区分);
  }
}
