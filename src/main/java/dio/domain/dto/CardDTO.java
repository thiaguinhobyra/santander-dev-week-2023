package dio.domain.dto;

import jakarta.validation.constraints.*;

import java.math.BigDecimal;

public class CardDTO {
    private Long id;

    @NotBlank(message = "O número do cartão não pode estar em branco")
    @Pattern(regexp = "\\d{16}", message = "O número do cartão deve conter 16 dígitos")
    private String number;

    @NotNull(message = "O limite do cartão não pode ser nulo")
    @Positive(message = "O limite do cartão deve ser um valor positivo")
    private BigDecimal limit;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public BigDecimal getLimit() {
        return limit;
    }

    public void setLimit(BigDecimal limit) {
        this.limit = limit;
    }
}
