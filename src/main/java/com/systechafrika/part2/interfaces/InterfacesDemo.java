package com.systechafrika.part2.interfaces;

public class InterfacesDemo {
    public static void main(String[] args) {
        ThreePinPlug mc = new MobileCharger();
        mc.plugIn();
        mc.plugOut();

        ThreePinPlug lc = new LaptopCharger();
        lc.plugIn();
        lc.plugOut();

        Square sq = new Square();
        System.out.println(sq.calculateArea(7, 7));
        System.out.println(sq.calculatePerimeter(7, 7));

        UserController uc = new UserControllerImpl();
        User user = new User("001", "winnie");
        User createdUser = uc.createUser(user);

        System.out.println(createdUser);
    }
}
