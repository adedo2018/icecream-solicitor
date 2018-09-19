package com.example.lta.demo.service;

public class SolicitorDto {

    public String getName() {
        return name;
    }

    public String getLine1() {
        return line1;
    }

    public String getLine2() {
        return line2;
    }

    private final String name;
    private final String line1;
    private final String line2;

    private SolicitorDto(Builder builder) {
        name = builder.name;
        line1 = builder.line1;
        line2 = builder.line2;
    }

    public static class Builder {
        private String name;
        private String line1;
        private String line2;


        public Builder() {
        }

        public Builder name(String val)
        {
            name = val;
            return this;
        }

        public Builder line1(String val)
        {
            line1 = val;
            return this;
        }

        public Builder line2(String val)
        {
            line2 = val;
            return this;
        }

        public SolicitorDto build() {
            return new SolicitorDto(this);
        }

    }

}