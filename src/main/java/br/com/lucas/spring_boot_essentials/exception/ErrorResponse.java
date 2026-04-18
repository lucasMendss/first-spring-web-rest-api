package br.com.lucas.spring_boot_essentials.exception;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ErrorResponse {

    String message;
    Integer status;
}
