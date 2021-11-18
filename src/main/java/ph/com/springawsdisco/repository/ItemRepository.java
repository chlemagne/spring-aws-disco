package ph.com.springawsdisco.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ph.com.springawsdisco.domain.Item;

@Repository
public interface ItemRepository extends JpaRepository<Item, Long> {
}
