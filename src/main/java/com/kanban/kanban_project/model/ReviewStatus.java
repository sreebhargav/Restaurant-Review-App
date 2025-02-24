package com.kanban.kanban_project.model;

public enum ReviewStatus {
    PENDING,   // When a user submits a review, but it's not yet reviewed
    ACCEPTED,  // When an admin approves the review
    REJECTED   // When an admin rejects the review
, APPROVED
}
