package kr.co.hanbit.product_management.presentation;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@Getter
@Setter
public class ErrorMessage {
    private List<String> errors;
}
