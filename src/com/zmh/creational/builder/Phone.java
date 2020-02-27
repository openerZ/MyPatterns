package com.zmh.creational.builder;

public class Phone {
    private int size;
    private int length;
    private String type;
    private String name;
    private String descri;

    private Phone(PhoneBuilder phoneBuilder){
        this.size=phoneBuilder.size;
        this.descri=phoneBuilder.descri;
        this.length=phoneBuilder.length;
        this.name= phoneBuilder.name;
        this.type=phoneBuilder.type;
    }

    @Override
    public String toString() {
        return "Phone{" +
                "size=" + size +
                ", length=" + length +
                ", type='" + type + '\'' +
                ", name='" + name + '\'' +
                ", descri='" + descri + '\'' +
                '}';
    }

    public static class PhoneBuilder{
        private int size;
        private int length;
        private String type;
        private String name;
        private String descri;

        public PhoneBuilder size(int size){
            this.size=size;
            return this;
        }
        public PhoneBuilder length(int length){
            this.length=length;
            return this;
        }
        public PhoneBuilder type(String type){
            this.type=type;
            return this;
        }
        public PhoneBuilder name(String name){
            this.name = name;
            return this;
        }
        public PhoneBuilder descri(String descri){
            this.descri=descri;
            return this;
        }

        public Phone build(){
            return new Phone(this);
        }

    }

}
