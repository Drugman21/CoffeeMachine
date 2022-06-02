package machine;

import java.util.*;

public class CoffeeMachine {
    int water;
    int milk;
    int beans;
    int cups;
    int money;

    public CoffeeMachine() {
        water=400;milk=540;beans=120;cups=9;money=550;
    }

    public void Remaining() {
        System.out.println("The coffee machine has:");
        System.out.println(water+" ml of water");
        System.out.println(milk+" ml of milk");
        System.out.println(beans+" g of coffee beans");
        System.out.println(cups+" disposable cups");
        System.out.println("$"+money+" of money");
    }

    public void BuyEspresso() {
        System.out.println("I have enough resources, making you a coffee!");
        this.water -= 250;
        this.beans -= 16;
        this.money += 4;
        this.cups--;

    }

    public void BuyLatte() {
        System.out.println("I have enough resources, making you a coffee!");
        this.water -= 350;
        this.milk -= 75;
        this.beans -= 20;
        this.money += 7;
        this.cups--;
    }

    public void BuyCappuccino() {
        System.out.println("I have enough resources, making you a coffee!");
        this.water -= 200;
        this.milk -= 100;
        this.beans -= 12;
        this.money += 6;
        this.cups--;
    }

    public void Fill(int addw,int addm,int addcb,int addc) {
        this.water += addw;
        this.milk += addm;
        this.beans += addcb;
        this.cups += addc;
    }


    public String Take() {
        int x=money;
        String s = "I gave you $" + x;
        this.money=0;
        return s;
    }


    public boolean Verify(int w,int m,int cb) {
        if (water < w) {
            System.out.println("Sorry, not enough water!");
            return false;
        }
        if (milk < m) {
            System.out.println("Sorry, not enough milk!");
            return false;
        }
        if (beans < cb) {
            System.out.println("Sorry, not enough coffee beans!");
            return false;
        }
        if (cups < 1) {
            System.out.println("Sorry, not enough cups!");
            return false;
        }
        return true;
    }



    public static void main(String[] args) {
        CoffeeMachine machine = new CoffeeMachine();
        while (true) {
            Scanner s = new Scanner(System.in);
            //machine.Show();
            System.out.println("Write action (buy, fill, take, remaining, exit):");
            String action = s.next();
            switch (action) {
                case "buy":
                    System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu:");
                    String x=s.next();
                    switch (x) {
                        case "1":
                            boolean e = machine.Verify(250, 0, 16);
                            if (e == true) {
                                machine.BuyEspresso();
                            }
                            break;
                        case "2":
                            boolean l = machine.Verify(350, 75, 20);
                            if (l == true) {
                                machine.BuyLatte();
                            }
                            break;
                        case "3":
                            boolean c = machine.Verify(200, 100, 12);
                            if (c == true) {
                                machine.BuyCappuccino();
                            }
                            break;
                        case "back":
                            break;
                    }

                    break;
                case "fill":
                    System.out.println("Write how many ml of water you want to add:");
                    int aw = s.nextInt();
                    System.out.println("Write how many ml of milk you want to add:");
                    int am = s.nextInt();
                    System.out.println("Write how many grams of coffee beans you want to add:");
                    int acb = s.nextInt();
                    System.out.println("Write how many disposable cups of coffee you want to add");
                    int ac = s.nextInt();
                    machine.Fill(aw,am,acb,ac);


                    break;
                case "take":
                    String msg = machine.Take();
                    System.out.println(msg);
                    //machine.Show();
                    break;
                case "remaining":
                    machine.Remaining();
                    break;
                case "exit":
                    System.exit(0);
            }
        }



    }

}
