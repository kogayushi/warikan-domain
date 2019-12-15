package warikan.domain.model;

public class 支払金額 {
  private final int value;

  public 支払金額(int value) {
    if (value <= 0) {
      throw new IllegalArgumentException("支払金額は0円以上を設定してください。");
    }
    this.value = value;
  }
}
