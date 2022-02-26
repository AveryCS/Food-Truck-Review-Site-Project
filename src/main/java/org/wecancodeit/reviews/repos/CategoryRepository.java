package org.wecancodeit.reviews.repos;

import org.springframework.data.repository.CrudRepository;
import org.wecancodeit.reviews.entities.Category;

public interface CategoryRepository extends CrudRepository<Category, Long> {
}
