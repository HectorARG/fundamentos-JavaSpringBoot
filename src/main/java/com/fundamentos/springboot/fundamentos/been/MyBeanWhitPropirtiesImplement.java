package com.fundamentos.springboot.fundamentos.been;

public class MyBeanWhitPropirtiesImplement implements MyBeanWhitPrperties {

    private String name;
    private String apellido;

    public MyBeanWhitPropirtiesImplement(String name, String apellido) {
        this.name = name;
        this.apellido = apellido;
    }



    @Override
    public String function() {
        return name + "-" + apellido;
    }
}
