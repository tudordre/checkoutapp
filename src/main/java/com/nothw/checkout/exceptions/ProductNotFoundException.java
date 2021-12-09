package com.nothw.checkout.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Exception thrown when a product is not found. Status code 404
 */

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "Product Not Found")
public class ProductNotFoundException extends RuntimeException {
}
