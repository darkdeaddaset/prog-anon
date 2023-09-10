package anon.ddd.prorammer.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * Статусы тем и топиков.
 */
@Getter
@RequiredArgsConstructor
public enum Status {
    ACTIVE("Активный"),
    SUPPORTED("Поддерживается"),
    UNSUPPORTED("Неподдерживается"),
    CLOSE("Закрыт");


    private final String statusName;
}
