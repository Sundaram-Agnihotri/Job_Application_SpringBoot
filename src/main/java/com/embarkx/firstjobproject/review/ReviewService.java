package com.embarkx.firstjobproject.review;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.*;

public interface ReviewService {
    //list all reviews
    //this is one of the methods to get all the reviews
    List<Review> getAllReviews(Long companyId);
    boolean addReview(Long companyId,Review review);
    Review getReview(Long companyId,Long reviewId);
    boolean updateReview(Long companyId,Long reviewId,Review review);
    boolean deleteReview(Long companyId, Long reviewId);
}
