package com.api.Bank.dtos;

import java.math.BigDecimal;

public record UserDTO(String firstname , String lastname  , String document , BigDecimal balance , String email , String password) {
}
