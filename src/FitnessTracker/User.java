package FitnessTracker;

import java.util.ArrayList;

public class User {
    private String name;
    private String password;
    private ArrayList<Food> foodList, consumedFood;
    private int calorieGoal, proteinGoal;
    
    public User (String name, String password) {
        this.name = name;
        this.password = password;
        this.foodList = new ArrayList<Food>();
        this.consumedFood = new ArrayList<Food>();
        this.calorieGoal = 0;
        this.proteinGoal = 0;
    }

    public String getName() {
        return this.name;
    }

    public String getPassword() {
        return this.password;
    }

    public int getTotalCalories() {
        int total = 0;
        for (Food food : consumedFood)
            total += food.getCalories();
        return total;
    }

    public int getTotalProtein() {
        int total = 0;
        for (Food food : consumedFood)
            total += food.getProtein();
        return total;
    }
    
    public int getCalorieGoal() {
        return calorieGoal;
    }

    public int getProteinGoal() {
        return proteinGoal;
    }

    public ArrayList<String> getFoodNames() {
        ArrayList<String> ret = new ArrayList<String>();
        for (Food food: foodList)
            ret.add(food.getName());
        return ret;
    }

    public void addFood(Food food) {
        foodList.add(food);
    }

    public void consumedFood(String name) {
        for (Food food : foodList) {
            if (food.getName().equals(name))
                consumedFood.add(food);
        }
    }

    public Boolean foodExists(String name) {
        for (Food food: foodList)
            if (food.getName().equals(name))
                return true;
        return false;
    }

    public void setCalorieGoal(int calorieGoal) {
        this.calorieGoal = calorieGoal;
    }

    public void setProteinGoal(int proteinGoal) {
        this.proteinGoal = proteinGoal;
    }
}
