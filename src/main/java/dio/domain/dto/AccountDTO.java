package dio.domain.dto;

import jakarta.validation.constraints.*;

import java.math.BigDecimal;

public class AccountDTO {
    private Long id;

    @NotBlank(message = "O número da conta não pode estar em branco")
    @Pattern(regexp = "\\d{4}-\\d{1}", message = "O número da conta deve estar no formato 1234-5")
    private String number;

    @NotBlank(message = "A agência não pode estar em branco")
    private String agency;

    @NotNull(message = "O saldo não pode ser nulo")
    @Positive(message = "O saldo deve ser um valor positivo")
    @DecimalMin(value = "0", message = "O saldo não pode ser negativo")
    private BigDecimal balance;

    @NotNull(message = "O limite não pode ser nulo")
    @Positive(message = "O limite deve ser um valor positivo")
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

    public String getAgency() {
        return agency;
    }

    public void setAgency(String agency) {
        this.agency = agency;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public BigDecimal getLimit() {
        return limit;
    }

    public void setLimit(BigDecimal limit) {
        this.limit = limit;
    }
}
