package com.embarkx.firstjobproject.review.impl;

import com.embarkx.firstjobproject.company.Company;
import com.embarkx.firstjobproject.company.CompanyService;
import com.embarkx.firstjobproject.review.Review;
import com.embarkx.firstjobproject.review.ReviewRepository;
import com.embarkx.firstjobproject.review.ReviewService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class ReviewServiceImpl implements ReviewService {
    private final ReviewRepository reviewRepository;
    private CompanyService companyService;

    public ReviewServiceImpl(ReviewRepository reviewRepository,CompanyService companyService) {
        this.reviewRepository = reviewRepository;
        this.companyService = companyService;
    }

    @Override
    public List<Review> getAllReviews(Long companyId) {
        List<Review> reviews = reviewRepository.findByCompanyId(companyId);
        return reviews;
    }

    @Override
    public boolean addReview(Long companyId, Review review) {
       Company company = companyService.getCompanyById(companyId);
       if(company!=null){
           review.setCompany(company);
           reviewRepository.save(review);
           return true;
        }
       else{
           return false;
       }

    }

    @Override
    public Review getReview(Long companyId, Long reviewId) {
        List<Review> reviews = reviewRepository.findByCompanyId(companyId);
        return reviews.stream()
                .filter(review -> review.getId().equals(reviewId))
                .findFirst()
                .orElse(null);
    }

    @Override
    public boolean updateReview(Long companyId, Long reviewId, Review review) {
        if(companyService.getCompanyById(companyId)!=null){
            updateReview.set
        }
    }
}
