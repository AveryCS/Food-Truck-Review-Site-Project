package org.wecancodeit.reviews.repos;

import org.springframework.data.repository.CrudRepository;
import org.wecancodeit.reviews.entities.Review;

public interface ReviewRepository extends CrudRepository<Review, Long> {
}
