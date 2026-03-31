package generics;

import java.util.*;

interface MealPlan {
    String getName();
    int getCalories();
    void showMeal();
}

class Veg implements MealPlan {
    private String name;
    private int calories;

    public Veg(String name, int calories) {
        this.name = name;
        this.calories = calories;
    }

    
    public String getName() {
        return name;
    }

    public int getCalories() {
        return calories;
    }

    public void showMeal() {
        System.out.println("Vegetarian Meal: " + name + ", Calories: " + calories);
    }
}

class Vegan implements MealPlan {
    private String name;
    private int calories;

    public Vegan(String name, int calories) {
        this.name = name;
        this.calories = calories;
    }

    public String getName() {
        return name;
    }

    public int getCalories() {
        return calories;
    }

    public void showMeal() {
        System.out.println("Vegan Meal: " + name + ", Calories: " + calories);
    }
}

class Keto implements MealPlan {
    private String name;
    private int calories;

    public Keto(String name, int calories) {
        this.name = name;
        this.calories = calories;
    }

    public String getName() {
        return name;
    }

    public int getCalories() {
        return calories;
    }

    public void showMeal() {
        System.out.println("Keto Meal: " + name + ", Calories: " + calories);
    }
}

class HighProtein implements MealPlan {
    private String name;
    private int calories;

    public HighProtein(String name, int calories) {
        this.name = name;
        this.calories = calories;
    }

    public String getName() {
        return name;
    }

    public int getCalories() {
        return calories;
    }

    public void showMeal() {
        System.out.println("High-Protein Meal: " + name + ", Calories: " + calories);
    }
}

class Meal<T extends MealPlan> {
    private T mealType;

    public Meal(T mealType) {
        this.mealType = mealType;
    }

    public T getMealType() {
        return mealType;
    }

    public void displayMealPlan() {
        mealType.showMeal();
    }
}

class MealPlanUtils {
    public static <T extends MealPlan> void personalizedPlan(T meal) {
        if (meal.getCalories() > 0 && meal.getCalories() < 1000) {
            System.out.println("Generating personalized meal plan...");
            meal.showMeal();
        } else {
            System.out.println("Invalid meal plan: " + meal.getName() + " has unrealistic calories.");
        }
    }
}

public class PersonalizedMealPlanSystem {
    public static void main(String[] args) {
        Meal<Veg> vegMeal = new Meal<>(new Veg("Paneer Curry", 500));
        Meal<Vegan> veganMeal = new Meal<>(new Vegan("Tofu Stir Fry", 450));
        Meal<Keto> ketoMeal = new Meal<>(new Keto("Keto Chicken Bowl", 650));
        Meal<HighProtein> proteinMeal = new Meal<>(new HighProtein("Grilled Chicken & Eggs", 700));

        List<MealPlan> allMeals = new ArrayList<>();
        allMeals.add(vegMeal.getMealType());
        allMeals.add(veganMeal.getMealType());
        allMeals.add(ketoMeal.getMealType());
        allMeals.add(proteinMeal.getMealType());

        System.out.println("--- Personalized Meal Plans ---");
        for (MealPlan m : allMeals) {
            MealPlanUtils.personalizedPlan(m);
        }
    }
}