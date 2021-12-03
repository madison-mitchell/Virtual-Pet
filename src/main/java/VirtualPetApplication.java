import java.sql.SQLOutput;
import java.util.Scanner;

public class VirtualPetApplication {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        VirtualPet myVirtualPet = new VirtualPet(100, 100, 100, 100, 100, 100);

        System.out.println("\n\n" +
                "         |\\_/|                  \n" +
                "         | @ @   Woof! \n" +
                "         |   <>              _  \n" +
                "         |  _/\\------____ ((| |))\n" +
                "         |               `--' |   \n" +
                "     ____|_       ___|   |___.' \n" +
                "    /_/_____/____/_______|");
        System.out.println("\n\t    Welcome to Virtual Pet!");
        System.out.println("  Meet your new pet! What's it's name?");
        String userPetName = input.nextLine();
        System.out.println("");

        String userPetNameCap = userPetName.substring(0, 1).toUpperCase() + userPetName.substring(1);

        System.out.println("       .....           .....\n" +
                "   ,ad8PPPP88b,     ,d88PPPP8ba,\n" +
                "  d8P\"      \"Y8b, ,d8P\"      \"Y8b\n" +
                " dP'           \"8a8\"           `Yd\n" +
                " 8(            .-\"-.            )8\n" +
                " I8           /|6 6|\\           8I\n" +
                "  Yb,        {/(_0_)\\}        ,dP\n" +
                "   \"8a,       _/ ^ \\_.      ,a8\"\n" +
                "     \"8a,    (/ /^\\ \\)-'  ,a8\"\n" +
                "       \"Yba   \"\"' '\"\"   adP\"\n" +
                "         `Y8a         a8P'\n" +
                "           `88,     ,88'\n" +
                "             \"8b   d8\"\n" +
                "              \"8b d8\"\n" +
                "               `888'\n" +
                "                 \"");
        System.out.println(userPetNameCap + " seems to like you!");


        while (myVirtualPet.isPetAlive()) {
            System.out.println("How would you like to interact with " + userPetNameCap + "?");
            System.out.println("1 - Feed " + userPetNameCap);
            System.out.println("2 - Water " + userPetNameCap);
            System.out.println("3 - Hold " + userPetNameCap);
            System.out.println("4 - Play with " + userPetNameCap);
            System.out.println("5 - Take " + userPetNameCap + " to the vet ");
            System.out.println("6 - Let " + userPetNameCap + " out to go potty");
            System.out.println("7 - Let " + userPetNameCap + " take a nap");
            int userChoice = input.nextInt();
            System.out.println(""); // Line break for formatting

            // Feed
            if (userChoice == 1) {
                myVirtualPet.feed();
                System.out.println(userPetNameCap + "'s belly is full!");
                myVirtualPet.tick();
                myVirtualPet.isPetAlive();
            }

            // Water
            if (userChoice == 2) {
                myVirtualPet.water();
                System.out.println(userPetNameCap + " is SUPER hydrated!");
                myVirtualPet.tick();
                myVirtualPet.isPetAlive();
            }

            // Hold
            if (userChoice == 3) {
                myVirtualPet.play();
                System.out.println("Cuddling time! " + userPetNameCap + " loves you!");
                myVirtualPet.tick();
                myVirtualPet.isPetAlive();
            }

            // Play
            if (userChoice == 4) {
                myVirtualPet.play();
                System.out.println(userPetNameCap + " just brought you back the ball you launched into the yard, tailing wagging!");
                myVirtualPet.tick();
                myVirtualPet.isPetAlive();
            }

            // Vet
            if (userChoice == 5) {
                myVirtualPet.goVisitVet();
                System.out.println(userPetNameCap + " feels much better!");
                myVirtualPet.tick();
                myVirtualPet.isPetAlive();
            }

            // Potty
            if (userChoice == 6) {
                myVirtualPet.goPotty();
                System.out.println(userPetNameCap + "'s tank is empty!");
                myVirtualPet.tick();
                myVirtualPet.isPetAlive();
            }

            // Nap
            if (userChoice == 7) {
                myVirtualPet.goNap();
                System.out.println(userPetNameCap + " took a nap and is well rested!");
                myVirtualPet.tick();
                myVirtualPet.isPetAlive();
            }

            // Hunger Indicators
            if (myVirtualPet.getHungerLevel() >= 150) {
                if (myVirtualPet.getHungerLevel() >= 170) {
                    System.out.println(userPetNameCap + " IS STARVING! Feed " + userPetNameCap + " NOW!");
                } else {
                    System.out.println(userPetNameCap + " is very hungry.");
                    myVirtualPet.isPetAlive();
                }
            }

            // Thirst Indicators
            if (myVirtualPet.getThirstLevel() >= 150) {
                if (myVirtualPet.getThirstLevel() >= 170) {
                    System.out.println(userPetNameCap + " IS DEHYDRATED! Water " + userPetNameCap + " NOW!");
                } else {
                    System.out.println(userPetNameCap + " is very thirsty.");
                    myVirtualPet.isPetAlive();
                }
            }

            // Waste Indicators
            if (myVirtualPet.getWasteLevel() >= 150) {
                if (myVirtualPet.getWasteLevel() >= 165) {
                    myVirtualPet.goPotty();
                    System.out.println("OH No! " + userPetNameCap + " went potty on the rug! YUCK!");
                } else {
                    System.out.println(userPetNameCap + " has to got potty NOW!");
                    myVirtualPet.isPetAlive();
                }

            }

            // Happiness Indicators
            if (myVirtualPet.getHappinessLevel() <= 70) {
                if (myVirtualPet.getHappinessLevel() <= 40) {
                    System.out.println(userPetNameCap + " chewed up all your carpet and couches too! They look pretty happy, but you're sure not! But look at those puppy dog eyes though!");
                    myVirtualPet.destroyCarpet();
                    myVirtualPet.isPetAlive();

                } else {
                    System.out.println(userPetNameCap + " is getting bored. Better play with them before they chew up the carpet!");
                    myVirtualPet.isPetAlive();
                }
            }


            // Sleep Indicators
            if (myVirtualPet.getSleepinessLevel() >= 150) {
                if (myVirtualPet.getSleepinessLevel() >= 170) {
                    System.out.println(userPetNameCap + " IS SLEEP DEPRIVED! " + userPetNameCap + " needs a nap, NOW!");
                } else {
                    System.out.println(userPetNameCap + " is tired.");
                    myVirtualPet.isPetAlive();
                }
            }

            if (myVirtualPet.getHealthLevel() <= 60) {
                if (myVirtualPet.getHealthLevel() <= 30) {
                    System.out.println(userPetNameCap + " IS DYING! Take " + userPetNameCap + " to the vet, NOW!");
                } else {
                    System.out.println(userPetNameCap + " isn't feeling well.");
                    myVirtualPet.isPetAlive();
                }
            }
            System.out.println(""); // Line break for formatting
        }

        System.out.println("" +
                "(\\,--------'()'--o\n" +
                " (_    ___    /~\"\n" +
                "  (_)_)  (_)_)");
        System.out.println(userPetName + " has died!");
        System.out.println("");
        System.out.println("Play program to start over!");
        System.out.println(myVirtualPet.getHungerLevel());
        System.out.println(myVirtualPet.getThirstLevel());
        System.out.println(myVirtualPet.getHappinessLevel());
        System.out.println(myVirtualPet.getWasteLevel());
        System.out.println(myVirtualPet.getHealthLevel());
        System.out.println(myVirtualPet.getSleepinessLevel());

    }

}
