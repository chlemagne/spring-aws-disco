package ph.com.springawsdisco.model.response;

import ph.com.springawsdisco.domain.Item;

public class ItemResponse {

    private Long id;

    private String title;

    private String description;

    public ItemResponse(Item item) {
        id = item.getId();
        title = item.getTitle();
        description = item.getDescription();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
