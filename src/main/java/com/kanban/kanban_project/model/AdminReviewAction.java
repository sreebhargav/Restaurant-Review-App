package com.kanban.kanban_project.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.AllArgsConstructor;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class AdminReviewAction {
    private boolean accepted; // Indicates if the admin accepts the dining review
}
