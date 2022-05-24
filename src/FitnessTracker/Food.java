package FitnessTracker;

public class Food {
    private String name;
    private int calories;
    private int protein;

    /**
     * Create new food type by initializing
     * @param name - Name of the food: Unique
     * @param calories - Amount of calories
     * @param protein - Amount of protein
     */
    public Food (String name, int calories, int protein) {
        this.name = name;
        this.calories = calories;
        this.protein = protein;
    }

    // Change the name of the food
    public void setName(String name) {
        this.name = name;
    }

    // Update calorie value
    public void setCalories(int calories) {
        this.calories = calories;
    }

    // Update protein value
    public void setProtein(int protein) {
        this.protein = protein;
    }

    // Get calorie value for given food
    public int getCalories() {
        return this.calories;
    }

    // Get protein value for given food
    public int getProtein() {
        return this.protein;
    }

    public String getName() {
        return this.name;
    }
}