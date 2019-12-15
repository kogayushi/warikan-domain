package warikan.domain.model;

public class 請求金額 {
  private final int value;

  public 請求金額(int value) {
    if (value < 0) {
      throw new IllegalArgumentException("請求金額は1円以上を設定してください。");
    }
    this.value = value;
  }

  public int 値を求める() {
    return this.value;
  }
}
