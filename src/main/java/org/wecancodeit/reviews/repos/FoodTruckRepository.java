package org.wecancodeit.reviews.repos;

import org.springframework.data.repository.CrudRepository;
import org.wecancodeit.reviews.entities.FoodTruck;

public interface FoodTruckRepository extends CrudRepository <FoodTruck, Long> {
}
