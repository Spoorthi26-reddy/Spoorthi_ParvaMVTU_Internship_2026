package com.static_final;

public class Instance_block {
	{

        System.out.println("Instance block executed");
    }

    Instance_block() {
        System.out.println("Constructor executed");
    }

    public static void main(String[] args) {
    	Instance_block d1 = new Instance_block();
    	Instance_block d2 = new Instance_block();
    }
}
