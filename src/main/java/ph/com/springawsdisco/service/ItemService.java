package ph.com.springawsdisco.service;

import org.springframework.stereotype.Service;
import ph.com.springawsdisco.domain.Item;
import ph.com.springawsdisco.model.request.ItemRequest;
import ph.com.springawsdisco.model.response.ItemResponse;
import ph.com.springawsdisco.repository.ItemRepository;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ItemService {

    private final ItemRepository itemRepository;

    public ItemService(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    public ItemResponse getItem(long id) throws EntityNotFoundException {
        return new ItemResponse(itemRepository.getById(id));
    }

    public List<ItemResponse> getItems() {
        return itemRepository.findAll()
                .stream()
                .map(ItemResponse::new)
                .collect(Collectors.toList());
    }

    public ItemResponse createItem(ItemRequest request) {
        Item item = new Item();
        item.setTitle(request.getTitle());
        item.setDescription(request.getDescription());

        return new ItemResponse(itemRepository.save(item));
    }

    public ItemResponse updateItem(long id, ItemRequest request) throws EntityNotFoundException {
        Item item = itemRepository.getById(id);

        // update title
        item.setTitle(request.getTitle() != null ? request.getTitle() : item.getTitle());

        // update description
        item.setDescription(request.getDescription() != null ? request.getDescription() : item.getDescription());

        return new ItemResponse(itemRepository.save(item));
    }

    public void deleteItem(long id) throws EntityNotFoundException {
        itemRepository.deleteById(id);
    }
}
