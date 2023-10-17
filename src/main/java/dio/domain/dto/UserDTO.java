package dio.domain.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.util.List;

public class UserDTO {
    private Long id;

    @NotBlank(message = "O nome deve ser informado. ")
    @Size(max = 100, message = "O nome deve ter no máximo 100 caracteres. ")
    private String name;

    @Valid
    private AccountDTO account;

    @Valid
    private List<FeatureDTO> features;

    @Valid
    private CardDTO card;

    @Valid
    private List<NewsDTO> news;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public AccountDTO getAccount() {
        return account;
    }

    public void setAccount(AccountDTO account) {
        this.account = account;
    }

    public List<FeatureDTO> getFeatures() {
        return features;
    }

    public void setFeatures(List<FeatureDTO> features) {
        this.features = features;
    }

    public CardDTO getCard() {
        return card;
    }

    public void setCard(CardDTO card) {
        this.card = card;
    }

    public List<NewsDTO> getNews() {
        return news;
    }

    public void setNews(List<NewsDTO> news) {
        this.news = news;
    }
}

