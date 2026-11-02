package com.study.backend.global.dto;

public record ApiResponse<T>(
        int status,
        boolean success,
        String message,
        T data
) {

    public static <T> ApiResponse<T> success(String message, T data) {
        return new ApiResponse<>(200, true, message, data);
    }

    public static ApiResponse<Void> error(int status, String message) {
        return new ApiResponse<>(status, false, message, null);
    }
}
