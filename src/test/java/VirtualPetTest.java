import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class VirtualPetTest {


    @Test
    public void shouldHaveADefaultHungerLevelOf100() {
        // Arrange
        VirtualPet underTest = new VirtualPet(100, 40, 80, 40, 100, 0);
        // Act
        int actualHungerLevel = underTest.getHungerLevel();
        // Assert
        assertEquals(100, actualHungerLevel);
    }

    @Test
    public void shouldHaveADefaultHungerLevelOf50() {
        // Arrange
        VirtualPet underTest = new VirtualPet(50, 40, 80, 40, 100, 0);
        // Act
        int actualHungerLevel = underTest.getHungerLevel();
        // Assert
        assertEquals(50, actualHungerLevel);
    }

    @Test
    public void feedingPetShouldDecreaseHungerLevelOf100By60() {
        // Arrange
        VirtualPet underTest = new VirtualPet(100, 40, 80, 40, 100, 0);
        // Act
        underTest.feed();
        int actualHungerLevel = underTest.getHungerLevel();
        assertEquals(40, actualHungerLevel);
    }

    @Test
    public void shouldHaveDefaultThirstLevelOf100() {
        VirtualPet underTest = new VirtualPet(40, 100, 80, 40, 100, 0);
        int actualThirstLevel = underTest.getThirstLevel();
        assertEquals(100, actualThirstLevel);
    }

    @Test
    public void wateringPetShouldDecreaseThirstLevelOf100By10() {
        VirtualPet underTest = new VirtualPet(40, 100, 80, 40, 100, 0);
        underTest.water();
        int actualThirstLevel = underTest.getThirstLevel();
        assertEquals(90, actualThirstLevel);
    }

    @Test
    public void shouldNotBeAbleToWaterPetWhenThirstLevelIsAt0() {
        VirtualPet underTest = new VirtualPet(40, 0, 80, 40, 100, 0);
        underTest.water();
        int actualThirstLevel = underTest.getThirstLevel();
        assertEquals(0, actualThirstLevel);
    }

    @Test
    public void shouldNotBeAbleToFeedPetWhenHungerLevelIsAt0() {
        VirtualPet underTest = new VirtualPet(0, 40, 80, 40, 100, 0);
        underTest.feed();
        int actualHungerLevel = underTest.getHungerLevel();
        assertEquals(0, actualHungerLevel);
    }

    @Test
    public void shouldHaveDefaultHappinessLevelOf80() {
        VirtualPet underTest = new VirtualPet(40, 40, 80, 80, 100, 0);
        int actualHappinessLevel = underTest.getHappinessLevel();
        assertEquals(80, actualHappinessLevel);
    }

    @Test
    public void shouldIncreaseHappinessLevelWhenPlayingWithFrisbeeBy20() {
        VirtualPet underTest = new VirtualPet(40, 40, 40, 80, 100, 0);
        underTest.play();
        int actualHappinessLevel = underTest.getHappinessLevel();
        assertEquals(60, actualHappinessLevel);
    }

    @Test
    public void shouldHaveDefaultWasteLevelOf40() {
        VirtualPet underTest = new VirtualPet(40, 40, 80, 40, 100, 0);
        int actualWasteLevel = underTest.getWasteLevel();
        assertEquals(40, actualWasteLevel);
    }

    @Test
    public void shouldDecreaseWasteLevelTo0WhenGoingOutside() {
        VirtualPet underTest = new VirtualPet(40, 40, 80, 100, 100, 0);
        underTest.goPotty();
        int actualWasteLevel = underTest.getWasteLevel();
        assertEquals(0, actualWasteLevel);
    }

    @Test
    public void shouldVisitADoctorIfHealthLevelIsBelow15() {
        VirtualPet underTest = new VirtualPet(40, 40, 5, 40, 10, 0);
        underTest.goVisitVet();
        int actualHealthLevel = underTest.getHealthLevel();
        assertEquals(50, actualHealthLevel);
    }

    @Test
    public void shouldZeroOutHappinessWhenVisitingVet() {
        VirtualPet underTest = new VirtualPet(40, 40, 15, 40, 10, 0);
        underTest.goVisitVet();
        int actualHappinessLevel = underTest.getHappinessLevel();
        assertEquals(0, actualHappinessLevel);
        int actualHealthLevel = underTest.getHealthLevel();
        assertEquals(50, actualHealthLevel);
    }

    @Test
    public void shouldHaveDefaultSleepinessLevelOf0() {
        VirtualPet underTest = new VirtualPet(0, 60, 80, 80, 80, 0);
        int actualSleepinessLevel = underTest.getSleepinessLevel();
        assertEquals(0, actualSleepinessLevel);
    }

    @Test
    public void shouldIncreaseSleepinessLevelAfterPlayingBy10() {
        VirtualPet underTest = new VirtualPet(40, 60, 100, 0, 100, 40);
        underTest.play();
        int actualSleepinessLevel = underTest.getSleepinessLevel();
        assertEquals(50, actualSleepinessLevel);
    }

    @Test
    public void shouldIncreaseSleepinessAsTimePasses() {
        VirtualPet underTest = new VirtualPet(40, 40, 80, 40, 80, 40);
    }
}