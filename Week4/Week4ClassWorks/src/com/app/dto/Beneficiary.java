package com.app.dto;
public record Beneficiary(String name, String accountno) {

    public boolean validateBene(String name) {
        
        if (name != null && name.equals("james")) {
            return false;
        } else {
            return true;
        }
    }

    @Override
    public boolean equals(Object o) {
        // 
        return true;
    }
}