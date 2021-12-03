public class VirtualPet {

    private int hungerLevel;
    private int thirstLevel;
    private int happinessLevel;
    private int wasteLevel;
    private int healthLevel;
    private int sleepinessLevel;
    private boolean isAlive = true;

    public boolean isPetAlive() {
        return isAlive;
    }

    public void tick() {
        hungerLevel += 7;
        thirstLevel += 13;
        wasteLevel += 9;
        healthLevel -= 5;
        sleepinessLevel -= 9;
        happinessLevel -= 11;

        if (hungerLevel >= 200) {
            isAlive = false;
        }
        if (thirstLevel >= 200) {
            isAlive = false;
        }
        if (wasteLevel >= 210) {
            isAlive = false;
        }
        if (healthLevel < 0) {
            isAlive = false;
        }
        if (sleepinessLevel <= -10) {
            isAlive = false;
        }
    }

    // Getter method to get Hunger Level
    public int getHungerLevel() {
        return hungerLevel;
    }

    // Getter method to get Thirst Level
    public int getThirstLevel() {
        return thirstLevel;
    }

    // Getter method to get Happiness Level
    public int getHappinessLevel() {
        return happinessLevel;
    }

    // Getter method to get Waste Level
    public int getWasteLevel() {
        return wasteLevel;
    }

    // Getter method to get Health Level
    public int getHealthLevel() {
        return healthLevel;
    }

    // Getter method to get Sleepiness Level
    public int getSleepinessLevel() {
        return sleepinessLevel;
    }

    // Constructor
    public VirtualPet(int hungerLevel, int thirstLevel, int happinessLevel, int wasteLevel, int healthLevel, int sleepinessLevel) {
        this.hungerLevel = hungerLevel;
        this.thirstLevel = thirstLevel;
        this.happinessLevel = happinessLevel;
        this.wasteLevel = wasteLevel;
        this.healthLevel = healthLevel;
        this.sleepinessLevel = sleepinessLevel;
    }

    // Behavioral methods
    public int water() {
        if (thirstLevel > 10) {
            thirstLevel = 0;
            happinessLevel += 10;
        }
        return 0;
    }

    public void feed() {
        hungerLevel = 0;
        thirstLevel += 10;
        sleepinessLevel += 30;
    }

    public void play() {
        happinessLevel += 41;
        hungerLevel += 9;
        thirstLevel += 13;
        sleepinessLevel += 10;
    }

    public void destroyCarpet() {
        happinessLevel = 100;
        hungerLevel += 9;
        thirstLevel += 13;
        sleepinessLevel = 100;
    }

    public void goPotty() {
        wasteLevel = 0;
        happinessLevel -= 10;
    }

    public void goVisitVet() {
        healthLevel = 200;
        sleepinessLevel = 40;
        happinessLevel = 90;
    }

    public void goNap() {
        sleepinessLevel = 100;
        hungerLevel = 110;
        thirstLevel = 130;
    }
}

