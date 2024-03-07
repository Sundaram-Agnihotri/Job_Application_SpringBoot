package com.embarkx.firstjobproject.review;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.*;

public interface ReviewRepository extends JpaRepository<Review,Long> {

    List<Review> findByCompanyId(Long companyId);
}
