package utils;

public class FakeRandomizer implements Randomizer{
    private int _randomIndex = 0;

    public FakeRandomizer(int index) {
        setRandomIndex(index);
    }
    @Override
    public int getRandomNumber(int maxSize) {
        return getRandomIndex();
    }

    private int getRandomIndex() {
        return _randomIndex;
    }

    public void setRandomIndex(int randomIndex) {
        _randomIndex = randomIndex;
    }

}
