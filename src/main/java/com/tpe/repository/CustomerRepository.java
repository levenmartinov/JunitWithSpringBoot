package com.tpe.repository;

import com.tpe.domain.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

    /*
    Repository metodlarını test etmek için Unit Test veya
    Integration Test yazılabilir. Ancak, repository katmanı
    genellikle veritabanıyla etkileşimde
    bulunduğu için Integration Test yazmak daha yaygındır.
     */

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
