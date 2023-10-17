package dio.domain.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import org.hibernate.validator.constraints.URL;

public class BaseItemDTO {
    private Long id;

    @URL(message = "O campo 'icon' deve ser uma URL válida")
    @NotBlank(message = "O campo 'icon' não pode estar em branco")
    private String icon;

    @NotBlank(message = "O campo 'description' não pode estar em branco")
    @Size(max = 50, message = "O campo 'description' deve ter no máximo 50 caracteres")
    private String description;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
