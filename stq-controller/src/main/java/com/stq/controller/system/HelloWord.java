package com.stq.controller.system;

/**
 * Created by stq on 16-8-30.
 */
public class HelloWord {
    private Long id;
    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public void test(){
        System.out.println(id+":::::"+name);
    }
    @Override
    public String toString() {
        return "HelloWord{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
